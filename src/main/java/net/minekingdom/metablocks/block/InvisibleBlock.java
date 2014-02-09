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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class InvisibleBlock extends Block {

	public InvisibleBlock(int id) {
		super(id, Material.glass);
		
		this.setCreativeTab(ModClass.tab);
		this.setUnlocalizedName("invisible_block");
		this.setTextureName(ModInfo.ressource_id + ":invisible_block");
		this.setBlockUnbreakable();
		this.setLightOpacity(0);
	}
	
	public int getMobilityFlag() {
        return 2;
    }

	@SideOnly(Side.CLIENT)
	private boolean isWearingGoggles() {
		ItemStack i = Minecraft.getMinecraft().thePlayer.inventory.armorInventory[3];
		return i != null && i.itemID == ModClass.googles.itemID;
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
    	
        return blockAccess.getBlockId(x, y, z) == this.blockID ? false : super.shouldSideBeRendered(blockAccess, x, y, z, 1 - side);
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
