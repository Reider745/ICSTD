package ru.koshakmine.icstd.type.block;

import com.zhekasmirnov.innercore.api.unlimited.IDRegistry;

import java.lang.reflect.Field;
import java.util.HashMap;

public class BlockID {
    private static final HashMap<String, Integer> blockIdShortcut;

    static {
        try {
            final Field field = IDRegistry.class.getDeclaredField("blockIdShortcut");
            field.setAccessible(true);
            blockIdShortcut = (HashMap<String, Integer>) field.get(null);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Integer getModId(String strId){
        return blockIdShortcut.get(strId);
    }

    public static int getModId(String strId, int def){
        return blockIdShortcut.getOrDefault(strId, def);
    }

    public static final int BIRCH_STAIRS = 135;
    public static final int MAGMA = 213;
    public static final int MOSSY_COBBLESTONE = 48;
    public static final int DIAMOND_ORE = 56;
    public static final int ELEMENT_12 = 278;
    public static final int ELEMENT_13 = 279;
    public static final int ELEMENT_14 = 280;
    public static final int ELEMENT_15 = 281;
    public static final int SPRUCE_FENCE_GATE = 183;
    public static final int ELEMENT_10 = 276;
    public static final int ELEMENT_11 = 277;
    public static final int BIRCH_FENCE_GATE = 184;
    public static final int STANDING_SIGN = 63;
    public static final int STAINED_GLASS_PANE = 160;
    public static final int DRAGON_EGG = 122;
    public static final int ELEMENT_16 = 282;
    public static final int ELEMENT_17 = 283;
    public static final int ELEMENT_18 = 284;
    public static final int LEAVES2 = 161;
    public static final int ELEMENT_19 = 285;
    public static final int POWERED_REPEATER = 94;
    public static final int SCAFFOLDING = 420;
    public static final int CHORUS_PLANT = 240;
    public static final int COCOA = 127;
    public static final int FLOWING_LAVA = 10;
    public static final int ELEMENT_23 = 289;
    public static final int LAPIS_ORE = 21;
    public static final int ELEMENT_24 = 290;
    public static final int ELEMENT_25 = 291;
    public static final int BIRCH_PRESSURE_PLATE = 406;
    public static final int ELEMENT_26 = 292;
    public static final int GOLD_BLOCK = 41;
    public static final int ELEMENT_20 = 286;
    public static final int TRAPDOOR = 96;
    public static final int ELEMENT_21 = 287;
    public static final int TRIPWIRE = 132;
    public static final int ELEMENT_22 = 288;
    public static final int ELEMENT_27 = 293;
    public static final int DARK_OAK_PRESSURE_PLATE = 407;
    public static final int ELEMENT_28 = 294;
    public static final int ELEMENT_29 = 295;
    public static final int BLAST_FURNACE = 451;
    public static final int CARTOGRAPHY_TABLE = 455;
    public static final int SPONGE = 19;
    public static final int DAYLIGHT_DETECTOR = 151;
    public static final int BONE_BLOCK = 216;
    public static final int LIT_REDSTONE_LAMP = 124;
    public static final int DAYLIGHT_DETECTOR_INVERTED = 178;
    public static final int PRISMARINE_STAIRS = 257;
    public static final int SLIME = 165;
    public static final int GRASS = 2;
    public static final int END_STONE = 121;
    public static final int WHEAT = 59;
    public static final int END_ROD = 208;
    public static final int DOUBLE_STONE_SLAB = 43;
    public static final int ACACIA_DOOR = 196;
    public static final int QUARTZ_ORE = 153;
    public static final int PISTON = 33;
    public static final int COBBLESTONE_WALL = 139;
    public static final int WHITE_GLAZED_TERRACOTTA = 220;
    public static final int ENDER_CHEST = 130;
    public static final int KELP = 393;
    public static final int RED_MUSHROOM_BLOCK = 100;
    public static final int NETHER_WART_BLOCK = 214;
    public static final int MELON_BLOCK = 103;
    public static final int GRASS_PATH = 198;
    public static final int STRIPPED_OAK_LOG = 265;
    public static final int BED = 26;
    public static final int HARD_GLASS_PANE = 190;
    public static final int FURNACE = 61;
    public static final int REDSTONE_ORE = 73;
    public static final int RED_FLOWER = 38;
    public static final int ELEMENT_60 = 326;
    public static final int ELEMENT_61 = 327;
    public static final int ELEMENT_62 = 328;
    public static final int STONE_SLAB = 44;
    public static final int FARMLAND = 60;
    public static final int ELEMENT_56 = 322;
    public static final int ELEMENT_57 = 323;
    public static final int ELEMENT_58 = 324;
    public static final int ELEMENT_59 = 325;
    public static final int ELEMENT_52 = 318;
    public static final int ELEMENT_53 = 319;
    public static final int ACACIA_STANDING_SIGN = 445;
    public static final int IRON_TRAPDOOR = 167;
    public static final int ELEMENT_54 = 320;
    public static final int PISTONARMCOLLISION = 34;
    public static final int ELEMENT_55 = 321;
    public static final int MOVINGBLOCK = 250;
    public static final int STONE_BUTTON = 77;
    public static final int STONE_PRESSURE_PLATE = 70;
    public static final int IRON_BARS = 101;
    public static final int SMOOTH_RED_SANDSTONE_STAIRS = 431;
    public static final int ELEMENT_70 = 336;
    public static final int ELEMENT_71 = 337;
    public static final int STRUCTURE_BLOCK = 252;
    public static final int ELEMENT_72 = 338;
    public static final int ELEMENT_73 = 339;
    public static final int STICKY_PISTON = 29;
    public static final int DARK_OAK_BUTTON = 397;
    public static final int FROSTED_ICE = 207;
    public static final int ELEMENT_67 = 333;
    public static final int DARK_OAK_DOOR = 197;
    public static final int SAND = 12;
    public static final int ELEMENT_68 = 334;
    public static final int ELEMENT_69 = 335;
    public static final int BEACON = 138;
    public static final int ELEMENT_63 = 329;
    public static final int ELEMENT_64 = 330;
    public static final int ELEMENT_65 = 331;
    public static final int ELEMENT_66 = 332;
    public static final int FRAME = 199;
    public static final int FLETCHING_TABLE = 456;
    public static final int PURPLE_GLAZED_TERRACOTTA = 219;
    public static final int STANDING_BANNER = 176;
    public static final int ELEMENT_40 = 306;
    public static final int NETHERREACTOR = 247;
    public static final int DISPENSER = 23;
    public static final int PINK_GLAZED_TERRACOTTA = 226;
    public static final int ELEMENT_34 = 300;
    public static final int ELEMENT_35 = 301;
    public static final int CHORUS_FLOWER = 200;
    public static final int ELEMENT_36 = 302;
    public static final int ELEMENT_37 = 303;
    public static final int ELEMENT_30 = 296;
    public static final int ELEMENT_31 = 297;
    public static final int COLORED_TORCH_RG = 202;
    public static final int ELEMENT_32 = 298;
    public static final int BIRCH_STANDING_SIGN = 441;
    public static final int ELEMENT_33 = 299;
    public static final int REDSTONE_LAMP = 123;
    public static final int HARD_GLASS = 253;
    public static final int ELEMENT_38 = 304;
    public static final int ELEMENT_39 = 305;
    public static final int COAL_BLOCK = 173;
    public static final int HEAVY_WEIGHTED_PRESSURE_PLATE = 148;
    public static final int FLOWER_POT = 140;
    public static final int ACACIA_BUTTON = 395;
    public static final int ELEMENT_50 = 316;
    public static final int ELEMENT_51 = 317;
    public static final int ACACIA_TRAPDOOR = 400;
    public static final int ELEMENT_45 = 311;
    public static final int NORMAL_STONE_STAIRS = 435;
    public static final int ELEMENT_46 = 312;
    public static final int ELEMENT_47 = 313;
    public static final int ELEMENT_48 = 314;
    public static final int ELEMENT_41 = 307;
    public static final int ELEMENT_42 = 308;
    public static final int ELEMENT_43 = 309;
    public static final int ACACIA_WALL_SIGN = 446;
    public static final int ELEMENT_44 = 310;
    public static final int ELEMENT_49 = 315;
    public static final int WOODEN_SLAB = 158;
    public static final int LIT_PUMPKIN = 91;
    public static final int CHAIN_COMMAND_BLOCK = 189;
    public static final int ACACIA_STAIRS = 163;
    public static final int DROPPER = 125;
    public static final int STONE_SLAB4 = 421;
    public static final int LIT_BLAST_FURNACE = 469;
    public static final int JUNGLE_WALL_SIGN = 444;
    public static final int GLOWSTONE = 89;
    public static final int BUBBLE_COLUMN = 415;
    public static final int ELEMENT_96 = 362;
    public static final int DOUBLE_STONE_SLAB3 = 422;
    public static final int DOUBLE_STONE_SLAB2 = 181;
    public static final int ELEMENT_97 = 363;
    public static final int CORAL_BLOCK = 387;
    public static final int ELEMENT_98 = 364;
    public static final int ELEMENT_99 = 365;
    public static final int DOUBLE_STONE_SLAB4 = 423;
    public static final int ORANGE_GLAZED_TERRACOTTA = 221;
    public static final int PORTAL = 90;
    public static final int BLACK_GLAZED_TERRACOTTA = 235;
    public static final int CONCRETEPOWDER = 237;
    public static final int BOOKSHELF = 47;
    public static final int BELL = 461;
    public static final int GRAVEL = 13;
    public static final int MOSSY_STONE_BRICK_STAIRS = 430;
    public static final int STONE_SLAB3 = 417;
    public static final int ACACIA_FENCE_GATE = 187;
    public static final int STONE_SLAB2 = 182;
    public static final int JIGSAW = 466;
    public static final int STRIPPED_JUNGLE_LOG = 262;
    public static final int BLUE_GLAZED_TERRACOTTA = 231;
    public static final int TNT = 46;
    public static final int DETECTOR_RAIL = 28;
    public static final int CORAL_FAN = 388;
    public static final int ANVIL = 145;
    public static final int ELEMENT_81 = 347;
    public static final int ELEMENT_82 = 348;
    public static final int ELEMENT_83 = 349;
    public static final int ELEMENT_84 = 350;
    public static final int AIR = 0;
    public static final int JUNGLE_FENCE_GATE = 185;
    public static final int SANDSTONE = 24;
    public static final int CONDUIT = 412;
    public static final int ELEMENT_80 = 346;
    public static final int END_BRICKS = 206;
    public static final int ELEMENT_78 = 344;
    public static final int OAK_STAIRS = 53;
    public static final int ELEMENT_79 = 345;
    public static final int BEDROCK = 7;
    public static final int ELEMENT_74 = 340;
    public static final int ELEMENT_75 = 341;
    public static final int UNPOWERED_REPEATER = 93;
    public static final int ELEMENT_76 = 342;
    public static final int ELEMENT_77 = 343;
    public static final int LOG2 = 162;
    public static final int END_PORTAL = 119;
    public static final int ELEMENT_92 = 358;
    public static final int BIRCH_WALL_SIGN = 442;
    public static final int PURPUR_BLOCK = 201;
    public static final int ELEMENT_93 = 359;
    public static final int DOUBLE_WOODEN_SLAB = 157;
    public static final int ELEMENT_94 = 360;
    public static final int TORCH = 50;
    public static final int ELEMENT_95 = 361;
    public static final int UNDERWATER_TORCH = 239;
    public static final int LANTERN = 463;
    public static final int SMITHING_TABLE = 457;
    public static final int ELEMENT_90 = 356;
    public static final int ELEMENT_91 = 357;
    public static final int ELEMENT_89 = 355;
    public static final int ELEMENT_85 = 351;
    public static final int ELEMENT_86 = 352;
    public static final int ELEMENT_87 = 353;
    public static final int ELEMENT_88 = 354;
    public static final int SMOOTH_STONE = 438;
    public static final int STONEBRICK = 98;
    public static final int SPRUCE_PRESSURE_PLATE = 409;
    public static final int SPRUCE_WALL_SIGN = 437;
    public static final int BIRCH_DOOR = 194;
    public static final int WOODEN_DOOR = 64;
    public static final int GLOWINGOBSIDIAN = 246;
    public static final int BROWN_MUSHROOM = 39;
    public static final int CORAL_FAN_DEAD = 389;
    public static final int NOTEBLOCK = 25;
    public static final int CORAL = 386;
    public static final int SAPLING = 6;
    public static final int LIGHT_BLUE_GLAZED_TERRACOTTA = 223;
    public static final int STONECUTTER = 245;
    public static final int GLASS_PANE = 102;
    public static final int SEA_PICKLE = 411;
    public static final int CARVED_PUMPKIN = 410;
    public static final int CORAL_FAN_HANG = 390;
    public static final int REDSTONE_TORCH = 76;
    public static final int GOLDEN_RAIL = 27;
    public static final int POLISHED_GRANITE_STAIRS = 427;
    public static final int DIRT = 3;
    public static final int POWERED_COMPARATOR = 150;
    public static final int LEVER = 69;
    public static final int INVISIBLEBEDROCK = 95;
    public static final int ACACIA_PRESSURE_PLATE = 405;
    public static final int ANDESITE_STAIRS = 426;
    public static final int FLOWING_WATER = 8;
    public static final int PRISMARINE_BRICKS_STAIRS = 259;
    public static final int DARK_OAK_FENCE_GATE = 186;
    public static final int SNOW = 80;
    public static final int POLISHED_ANDESITE_STAIRS = 429;
    public static final int GRANITE_STAIRS = 424;
    public static final int JUNGLE_PRESSURE_PLATE = 408;
    public static final int EMERALD_ORE = 129;
    public static final int STRIPPED_SPRUCE_LOG = 260;
    public static final int MONSTER_EGG = 97;
    public static final int STRIPPED_ACACIA_LOG = 263;
    public static final int FENCE_GATE = 107;
    public static final int BREWING_STAND = 117;
    public static final int CYAN_GLAZED_TERRACOTTA = 229;
    public static final int COBBLESTONE = 4;
    public static final int REDSTONE_BLOCK = 152;
    public static final int JUNGLE_DOOR = 195;
    public static final int SKULL = 144;
    public static final int WALL_SIGN = 68;
    public static final int BEETROOT = 244;
    public static final int YELLOW_FLOWER = 37;
    public static final int LADDER = 65;
    public static final int RED_NETHER_BRICK = 215;
    public static final int PUMPKIN = 86;
    public static final int FENCE = 85;
    public static final int TRAPPED_CHEST = 146;
    public static final int ELEMENT_101 = 367;
    public static final int ELEMENT_100 = 366;
    public static final int SPRUCE_DOOR = 193;
    public static final int NETHER_BRICK_FENCE = 113;
    public static final int OBSERVER = 251;
    public static final int CAKE = 92;
    public static final int PODZOL = 243;
    public static final int ELEMENT_109 = 375;
    public static final int ELEMENT_108 = 374;
    public static final int FIRE = 51;
    public static final int ELEMENT_107 = 373;
    public static final int HARDENED_CLAY = 172;
    public static final int ELEMENT_106 = 372;
    public static final int ELEMENT_105 = 371;
    public static final int ELEMENT_104 = 370;
    public static final int ELEMENT_103 = 369;
    public static final int ELEMENT_102 = 368;
    public static final int REPEATING_COMMAND_BLOCK = 188;
    public static final int PACKED_ICE = 174;
    public static final int WATERLILY = 111;
    public static final int ENCHANTING_TABLE = 116;
    public static final int NETHER_BRICK = 112;
    public static final int BAMBOO = 418;
    public static final int DEADBUSH = 32;
    public static final int CLAY = 82;
    public static final int STONE_BRICK_STAIRS = 109;
    public static final int LECTERN = 449;
    public static final int QUARTZ_BLOCK = 155;
    public static final int SPRUCE_TRAPDOOR = 404;
    public static final int CACTUS = 81;
    public static final int CARROTS = 141;
    public static final int GRAY_GLAZED_TERRACOTTA = 227;
    public static final int INFO_UPDATE2 = 249;
    public static final int ELEMENT_112 = 378;
    public static final int ELEMENT_111 = 377;
    public static final int ELEMENT_110 = 376;
    public static final int BIRCH_BUTTON = 396;
    public static final int ELEMENT_118 = 384;
    public static final int ELEMENT_117 = 383;
    public static final int ELEMENT_116 = 382;
    public static final int ELEMENT_115 = 381;
    public static final int ELEMENT_114 = 380;
    public static final int ELEMENT_113 = 379;
    public static final int MYCELIUM = 110;
    public static final int WOOL = 35;
    public static final int RED_NETHER_BRICK_STAIRS = 439;
    public static final int LIT_REDSTONE_ORE = 74;
    public static final int STRIPPED_BIRCH_LOG = 261;
    public static final int ICE = 79;
    public static final int HAY_BLOCK = 170;
    public static final int DARK_OAK_STAIRS = 164;
    public static final int SMOKER = 453;
    public static final int CHEMICAL_HEAT = 192;
    public static final int BAMBOO_SAPLING = 419;
    public static final int LOOM = 459;
    public static final int LEAVES = 18;
    public static final int DARKOAK_STANDING_SIGN = 447;
    public static final int NETHER_WART = 115;
    public static final int WOOD = 467;
    public static final int RESERVED6 = 255;
    public static final int COMPOSTER = 468;
    public static final int WOODEN_BUTTON = 143;
    public static final int CHEST = 54;
    public static final int OBSIDIAN = 49;
    public static final int GLASS = 20;
    public static final int SEAGRASS = 385;
    public static final int STONE_STAIRS = 67;
    public static final int WOODEN_PRESSURE_PLATE = 72;
    public static final int END_PORTAL_FRAME = 120;
    public static final int COLORED_TORCH_BP = 204;
    public static final int GRINDSTONE = 450;
    public static final int CORAL_FAN_HANG2 = 391;
    public static final int CARPET = 171;
    public static final int CORAL_FAN_HANG3 = 392;
    public static final int DARK_PRISMARINE_STAIRS = 258;
    public static final int JUNGLE_BUTTON = 398;
    public static final int SWEET_BERRY_BUSH = 462;
    public static final int POTATOES = 142;
    public static final int JUKEBOX = 84;
    public static final int UNLIT_REDSTONE_TORCH = 75;
    public static final int BIRCH_TRAPDOOR = 401;
    public static final int UNDYED_SHULKER_BOX = 205;
    public static final int LAVA = 11;
    public static final int JUNGLE_STANDING_SIGN = 443;
    public static final int REEDS = 83;
    public static final int JUNGLE_TRAPDOOR = 403;
    public static final int MAGENTA_GLAZED_TERRACOTTA = 222;
    public static final int STAINED_HARDENED_CLAY = 159;
    public static final int RED_SANDSTONE_STAIRS = 180;
    public static final int DOUBLE_PLANT = 175;
    public static final int CRAFTING_TABLE = 58;
    public static final int BROWN_MUSHROOM_BLOCK = 99;
    public static final int MELON_STEM = 105;
    public static final int DIAMOND_BLOCK = 57;
    public static final int DRIED_KELP_BLOCK = 394;
    public static final int STONE = 1;
    public static final int DARK_OAK_TRAPDOOR = 402;
    public static final int SPRUCE_STANDING_SIGN = 436;
    public static final int CAULDRON = 118;
    public static final int RED_SANDSTONE = 179;
    public static final int SOUL_SAND = 88;
    public static final int SILVER_GLAZED_TERRACOTTA = 228;
    public static final int END_BRICK_STAIRS = 433;
    public static final int SANDSTONE_STAIRS = 128;
    public static final int ELEMENT_9 = 275;
    public static final int ELEMENT_8 = 274;
    public static final int POLISHED_DIORITE_STAIRS = 428;
    public static final int ELEMENT_7 = 273;
    public static final int ELEMENT_6 = 272;
    public static final int ELEMENT_5 = 271;
    public static final int ELEMENT_4 = 270;
    public static final int ELEMENT_3 = 269;
    public static final int LIME_GLAZED_TERRACOTTA = 225;
    public static final int END_GATEWAY = 209;
    public static final int HARD_STAINED_GLASS = 254;
    public static final int NETHER_BRICK_STAIRS = 114;
    public static final int COMMAND_BLOCK = 137;
    public static final int LAVA_CAULDRON = 465;
    public static final int ELEMENT_2 = 268;
    public static final int JUNGLE_STAIRS = 136;
    public static final int ELEMENT_1 = 267;
    public static final int ELEMENT_0 = 36;
    public static final int MOB_SPAWNER = 52;
    public static final int SMOOTH_QUARTZ_STAIRS = 440;
    public static final int LOG = 17;
    public static final int SMOOTH_SANDSTONE_STAIRS = 432;
    public static final int REDSTONE_WIRE = 55;
    public static final int WEB = 30;
    public static final int STRIPPED_DARK_OAK_LOG = 264;
    public static final int BRICK_BLOCK = 45;
    public static final int BARREL = 458;
    public static final int PUMPKIN_STEM = 104;
    public static final int EMERALD_BLOCK = 133;
    public static final int STAINED_GLASS = 241;
    public static final int SEALANTERN = 169;
    public static final int IRON_ORE = 15;
    public static final int LAPIS_BLOCK = 22;
    public static final int PLANKS = 5;
    public static final int WALL_BANNER = 177;
    public static final int LIT_SMOKER = 454;
    public static final int PRISMARINE = 168;
    public static final int DARKOAK_WALL_SIGN = 448;
    public static final int MOSSY_COBBLESTONE_STAIRS = 434;
    public static final int TALLGRASS = 31;
    public static final int IRON_BLOCK = 42;
    public static final int IRON_DOOR = 71;
    public static final int UNPOWERED_COMPARATOR = 149;
    public static final int BLUE_ICE = 266;
    public static final int BARRIER = 416;
    public static final int CAMPFIRE = 464;
    public static final int VINE = 106;
    public static final int QUARTZ_STAIRS = 156;
    public static final int RAIL = 66;
    public static final int HARD_STAINED_GLASS_PANE = 191;
    public static final int CHEMISTRY_TABLE = 238;
    public static final int TURTLE_EGG = 414;
    public static final int WATER = 9;
    public static final int RED_GLAZED_TERRACOTTA = 234;
    public static final int COAL_ORE = 16;
    public static final int LIT_FURNACE = 62;
    public static final int CONCRETE = 236;
    public static final int BRICK_STAIRS = 108;
    public static final int BROWN_GLAZED_TERRACOTTA = 232;
    public static final int DIORITE_STAIRS = 425;
    public static final int TRIPWIRE_HOOK = 131;
    public static final int INFO_UPDATE = 248;
    public static final int STONECUTTER_BLOCK = 452;
    public static final int PURPUR_STAIRS = 203;
    public static final int GREEN_GLAZED_TERRACOTTA = 233;
    public static final int SPRUCE_BUTTON = 399;
    public static final int NETHERRACK = 87;
    public static final int SNOW_LAYER = 78;
    public static final int LIGHT_WEIGHTED_PRESSURE_PLATE = 147;
    public static final int SPRUCE_STAIRS = 134;
    public static final int ACTIVATOR_RAIL = 126;
    public static final int GOLD_ORE = 14;
    public static final int SHULKER_BOX = 218;
    public static final int YELLOW_GLAZED_TERRACOTTA = 224;
    public static final int RED_MUSHROOM = 40;
    public static final int HOPPER = 154;
}
