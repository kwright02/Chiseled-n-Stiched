package net.kwright02.cns.modHandlers;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.loader.api.FabricLoader;
import net.kwright02.cns.StyleRegistry;
import net.kwright02.cns.common.Planks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.HashMap;

public class WoodsAndMires extends Registrar {

    static {
        mod_name = "woods_and_mires";
    }

    public static HashMap<String, Block> registeredBlocks = new HashMap<>();
    public static HashMap<String, BlockItem> registeredItems = new HashMap<>();

    public static String[] plankVariants = { "pine_planks" };
    public static String[] logVariants = { "pine_log" };

    @Override
    public void registerVariants() {
        if(isModPresent()){
            itemGroup = FabricItemGroupBuilder.build(
                    new Identifier("cns", mod_name),
                    () -> new ItemStack(Registry.BLOCK.get(new Identifier(mod_name + ":pine_planks"))));
            for(String style : Planks.types){
                for(String variant : plankVariants) {
                    Block b = new Block(FabricBlockSettings.of(Material.WOOD).strength(0.4f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES));
                    BlockItem bi = new BlockItem(b, new FabricItemSettings().group(itemGroup));
                    registeredBlocks.put(style + "_" + variant, b);
                    registeredItems.put(style + "_" + variant, bi);
                    StyleRegistry.INSTANCE.registerBlock(style, variant, b, bi);
                }
            }
//            for(String s : Logs.types){
//                for(String variant: logVariants){
//                    Block b = new Block(FabricBlockSettings.of(Material.WOOD).strength(0.4f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES));
//                    BlockItem bi = new BlockItem(b, new FabricItemSettings().group(itemGroup));
//                    registeredBlocks.put(s + "_" + variant, b);
//                    registeredItems.put(s + "_" + variant, bi);
//                    StyleRegistry.INSTANCE.registerBlock(s, variant, b, bi);
//                }
//            }
        } else {
            System.out.println("Skipped woodsandmires variants");
        }
    }

}
