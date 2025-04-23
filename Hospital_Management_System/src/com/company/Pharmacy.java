package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pharmacy {

    public void display() {
        int c, a, n;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("*******  PHARMACY  *********");
            System.out.println("1. Add New Medicine\t2. Search Medicine List");
            System.out.print("Enter Option:\t");
            c = input.nextInt();

            switch (c) {
                case 1:
                    System.out.println("Add Medicinal Drug In:\n1. Cardiology\n2. Neurology\n3. Eye\n4. Dental");
                    a = input.nextInt();
                    switch (a) {
                        case 1:
                            addMedicine("Cardiac_Medicines.txt");
                            break;
                        case 2:
                            addMedicine("Brain_Medicines.txt");
                            break;
                        case 3:
                            addMedicine("Eye_Medicines.txt");
                            break;
                        case 4:
                            addMedicine("Dental_Medicines.txt");
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                case 2:
                    System.out.println("Search Medicines in:\n1. Cardiology\n2. Neurology\n3. Eye\n4. Dental");
                    a = input.nextInt();
                    switch (a) {
                        case 1:
                            searchMedicine("Cardiac_Medicines.txt");
                            break;
                        case 2:
                            searchMedicine("Brain_Medicines.txt");
                            break;
                        case 3:
                            searchMedicine("Eye_Medicines.txt");
                            break;
                        case 4:
                            searchMedicine("Dental_Medicines.txt");
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println("To Exit Pharmacy press 0, any other key to continue:");
            n = input.nextInt();
        } while (n != 0);
    }

    private void addMedicine(String fileName) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Medicine Name:");
        String medName = input.next();
        System.out.println("Cost:");
        float cost = input.nextFloat();
        System.out.println("Expiry Date:");
        String expDate = input.next();
        System.out.println("Used for curing:");
        String usedFor = input.next();

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(medName + "\t" + cost + "\t\t" + expDate + "\t" + usedFor + "\n");
            System.out.println("Medicine added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    private void searchMedicine(String fileName) {
        try (Scanner fileReader = new Scanner(new File(fileName))) {
            System.out.println("Medicines listed in " + fileName + ":");
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No records found for this department.");
        }
    }

    public static void main(String[] args) {
        Pharmacy p = new Pharmacy();
        p.display();
    }
}
