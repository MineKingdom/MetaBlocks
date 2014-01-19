package net.minekingdom.invisibleblock;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class InvisibleRenderer implements ISimpleBlockRenderingHandler {
	
	public static int	render_id = -1;

	@SideOnly(Side.CLIENT)
	private boolean isWearingGoggles() {
		ItemStack i = Minecraft.getMinecraft().thePlayer.inventory.armorInventory[3];
		return i != null && i.itemID == InvisibleBlockMod.googles.itemID;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		if (modelId == render_id) {
			FMLCommonHandler.instance().getFMLLogger().severe("wearing : " + isWearingGoggles());
			if (!isWearingGoggles()) {
				renderer.renderStandardBlock(InvisibleBlockMod.block, x, y, z);
			}
        }
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return render_id;
	}
}
