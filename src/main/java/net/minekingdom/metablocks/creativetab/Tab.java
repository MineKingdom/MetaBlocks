package net.minekingdom.metablocks.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minekingdom.metablocks.ModClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Tab extends CreativeTabs {

	public Tab() {
		super("Block utilities");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModClass.oneWayBlock);
	}

}
