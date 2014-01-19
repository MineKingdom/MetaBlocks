package net.minekingdom.invisibleblock;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class Goggles extends ItemArmor {

	public Goggles(int id) {
		super(id, EnumArmorMaterial.CHAIN, 0, 0);
		
		setUnlocalizedName("invisible_googles").setTextureName("ender_eye");
		
		LanguageRegistry.addName(this, "Oeil d'un modérateur vicieux");
		
		this.setCreativeTab(CreativeTabs.tabMisc);
	}

}
