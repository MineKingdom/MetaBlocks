package net.minekingdom.metablocks.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minekingdom.metablocks.ModClass;
import net.minekingdom.metablocks.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BouncerBlock extends Block {
	
	public final static String NAME = "bouncer";
	public final static String ID = ModInfo.mod_id + "." + NAME;

	public BouncerBlock() {
		super(Material.rock);
		
		this.setCreativeTab(ModClass.tab);
		this.setBlockName(ID);
		this.setBlockTextureName(ModInfo.mod_id + ":" + NAME);
		this.setBlockUnbreakable();
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(net.minecraft.item.Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 7; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public int damageDropped(int damage) {
        return damage;
    }
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item) {
		world.setBlockMetadataWithNotify(x, y, z, item.getItemDamage(), 3);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		if (entity == null) {
			return;
		}
		
		double mult = getBounceMultiplierFromMetadata(world.getBlockMetadata(x, y, z));
		
		if (entity.motionX > 0 ^ x < entity.posX) {
			entity.motionX = - mult * entity.motionX;
		}
		if (entity.motionY > 0 ^ y < entity.posY) {
			entity.motionY = - mult * entity.motionY;
		}
		if (entity.motionZ > 0 ^ z < entity.posZ) {
			entity.motionZ = - mult * entity.motionZ;
		}
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
	}
	
	public static double getBounceMultiplierFromMetadata(int meta) {
		switch (meta) {
			default:
			case 0: return 1;
			
			case 1: return 1.5;
			case 2: return 2.0;
			case 3: return 2.5;
			case 4: return 3.0;
			case 5: return 3.5;
			case 6: return 4.0;
		}
	}
	
	public static class Item extends ItemBlock {
		public Item(Block block) {
			super(block);
		}
		
		@Override
		public String getItemStackDisplayName(ItemStack stack) {
			return String.format(super.getItemStackDisplayName(stack), getBounceMultiplierFromMetadata(stack.getItemDamage()));
		}
	}
}
