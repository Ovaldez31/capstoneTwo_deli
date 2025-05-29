package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);
    private Order order;


    public UserInterface() {
        init();
    }

    private void init() {

    }

    public void display() {

        int mainMenuCommand;

        do {
            System.out.println("\nWelcome to DELI-cious Sandwiches!\n");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.println("Choose an option: ");
            mainMenuCommand = scanner.nextInt();
            scanner.nextLine();

            switch (mainMenuCommand) {
                case 1:
                    newOrder();
                    break;
                case 0:
                    System.out.println("Exiting from Delicious Sandwiches... have a scrumptious day!!!");
                    break;
                default:
                    System.out.println("System error");
            }
        } while (mainMenuCommand != 0);
    }

    private void newOrder() {
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();

        order = new Order(name);
        orderMenu();
    }

    public void orderMenu() {
        int input;

        do {
            System.out.println("----------------------------------------");
            System.out.println(" --- Order for " + order.getCustomerName() + " ---");
            System.out.printf(" Current Order Total: $%.2f\n", order.getTotal());
            System.out.println("----------------------------------------");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) View Current Order / Checkout");
            System.out.println("0) Cancel Order (Return to Main Menu)");
            System.out.println("----------------------------------------");
            System.out.print("Choose an option: ");

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    addSandwichMenu();
                    break;
                case 2:
                    addDrinkMenu();
                    break;
                case 3:
                    addChipsMenu();
                    break;
                case 4:
                    checkingOut();
                    break;
                case 0:
                    System.out.println("Order cancelled.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (input != 0 && order != null);

    }


    private void addSandwichMenu() {
        int input;

        do {
            System.out.println("\n----------------------------------------");
            System.out.println(" --- Building Your Sandwich ---");
            System.out.println("----------------------------------------");
            System.out.println("1) Customize New Sandwich");
            System.out.println("2) Choose Signature Sandwich (Implement this method)");
            System.out.println("0) Back to Order Menu");
            System.out.println("----------------------------------------");
            System.out.print("Choose an option: ");

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    customizeSandwichMenu();
                    break;
                case 2:
                    choosingSignatureSandwichMenu();
                    break;
                case 0:
                    System.out.println("Returning to Order Menu");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }

        }
        while (input != 0);


    }

    private void addDrinkMenu() {

        System.out.println("Select drink size:");
        System.out.println("1) SMALL");
        System.out.println("2) MEDIUM");
        System.out.println("3) LARGE");
        System.out.println("Choice: ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        String size = switch (sizeChoice) {
            case 1 -> "SMALL";
            case 2 -> "MEDIUM";
            case 3 -> "LARGE";
            default -> "Invalid choice.";
        };

        System.out.print("Select drink flavor:");
        System.out.println("1) COLA");
        System.out.println("2) SPRITE");
        System.out.println("3) GRAPE");
        System.out.println("4) ORANGE");
        System.out.println("Choice: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        order.addProduct(drink);
        System.out.println("Drink added to order.");

    }

    private void addChipsMenu() {
        System.out.print("Enter chip flavor: ");

        System.out.println("1) PLAIN");
        System.out.println("2) BBQ");
        System.out.println("3) SOUR CREAM");
        System.out.println("Choice:  ");
        String flavorChoice = scanner.nextLine();

        String flavor = switch (flavorChoice) {
            case "1" -> "Plain";
            case "2" -> "BBQ";
            case "3" -> "Sour Cream";
            default -> "Invalid choice.";
        };

        Chip chips = new Chip(flavor);
        order.addProduct(chips);
        System.out.println("Chips added to order.");
    }

    private void choosingSignatureSandwichMenu() {
    }

    private void customizeSandwichMenu() {
        Sandwich.Size currentSize = Sandwich.Size.SMALL;
        Sandwich.BreadType currentSandwichBreadType = Sandwich.BreadType.WHITE;
        Sandwich.MeatOption currentSandwichMeat = Sandwich.MeatOption.CHICKEN;
        boolean currentSandwichExtraMeat = false;
        Sandwich.CheeseOption currentSandwichCheese = Sandwich.CheeseOption.AMERICAN;
        boolean currentSandwichExtraCheese = false;
        boolean currentSandwichToasted = false;

        ArrayList<Sandwich.RegularTopping> regularToppings = new ArrayList<>();
        ArrayList<Sandwich.SauceOption> sauces = new ArrayList<>();

        int input;
        do {
            System.out.println("\n----------------------------------------");
            System.out.println(" --- Customize Your Sandwich ---");
            System.out.println("\nOptions:");
            System.out.println("- Size: " + currentSize);
            System.out.println("- Bread: " + currentSandwichBreadType);
            System.out.println("- Meat: " + currentSandwichMeat + (currentSandwichExtraMeat ? "(EXTRA)" : ""));
            System.out.println("- Cheese: " + currentSandwichCheese + (currentSandwichExtraCheese ? " (Extra)" : ""));
            System.out.println("- Toasted: " + (currentSandwichToasted ? "Yes" : "No"));
            System.out.println("- Toppings: " + regularToppings);
            System.out.println("- Sauces: " + sauces);
            System.out.println("----------------------------------------");
            System.out.println("1) Choose Size");
            System.out.println("2) Choose Bread Type");
            System.out.println("3) Choose Meat");
            System.out.println("4) Choose Cheese");
            System.out.println("5) Add/Remove Regular Toppings");
            System.out.println("6) Add/Remove Sauces");
            System.out.println("7) Toggle Toasted");
            System.out.println("8) Add Sandwich to Order");
            System.out.println("0) Cancel and Go Back");
            System.out.print("Your choice: ");

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("Choose a sandwich size: ");
                    System.out.println("1) SMALL (4\")");
                    System.out.println("2) MEDIUM (8\")");
                    System.out.println("3) LARGE (12\")");
                    System.out.print("Enter option: ");

                    int sizeChoice = scanner.nextInt();
                    scanner.nextLine();


            }
        } while (input != 0);
    }

    private void checkingOut() {
        System.out.println("\n--- CHECKOUT ---");
        order.printOrderSummary();

        System.out.print("Would you like to confirm and save this order? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes")) {
            FileManager.saveOrderToFile(order);
            order = null;
            System.out.println("Thank you! Returning to main menu.");
        } else {
            System.out.println("Checkout cancelled. Returning to order menu.");
        }
    }
}
