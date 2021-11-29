package com.example.productmnagementapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReceivingFragment#} factory method to
 * create an instance of this fragment.
 */
public class ReceivingFragment extends Fragment {
    private String name;// = "Product name";
    private int quantityReceived;
    public ArrayAdapter<String> adapter;

    public ReceivingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);*/

        SQLiteOpenHelper productDatabaseHelper = new ProductDatabaseHelper(inflater.getContext());
        try {
            SQLiteDatabase db = productDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("PRODUCT",
                    new String[] {"NAME"},
                    null, null, null, null, null);
            if(cursor.moveToFirst()) {
                this.name = cursor.getString(0);
            }
            String[] productList =
                    {name};
            this.adapter = new ArrayAdapter<>(
                    inflater.getContext(), android.R.layout.simple_list_item_1,
                    productList);
            this.adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        }
        catch (SQLiteException e) {
            Toast toast = Toast.makeText(inflater.getContext(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        return inflater.inflate(R.layout.fragment_ordering, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View v = getView();
        TextView text = (TextView) v.findViewById(R.id.text);
        Spinner spinner = (Spinner) v.findViewById(R.id.pSpinner);
        spinner.setAdapter(adapter);
        text.setText(name);

    }
}

