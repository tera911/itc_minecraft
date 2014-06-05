package jp.oic.itc.demo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * Created by takahiro on 2014/06/03.
 */
public class CreativeTabsMyMod extends CreativeTabs{

    public CreativeTabsMyMod(String tabLabel){
        super(tabLabel);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem(){
        return Item.getItemFromBlock(Blocks.dirt);
    }

}
