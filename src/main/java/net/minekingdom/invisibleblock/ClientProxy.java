package net.minekingdom.invisibleblock;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends Proxy {

	@Override
	public void initialize() {
		super.initialize();
		
		InvisibleRenderer.render_id = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(new InvisibleRenderer());
	}
	
}
