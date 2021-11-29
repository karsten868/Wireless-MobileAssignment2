package com.example.productmnagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class TopLevelActivity extends AppCompatActivity {
    private String name;
    private int stockInHand;
    private int stockInTransit;
    private int recorderQuantity;
    private int recorderAmt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplevel);
/*
        SQLiteOpenHelper productDatabaseHelper = new ProductDatabaseHelper(this);//inflater.getContext()
        try {
            SQLiteDatabase db = productDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("PRODUCT",
                    new String[] {"NAME", "STOCKINHAND", "STOCKINTRANSIT", "REORDERQUANTITY", "REORDERAMOUNT"},
                    null, null, null, null, null);
            if(cursor.moveToFirst()) {
                name = cursor.getString(0);
                stockInHand = cursor.getInt(1);
                stockInTransit = cursor.getInt(2);
                recorderQuantity = cursor.getInt(3);
                recorderAmt = cursor.getInt(4);
            }
            productList[0] = name;
            productList[1] = Integer.toString(stockInHand);
            productList[2] = Integer.toString(stockInTransit);
            productList[3] = Integer.toString(recorderQuantity);
            productList[4] = Integer.toString(recorderAmt);
            String[] productList =
                    {name, Integer.toString(stockInHand), Integer.toString(stockInTransit), Integer.toString(recorderQuantity), Integer.toString(recorderAmt) };
            String [] values =
                    {name,productList[1],productList[2],productList[3],productList[4]};
            ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, productList);
            listAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            Spinner productsList = (Spinner) findViewById(R.id.spinner);

            productsList.setAdapter(listAdapter);

        }
        catch (SQLiteException e) {
            Toast toast = Toast.makeText(this*//*inflater.getContext()*//*, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }*/
    }


    public void onClickReceive(View view){
        Intent intent = new Intent(this, ReceiveFragmentActivity.class);
        startActivity(intent);

    }

    public void onClickOrder(View view) {
        Intent intent = new Intent(this, OrderFragmentActivity.class);
        startActivity(intent);

    }

    /*public void setProductList() {
        this.productList[0] = this.name;
        this.productList[1] = Integer.toString(this.stockInHand);
        this.productList[2] = Integer.toString(this.stockInTransit);
        this.productList[3] = Integer.toString(this.recorderQuantity);
        this.productList[4] = Integer.toString(this.recorderAmt);

        //this.workoutId = workoutId;
    }*/



}