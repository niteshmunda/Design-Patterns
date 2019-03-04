package com.example.beerexpert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner spinner;
    private TextView textView;
    private BeerExpert beerExpert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);
    }

    public void onButtonClickCallMe(View view) {
        String beerType = String.valueOf(spinner.getSelectedItem());
        textView.setText(beerType);
        List<String> brands;
        brands = beerExpert.getBrands(beerType);
        StringBuilder stringBuilder = new StringBuilder();
        for (String brand : brands){
            stringBuilder.append(brand).append("\n");
        }
        textView.setText(stringBuilder);
    }
}
