package net.kwright02.cns.modHandlers;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;

public class Registrar {

    public static String mod_name = "";
    public static ItemGroup itemGroup;
    public void registerVariants() {

    }
    public boolean isModPresent() {
        return FabricLoader.getInstance().isModLoaded(mod_name);
    }

    public static void setModName(String name){
        mod_name = name;
    }

}
