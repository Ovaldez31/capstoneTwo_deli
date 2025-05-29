package com.ps;

public class Topping extends Premium {

    private String name;
    private String type;
    private boolean isExtra;


    public Topping(double price, String name, String type, boolean isExtra) {
        super(price);
        this.name = name;
        this.type = type;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }
}



