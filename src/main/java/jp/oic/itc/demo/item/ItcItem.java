package jp.oic.itc.demo.item;

import jp.oic.itc.demo.TutorialMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by takahiro on 2014/06/04.
 */
public class ItcItem extends ItemSnowball {

    public ItcItem(){
        this.setCreativeTab(TutorialMain.tabMyMod);
        setMaxStackSize(64);
        setMaxDamage(128);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    	
    	if(!entityPlayer.capabilities.isCreativeMode){
    		itemStack.damageItem(1, entityPlayer);
    	}
    	
    	world.playSoundAtEntity(entityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote)
        {
        	world.spawnEntityInWorld(new EntitySnowball(world, entityPlayer));
        }

        System.out.println("right click:");

        return itemStack;
    }
    
}
