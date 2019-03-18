package com.example.starbuzz;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class DrinksCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] array = new String[3];
        array[0] = "Latte";
        array[1] = "Cappuccino";
        array[2] = "Filter";
        ListView listView = getListView();
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                array
        );
        listView.setAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(DrinksCategoryActivity.this, DrinksActivity.class);
        intent.putExtra(DrinksActivity.EXTRA_NO,  (int)id);
        startActivity(intent);
    }
}
