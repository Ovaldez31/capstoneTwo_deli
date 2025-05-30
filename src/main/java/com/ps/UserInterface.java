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
            System.out.println("0) Cancel Order (Return to Home Page)");
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

        System.out.print("Select drink flavor: ");
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

        Sandwich.Size currentSize = null;
        Sandwich.BreadType currentSandwichBreadType = null;
        Sandwich.MeatOption currentSandwichMeat = null;
        Sandwich.CheeseOption currentSandwichCheese = null;

        boolean currentSandwichExtraMeat = false;
        boolean currentSandwichExtraCheese = false;
        boolean currentSandwichToasted = false;

        ArrayList<Sandwich.RegularTopping> toppings = new ArrayList<>();
        ArrayList<Sandwich.SauceOption> saucesOption = new ArrayList<>();

        System.out.println("Choose size: 1) SMALL  2) MEDIUM  3) LARGE  0) Go Back");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        if (sizeChoice == 0) {
            System.out.println("Going back...");
            return; // exits the customizeSandwichMenu() method
        } else if (sizeChoice == 1) {
            currentSize = Sandwich.Size.SMALL;
        } else if (sizeChoice == 2) {
            currentSize = Sandwich.Size.MEDIUM;
        } else if (sizeChoice == 3) {
            currentSize = Sandwich.Size.LARGE;
        } else {
            System.out.println("Invalid size choice.");

        }

        System.out.println("Choose bread: 1) WHITE  2)WHEAT  3)RYE  4)WRAP  0) Go Back");
        int breadChoice = scanner.nextInt();
        scanner.nextLine();

        if (breadChoice == 0) {
            System.out.println("Going back...");
            return;
        } else if (breadChoice == 1) {
            currentSandwichBreadType = Sandwich.BreadType.WHITE;
        } else if (breadChoice == 2) {
            currentSandwichBreadType = Sandwich.BreadType.WHEAT;
        } else if (breadChoice == 3) {
            currentSandwichBreadType = Sandwich.BreadType.RYE;
        } else if (breadChoice == 4) {
            currentSandwichBreadType = Sandwich.BreadType.WRAP;
        } else {
            System.out.println("Invalid bread choice.");
            return;
        }

        System.out.println("Choose meat: 1) STEAK  2) HAM  3) SALAMI  4) ROASTED BEEF  5) CHICKEN  6) BACON  0) Go Back");
        int meatChoice = scanner.nextInt();
        scanner.nextLine();

        if (meatChoice == 1) {
            currentSandwichMeat = Sandwich.MeatOption.STEAK;
        } else if (meatChoice == 2) {
            currentSandwichMeat = Sandwich.MeatOption.HAM;
        } else if (meatChoice == 3) {
            currentSandwichMeat = Sandwich.MeatOption.SALAMI;
        } else if (meatChoice == 4) {
            currentSandwichMeat = Sandwich.MeatOption.ROAST_BEEF;
        } else if (meatChoice == 5) {
            currentSandwichMeat = Sandwich.MeatOption.CHICKEN;
        } else if (meatChoice == 6) {
            currentSandwichMeat = Sandwich.MeatOption.BACON;
        } else if (meatChoice == 0) {
            System.out.println("Going back...");
            return;
        } else {
            System.out.println("Invalid meat choice.");
            return;
        }

        String extraMeatInput;

        do {
            System.out.println("Add extra meat? (yes/no): ");
            extraMeatInput = scanner.nextLine().trim().toLowerCase();

            if (!extraMeatInput.equals("yes") && !extraMeatInput.equals("no")) {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        } while (!extraMeatInput.equals("yes") && !extraMeatInput.equals("no"));

        currentSandwichExtraMeat = extraMeatInput.equals("yes");

        if (currentSandwichExtraMeat) {
            System.out.println("Choose an additional meat: 1) STEAK  2) HAM  3) SALAMI  4) ROASTED BEEF  5) CHICKEN  6) BACON  0) Go Back");
            int extraMeatChoice = scanner.nextInt();
            scanner.nextLine();
            if (extraMeatChoice == 0) {
                System.out.println("Going back...");
                return;
            }
        }
        System.out.println("Choose cheese: 1) AMERICAN  2) PROVOLONE  3) CHEDDAR  4) SWISS  5) No Cheese");
        int cheeseChoice = scanner.nextInt();
        scanner.nextLine();
        currentSandwichCheese = switch (cheeseChoice) {
            case 1 -> Sandwich.CheeseOption.AMERICAN;
            case 2 -> Sandwich.CheeseOption.PROVOLONE;
            case 3 -> Sandwich.CheeseOption.CHEDDAR;
            case 4 -> Sandwich.CheeseOption.SWISS;
            case 5 -> null;
            default -> {
                System.out.println("Invalid cheese choice.");
                yield null;
            }
        };

        String extraCheeseInput;

        do {
            System.out.println("Add extra cheese? (yes/no): ");
            extraCheeseInput = scanner.nextLine().trim().toLowerCase();

            if (!extraCheeseInput.equals("yes") && !extraCheeseInput.equals("no")) {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        } while (!extraCheeseInput.equals("yes") && !extraCheeseInput.equals("no"));

        currentSandwichExtraCheese = extraCheeseInput.equals("yes");

        if (currentSandwichExtraCheese) {
            System.out.println("Choose an additional cheese: 1) AMERICAN  2) PROVOLONE  3) CHEDDAR  4) SWISS  0) Go Back");
            int extraCheeseChoice = scanner.nextInt();
            scanner.nextLine();

            if (extraCheeseChoice == 0) {
                System.out.println("Going back...");
                return;
            }
        }

        String toastedInput;
        do {
            System.out.println("Would you like it toasted? (yes/no or 0 to go back): ");
            toastedInput = scanner.nextLine().trim().toLowerCase();

            if (toastedInput.equals("0")) {
                System.out.println("Going back...");
                return;
            }

            if (!toastedInput.equals("yes") && !toastedInput.equals("no")) {
                System.out.println("Please enter 'yes', 'no', or '0' to go back.");
            }
        } while (!toastedInput.equals("yes") && !toastedInput.equals("no"));

        currentSandwichToasted = toastedInput.equals("yes");

        System.out.println("Choose toppings: 1)LETTUCE  2)PEPPERS  3)ONIONS  4)TOMATOES  5)JALAPENOS " +
                " 6)CUCUMBERS  7)PICKLES  8)GUACAMOLE  9)MUSHROOMS");
        System.out.println("Enter 0 to stop adding toppings or -1 to go back.");
        int toppingChoice;

        do {
            toppingChoice = scanner.nextInt();
            scanner.nextLine();

            if (toppingChoice == -1) {
                System.out.println("Going back...");
                return;
            }

            switch (toppingChoice) {
                case 1 -> toppings.add(Sandwich.RegularTopping.LETTUCE);
                case 2 -> toppings.add(Sandwich.RegularTopping.PEPPERS);
                case 3 -> toppings.add(Sandwich.RegularTopping.ONIONS);
                case 4 -> toppings.add(Sandwich.RegularTopping.TOMATOES);
                case 5 -> toppings.add(Sandwich.RegularTopping.JALAPENOS);
                case 6 -> toppings.add(Sandwich.RegularTopping.CUCUMBERS);
                case 7 -> toppings.add(Sandwich.RegularTopping.PICKLES);
                case 8 -> toppings.add(Sandwich.RegularTopping.GUACAMOLE);
                case 9 -> toppings.add(Sandwich.RegularTopping.MUSHROOMS);
                case 0 -> System.out.println("Done selecting toppings.");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (toppingChoice != 0);

        boolean addingSauces = true;
        while (addingSauces) {
            System.out.println("Choose a sauce to add:");
            System.out.println("1) MAYO  2) MUSTARD  3) KETCHUP  4) RANCH  5) THOUSAND ISLANDS  6) VINAIGRETTE");
            System.out.println("0) Done adding sauces");

            int sauceChoice = scanner.nextInt();
            scanner.nextLine();

            if (sauceChoice == -1) {
                System.out.println("Going back...");
                return;
            }

            Sandwich.SauceOption selectedSauce = switch (sauceChoice) {
                case 1 -> Sandwich.SauceOption.MAYO;
                case 2 -> Sandwich.SauceOption.MUSTARD;
                case 3 -> Sandwich.SauceOption.KETCHUP;
                case 4 -> Sandwich.SauceOption.RANCH;
                case 5 -> Sandwich.SauceOption.THOUSAND_ISLANDS;
                case 6 -> Sandwich.SauceOption.VINAIGRETTE;
                case 0 -> {
                    addingSauces = false;
                    yield null;
                }
                default -> {
                    System.out.println("Invalid sauce choice.");
                    yield null;
                }
            };

            if (selectedSauce != null && !saucesOption.contains(selectedSauce)) {
                saucesOption.add(selectedSauce);
                System.out.println(selectedSauce + " added!");
            } else if (selectedSauce != null) {
                System.out.println("You already added that sauce.");
            }
        }
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
            System.out.println("- Toppings: " + toppings);
            System.out.println("- Sauces: " + saucesOption);
            System.out.println("----------------------------------------");
            System.out.println("1) Add Sandwich to Order");
            System.out.println("0) Cancel and Go Back");
            System.out.print("Your choice: ");

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    assert currentSize != null;
                    Sandwich sandwich = new Sandwich(

                            currentSize,
                            currentSandwichBreadType,
                            currentSandwichMeat,
                            currentSandwichExtraMeat,
                            currentSandwichCheese,
                            currentSandwichExtraCheese,
                            currentSandwichToasted,
                            toppings.toString(),
                            saucesOption.toString(),
                            currentSize.getBreadPrice(),
                            currentSize.getMeatPrice(),
                            currentSize.getCheesePrice(),
                            currentSize.getExtraMeatPrice(),
                            currentSize.getExtraCheesePrice()
                    );

                    order.addProduct(sandwich);
                    System.out.println("Custom sandwich added to order!");
                    input = 0;
                    break;

                case 0:
                    System.out.println("Cancelled sandwich creation. Have a DELI-cious Day!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (input != 0);

        System.out.println("Custom sandwich added to order!");

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
