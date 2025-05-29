package com.ps;

import java.util.ArrayList;

public class Order {

    private String customerName;
    private ArrayList<Product> products;

    public Order(String customerName) {
        this.customerName = customerName;
        this.products = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        return products.stream().mapToDouble(Product::calcPrice).sum(); // assuming Product has getPrice()
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProduct() {
    return products;
    }

    public void printOrderSummary() {
        System.out.println("\n --- ORDER SUMMARY --- \n");
        System.out.println("Customer: " + customerName);
        int count = 1;
        for (Product product : products) {
            System.out.println("Item #" + count++);
            System.out.println(product.getReceiptDescription());
            System.out.println();
        }

        System.out.printf("Total: $%.2f%n", getTotal());
    }

}