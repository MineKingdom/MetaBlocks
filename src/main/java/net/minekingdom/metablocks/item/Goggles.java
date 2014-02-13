package net.minekingdom.metablocks.item;

import net.minecraft.item.ItemArmor;
import net.minekingdom.metablocks.ModClass;
import net.minekingdom.metablocks.ModInfo;

public class Goggles extends ItemArmor {
	
	public final static String NAME = "invisible_goggles";
	public final static String ID = ModInfo.mod_id + "." + NAME;

	public Goggles() {
		super(ItemArmor.ArmorMaterial.CHAIN, 0, 0);
		
		this.setCreativeTab(ModClass.tab);
		this.setUnlocalizedName(ID);
		this.setTextureName("ender_eye");
	}

}
