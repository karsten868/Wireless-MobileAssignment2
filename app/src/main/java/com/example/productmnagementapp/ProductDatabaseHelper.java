package com.example.productmnagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Product";
    private static final int DB_VERSION = 1;

    ProductDatabaseHelper(Context context){

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        updateMyDatabase(db,0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion<1){
            db.execSQL("CREATE TABLE PRODUCT(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT, " +
                    "STOCKINHAND INTEGER, " +
                    "STOCKINTRANSIT INTEGER," +
                    "PRICE REAL," +
                    "REORDERQUANTITY INTEGER," +
                    "REORDERAMOUNT INTEGER);");
            insertProduct(db, "iphone 13 Pro", 500, 400, 1200, 50, 400);
            insertProduct(db, "MacBook Pro", 700, 200, 7000, 100, 200);
            insertProduct(db, "PS5", 1000, 500, 4000, 150, 500);
        }
    }

    public void insertProduct(SQLiteDatabase db, String name, int stockInHand, int stockInTransit, double price, int reorderQuantity, int reorderAmount){
        ContentValues productValues = new ContentValues();
        productValues.put("NAME", name);
        productValues.put("STOCKINHAND", stockInHand);
        productValues.put("STOCKINTRANSIT", stockInTransit);
        productValues.put("PRICE", price);
        productValues.put("REORDERQUANTITY", reorderQuantity);
        productValues.put("REORDERAMOUNT", reorderAmount);
        db.insert("PRODUCT", null, productValues);
    }





}
