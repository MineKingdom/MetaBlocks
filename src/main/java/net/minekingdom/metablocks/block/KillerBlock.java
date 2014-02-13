package net.minekingdom.metablocks.block;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minekingdom.metablocks.ModClass;
import net.minekingdom.metablocks.ModInfo;

public class KillerBlock extends InvisibleBlock {
	
	public final static String NAME = "killer_block";
	public final static String ID = ModInfo.mod_id + "." + NAME;

	public KillerBlock() {
		this.setCreativeTab(ModClass.tab);
		this.setBlockName(ID);
		this.setBlockUnbreakable();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
		if (entity == null) {
			return;
		}
		if (entity instanceof EntityLivingBase) {
			if (!(entity instanceof EntityPlayerMP) || !((EntityPlayerMP) entity).capabilities.isCreativeMode) {
				((EntityLivingBase) entity).attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
			}
		} else if (!entity.isDead) { 
			entity.setDead();
		}
	}

}
