package net.minekingdom.metablocks.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minekingdom.metablocks.ModClass;
import net.minekingdom.metablocks.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OneWayBlock extends Block {
	
	public final static double EPSILON = 0.31;

	public OneWayBlock(int id) {
		super(id, Material.rock);
		
		this.setCreativeTab(ModClass.tab);
		this.setUnlocalizedName("one_way_block");
		this.setTextureName(ModInfo.ressource_id + ":one_way");
		this.setBlockUnbreakable();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < 6; ++i) {
			list.add(new ItemStack(id, 1, i));
		}
	}
	
	public int damageDropped(int damage) {
        return damage;
    }
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack item) {
		world.setBlockMetadataWithNotify(x, y, z, item.getItemDamage(), 3);
	}
	
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public boolean isBlockSolid(IBlockAccess blockAccess, int x, int y, int z, int size) {
    	return false;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
    	switch (side) {
			case 0: ++y; break;
			case 1: --y; break;
			case 2: ++z; break;
			case 3: --z; break;
			case 4: ++x; break;
			case 5: --x; break;
			default: break;
		}
    	
    	return blockAccess.getBlockMetadata(x, y, z) == side;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		Vec3 entityPos = Vec3.createVectorHelper(entity.posX, entity.posY + entity.getEyeHeight() / 2, entity.posZ);
		Vec3 blockPos  = Vec3.createVectorHelper(x + 0.5, y + 0.5, z + 0.5);
		
		boolean collide = true;
		switch (world.getBlockMetadata(x, y, z)) {
			case 0: collide = intersectsYPlane(y - 0.1, entityPos.addVector(0,   entity.getEyeHeight() / 2, 0), blockPos); break;
			case 1: collide = intersectsYPlane(y + 1.1, entityPos.addVector(0, - entity.getEyeHeight() / 2, 0), blockPos); break;
			case 2: collide = intersectsZPlane(z - 0.2, entityPos, blockPos); break;
			case 3: collide = intersectsZPlane(z + 1.2, entityPos, blockPos); break;
			case 4: collide = intersectsXPlane(x - 0.2, entityPos, blockPos); break;
			case 5: collide = intersectsXPlane(x + 1.2, entityPos, blockPos); break;
			default: break;
		}
		
		if (collide) {
			super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
		}
	}
	
	private boolean intersectsXPlane(double x, Vec3 v1, Vec3 v2) {
		return (v1.xCoord > x && v2.xCoord < x) || (v1.xCoord < x && v2.xCoord > x);
	}
	
	private boolean intersectsYPlane(double y, Vec3 v1, Vec3 v2) {
		return (v1.yCoord > y && v2.yCoord < y) || (v1.yCoord < y && v2.yCoord > y);
	}
	
	private boolean intersectsZPlane(double z, Vec3 v1, Vec3 v2) {
		return (v1.zCoord > z && v2.zCoord < z) || (v1.zCoord < z && v2.zCoord > z);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return ModClass.NO_OUTLINE;
	}
}
