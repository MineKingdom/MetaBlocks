package net.minekingdom.metablocks.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minekingdom.metablocks.ModClass;

public class Goggles extends ItemArmor {

	public Goggles(int id) {
		super(id, EnumArmorMaterial.CHAIN, 0, 0);
		
		this.setCreativeTab(ModClass.tab);
		this.setUnlocalizedName("invisible_googles");
		this.setTextureName("ender_eye");
	}

}
