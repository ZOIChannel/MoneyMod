package com.zoi.money;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.world.World;
import net.minecraftforge.common.AchievementPage;


@Mod(modid = "MoneyMod", name = "MoneyMod", version = "1.0.0")
public class MoneyMod {
    public static Item wood_coin;
    public static Item stone_coin;
    public static Item iron_coin;
    public static Item gold_coin;
    public static Item diamond_coin;

    public static Achievement get_wood_coin;
    public static Achievement get_stone_coin;
    public static Achievement get_iron_coin;
    public static Achievement get_gold_coin;
    public static Achievement get_diamond_coin;

    public static  CreativeTabs tabMoney = new MoneyTab("Moneytab");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        wood_coin = new Item() {

            public void onCreated(ItemStack stack, World world, EntityPlayer player) {
                player.triggerAchievement(get_wood_coin);
                super.onCreated(stack, world, player);
            }
        }
                .setCreativeTab(MoneyMod.tabMoney)
                .setUnlocalizedName("wood_coin")
                .setTextureName("MoneyMod:wood_coin");
        GameRegistry.registerItem(wood_coin, "wood_coin");

        stone_coin = new Item(){
            public void onCreated(ItemStack stack, World world, EntityPlayer player) {
                player.triggerAchievement(get_stone_coin);
                super.onCreated(stack, world, player);
            }
        }
                .setCreativeTab(MoneyMod.tabMoney)
                .setUnlocalizedName("stone_coin")
                .setTextureName("MoneyMod:stone_coin");
        GameRegistry.registerItem(stone_coin, "stone_coin");

        iron_coin = new Item(){
            public void onCreated(ItemStack stack, World world, EntityPlayer player) {
                player.triggerAchievement(get_iron_coin);
                super.onCreated(stack, world, player);
            }
        }
                .setCreativeTab(MoneyMod.tabMoney)
                .setUnlocalizedName("iron_coin")
                .setTextureName("MoneyMod:iron_coin");
        GameRegistry.registerItem(iron_coin, "iron_coin");


        gold_coin = new Item(){
            public void onCreated(ItemStack stack, World world, EntityPlayer player) {
                player.triggerAchievement(get_gold_coin);
                super.onCreated(stack, world, player);
            }
        }
                .setCreativeTab(MoneyMod.tabMoney)
                .setUnlocalizedName("gold_coin")
                .setTextureName("MoneyMod:gold_coin");
        GameRegistry.registerItem(gold_coin, "gold_coin");

        diamond_coin = new Item(){
            public void onCreated(ItemStack stack, World world, EntityPlayer player) {
                player.triggerAchievement(get_diamond_coin);
                super.onCreated(stack, world, player);
            }
        }
                .setCreativeTab(MoneyMod.tabMoney)
                .setUnlocalizedName("diamond_coin")
                .setTextureName("MoneyMod:diamond_coin");
        GameRegistry.registerItem(diamond_coin, "diamond_coin");





        get_wood_coin = new Achievement("get_wood_coin", "get_wood_coin", 0, 0,
                new ItemStack(wood_coin, 0), null).registerStat();

        get_stone_coin = new Achievement("get_stone_coin", "get_stone_coin", 0, 2,
                new ItemStack(stone_coin, 0), get_wood_coin).registerStat();

        get_iron_coin = new Achievement("get_iron_coin", "get_iron_coin", 0, 4,
                new ItemStack(iron_coin, 0), get_stone_coin).registerStat();

        get_gold_coin = new Achievement("get_gold_coin", "get_gold_coin", 0, 6,
                new ItemStack(gold_coin, 0), get_iron_coin).registerStat();

        get_diamond_coin = new Achievement("get_diamond_coin", "get_diamond_coin", 0, 8,
                new ItemStack(diamond_coin, 0), get_gold_coin).registerStat();


        AchievementPage.registerAchievementPage(new AchievementPage("MoneyMod",
                get_wood_coin, get_stone_coin, get_iron_coin, get_gold_coin, get_diamond_coin));
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.addRecipe(new ItemStack(stone_coin),
                "XXX", "X X", "XXX", 'X', wood_coin);
        GameRegistry.addRecipe(new ItemStack(iron_coin),
                "XXX", "X X", "XXX", 'X', stone_coin);
        GameRegistry.addRecipe(new ItemStack(gold_coin),
                "XXX", "X X", "XXX", 'X', iron_coin);
        GameRegistry.addRecipe(new ItemStack(diamond_coin),
                "XXX", "X X", "XXX", 'X', gold_coin);

        GameRegistry.addShapelessRecipe(new ItemStack(gold_coin, 8),
                new ItemStack(diamond_coin));
        GameRegistry.addShapelessRecipe(new ItemStack(iron_coin, 8),
                new ItemStack(gold_coin));
        GameRegistry.addShapelessRecipe(new ItemStack(stone_coin, 8),
                new ItemStack(iron_coin));
        GameRegistry.addShapelessRecipe(new ItemStack(wood_coin, 8),
                new ItemStack(stone_coin));
    }

}
