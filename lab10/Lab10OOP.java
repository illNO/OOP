package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello, here you can see list of criminals:");
        System.out.println("You have to enter a number;");
        System.out.println("1 - Write data into file;");
        System.out.println("2 - Read data from file");
        System.out.print("Enter a number, please: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if (number == 1) {
            Scanner name = new Scanner(System.in);
            System.out.print("Enter a name: ");
            String name_text = name.nextLine();

            Scanner surname = new Scanner(System.in);
            System.out.print("Enter a surname: ");
            String surname_text = surname.nextLine();

            Scanner gender = new Scanner(System.in);
            System.out.print("Gender: ");
            String gender_text = gender.nextLine();

            Scanner times = new Scanner(System.in);
            System.out.print("Amount of beings in prison: ");
            int timesInPrison = times.nextInt();

            Scanner lastIn = new Scanner(System.in);
            System.out.print("Last arrest date: ");
            String lastArrest = lastIn.nextLine();

            Scanner lastOut = new Scanner(System.in);
            System.out.print("Last escape date: ");
            String lastEscape = lastOut.nextLine();

            System.out.println("Criminal`s name - " + name_text);
            System.out.println("Criminal`s surname - " + surname_text);
            System.out.println("Criminal`s gender - " + gender);
            System.out.println("Times in prison - " + timesInPrison);
            System.out.println("Last arrest date - " + lastArrest);
            System.out.println("Last escape date - " + lastEscape);
            File myFile = new File("C:\\Users\\Igor\\IdeaProjects\\Lab10OOP\\Prison.txt");
            try {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
                writer.println("Name - " + name_text);
                writer.println("Surname - " + surname_text);
                writer.println("Times in prison - " + timesInPrison);
                writer.println("Last arest date - " + lastArrest);
                writer.println("Last escape date - " + lastEscape);
                writer.println("-----------------------------------------");
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (number == 2) {
            File file = new File("C:\\Users\\Igor\\IdeaProjects\\Lab10OOP\\Prison.txt");

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } else {
            System.out.println("Number does not match. Program ends.");
        }
    }
}
