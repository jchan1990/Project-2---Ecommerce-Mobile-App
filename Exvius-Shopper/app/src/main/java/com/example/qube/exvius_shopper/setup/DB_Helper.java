package com.example.qube.exvius_shopper.setup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Qube on 7/27/16.
 */
public class DB_Helper extends SQLiteOpenHelper {

    private static DB_Helper instance;

    private static final String DATABASE_NAME = "Exvius_Shopper_Database";
    public static final int DATABASE_VERSION = 1;

    private static final String CHARACTER_ESPER_TABLE = "CHARACTER_ESPER_TABLE";
    private static final String ITEM_TABLE = "ITEM_TABLE";
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
            + COL_C_E_ID + " INTEGER NOT NULL, "
//            + COL_ITEM_ID + " INTEGER NOT NULL, "
            + "FOREIGN KEY (" + COL_C_E_ID + ") REFERENCES " + CHARACTER_ESPER_TABLE + "(" + COL_C_E_ID + ")) ";
    // Will work on after project is completed
//            + "FOREIGN KEY (" + COL_ITEM_ID + ") REFERENCES " + ITEM_TABLE + "(" + COL_ITEM_ID + "))";

    private DB_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DB_Helper getInstance(Context context) {
        if (instance == null) {
            instance = new DB_Helper(context.getApplicationContext());
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
                "ic_rain", "ic_lasswell", "ic_fina", "ic_rizer", "ic_leah", "ic_tronn", "ic_eldin", "ic_baurg", "ic_gimlee", "ic_maxwell",
                "ic_liza", "ic_wedge", "ic_biggs", "ic_paul", "ic_anastasis", "ic_sarah", "ic_king giott", "ic_shiki", "ic_mizell", "ic_ronaldo",
                "ic_mel", "ic_vivi", "ic_penelo", "ic_maria", "ic_sabin", "ic_shadow", "ic_krile", "ic_kain", "ic_edgar", "ic_fran",
                "ic_shantotto", "ic_rydia", "ic_cyan", "ic_clyne", "ic_anzelm", "ic_luna", "ic_bedile", "ic_garland", "ic_exdeath", "ic_kuja",
                "ic_cloud of darkness", "ic_cecil", "ic_terra", "ic_magitek armor terra", "ic_bartz", "ic_firion", "ic_zidane", "ic_vaan", "ic_duane", "ic_cerius",
                "ic_roselia", "ic_medius", "ic_sarai", "ic_paula", "ic_kenyu", "ic_ollie", "ic_carrie", "ic_skaha", "ic_montana", "ic_russell",
                "ic_miyuki", "ic_golbez", "ic_galuf", "ic_xiao", "ic_artemios", "ic_locke", "ic_leo", "ic_gilbert", "ic_celes", "ic_kefka",
                "ic_rakshasa", "ic_chizuru", "ic_hayate", "ic_siren", "ic_ifrit", "ic_golem", "ic_shiva", "ic_ramuh"};

        String[] name = {
                "Rain", "Lasswell", "Fina", "Rizer", "Leah", "Tronn", "Eldin", "Baurg", "Gimlee", "Maxwell",
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
                24, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                24, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                24, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                24, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                24, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                24, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                24, 00, 00, 00, 00, 00, 00, 00};

        int[] mp = {
                97, 100, 131, 40, 54, 57, 41, 39, 46, 44,
                97, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                97, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                97, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                97, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                97, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                97, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                97, 00, 00, 00, 00, 00, 00, 00};

        int[] atk = {
                89, 96, 79, 47, 31, 30, 43, 45, 40, 47,
                89, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                89, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                89, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                89, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                89, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                89, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                89, 00, 00, 00, 00, 00, 00, 00};

        int[] def = {
                88, 82, 79, 44, 30, 33, 37, 52, 36, 32,
                88, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                88, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                88, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                88, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                88, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                88, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                88, 00, 00, 00, 00, 00, 00, 00};

        int[] mag = {
                86, 89, 93, 31, 41, 47, 34, 27, 39, 38,
                86, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                86, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                86, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                86, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                86, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                86, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                86, 00, 00, 00, 00, 00, 00, 00};

        int[] spr = {
                80, 74, 101, 35, 48, 43, 36, 31, 34, 36,
                80, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                80, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                80, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                80, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                80, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                80, 00, 00, 00, 00, 00, 00, 00, 00, 00,
                80, 00, 00, 00, 00, 00, 00, 00};

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
        db.execSQL("DROP TABLE IF Exists " + CREATE_CHARACTER_ESPER_TABLE);
//        db.execSQL("DROP TABLE IF Exists " + CREATE_ITEM_TABLE);
        db.execSQL("DROP TABLE IF Exists " + CREATE_CART_TABLE);
        onCreate(db);
    }

    //For the character tab
    public ArrayList<String> getCharacterTab() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> list = new ArrayList<>();

        String query =
                "SELECT " + COL_ICON + ", " + COL_NAME + ", " + COL_TYPE + ", " + COL_RARITY + ", " +
                        COL_PRICE + ", " + COL_QUANTITY +
                        " FROM " + CHARACTER_ESPER_TABLE +
                        " WHERE " + COL_CATEGORY + " = 'CHARACTER'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(cursor.getColumnIndex(COL_ICON)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_NAME)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_TYPE)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_RARITY)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_PRICE)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_QUANTITY)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return list;
    }

    //For the esper tab
    public ArrayList<String> getEsperTab() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> list = new ArrayList<>();

        String query =
                "SELECT " + COL_ICON + ", " + COL_NAME + ", " + COL_TYPE + ", " + COL_RARITY + ", " +
                        COL_PRICE + ", " + COL_QUANTITY +
                        " FROM " + CHARACTER_ESPER_TABLE +
                        " WHERE " + COL_CATEGORY + " = 'ESPER'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(cursor.getColumnIndex(COL_ICON)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_NAME)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_TYPE)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_RARITY)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_PRICE)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_QUANTITY)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return list;
    }

    //For details once you click a CardView
    public ArrayList<String> getDetailInfo() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> list = new ArrayList<>();

        String query =
                "SELECT " + COL_ICON + ", " + COL_NAME + ", " + COL_TYPE + ", " + COL_RARITY + ", " +
                        COL_PRICE + ", " + COL_QUANTITY +
                        ", " + COL_ORIGIN + ", " + COL_QUANTITY + ", " + COL_HP + ", " + COL_MP +
                        ", " + COL_ATK + ", " + COL_DEF + ", " + COL_MAG + ", " + COL_SPR +
                        " FROM " + CHARACTER_ESPER_TABLE;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(cursor.getColumnIndex(COL_ICON)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_NAME)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_TYPE)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_RARITY)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_PRICE)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_QUANTITY)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_ORIGIN)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_QUANTITY)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_HP)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_MP)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_ATK)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_DEF)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_MAG)) + " " +
                        cursor.getString(cursor.getColumnIndex(COL_SPR)));

                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return list;
    }
}
