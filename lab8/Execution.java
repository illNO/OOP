package com.company;
import java.util.Scanner;

public class Execution extends Main{
    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Text: ");
        String text = in.nextLine();
        String text_copy = text;

        Scanner in2 = new Scanner(System.in);
        System.out.println("Enter number");
        int number = in2.nextInt();

        Scanner in3 = new Scanner(System.in);
        System.out.println("Enter line");
        String newtext = in3.nextLine();
        int counter = 0;
        String output[] = text.split(" ");
        for(int i=0;i<output.length;i++){
            if(output[i].length() == number){
                output[i]=newtext;
            }
        }


        for(int i=0;i<output.length;i++){
            System.out.print(output[i] + " ");
        }
        System.out.println("");
        System.out.println(text.toString());
    }
}
