package com.example.qube.project2simpleshop.setup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Qube on 7/31/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String KEY = "key";

    private static final String DATABASE_NAME = "Exvius_Shop_Database";
    public static final int DATABASE_VERSION = 6;

    private static final String CHARACTER_ESPER_TABLE = "CHARACTER_ESPER_TABLE";
    //    private static final String ITEM_TABLE = "ITEM_TABLE";
    private static final String CART_TABLE = "CART_TABLE";

    private static final String COL_ID = "_id";

    private static final String COL_C_E_ID = "C_E_ID";
    private static final String COL_ICON = "ICON";
    private static final String COL_NAME = "NAME";
    private static final String COL_TYPE = "TYPE";
    private static final String COL_RARITY = "RARITY";
    private static final String COL_PRICE = "PRICE";
    private static final String COL_QUANTITY = "QUANTITY";
    private static final String COL_CATEGORY = "CATEGORY";
    private static final String COL_HP = "HP";
    private static final String COL_MP = "MP";
    private static final String COL_ATK = "ATK";
    private static final String COL_DEF = "DEF";
    private static final String COL_MAG = "MAG";
    private static final String COL_SPR = "SPR";
    private static final String COL_ORIGIN = "ORIGIN";

//    private static final String COL_ITEM_ID = "ITEM_ID";
//    private static final String COL_ITEM_ICON = "ITEM_ICON";
//    private static final String COL_ITEM_NAME = "ITEM_NAME";
//    private static final String COL_ITEM_TYPE = "ITEM_TYPE";
//    private static final String COL_ITEM_RARITY = "ITEM_RARITY";
//    private static final String COL_ITEM_PRICE = "ITEM_PRICE";
//    private static final String COL_ITEM_QUANTITY = "ITEM_QUANTITY";

    private static final String COL_CART_ID = "CART_ID";
    private static final String COL_CART_QUANTITY = "CART_QUANTITY";
    public static final String COL_REF_C_E_ID = "C_E_ID";

    private static final String CREATE_CHARACTER_ESPER_TABLE = "CREATE TABLE " + CHARACTER_ESPER_TABLE + " ("
            + COL_C_E_ID + " INTEGER PRIMARY KEY NOT NULL, "
            + COL_ICON + " TEXT NOT NULL, "
            + COL_NAME + " TEXT NOT NULL, "
            + COL_TYPE + " TEXT NOT NULL, "
            + COL_RARITY + " TEXT NOT NULL, "
            + COL_PRICE + " INTEGER NOT NULL, "
            + COL_QUANTITY + " INTEGER NOT NULL, "
            + COL_CATEGORY + " TEXT NOT NULL, "
            + COL_HP + " INTEGER NOT NULL, "
            + COL_MP + " INTEGER NOT NULL, "
            + COL_ATK + " INTEGER NOT NULL, "
            + COL_DEF + " INTEGER NOT NULL, "
            + COL_MAG + " INTEGER NOT NULL, "
            + COL_SPR + " INTEGER NOT NULL, "
            + COL_ORIGIN + " TEXT NOT NULL)";

    // Will work on after project is completed
//    private static final String CREATE_ITEM_TABLE = "CREATE TABLE " + ITEM_TABLE + " ("
//            + COL_ITEM_ID + " INTEGER PRIMARY KEY NOT NULL, "
//            + COL_ITEM_ICON + " TEXT NOT NULL, "
//            + COL_ITEM_NAME + " TEXT NOT NULL, "
//            + COL_ITEM_TYPE + " TEXT NOT NULL, "
//            + COL_ITEM_RARITY + " TEXT NOT NULL, "
//            + COL_ITEM_PRICE + " INTEGER NOT NULL, "
//            + COL_ITEM_QUANTITY + " INTEGER NOT NULL)";

    public static final String CREATE_CART_TABLE = "CREATE TABLE " + CART_TABLE + " ("
            + COL_CART_ID + " INTEGER PRIMARY KEY NOT NULL, "
            + COL_CART_QUANTITY + " INTEGER NOT NULL, "
            + COL_REF_C_E_ID + " INTEGER NOT NULL, "
//            + COL_ITEM_ID + " INTEGER NOT NULL, "
            + "FOREIGN KEY (" + COL_REF_C_E_ID + ") REFERENCES " + CHARACTER_ESPER_TABLE + "(" + COL_C_E_ID + ")) ";
    // Will work on after project is completed
//            + "FOREIGN KEY (" + COL_ITEM_ID + ") REFERENCES " + ITEM_TABLE + "(" + COL_ITEM_ID + "))";


    private static DatabaseHelper instance;

    // Constructor
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // getInstance helper method
    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CHARACTER_ESPER_TABLE);
//        db.execSQL(CREATE_ITEM_TABLE);
        db.execSQL(CREATE_CART_TABLE);

        int[] id = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
                71, 72, 73, 74, 75, 76, 77, 78};

        String[] icon = {
                "ic_rain", "ic_lasswell", "ic_fina", "ic_rizer", "ic_leah", "ic_tronn", "ic_eldin", "ic_baurg", "ic_gimlee", "ic_maxell",
                "ic_liza", "ic_wedge", "ic_biggs", "ic_paul", "ic_anastasis", "ic_sarah", "ic_king_giott", "ic_shiki", "ic_mizell", "ic_ronaldo",
                "ic_mel", "ic_vivi", "ic_penelo", "ic_maria", "ic_sabin", "ic_shadow", "ic_krile", "ic_kain", "ic_edgar", "ic_fran",
                "ic_shantotto", "ic_rydia", "ic_cyan", "ic_clyne", "ic_anzelm", "ic_luna", "ic_bedile", "ic_garland", "ic_exdeath", "ic_kuja",
                "ic_cloud_of_darkness", "ic_cecil", "ic_terra", "ic_magitek_armor_terra", "ic_bartz", "ic_firion", "ic_zidane", "ic_vaan", "ic_duane", "ic_cerius",
                "ic_roselia", "ic_medius", "ic_sarai", "ic_paula", "ic_kenyu", "ic_ollie", "ic_carrie", "ic_skaha", "ic_montana", "ic_russell",
                "ic_miyuki", "ic_golbez", "ic_galuf", "ic_xiao", "ic_artemios", "ic_locke", "ic_leo", "ic_gilbert", "ic_celes", "ic_kefka",
                "ic_rakshasa", "ic_chizuru", "ic_hayate", "ic_siren", "ic_ifrit", "ic_golem", "ic_shiva", "ic_ramuh"};

        String[] name = {
                "Rain", "Lasswell", "Fina", "Rizer", "Leah", "Tronn", "Eldin", "Baurg", "Gimlee", "Maxell",
                "Liza", "Wedge", "Biggs", "Paul", "Anastasis", "Sarah", "King Giott", "Shiki", "Mizell", "Ronaldo",
                "Mel", "Vivi", "Penelo", "Maria", "Sabin", "Shadow", "Krile", "Kain", "Edgar", "Fran",
                "Shantotto", "Rydia", "Cyan", "Clyne", "Anzelm", "Luna", "Bedile", "Garland", "Exdeath", "Kuja",
                "Cloud of Darkness", "Cecil", "Terra", "Magitek Armor Terra", "Bartz", "Firion", "Zidane", "Vaan", "Duane", "Cerius",
                "Roselia", "Medius", "Sarai", "Paula", "Kenyu", "Ollie", "Carrie", "Skaha", "Montana", "Russell",
                "Miyuki", "Golbez", "Galuf", "Xiao", "Artemios", "Locke", "Leo", "Gilbert", "Celes", "Kefka",
                "Rakshasa", "Chizuru", "Hayate", "Siren", "Ifrit", "Golem", "Shiva", "Ramuh"};

        String[] type = {
                "Knight", "Knight", "White Magus", "Warrior", "White Mage", "Black Mage", "Thief", "Monk", "Ranger", "Gunner",
                "Bard", "Imperial", "Imperial", "Bandit", "High Priest", "Songstress", "Warrior", "Samurai", "Green Mage", "Spellblade",
                "Salve-maker", "Black Mage", "Dancer", "White Mage", "Monk", "Assassin", "Red Mage", "Dragoon", "Machinist", "Sky Pirate",
                "Professor", "Summoner", "Samurai", "Knight", "Red Mage", "Ranger", "Spellblade", "Chaos Knight", "Dark Mage", "Reaper",
                "Ravager", "Paladin", "Magic Warrior", "Imperial", "Adventurer", "Warrior", "Bandit", "Warrior", "Warmage", "Green Mage",
                "White Magus", "Gunner", "Dancer", "Black Mage", "Black Belt", "Viking", "Machinist", "Dragoon", "Adventurer", "Gladiator",
                "Ninja", "Mage", "Warrior", "Monk", "Ranger", "Adventurer", "General", "Bard", "Rune Knight", "Archmage",
                "Spellblade", "Samurai", "Ninja", "Water", "Fire", "Earth", "Ice", "Thunder"};

        String[] rarity = {
                "5*", "5*", "5*", "2*", "2*", "2*", "2*", "2*", "2*", "2*",
                "2*", "3*", "3*", "3*", "3*", "3*", "3*", "3*", "3*", "3*",
                "3*", "4*", "4*", "4*", "4*", "4*", "4*", "4*", "4*", "4*",
                "4*", "4*", "4*", "4*", "4*", "4*", "4*", "5*", "5*", "5*",
                "5*", "5*", "5*", "4*", "5*", "5*", "5*", "5*", "5*", "5*",
                "5*", "5*", "2*", "3*", "3*", "3*", "3*", "3*", "3*", "4*",
                "5*", "5*", "4*", "5*", "5*", "5*", "5*", "5*", "5*", "5*",
                "5*", "5*", "5*", "2*", "2*", "2*", "2*", "2*"};

        int[] price = {
                1999, 1999, 1999, 199, 199, 199, 199, 199, 199, 199,
                199, 599, 599, 599, 599, 599, 599, 599, 599, 599,
                599, 1399, 1399, 1399, 1399, 1399, 1399, 1399, 1399, 1399,
                1399, 1399, 1399, 1399, 1399, 1399, 1399, 4999, 8999, 4999,
                99999, 99999, 19999, 1399, 27999, 24999, 999999, 24999, 19999, 14999,
                27999, 14999, 199, 599, 599, 599, 599, 599, 599, 1399,
                49999, 49999, 2999, 49999, 19999, 49999, 49999, 19999, 29999, 74999,
                14999, 79999, 49999, 999999, 999999, 999999, 999999, 999999
        };

        int[] quantity = {
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1};

        String[] category = {
                "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER",
                "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER",
                "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER",
                "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER",
                "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER",
                "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER",
                "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER", "CHARACTER",
                "CHARACTER", "CHARACTER", "CHARACTER", "ESPER", "ESPER", "ESPER", "ESPER", "ESPER"};

        int[] hp = {
                2488, 2349, 1867, 1108, 796, 801, 883, 1201, 827, 864,
                782, 1162, 1168, 1133, 1001, 998, 1353, 1224, 1008, 1218,
                978, 1504, 1607, 1489, 2250, 1896, 1651, 2090, 1996, 1792,
                1642, 1523, 2017, 2204, 1739, 1648, 1784, 2730, 2401, 2482,
                2574, 2800, 2127, 1752, 2650, 2721, 2527, 2639, 2360, 2001,
                1955, 2264, 814, 981, 1282, 1184, 1055, 1157, 1181, 1834,
                2185, 2703, 2127, 2753, 2090, 2582, 2715, 2222, 2318, 2115,
                2257, 2536, 2305, 3000, 4500, 5500, 3300, 2800};

        int[] mp = {
                97, 100, 131, 40, 54, 57, 41, 39, 46, 44,
                51, 56, 59, 55, 70, 63, 48, 53, 69, 65,
                72, 111, 91, 95, 79, 88, 98, 85, 90, 86,
                132, 127, 85, 85, 88, 87, 85, 110, 145, 124,
                113, 110, 120, 79, 115, 110, 109, 110, 127, 138,
                143, 102, 48, 69, 45, 47, 61, 62, 58, 86,
                118, 140, 94, 105, 126, 110, 105, 96, 115, 150,
                118, 103, 96, 3400, 2200, 4300, 5900, 6200};

        int[] atk = {
                89, 96, 79, 47, 31, 30, 43, 45, 40, 47,
                35, 50, 51, 52, 35, 37, 61, 59, 45, 52,
                38, 59, 67, 65, 90, 89, 64, 89, 83, 75,
                59, 62, 90, 82, 78, 80, 79, 113, 90, 105,
                115, 97, 94, 79, 95, 102, 104, 99, 96, 82,
                77, 106, 39, 36, 59, 53, 55, 64, 55, 90,
                100, 88, 81, 101, 101, 100, 111, 88, 100, 83,
                93, 120, 113, 1800, 5100, 3200, 2100, 1600};

        int[] def = {
                88, 82, 79, 44, 30, 33, 37, 52, 36, 32,
                34, 51, 50, 45, 36, 34, 51, 37, 45, 46,
                44, 63, 61, 58, 82, 76, 66, 84, 76, 75,
                59, 58, 80, 85, 69, 70, 73, 106, 84, 89,
                102, 109, 81, 67, 96, 99, 99, 97, 84, 90,
                81, 84, 35, 35, 44, 60, 41, 48, 51, 79,
                80, 85, 69, 98, 82, 92, 100, 80, 82, 79,
                85, 99, 84, 1900, 2800, 4500, 2300, 1100};

        int[] mag = {
                86, 89, 93, 31, 41, 47, 34, 27, 39, 38,
                39, 41, 42, 44, 55, 54, 33, 35, 53, 54,
                48, 92, 79, 78, 61, 73, 81, 67, 71, 76,
                93, 93, 63, 69, 81, 70, 77, 85, 112, 106,
                89, 85, 109, 71, 94, 88, 87, 87, 104, 97,
                89, 91, 37, 61, 36, 34, 43, 48, 43, 65,
                100, 109, 80, 86, 95, 89, 79, 100, 104, 116,
                100, 83, 93, 3600, 2100, 1600, 5400, 5900};

        int[] spr = {
                80, 74, 101, 35, 48, 43, 36, 31, 34, 36,
                41, 43, 42, 42, 58, 58, 35, 42, 53, 54,
                49, 85, 78, 85, 58, 68, 73, 65, 73, 78,
                85, 85, 61, 68, 71, 73, 71, 78, 95, 81,
                77, 88, 95, 59, 91, 88, 85, 88, 85, 98,
                114, 84, 37, 51, 38, 38, 44, 47, 45, 55,
                83, 108, 66, 86, 88, 88, 80, 97, 91, 109,
                86, 82, 76, 3600, 2100, 1600, 5400, 4500};

        String[] origin = {
                "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE",
                "FFBE", "FFVI", "FFVI", "FFII", "FFXII", "FFI", "FFIV", "FFBE", "FFBE", "FFBE",
                "FFBE", "FFIX", "FFXII", "FFII", "FFVI", "FFVI", "FFV", "FFIV", "FFVI", "FFXII",
                "FFXI", "FFIV", "FFVI", "FFBE", "FFBE", "FFBE", "FFBE", "FFI", "FFV", "FFIX",
                "FFIII", "FFIV", "FFVI", "FFVI", "FFV", "FFII", "FFIX", "FFXII", "FFBE", "FFBE",
                "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE", "FFBE",
                "FFBE", "FFIV", "FFV", "FFBE", "FFBE", "FFVI", "FFVI", "FFBE", "FFVI", "FFVI",
                "FFBE", "FFBE", "FFBE", "FF", "FF", "FF", "FF", "FF"
        };

//        int[] item_id = {};
//        String[] item_icon = {};
//        String[] item_name = {};
//        String[] item_type = {};
//        String[] item_rarity = {};
//        int[] item_price={};
//        int[] item_quantity{};

        ContentValues values = new ContentValues();
        for (int i = 0; i < id.length; i++) {
            values.put(COL_C_E_ID, id[i]);
            values.put(COL_ICON, icon[i]);
            values.put(COL_NAME, name[i]);
            values.put(COL_TYPE, type[i]);
            values.put(COL_RARITY, rarity[i]);
            values.put(COL_PRICE, price[i]);
            values.put(COL_QUANTITY, quantity[i]);
            values.put(COL_CATEGORY, category[i]);
            values.put(COL_HP, hp[i]);
            values.put(COL_MP, mp[i]);
            values.put(COL_ATK, atk[i]);
            values.put(COL_DEF, def[i]);
            values.put(COL_MAG, mag[i]);
            values.put(COL_SPR, spr[i]);
            values.put(COL_ORIGIN, origin[i]);
            db.insert(CHARACTER_ESPER_TABLE, null, values);
            values.clear();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF Exists " + CHARACTER_ESPER_TABLE);
//        db.execSQL("DROP TABLE IF Exists " + CREATE_ITEM_TABLE);
        db.execSQL("DROP TABLE IF Exists " + CART_TABLE);
        onCreate(db);
    }

    //For both character and esper tab
    public ArrayList<CharacterEsper> getCharactersAndEspers() {
        ArrayList<CharacterEsper> characterEsper = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query =
                "SELECT * FROM " + CHARACTER_ESPER_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                characterEsper.add(new CharacterEsper(cursor.getInt(cursor.getColumnIndex(COL_C_E_ID)), cursor.getString(cursor.getColumnIndex(COL_ICON)),
                        cursor.getString(cursor.getColumnIndex(COL_NAME)), cursor.getString(cursor.getColumnIndex(COL_TYPE)),
                        cursor.getString(cursor.getColumnIndex(COL_RARITY)), cursor.getInt(cursor.getColumnIndex(COL_PRICE)),
                        cursor.getInt(cursor.getColumnIndex(COL_QUANTITY)), cursor.getString(cursor.getColumnIndex(COL_CATEGORY)),
                        cursor.getInt(cursor.getColumnIndex(COL_HP)), cursor.getInt(cursor.getColumnIndex(COL_MP)),
                        cursor.getInt(cursor.getColumnIndex(COL_ATK)), cursor.getInt(cursor.getColumnIndex(COL_DEF)),
                        cursor.getInt(cursor.getColumnIndex(COL_MAG)), cursor.getInt(cursor.getColumnIndex(COL_SPR)),
                        cursor.getString(cursor.getColumnIndex(COL_ORIGIN))));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return characterEsper;
    }

    //For the character tab
    public ArrayList<CharacterEsper> getCharacterTab() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<CharacterEsper> character = new ArrayList<>();

        String query =
                "SELECT " + COL_ICON + ", " + COL_NAME + ", " + COL_TYPE + ", " + COL_RARITY + ", " +
                        COL_PRICE + ", " + COL_QUANTITY +
                        " FROM " + CHARACTER_ESPER_TABLE +
                        " WHERE " + COL_CATEGORY + " = 'CHARACTER'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                character.add(new CharacterEsper(cursor.getInt(cursor.getColumnIndex(COL_C_E_ID)), cursor.getString(cursor.getColumnIndex(COL_ICON)),
                        cursor.getString(cursor.getColumnIndex(COL_NAME)), cursor.getString(cursor.getColumnIndex(COL_TYPE)),
                        cursor.getString(cursor.getColumnIndex(COL_RARITY)), cursor.getInt(cursor.getColumnIndex(COL_PRICE)),
                        cursor.getInt(cursor.getColumnIndex(COL_QUANTITY)), cursor.getString(cursor.getColumnIndex(COL_CATEGORY)),
                        cursor.getInt(cursor.getColumnIndex(COL_HP)), cursor.getInt(cursor.getColumnIndex(COL_MP)),
                        cursor.getInt(cursor.getColumnIndex(COL_ATK)), cursor.getInt(cursor.getColumnIndex(COL_DEF)),
                        cursor.getInt(cursor.getColumnIndex(COL_MAG)), cursor.getInt(cursor.getColumnIndex(COL_SPR)),
                        cursor.getString(cursor.getColumnIndex(COL_ORIGIN))));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return character;
    }

    //For the esper tab
    public ArrayList<CharacterEsper> getEsperTab() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<CharacterEsper> esper = new ArrayList<>();

        String query =
                "SELECT " + COL_ICON + ", " + COL_NAME + ", " + COL_TYPE + ", " + COL_RARITY + ", " +
                        COL_PRICE + ", " + COL_QUANTITY +
                        " FROM " + CHARACTER_ESPER_TABLE +
                        " WHERE " + COL_CATEGORY + " = 'ESPER'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                esper.add(new CharacterEsper(cursor.getInt(cursor.getColumnIndex(COL_C_E_ID)), cursor.getString(cursor.getColumnIndex(COL_ICON)),
                        cursor.getString(cursor.getColumnIndex(COL_NAME)), cursor.getString(cursor.getColumnIndex(COL_TYPE)),
                        cursor.getString(cursor.getColumnIndex(COL_RARITY)), cursor.getInt(cursor.getColumnIndex(COL_PRICE)),
                        cursor.getInt(cursor.getColumnIndex(COL_QUANTITY)), cursor.getString(cursor.getColumnIndex(COL_CATEGORY)),
                        cursor.getInt(cursor.getColumnIndex(COL_HP)), cursor.getInt(cursor.getColumnIndex(COL_MP)),
                        cursor.getInt(cursor.getColumnIndex(COL_ATK)), cursor.getInt(cursor.getColumnIndex(COL_DEF)),
                        cursor.getInt(cursor.getColumnIndex(COL_MAG)), cursor.getInt(cursor.getColumnIndex(COL_SPR)),
                        cursor.getString(cursor.getColumnIndex(COL_ORIGIN))));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return esper;
    }

    //Query that searches for the hero I'm searching for by name
    public ArrayList<CharacterEsper> getCharacterEsperSearch(String search) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        ArrayList<CharacterEsper> characterEspers = new ArrayList<>();
        String query = "";

        if (search.length() == 0) {
            query = "SELECT * FROM " + CHARACTER_ESPER_TABLE;
        } else {
            query = "SELECT * FROM " + CHARACTER_ESPER_TABLE + " WHERE " + COL_NAME +
                    " LIKE '%" + search + "%'";
        }

        cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                characterEspers.add(new CharacterEsper(cursor.getInt(cursor.getColumnIndex(COL_C_E_ID)), cursor.getString(cursor.getColumnIndex(COL_ICON)),
                        cursor.getString(cursor.getColumnIndex(COL_NAME)), cursor.getString(cursor.getColumnIndex(COL_TYPE)),
                        cursor.getString(cursor.getColumnIndex(COL_RARITY)), cursor.getInt(cursor.getColumnIndex(COL_PRICE)),
                        cursor.getInt(cursor.getColumnIndex(COL_QUANTITY)), cursor.getString(cursor.getColumnIndex(COL_CATEGORY)),
                        cursor.getInt(cursor.getColumnIndex(COL_HP)), cursor.getInt(cursor.getColumnIndex(COL_MP)),
                        cursor.getInt(cursor.getColumnIndex(COL_ATK)), cursor.getInt(cursor.getColumnIndex(COL_DEF)),
                        cursor.getInt(cursor.getColumnIndex(COL_MAG)), cursor.getInt(cursor.getColumnIndex(COL_SPR)),
                        cursor.getString(cursor.getColumnIndex(COL_ORIGIN))));

                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();
        return characterEspers;
    }

    public ArrayList<ShoppingCartObject> getCartItemsAsObjects() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<ShoppingCartObject> shoppingCartObjectList = new ArrayList<>();

        String query = "SELECT " + COL_ICON + "," + COL_NAME + "," + COL_QUANTITY + "," + COL_PRICE +
                " FROM " + CHARACTER_ESPER_TABLE + " JOIN " + CART_TABLE + " ON " + CART_TABLE + "." +
                COL_REF_C_E_ID + " = " + CHARACTER_ESPER_TABLE + "." + COL_C_E_ID;
        Cursor cursor = db.rawQuery(query, null);
        Log.d("Item in cart", "getCartItemsAsObjects: " + cursor.getCount());
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                shoppingCartObjectList.add(new ShoppingCartObject(
                        cursor.getString(cursor.getColumnIndex(COL_ICON)), cursor.getString(cursor.getColumnIndex(COL_NAME)),
                        cursor.getInt(cursor.getColumnIndex(COL_PRICE)), cursor.getInt(cursor.getColumnIndex(COL_QUANTITY))));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return shoppingCartObjectList;
    }

    public void deleteCharacterEsperFromCart(ShoppingCartObject item) {
        int id = getCharacterEsperIdFromShoppingCartObject(item);
        SQLiteDatabase db = getWritableDatabase();

        String selection = COL_REF_C_E_ID + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        db.delete(CART_TABLE, selection, selectionArgs);
        db.close();
    }

    public int getCharacterEsperIdFromShoppingCartObject(ShoppingCartObject item) {
        int id = 0;
        String iconId = String.valueOf(item.getmIcon());
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + COL_C_E_ID + " FROM " + CHARACTER_ESPER_TABLE +
                " WHERE " + COL_ICON + " LIKE '" + iconId + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                id = cursor.getInt(cursor.getColumnIndex(COL_C_E_ID));
                cursor.moveToNext();
            }
        }
        return id;
    }

    public void addToCart(CharacterEsper characterEsper) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        int characterEsperId = characterEsper.getId();
        values.put(COL_REF_C_E_ID, characterEsperId);
        values.put(COL_CART_QUANTITY, 1);
//        db.update(CART_TABLE, values, COL_C_E_ID + " = " + characterEsperId, null);
        db.insertOrThrow(CART_TABLE, null, values);
        db.close();
    }

    public void clearCartTableUponCheckout() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + CART_TABLE);
        db.close();
    }

    public int getQuantityFromTable(ShoppingCartObject item) {
        SQLiteDatabase db = getReadableDatabase();
        int quantity = 0;
        int characterEsperId = getCharacterEsperIdFromShoppingCartObject(item);
        String query = "SELECT " + COL_CART_QUANTITY + " FROM " + CART_TABLE +
                " WHERE " + COL_REF_C_E_ID + " = " + characterEsperId;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                quantity = cursor.getInt(cursor.getColumnIndex(COL_CART_QUANTITY));
                cursor.moveToNext();
            }
        }
        return quantity;
    }

    public void increaseQuantity(ShoppingCartObject item) {
        SQLiteDatabase db = getWritableDatabase();
        int characterEsperId = getCharacterEsperIdFromShoppingCartObject(item);
        int currentQuantity = getQuantityFromTable(item);
        String update = "UPDATE " + CART_TABLE + " SET " + COL_CART_QUANTITY + " = " + (currentQuantity + 1) +
                " WHERE " + COL_REF_C_E_ID + " = " + characterEsperId;
        db.execSQL(update);
        db.close();
    }

    public void decreaseQuantity(ShoppingCartObject item) {
        SQLiteDatabase db = getWritableDatabase();
        int characterEsperId = getCharacterEsperIdFromShoppingCartObject(item);
        int currentQuantity = getQuantityFromTable(item);
        String update = "UPDATE " + CART_TABLE + " SET " + COL_CART_QUANTITY + " = " + (currentQuantity - 1) +
                " WHERE " + COL_REF_C_E_ID + " = " + characterEsperId;
        db.execSQL(update);
        db.close();
    }
}
