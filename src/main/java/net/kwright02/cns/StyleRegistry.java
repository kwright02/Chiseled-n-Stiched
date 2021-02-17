package net.kwright02.cns;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class StyleRegistry {

    public static StyleRegistry INSTANCE = new StyleRegistry();

    private StyleRegistry(){}

    public void registerBlock(String variant, String path, Block b, BlockItem bi){
        Registry.register(Registry.BLOCK, new Identifier("cns", variant + "_" + path), b);
        Registry.register(Registry.ITEM, new Identifier("cns", variant + "_" + path), bi);
    }

}
