package net.minekingdom.invisibleblock;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="InvisibleBlock", name="InvisibleBlock", version="1.0.0")
@NetworkMod(clientSideRequired = true)
public class InvisibleBlockMod {
	
	@Instance("MineKingdom")
	public static InvisibleBlockMod instance;
	
	public static Goggles googles;
	public static InvisibleBlock block;
	
	@SidedProxy(clientSide = "net.minekingdom.invisibleblock.ClientProxy", serverSide = "net.minekingdom.invisibleblock.Proxy")
	public static Proxy proxy;

	@EventHandler
	public void load(FMLInitializationEvent event) {
		googles = new Goggles(1000);
		block = new InvisibleBlock(500);
		
		proxy.initialize();
	}
}
