package net.minekingdom.metablocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minekingdom.metablocks.ModClass;
import net.minekingdom.metablocks.ModInfo;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class InvisibleBlock extends Block {
	
	public final static String NAME = "invisible_block";
	public final static String ID = ModInfo.mod_id + "." + NAME;

	public InvisibleBlock() {
		super(Material.glass);
		
		this.setCreativeTab(ModClass.tab);
		this.setBlockName(ID);
		this.setBlockTextureName(ModInfo.mod_id + ":" + NAME);
		this.setBlockUnbreakable();
		this.setLightOpacity(0);
		
		FMLCommonHandler.instance().getFMLLogger().error(this.getUnlocalizedName());
		FMLCommonHandler.instance().getFMLLogger().error(this.getTextureName());
	}
	
	public int getMobilityFlag() {
        return 2;
    }

	@SideOnly(Side.CLIENT)
	private boolean isWearingGoggles() {
		ItemStack i = Minecraft.getMinecraft().thePlayer.inventory.armorInventory[3];
		return i != null && i.getItem() == ModClass.goggles;
	}
	
	public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
    	if (!isWearingGoggles()) {
    		return false;
    	}
    	
        return blockAccess.getBlock(x, y, z) == this ? false : super.shouldSideBeRendered(blockAccess, x, y, z, 1 - side);
	}
    
    @Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return ModClass.NO_OUTLINE;
	}
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

}
