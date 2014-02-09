package net.minekingdom.metablocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.AxisAlignedBB;
import net.minekingdom.metablocks.block.ColorBlock;
import net.minekingdom.metablocks.block.InvisibleBlock;
import net.minekingdom.metablocks.block.KillerBlock;
import net.minekingdom.metablocks.block.OneWayBlock;
import net.minekingdom.metablocks.creativetab.Tab;
import net.minekingdom.metablocks.item.Goggles;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModInfo.mod_id, name = ModInfo.mod_name, version = ModInfo.version)
@NetworkMod(clientSideRequired = true)
public class ModClass {
	
	public static final AxisAlignedBB NO_OUTLINE = AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);

	@Instance(ModInfo.mod_id)
	public static ModClass instance;
	
	public static Goggles googles;
	
	public static InvisibleBlock invisibleBlock;
	public static ColorBlock colorBlock;
	public static OneWayBlock oneWayBlock;
	public static KillerBlock killerBlock;
	
	public static CreativeTabs tab;

	@EventHandler
	public void load(FMLInitializationEvent event) {
		tab = new Tab();
		
		setupItems();
		setupBlocks();
		setupLang();
	}

	private void setupItems() {
		googles = new Goggles(1000);
	}

	private void setupLang() {
		LanguageRegistry.instance().addNameForObject(googles,        "fr_FR", "Oeil d'un modérateur vicieux");
		LanguageRegistry.instance().addNameForObject(invisibleBlock, "fr_FR", "Bloc Invisible");
		LanguageRegistry.instance().addNameForObject(colorBlock,     "fr_FR", "Bloc coloré");
		LanguageRegistry.instance().addNameForObject(oneWayBlock,    "fr_FR", "Bloc de passage");
		LanguageRegistry.instance().addNameForObject(killerBlock,    "fr_FR", "Bloc de mort inconditionnelle");
	}

	private void setupBlocks() {
		GameRegistry.registerBlock(invisibleBlock = new InvisibleBlock(999), ItemBlock.class, invisibleBlock.getUnlocalizedName(), null);
		GameRegistry.registerBlock(colorBlock     = new ColorBlock(998),     ItemBlock.class, colorBlock.getUnlocalizedName(), null);
		GameRegistry.registerBlock(oneWayBlock    = new OneWayBlock(997),    ItemBlock.class, oneWayBlock.getUnlocalizedName(), null);
		GameRegistry.registerBlock(killerBlock    = new KillerBlock(996),    ItemBlock.class, killerBlock.getUnlocalizedName(), null);
	}
}
