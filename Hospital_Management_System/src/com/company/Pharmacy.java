package com.company;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
// Command Interface
interface Command {
    void execute();
}

// Concrete Command Classes for Adding Medicines
class AddCardiacMedicineCommand implements Command {
    private Cardiac_med cardiacMed;

    public AddCardiacMedicineCommand(Cardiac_med cardiacMed) {
        this.cardiacMed = cardiacMed;
    }

    @Override
    public void execute() {
        cardiacMed.add();
    }
}

class AddNeurologyMedicineCommand implements Command {
    private Neurology_med neurologyMed;

    public AddNeurologyMedicineCommand(Neurology_med neurologyMed) {
        this.neurologyMed = neurologyMed;
    }

    @Override
    public void execute() {
        neurologyMed.add();
    }
}

class AddEyeMedicineCommand implements Command {
    private Eye_med eyeMed;

    public AddEyeMedicineCommand(Eye_med eyeMed) {
        this.eyeMed = eyeMed;
    }

    @Override
    public void execute() {
        eyeMed.add();
    }
}

class AddDentalMedicineCommand implements Command {
    private Dental_med dentalMed;

    public AddDentalMedicineCommand(Dental_med dentalMed) {
        this.dentalMed = dentalMed;
    }

    @Override
    public void execute() {
        dentalMed.add();
    }
}

// Concrete Command Classes for Searching Medicines
class SearchCardiacMedicineCommand implements Command {
    private search_med searchMed;

    public SearchCardiacMedicineCommand(search_med searchMed) {
        this.searchMed = searchMed;
    }

    @Override
    public void execute() {
        searchMed.search_heart();
    }
}

class SearchNeurologyMedicineCommand implements Command {
    private search_med searchMed;

    public SearchNeurologyMedicineCommand(search_med searchMed) {
        this.searchMed = searchMed;
    }

    @Override
    public void execute() {
        searchMed.search_Brain_Med();
    }
}

class SearchEyeMedicineCommand implements Command {
    private search_med searchMed;

    public SearchEyeMedicineCommand(search_med searchMed) {
        this.searchMed = searchMed;
    }

    @Override
    public void execute() {
        searchMed.search_Eye_Med();
    }
}

class SearchDentalMedicineCommand implements Command {
    private search_med searchMed;

    public SearchDentalMedicineCommand(search_med searchMed) {
        this.searchMed = searchMed;
    }

    @Override
    public void execute() {
        searchMed.search_Dental_Med();
    }
}

// The Pharmacy Class (Invoker)
public class Pharmacy {
    private Command addCommand;
    private Command searchCommand;

    public void setAddCommand(Command command) {
        this.addCommand = command;
    }

    public void setSearchCommand(Command command) {
        this.searchCommand = command;
    }

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
                case 1:
                    System.out.println("Add Medicinal Drug In:\n1.Cardiology\n2.Neurology\n3.Eye\n4.Dental");
                    a = input.nextInt();
                    switch (a) {
                        case 1:
                            setAddCommand(new AddCardiacMedicineCommand(cardiac));
                            addCommand.execute();
                            break;
                        case 2:
                            setAddCommand(new AddNeurologyMedicineCommand(neuro));
                            addCommand.execute();
                            break;
                        case 3:
                            setAddCommand(new AddEyeMedicineCommand(e));
                            addCommand.execute();
                            break;
                        case 4:
                            setAddCommand(new AddDentalMedicineCommand(den));
                            addCommand.execute();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("View/Search Medicines of:\n1.Cardiology\n2.Neurology\n3.Eye\n4.Dental");
                    a = input.nextInt();
                    switch (a) {
                        case 1:
                            setSearchCommand(new SearchCardiacMedicineCommand(h));
                            searchCommand.execute();
                            break;
                        case 2:
                            setSearchCommand(new SearchNeurologyMedicineCommand(h));
                            searchCommand.execute();
                            break;
                        case 3:
                            setSearchCommand(new SearchEyeMedicineCommand(h));
                            searchCommand.execute();
                            break;
                        case 4:
                            setSearchCommand(new SearchDentalMedicineCommand(h));
                            searchCommand.execute();
                            break;
                    }
                    break;
            }
            System.out.println("To Exit Pharmacy press 0");
            n = input.nextInt();
        } while (n != 0);
    }
}

// Abstract Class for Adding Medicines
abstract class ADD_Medicine extends Pharmacy {
    String med_name, exp_date, used_for;
    float cost;
    public abstract void add();
}

// Concrete Classes for Different Categories of Medicines
class Cardiac_med extends ADD_Medicine {
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

// Search Class
class search_med extends Pharmacy {
    ArrayList<String> Med = new ArrayList<String>();
    ArrayList<String> Neuro = new ArrayList<String>();
    ArrayList<String> Eye = new ArrayList<String>();
    ArrayList<String> Dental = new ArrayList<String>();

    public void search_heart() {
        try {
            File myObj = new File("Cardiac_Medicines.txt");
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

    public void search_Brain_Med() {
        try {
            File myObj = new File("Brain_Medicines.txt");
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

    public void search_Eye_Med() {
        try {
            File myObj = new File("Eye_Medicines.txt");
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

    public void search_Dental_Med() {
        try {
            File myObj = new File("Dental_Medicines.txt");
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
