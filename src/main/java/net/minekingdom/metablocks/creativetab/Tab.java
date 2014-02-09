package net.minekingdom.metablocks.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minekingdom.metablocks.ModClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Tab extends CreativeTabs {

	public Tab() {
		super("Block utilities");
	}
	
	@SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        return ModClass.oneWayBlock.blockID;
    }

}
