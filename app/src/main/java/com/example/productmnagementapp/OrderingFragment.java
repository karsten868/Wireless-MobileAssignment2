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
 * Use the {@link OrderingFragment#} factory method to
 * create an instance of this fragment.
 */
public class OrderingFragment extends Fragment {
    private String name;// = "Product name";
    private int stockInHand;//= 30;
    private int stockInTransit;// = 40;
    private int recorderQuantity;// = 50;
    private int recorderAmt;// =60;
    //public View view;
    public ArrayAdapter<String> adapter;
    public OrderingFragment() {
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
                    new String[] {"NAME", "STOCKINHAND", "STOCKINTRANSIT", "REORDERQUANTITY", "REORDERAMOUNT"},
                    null, null, null, null, null);
            if(cursor.moveToFirst()) {
                this.name = cursor.getString(0);
                this.stockInHand = cursor.getInt(1);
                this.stockInTransit = cursor.getInt(2);
                this.recorderQuantity = cursor.getInt(3);
                this.recorderAmt = cursor.getInt(4);
            }
            String[] productList =
                {name, Integer.toString(stockInHand), Integer.toString(stockInTransit), Integer.toString(recorderQuantity), Integer.toString(recorderAmt) };
           this.adapter = new ArrayAdapter<>(
                    inflater.getContext(), android.R.layout.simple_list_item_1,
                    productList);
           this.adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            /*String [] values =
                {"Time at Residence","Under 6 months","6-12 months","1-2 years","2-4 years","4-8 years","8-15 years","Over 15 years",};
        ArrayAdapter<String>adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_spinner_item, values );
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            Spinner spinner = (Spinner) view.findViewById(R.id.products_spinner);

            spinner.setAdapter(adapter);*/
           /* TextView text = (TextView) view.findViewById(R.id.text);
            text.setText(values[1]);
*/
       }
        catch (SQLiteException e) {
            Toast toast = Toast.makeText(inflater.getContext(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }




        return inflater.inflate(R.layout.fragment_ordering, container, false);
    }
/**/
    @Override
    public void onStart(){
        super.onStart();
        View v = getView();
        TextView text = (TextView) v.findViewById(R.id.text);
        Spinner spinner = (Spinner) v.findViewById(R.id.products_spinner);
        spinner.setAdapter(adapter);
        text.setText(name);

    }


}

