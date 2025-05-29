package com.ps;

public class Chip implements Product {

    private final String flavor;
    private final double price = 1.50;

    public Chip(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double calcPrice() {
        return price;
    }


    @Override
    public String getReceiptDescription() {
        return String.format("Chips: %s - $%.2f", flavor, price);
    }
}
