package jp.oic.itc.demo.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Created by takahiro on 2014/06/04.
 */
public class EntityTest extends EntityMob {


    public EntityTest(World par1World){
        super(par1World);


		/*
		 * タスクにAIを追加する.
		 * 引数は(優先度, AIクラスのインスタンス)
		 */

		/*
		 * 近接攻撃を行うAIを追加する.
		 * EntityAIAttackOnCollideの引数のうち, 末尾2つは(攻撃距離, ずっと追い続けるかどうか)
		 */
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

    @Override
    protected Item getDropItem() {
        return Items.bone;
    }
}
