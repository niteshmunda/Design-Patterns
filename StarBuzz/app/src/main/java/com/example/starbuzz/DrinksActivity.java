package com.example.starbuzz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;



public class DrinksActivity extends AppCompatActivity {
    public static final String EXTRA_NO = "drinkNo";
    public Drinks drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        int drinkNo = (int) getIntent().getExtras().get(EXTRA_NO);
        drink = Drinks.drinks[drinkNo];
        updateData();
    }

    private void updateData() {
        ImageView imageView = findViewById(R.id.image);
        TextView textView = findViewById(R.id.name_text);
        TextView textView2 = findViewById(R.id.description_text);

        imageView.setImageResource(drink.getImageUrl());
        textView.setText(drink.getName());
        textView2.setText(drink.getDescription());
    }

}
