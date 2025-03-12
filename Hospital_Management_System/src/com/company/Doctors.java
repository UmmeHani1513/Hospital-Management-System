package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Doctors {
    public static void addDoctor() {
        Scanner input = new Scanner(System.in);
        String name, special, workingHours, department = "";
        int age, dep;
        char gender;
        double CNIC;

        System.out.println("Enter Name:");
        name = input.next();
        System.out.println("Enter CNIC:");
        CNIC = input.nextDouble();
        System.out.println("Enter Age:");
        age = input.nextInt();
        System.out.println("Gender (F/M):");
        gender = input.next().charAt(0);
        System.out.println("Working Hours:");
        workingHours = input.next();
        System.out.println("Specialization in:");
        special = input.next();
        
        System.out.println("Hired in department:");
        System.out.println("1. Cardiology\n2. Neurology\n3. Eye\n4. Dental\n5. Lab");
        dep = input.nextInt();

        String fileName = "";
        switch (dep) {
            case 1:
                department = "Cardiology";
                fileName = "Heart_Specialist.txt";
                break;
            case 2:
                department = "Neurology";
                fileName = "Neurologist.txt";
                break;
            case 3:
                department = "Eye";
                fileName = "Eye_Specialist.txt";
                break;
            case 4:
                department = "Dental";
                fileName = "Dentist.txt";
                break;
            case 5:
                department = "Lab";
                fileName = "Lab_Doctors.txt";
                break;
            default:
                System.out.println("Invalid department selection.");
                return;
        }

        String doctorData = "Name: " + name + "\n" +
                "CNIC: " + CNIC + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Working Hours: " + workingHours + "\n" +
                "Specialization: " + special + "\n" +
                "Department: " + department + "\n\n";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(doctorData);
            System.out.println("Doctor information saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    public static void viewDoctors() {
        Scanner input = new Scanner(System.in);
        System.out.println("View Doctor list of:\n1. Cardiology\n2. Neurology\n3. Eye\n4. Dental\n5. Lab");
        int choice = input.nextInt();
        String fileName = "";

        switch (choice) {
            case 1:
                fileName = "Heart_Specialist.txt";
                break;
            case 2:
                fileName = "Neurologist.txt";
                break;
            case 3:
                fileName = "Eye_Specialist.txt";
                break;
            case 4:
                fileName = "Dentist.txt";
                break;
            case 5:
                fileName = "Lab_Doctors.txt";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        try (Scanner fileReader = new Scanner(new File(fileName))) {
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No records found for the selected department.");
        }
    }
}
