package net.minekingdom.metablocks.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minekingdom.metablocks.ModClass;
import net.minekingdom.metablocks.ModInfo;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ColorBlock extends Block {
	
	public final static String NAME = "color_block";
	public final static String ID = ModInfo.mod_id + "." + NAME;
	
	public final static int[] COLORS = {
		0x000000, 0x28008A, 0x009D2D, 0x00958F, 0x9F001A, 0xA3008B, 0x8D9933, 0xB6B6B6,
		0x676767, 0x4600F2, 0x00FF4F, 0x00FFFC, 0xFF002F, 0xFF00F5, 0xF8FF5A, 0xFFFFFF
	};

	public ColorBlock() {
		super(Material.rock);
		
		this.setCreativeTab(ModClass.tab);
		this.setBlockName(ID);
		this.setBlockTextureName(ModInfo.mod_id + ":blank");
		this.setBlockUnbreakable();
		
		FMLCommonHandler.instance().getFMLLogger().error(this.getUnlocalizedName());
		FMLCommonHandler.instance().getFMLLogger().error(this.getTextureName());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 16; ++i) {
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
	
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int meta) {
		return COLORS[meta];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess blockAccess, int x, int y, int z) {
		return COLORS[blockAccess.getBlockMetadata(x, y, z)];
	}
}
