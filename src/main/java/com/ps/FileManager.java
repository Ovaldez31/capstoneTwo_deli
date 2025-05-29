package com.ps;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    private static final String RECEIPT_FOLDER = "receipts";

    public static void saveOrderToFile(Order order) {
        try {
            File folder = new File(RECEIPT_FOLDER);
            if (!folder.exists()) {
                folder.mkdir();
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            File file = new File(folder, timestamp + ".txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("DELI-cious Order Receipt\n");
                writer.write("-------------------------\n");
                writer.write("Customer: " + order.getCustomerName() + "\n\n");

                int count = 1;
                for (Product products : order.getProduct()) {
                    writer.write("Item #" + count++ + "\n");
                    writer.write(products.getReceiptDescription());
                    writer.newLine();
                    writer.newLine();

                }

                writer.write("-------------------------\n");
                writer.write(String.format("Total: $%.2f", order.getTotal()));
            }

            System.out.println("Receipt saved to: " + file.getPath());
            } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
            }
        }
}