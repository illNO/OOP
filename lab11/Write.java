import java.io.*;
import java.util.Scanner;

public class Write extends Main implements Main.Command {
    public void execute(){
        File myFile = new File("C:\\Users\\DareBlig\\IdeaProjects\\Lab_11\\Information.txt");
        Scanner name = new Scanner(System.in);
        System.out.print("Your name: ");
        String name_text = name.nextLine();
        Scanner gender = new Scanner(System.in);
        System.out.print("Your gender: ");
        String gender_text = gender.nextLine();
        Scanner registration = new Scanner(System.in);
        System.out.print("Your registration number: ");
        String reg_text = registration.nextLine();
        Scanner date = new Scanner(System.in);
        System.out.print("Your registration date: ");
        String date_text = date.nextLine();
        System.out.println("**************************************");
        System.out.println("Your name - " + name_text);
        System.out.println("Your gender - " + gender_text);
        System.out.println("Your registration number - " + reg_text);
        System.out.println("Your registration date - " + date_text);
        System.out.println("**************************************");
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
            writer.println("Name - " + name_text);
            writer.println("Gender - " + gender_text);
            writer.println("Registration number - " + reg_text);
            writer.println("Registration date - " + date_text);
            writer.println("**************************************");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
