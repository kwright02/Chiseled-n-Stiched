package net.kwright02.cns;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kwright02.cns.common.BlockOfs;
import net.kwright02.cns.common.Planks;
import net.kwright02.cns.modHandlers.WoodsAndMires;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {

	public static ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier("cns", "cns"),
			() -> new ItemStack(Blocks.OAK_PLANKS));

	public static WoodsAndMires wam = new WoodsAndMires();

	@Override
	public void onInitialize() {
		Planks.registerVanillaVariants();
		BlockOfs.registerVanillaVariants();
		//Mod inits
		wam.registerVariants();

	}
}
