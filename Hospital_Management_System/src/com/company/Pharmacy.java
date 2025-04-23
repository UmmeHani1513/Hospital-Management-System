package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pharmacy {
    private CommandInvoker invoker = new CommandInvoker();

    public void display() {
        int c, a, n;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("*******  PHARMACY  *********");
            System.out.println("1.Add New Medicine\t2.Search Medicine List\nEnter Option:\t");
            c = input.nextInt();

            Cardiac_med cardiac = new Cardiac_med();
            Neurology_med neuro = new Neurology_med();
            Eye_med e = new Eye_med();
            Dental_med den = new Dental_med();
            search_med h = new search_med();

            switch (c) {
                case 1: {
                    System.out.println("Add Medicinal Drug In:\n1.Cardiology\n2.Neurology\n3.Eye\n4.Dental");
                    a = input.nextInt();
                    switch (a) {
                        case 1:
                            invoker.setCommand(new AddMedicineCommand(cardiac));
                            invoker.executeCommand();
                            break;
                        case 2:
                            invoker.setCommand(new AddMedicineCommand(neuro));
                            invoker.executeCommand();
                            break;
                        case 3:
                            invoker.setCommand(new AddMedicineCommand(e));
                            invoker.executeCommand();
                            break;
                        case 4:
                            invoker.setCommand(new AddMedicineCommand(den));
                            invoker.executeCommand();
                            break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("View/Search Medicines of:\n1.Cardiology\n2.Neurology\n3.Eye\n4.Dental");
                    a = input.nextInt();
                    switch (a) {
                        case 1:
                            invoker.setCommand(new SearchMedicineCommand(h, "Cardiac_Medicines.txt"));
                            invoker.executeCommand();
                            break;
                        case 2:
                            invoker.setCommand(new SearchMedicineCommand(h, "Brain_Medicines.txt"));
                            invoker.executeCommand();
                            break;
                        case 3:
                            invoker.setCommand(new SearchMedicineCommand(h, "Eye_Medicines.txt"));
                            invoker.executeCommand();
                            break;
                        case 4:
                            invoker.setCommand(new SearchMedicineCommand(h, "Dental_Medicines.txt"));
                            invoker.executeCommand();
                            break;
                    }
                    break;
                }
            }
            System.out.println("To Exit Pharmacy press 0");
            n = input.nextInt();
        } while (n != 0);
    }
}

interface Command {
    void execute();
}

class CommandInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

abstract class ADD_Medicine {
    String med_name, exp_date, used_for;
    float cost;

    public abstract void add();
}

class Cardiac_med extends ADD_Medicine {
    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Medicine Name:");
        med_name = input.next();
        System.out.println("Cost:");
        cost = input.nextInt();
        System.out.println("Expiry Date:\t");
        exp_date = input.next();
        System.out.println("Used for curing:");
        used_for = input.next();
        try {
            FileWriter g = new FileWriter("Cardiac_Medicines.txt", true);
            g.write(med_name + "\t" + cost + "\t\t" + exp_date + "\t" + used_for + "\n");
            System.out.println("Written");
            g.close();
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }
    }
}

class Neurology_med extends ADD_Medicine {
    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Medicine Name:");
        med_name = input.next();
        System.out.println("Cost:");
        cost = input.nextInt();
        System.out.println("Expiry Date:\t");
        exp_date = input.next();
        System.out.println("Used for curing:");
        used_for = input.next();
        try {
            FileWriter g = new FileWriter("Brain_Medicines.txt", true);
            g.write(med_name + "\t" + cost + "\t\t" + exp_date + "\t" + used_for + "\n");
            System.out.println("Written");
            g.close();
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }
    }
}

class Eye_med extends ADD_Medicine {
    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Medicine Name:");
        med_name = input.next();
        System.out.println("Cost:");
        cost = input.nextInt();
        System.out.println("Expiry Date:\t");
        exp_date = input.next();
        System.out.println("Used for curing:");
        used_for = input.next();
        try {
            FileWriter g = new FileWriter("Eye_Medicines.txt", true);
            g.write(med_name + "\t" + cost + "\t\t" + exp_date + "\t" + used_for + "\n");
            System.out.println("Written");
            g.close();
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }
    }
}

class Dental_med extends ADD_Medicine {
    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Medicine Name:");
        med_name = input.next();
        System.out.println("Cost:");
        cost = input.nextInt();
        System.out.println("Expiry Date:\t");
        exp_date = input.next();
        System.out.println("Used for curing:");
        used_for = input.next();
        try {
            FileWriter g = new FileWriter("Dental_Medicines.txt", true);
            g.write(med_name + "\t" + cost + "\t\t" + exp_date + "\t" + used_for + "\n");
            System.out.println("Written");
            g.close();
        } catch (IOException e) {
            System.out.println("Error ");
            e.printStackTrace();
        }
    }
}

class search_med {
    public void search_heart(String fileName) {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class AddMedicineCommand implements Command {
    private ADD_Medicine medicine;

    public AddMedicineCommand(ADD_Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public void execute() {
        medicine.add();
    }
}

class SearchMedicineCommand implements Command {
    private search_med search;
    private String fileName;

    public SearchMedicineCommand(search_med search, String fileName) {
        this.search = search;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        search.search_heart(fileName);
    }
}
