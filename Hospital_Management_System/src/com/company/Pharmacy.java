package com.company;

import java.io.*;
import java.util.Scanner;

public class Pharmacy {
    private static final Scanner input = new Scanner(System.in);
    private static final String[] departments = {"Cardiology", "Neurology", "Eye", "Dental"};
    private static final String[] fileNames = {"Cardiac_Medicines.txt", "Brain_Medicines.txt", "Eye_Medicines.txt", "Dental_Medicines.txt"};

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("*******  PHARMACY  *********");
            System.out.println("1. Add New Medicine\t2. Search Medicine List\nEnter Option:");
            choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    searchMedicine();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            
            System.out.println("To Exit Pharmacy press 0, otherwise continue.");
        } while (input.nextInt() != 0);
    }

    private static void addMedicine() {
        int department = selectDepartment("Add Medicinal Drug In:");
        if (department == -1) return;
        
        System.out.println("Enter Medicine Name:");
        String medName = input.next();
        
        System.out.println("Cost:");
        float cost = input.nextFloat();
        
        System.out.println("Expiry Date:");
        String expDate = input.next();
        
        System.out.println("Used for curing:");
        String usedFor = input.next();
        
        String record = medName + "\t" + cost + "\t" + expDate + "\t" + usedFor + "\n";
        writeToFile(fileNames[department], record);
    }

    private static void searchMedicine() {
        int department = selectDepartment("View/Search Medicines of:");
        if (department == -1) return;
        readFromFile(fileNames[department]);
    }

    private static int selectDepartment(String message) {
        System.out.println(message);
        for (int i = 0; i < departments.length; i++) {
            System.out.println((i + 1) + ". " + departments[i]);
        }
        int choice = input.nextInt();
        return (choice >= 1 && choice <= departments.length) ? choice - 1 : -1;
    }

    private static void writeToFile(String fileName, String data) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data);
            System.out.println("Medicine added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readFromFile(String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No medicines found in this category.");
        }
    }
}