package com.example.beerexpert;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    public List<String> getBrands(String beerType) {
        List<String> brands = new ArrayList<>();
        if (beerType.equals("value1")){
            brands.add("value11");
            brands.add("value12");
            brands.add("value13");
            brands.add("value14");
        }
        else if (beerType.equals("value2")){
            brands.add("value21");
            brands.add("value22");
            brands.add("value23");
            brands.add("value24");
        }
        else if (beerType.equals("value3")){
            brands.add("value31");
            brands.add("value32");
            brands.add("value33");
            brands.add("value34");
        }
        else{
            brands.add("value41");
            brands.add("value42");
            brands.add("value43");
            brands.add("value44");
        }
        return brands;
    }
}
