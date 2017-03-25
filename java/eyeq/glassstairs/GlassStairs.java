package eyeq.glassstairs;

import eyeq.util.client.model.UModelLoader;
import eyeq.util.client.renderer.ResourceLocationFactory;
import eyeq.util.client.resource.ULanguageCreator;
import eyeq.util.client.resource.lang.LanguageResourceManager;
import eyeq.util.item.crafting.UCraftingManager;
import eyeq.util.oredict.CategoryTypes;
import eyeq.util.oredict.UOreDictionary;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import eyeq.glassstairs.block.BlockStairsGlass;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

import static eyeq.glassstairs.GlassStairs.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
@Mod.EventBusSubscriber
public class GlassStairs {
    public static final String MOD_ID = "eyeq_glassstairs";

    @Mod.Instance(MOD_ID)
    public static GlassStairs instance;

    private static final ResourceLocationFactory resource = new ResourceLocationFactory(MOD_ID);

    public static Block stairsGlass;
    public static Block stairsGlassBlack;
    public static Block stairsGlassRed;
    public static Block stairsGlassGreen;
    public static Block stairsGlassBrown;
    public static Block stairsGlassBlue;
    public static Block stairsGlassPurple;
    public static Block stairsGlassCyan;
    public static Block stairsGlassSilver;
    public static Block stairsGlassGray;
    public static Block stairsGlassPink;
    public static Block stairsGlassLime;
    public static Block stairsGlassYellow;
    public static Block stairsGlassLightBlue;
    public static Block stairsGlassMagenta;
    public static Block stairsGlassOrange;
    public static Block stairsGlassWhite;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        addRecipes();
        if(event.getSide().isServer()) {
            return;
        }
        renderItemModels();
        createFiles();
    }

    public static Block getBlockStairsStainedGlass(EnumDyeColor color) {
        String name = color.getUnlocalizedName();
        return new BlockStairsGlass(Blocks.STAINED_GLASS.getDefaultState().withProperty(BlockStainedGlass.COLOR, color)).setUnlocalizedName("stairsGlass" + name.substring(0, 1).toUpperCase() + name.substring(1));
    }

    @SubscribeEvent
    protected static void registerBlocks(RegistryEvent.Register<Block> event) {
        stairsGlass = new BlockStairsGlass(Blocks.GLASS.getDefaultState()).setUnlocalizedName("stairsGlass");
        stairsGlassWhite = getBlockStairsStainedGlass(EnumDyeColor.WHITE);
        stairsGlassOrange = getBlockStairsStainedGlass(EnumDyeColor.ORANGE);
        stairsGlassMagenta = getBlockStairsStainedGlass(EnumDyeColor.MAGENTA);
        stairsGlassLightBlue = getBlockStairsStainedGlass(EnumDyeColor.LIGHT_BLUE);
        stairsGlassYellow = getBlockStairsStainedGlass(EnumDyeColor.YELLOW);
        stairsGlassLime = getBlockStairsStainedGlass(EnumDyeColor.LIME);
        stairsGlassPink = getBlockStairsStainedGlass(EnumDyeColor.PINK);
        stairsGlassGray = getBlockStairsStainedGlass(EnumDyeColor.GRAY);
        stairsGlassSilver = getBlockStairsStainedGlass(EnumDyeColor.SILVER);
        stairsGlassCyan = getBlockStairsStainedGlass(EnumDyeColor.CYAN);
        stairsGlassPurple = getBlockStairsStainedGlass(EnumDyeColor.PURPLE);
        stairsGlassBlue = getBlockStairsStainedGlass(EnumDyeColor.BLUE);
        stairsGlassBrown = getBlockStairsStainedGlass(EnumDyeColor.BROWN);
        stairsGlassGreen = getBlockStairsStainedGlass(EnumDyeColor.GREEN);
        stairsGlassRed = getBlockStairsStainedGlass(EnumDyeColor.RED);
        stairsGlassBlack = getBlockStairsStainedGlass(EnumDyeColor.BLACK);

        GameRegistry.register(stairsGlass, resource.createResourceLocation("glass_stairs"));
        GameRegistry.register(stairsGlassWhite, resource.createResourceLocation("white_glass_stairs"));
        GameRegistry.register(stairsGlassOrange, resource.createResourceLocation("orange_glass_stairs"));
        GameRegistry.register(stairsGlassMagenta, resource.createResourceLocation("magenta_glass_stairs"));
        GameRegistry.register(stairsGlassLightBlue, resource.createResourceLocation("light_blue_glass_stairs"));
        GameRegistry.register(stairsGlassYellow, resource.createResourceLocation("yellow_glass_stairs"));
        GameRegistry.register(stairsGlassLime, resource.createResourceLocation("lime_glass_stairs"));
        GameRegistry.register(stairsGlassPink, resource.createResourceLocation("pink_glass_stairs"));
        GameRegistry.register(stairsGlassGray, resource.createResourceLocation("gray_glass_stairs"));
        GameRegistry.register(stairsGlassSilver, resource.createResourceLocation("silver_glass_stairs"));
        GameRegistry.register(stairsGlassCyan, resource.createResourceLocation("cyan_glass_stairs"));
        GameRegistry.register(stairsGlassPurple, resource.createResourceLocation("purple_glass_stairs"));
        GameRegistry.register(stairsGlassBlue, resource.createResourceLocation("blue_glass_stairs"));
        GameRegistry.register(stairsGlassBrown, resource.createResourceLocation("brown_glass_stairs"));
        GameRegistry.register(stairsGlassGreen, resource.createResourceLocation("green_glass_stairs"));
        GameRegistry.register(stairsGlassRed, resource.createResourceLocation("red_glass_stairs"));
        GameRegistry.register(stairsGlassBlack, resource.createResourceLocation("black_glass_stairs"));
    }

    @SubscribeEvent
    protected static void registerItems(RegistryEvent.Register<Item> event) {
        GameRegistry.register(new ItemBlock(stairsGlass), stairsGlass.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassWhite), stairsGlassWhite.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassOrange), stairsGlassOrange.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassMagenta), stairsGlassMagenta.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassLightBlue), stairsGlassLightBlue.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassYellow), stairsGlassYellow.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassLime), stairsGlassLime.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassPink), stairsGlassPink.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassGray), stairsGlassGray.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassSilver), stairsGlassSilver.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassCyan), stairsGlassCyan.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassPurple), stairsGlassPurple.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassBlue), stairsGlassBlue.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassBrown), stairsGlassBrown.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassGreen), stairsGlassGreen.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassRed), stairsGlassRed.getRegistryName());
        GameRegistry.register(new ItemBlock(stairsGlassBlack), stairsGlassBlack.getRegistryName());
    }

    public static void addRecipes() {
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlass, 4), UOreDictionary.OREDICT_COLORLESS_GLASS));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassWhite, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.WHITE.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassOrange, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.ORANGE.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassMagenta, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.MAGENTA.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassYellow, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.YELLOW.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassLime, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.LIME.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassPink, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.PINK.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassLightBlue, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.LIGHT_BLUE.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassGray, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.GRAY.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassSilver, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.SILVER.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassCyan, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.CYAN.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassPurple, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.PURPLE.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassBlue, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.BLUE.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassBrown, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.BROWN.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassGreen, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.GREEN.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassRed, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.RED.getUnlocalizedName())));
        GameRegistry.addRecipe(UCraftingManager.getRecipeStairs(new ItemStack(stairsGlassBlack, 4), CategoryTypes.PREFIX_BLOCK_GLASS.getDictionaryName(EnumDyeColor.BLACK.getUnlocalizedName())));
    }

    @SideOnly(Side.CLIENT)
    public static void renderItemModels() {
        UModelLoader.setCustomModelResourceLocation(stairsGlass);
        UModelLoader.setCustomModelResourceLocation(stairsGlassWhite);
        UModelLoader.setCustomModelResourceLocation(stairsGlassOrange);
        UModelLoader.setCustomModelResourceLocation(stairsGlassMagenta);
        UModelLoader.setCustomModelResourceLocation(stairsGlassYellow);
        UModelLoader.setCustomModelResourceLocation(stairsGlassLime);
        UModelLoader.setCustomModelResourceLocation(stairsGlassPink);
        UModelLoader.setCustomModelResourceLocation(stairsGlassLightBlue);
        UModelLoader.setCustomModelResourceLocation(stairsGlassGray);
        UModelLoader.setCustomModelResourceLocation(stairsGlassSilver);
        UModelLoader.setCustomModelResourceLocation(stairsGlassCyan);
        UModelLoader.setCustomModelResourceLocation(stairsGlassPurple);
        UModelLoader.setCustomModelResourceLocation(stairsGlassBlue);
        UModelLoader.setCustomModelResourceLocation(stairsGlassBrown);
        UModelLoader.setCustomModelResourceLocation(stairsGlassGreen);
        UModelLoader.setCustomModelResourceLocation(stairsGlassRed);
        UModelLoader.setCustomModelResourceLocation(stairsGlassBlack);
    }

    public static void createFiles() {
        File project = new File("../1.11.2-GlassStairs");

        LanguageResourceManager language = new LanguageResourceManager();

        language.register(LanguageResourceManager.EN_US, stairsGlass, "Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlass, "ガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassWhite, "White Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassWhite, "白色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassOrange, "Orange Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassOrange, "橙色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassMagenta, "Magenta Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassMagenta, "赤紫色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassYellow, "Yellow Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassYellow, "黄色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassLime, "Lime Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassLime, "黄緑色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassPink, "Pink Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassPink, "桃色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassLightBlue, "Light Blue Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassLightBlue, "空色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassGray, "Gray Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassGray, "灰色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassSilver, "Silver Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassSilver, "薄灰色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassCyan, "Cyan Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassCyan, "水色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassPurple, "Purple Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassPurple, "紫色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassBlue, "Blue Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassBlue, "青色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassBrown, "Brown Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassBrown, "茶色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassGreen, "Green Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassGreen, "緑色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassRed, "Red Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassRed, "赤色のガラスの階段");
        language.register(LanguageResourceManager.EN_US, stairsGlassBlack, "Black Glass Stairs");
        language.register(LanguageResourceManager.JA_JP, stairsGlassBlack, "黒色のガラスの階段");

        ULanguageCreator.createLanguage(project, MOD_ID, language);
    }
}
