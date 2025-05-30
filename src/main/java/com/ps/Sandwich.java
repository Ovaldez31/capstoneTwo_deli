package com.ps;


public class Sandwich implements Product {

    private final BreadType currentSandwichBreadType;
    private final MeatOption currentSandwichMeat;
    private final boolean  currentSandwichExtraMeat;
    private final CheeseOption currentSandwichCheese;
    private final boolean  currentSandwichExtraCheese;
    private final boolean  currentSandwichToasted;
    private final String regularToppings;
    private final String sauces;
    private final double breadPrice;
    private final double meatPrice;
    private final double cheesePrice;
    private final double extraMeatPrice;
    private final double extraCheesePrice;

    public Sandwich(Size currentSize, BreadType currentSandwichBreadType, MeatOption currentSandwichMeat, boolean currentSandwichExtraMeat, CheeseOption currentSandwichCheese, boolean currentSandwichExtraCheese, boolean currentSandwichToasted, String regularToppings, String sauces, double breadPrice, double meatPrice, double cheesePrice, double extraMeatPrice, double extraCheesePrice) {
        this.currentSandwichBreadType = currentSandwichBreadType;
        this.currentSandwichMeat = currentSandwichMeat;
        this.currentSandwichExtraMeat = currentSandwichExtraMeat;
        this.currentSandwichCheese = currentSandwichCheese;
        this.currentSandwichExtraCheese = currentSandwichExtraCheese;
        this.currentSandwichToasted = currentSandwichToasted;
        this.regularToppings = regularToppings;
        this.sauces = sauces;


        this.breadPrice = currentSize.getBreadPrice();
        this.meatPrice = currentSize.getMeatPrice();
        this.cheesePrice = currentSize.getCheesePrice();
        this.extraMeatPrice = currentSize.getExtraMeatPrice();
        this.extraCheesePrice = currentSize.getExtraCheesePrice();

    }

    public enum Size {
        SMALL(4, 5.50, 1.00, 0.75, 0.50, 0.30),
        MEDIUM(8, 7.00, 2.00, 1.50, 1.00, 0.60),
        LARGE(12, 8.50, 3.00, 2.25, 1.50, 0.90);

        private final int inches;
        private final double breadPrice;
        private final double meatPrice;
        private final double cheesePrice;
        private final double extraMeatPrice;
        private final double extraCheesePrice;


        Size(int inches, double breadPrice, double meatPrice, double cheesePrice, double extraMeatPrice, double extraCheesePrice) {
            this.inches = inches;
            this.breadPrice = breadPrice;
            this.meatPrice = meatPrice;
            this.cheesePrice = cheesePrice;
            this.extraMeatPrice = extraMeatPrice;
            this.extraCheesePrice = extraCheesePrice;

        }

        public int getInches() {
            return inches;
        }

        public double getBreadPrice() {
            return breadPrice;
        }

        public double getMeatPrice() {
            return meatPrice;
        }

        public double getCheesePrice() {
            return cheesePrice;
        }

        public double getExtraMeatPrice() {
            return extraMeatPrice;
        }

        public double getExtraCheesePrice() {
            return extraCheesePrice;
        }


    }

    public enum BreadType {
        WHITE, WHEAT, RYE, WRAP;
    }

    public enum MeatOption {
        STEAK, HAM, SALAMI, ROAST_BEEF, CHICKEN, BACON;

    }

    public enum CheeseOption {
        AMERICAN, PROVOLONE, CHEDDAR, SWISS;
    }

    public enum RegularTopping {
        LETTUCE, PEPPERS, ONIONS, TOMATOES, JALAPENOS, CUCUMBERS, PICKLES, GUACAMOLE, MUSHROOMS
    }

    public enum SauceOption {
        AU_JUS, MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLANDS, VINAIGRETTE;
    }


    @Override
    public double calcPrice() {

        double total = breadPrice + meatPrice;

        if (currentSandwichCheese != null) {
            total += cheesePrice;
        }

        if (currentSandwichExtraMeat) {
            total += extraMeatPrice;
        }

        if (currentSandwichExtraCheese) {
            total += extraCheesePrice;
        }

        return total;
    }

    @Override
    public String getReceiptDescription() {
        StringBuilder sb = new StringBuilder();

        sb.append("Sandwich:\n");
        sb.append(" - Bread: ").append(currentSandwichBreadType).append("\n");
        sb.append(" - Meat: ").append(currentSandwichMeat);
        if (currentSandwichExtraMeat) sb.append(" (Extra)");
        sb.append("\n");

        if (currentSandwichCheese != null) {
            sb.append(" - Cheese: ").append(currentSandwichCheese);
            if (currentSandwichExtraCheese) sb.append(" (Extra)");
            sb.append("\n");
        } else {
            sb.append(" - No Cheese\n");
        }

        sb.append(" - Toasted: ").append(currentSandwichToasted ? "Yes" : "No").append("\n");
        sb.append(" - Toppings: ").append(regularToppings).append("\n");
        sb.append(" - Sauces: ").append(sauces).append("\n");
        sb.append(String.format(" - Price: $%.2f", calcPrice()));

        return sb.toString();
    }


}



