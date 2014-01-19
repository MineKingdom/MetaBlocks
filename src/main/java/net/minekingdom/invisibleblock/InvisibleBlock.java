package net.minekingdom.invisibleblock;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class InvisibleBlock extends BlockGlass {

	public InvisibleBlock(int id) {
		super(id, Material.glass, true);
		
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setUnlocalizedName("invisible_block");
		this.setBlockUnbreakable();
		
		LanguageRegistry.addName(this, "Bloc Invisible");
		GameRegistry.registerBlock(this, ItemBlock.class, "invisible_block", null);
	}
	
	@Override
	public int getRenderType() {
		return InvisibleRenderer.render_id;
	}

}
