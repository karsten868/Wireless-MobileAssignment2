package com.example.productmnagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderFragmentActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_fragment);

    }
/*

            OrderingFragment fragment = (OrderingFragment) getSupportFragmentManager().findFragmentById(R.id.ordering_frag);
            fragment.setProductList(name, stockInHand, stockInTransit, recorderQuantity, recorderAmt);
            Intent intent = new Intent(this, OrderingFragment.class);
            startActivity(intent);
*/


}