package jp.oic.itc.demo.block;

import jp.oic.itc.demo.TutorialMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by takahiro on 2014/06/03.
 */
public class BlockTest extends Block {

    public BlockTest(){
        super(Material.ground);
        this.setCreativeTab(TutorialMain.tabMyMod); //creativeのページに追加
        this.setBlockName("うんこ");
        this.setHarvestLevel("pickaxe", 3);
    }


    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
       // return Item.getItemFromBlock(this);
        return Items.diamond;
    }

    //ドロップした時の個数
    @Override
    public int quantityDropped(Random rand) {
        return 5 * rand.nextInt(1000);
    }

    @Override
    public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
        super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
        System.out.println("ブロック破壊");
    }

    @Override
    public int getLightValue() {
        return 15;
    }
}
