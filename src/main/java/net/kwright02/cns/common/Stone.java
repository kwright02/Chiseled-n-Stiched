package net.kwright02.cns.common;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.kwright02.cns.StyleRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;

import java.util.HashMap;

import static net.kwright02.cns.Main.MOD_GROUP;

public class Stone {

    public static HashMap<String, Block> registeredBlocks = new HashMap<>();
    public static HashMap<String, BlockItem> registeredItems = new HashMap<>();

    public static String[] types = { "cracked","weathered_bricks","cracked_bricks","wide_bricks","braid","arrayed_bricks",
            "big_tile","small_tile","disordered_tile","small_disordered_tile","dent","french1","french2","jellybean","layers",
            "mosaic","ornate","panel","road","slanted","zag","circular_ctm","celtic","bricks","small_bricks","circular_nonct",
            "tiles","pillar","prism", "trodden_bricks", "cuts" };

    public static String[] vanillaVariants = {
           "andesite", "granite", "diorite", "red_concrete","blue_concrete","white_concrete" ,"orange_concrete", "magenta_concrete",
            "light_blue_concrete", "yellow_concrete","lime_concrete","pink_concrete", "gray_concrete","light_gray_concrete",
            "cyan_concrete", "purple_concrete", "brown_concrete", "green_concrete", "black_concrete", "terracotta", "end_stone",
            "purpur","red_sandstone","sandstone", "quartz_block", "prismarine", "block_of_redstone", "stone_brick", "block_of_coal",
            "cobblestone","bricks","basalt", "lava_stone","water_stone","limestone","marble","mossy_cobblestone","mossy_temple"
    };

    public static void registerVanillaVariants(){
        for(String s : vanillaVariants){
            System.out.println("Variant: " + s);
            register(s + "_block");
        }
    }

    public static void register(String blockPath){
        for(int i = 0; i < types.length; i++){
            String s = types[i];
            System.out.println("Registering type " + s + " for blockpath " + blockPath);
            Block b = new Block(FabricBlockSettings.of(Material.METAL).strength(0.4f).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
            BlockItem bi = new BlockItem(b, new FabricItemSettings().group(MOD_GROUP));
            registeredBlocks.put(s + "_" + blockPath, b);
            registeredItems.put(s + "_" + blockPath, bi);
            StyleRegistry.INSTANCE.registerBlock(s, blockPath, b, bi);
        }
    }

}
