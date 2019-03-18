package com.example.starbuzz;


public class Drinks {

    private String name;
    private String description;
    private int imageUrl;

    public static final Drinks[] drinks = {
        new Drinks("Latte","A couple of espresso shots with steamed milk",R.drawable.latte),
        new Drinks("Cappuccino","Espresso, hot milk and steamed milk foam",R.drawable.cappuccino),
        new Drinks("Filter","Highest quality beans roasted and brewed fresh",R.drawable.filter)
    };

    private Drinks(String name, String description, int imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
