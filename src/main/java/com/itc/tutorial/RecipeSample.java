package com.itc.tutorial;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by takahiro on 2014/05/31.
 */
@Mod(modid="RecipeSampleMod", name="RecipeSampleMod", version="1.0")
public class RecipeSample {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.addRecipe(new ItemStack(Items.diamond, 64),
                "XXX",
                "XXX",
                "XXX",
            'X', Blocks.dirt);
    }
}
