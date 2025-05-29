package com.ps;


public abstract class Sandwich implements Product {


    private int size;
    private BreadType bread;
    private MeatOption meat;
    private boolean extraMeat;
    private CheeseOption cheese;
    private boolean extraCheese;
    private boolean toasted;
    private final int inches;
    private final double breadBasePrice;
    private final double meatPrice;
    private final double cheesePrice;
    private final double extraMeatPrice;
    private final double extraCheesePrice;

    public Sandwich(int inches, double breadBasePrice, double meatPrice, double cheesePrice, double extraMeatPrice, double extraCheesePrice, boolean toasted, boolean extraCheese, CheeseOption cheese, boolean extraMeat, MeatOption meat, BreadType bread, int size) {
        super();
        this.inches = inches;
        this.breadBasePrice = breadBasePrice;
        this.meatPrice = meatPrice;
        this.cheesePrice = cheesePrice;
        this.extraMeatPrice = extraMeatPrice;
        this.extraCheesePrice = extraCheesePrice;
        this.toasted = toasted;
        this.extraCheese = extraCheese;
        this.cheese = cheese;
        this.extraMeat = extraMeat;
        this.meat = meat;
        this.bread = bread;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BreadType getBread() {
        return bread;
    }

    public void setBread(BreadType bread) {
        this.bread = bread;
    }

    public MeatOption getMeat() {
        return meat;
    }

    public void setMeat(MeatOption meat) {
        this.meat = meat;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public CheeseOption getCheese() {
        return cheese;
    }

    public void setCheese(CheeseOption cheese) {
        this.cheese = cheese;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public int getInches() {
        return inches;
    }

    public double getBreadBasePrice() {
        return breadBasePrice;
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

    public enum Size {
        SMALL(4, 5.50, 1.00, 0.75, 0.50, 0.30),
        MEDIUM(8, 7.00, 2.00, 1.50, 1.00, 0.60),
        LARGE(12, 8.50, 3.00, 2.25, 1.50, 0.90);

        Size(int size, double breadPrice, double meatPrice, double cheesePrice, double xtMeat, double xtCheese) {
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
        MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLANDS, VINAIGRETTE;
    }


}



