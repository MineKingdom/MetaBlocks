package net.minekingdom.metablocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.AxisAlignedBB;
import net.minekingdom.metablocks.block.BouncerBlock;
import net.minekingdom.metablocks.block.ColorBlock;
import net.minekingdom.metablocks.block.InvisibleBlock;
import net.minekingdom.metablocks.block.KillerBlock;
import net.minekingdom.metablocks.block.OneWayBlock;
import net.minekingdom.metablocks.creativetab.Tab;
import net.minekingdom.metablocks.item.Goggles;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.mod_id, name = ModInfo.mod_name, version = ModInfo.version)
public class ModClass {
	
	public static final AxisAlignedBB NO_OUTLINE = AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);

	@Instance(ModInfo.mod_id)
	public static ModClass instance;
	
	public static Goggles goggles;
	
	public static InvisibleBlock invisibleBlock;
	public static ColorBlock colorBlock;
	public static OneWayBlock oneWayBlock;
	public static KillerBlock killerBlock;
	public static BouncerBlock bouncerBlock;
	
	public static CreativeTabs tab;
	
	@EventHandler
	public void load(FMLPreInitializationEvent event) {
		tab = new Tab();
		
		setupItems();
		setupBlocks();
	}

	private void setupItems() {
		GameRegistry.registerItem(goggles = new Goggles(), Goggles.NAME);
	}

	private void setupBlocks() {
		GameRegistry.registerBlock(invisibleBlock = new InvisibleBlock(), ItemBlock.class,         InvisibleBlock.NAME);
		GameRegistry.registerBlock(colorBlock     = new ColorBlock(),     ItemBlock.class,         ColorBlock.NAME);
		GameRegistry.registerBlock(oneWayBlock    = new OneWayBlock(),    ItemBlock.class,         OneWayBlock.NAME);
		GameRegistry.registerBlock(killerBlock    = new KillerBlock(),    ItemBlock.class,         KillerBlock.NAME);
		GameRegistry.registerBlock(bouncerBlock   = new BouncerBlock(),   BouncerBlock.Item.class, BouncerBlock.NAME);
	}
}
