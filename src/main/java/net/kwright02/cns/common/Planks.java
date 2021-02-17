package net.kwright02.cns.common;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.kwright02.cns.StyleRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

import static net.kwright02.cns.Main.MOD_GROUP;

public class Planks {

    public static HashMap<String, Block> registeredBlocks = new HashMap<>();
    public static HashMap<String, BlockItem> registeredItems = new HashMap<>();

    public static String[] types = { "smooth", "planked", "fancy", "nailed_panel", "nailed_large", "crate",
            "fancy_crate", "large", "vertical", "uneven_vertical", "braid", "blinds", "scaffold",
            "disarray_horizontal", "disarray_vertical" };

    public static String[] vanillaVariants = {
      "oak","dark_oak","jungle","spruce","acacia","birch"
    };

    public static void registerVanillaVariants(){
        for(String s : vanillaVariants){
            System.out.println("Variant: " + s);
            register(s + "_planks");
        }
    }

    public static void register(String blockPath){
        for(int i = 0; i < vanillaVariants.length; i++){
            String s = types[i];
            System.out.println("Registering type " + s + " for blockpath " + blockPath);
            Block b = new Block(FabricBlockSettings.of(Material.WOOD).strength(0.4f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES));
            BlockItem bi = new BlockItem(b, new FabricItemSettings().group(MOD_GROUP));
            registeredBlocks.put(s + "_" + blockPath, b);
            registeredItems.put(s + "_" + blockPath, bi);
            StyleRegistry.INSTANCE.registerBlock(s, blockPath, b, bi);
        }
    }

}
