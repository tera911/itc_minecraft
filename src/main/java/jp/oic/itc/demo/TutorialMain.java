package jp.oic.itc.demo;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import jp.oic.itc.demo.block.BlockTest;
import jp.oic.itc.demo.entity.EntityTest;
import jp.oic.itc.demo.item.ItcItem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import java.util.Random;

/**
 * Created by takahiro on 2014/06/03.
 */
@Mod(modid = TutorialMain.MODID, name = "Tutorial Mod", version = TutorialMain.VERSION)
public class TutorialMain {
    public static final String MODID = "tutorial";
    public static final String VERSION = "1.0";

    public static Block blockTest;
    public static Item itcItem;
    public static EntityMob mob;
    public static CreativeTabs tabMyMod = new CreativeTabsMyMod("MyMod");

    @Mod.Instance(MODID)
    public static TutorialMain instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        blockTest = new BlockTest().setBlockName("test");
        GameRegistry.registerBlock(blockTest, blockTest.getUnlocalizedName().substring(5));

        itcItem = new ItcItem().setUnlocalizedName("itcItem").setTextureName("tutorial:itcItem");
        GameRegistry.registerItem(itcItem, itcItem.getUnlocalizedName().substring(5));

        registerEntity(EntityTest.class, "entityTest");
    }

    public static void registerEntity(Class entityClass, String name)
    {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
}
