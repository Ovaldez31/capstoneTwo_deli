package com.ps;

public class Drink implements Product {

    private final String size;
    private final String flavor;
    private final double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;

        switch (size.toLowerCase()) {
            case "small" -> price = 2.00;
            case "medium" -> price = 2.50;
            case "large" -> price = 3.00;
            default -> price = 0.00;
        }
    }

    @Override
    public double calcPrice() {
        return price;
    }

    @Override
    public String getReceiptDescription() {
        return "Drink\nSize: " + size
                + "\nFlavor: " + flavor
                + "\nPrice: $" + String.format("%.2f", price);
    }
}
