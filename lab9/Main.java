package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String[] divide(String s) {
        ArrayList<String> tmp = new ArrayList<String>();
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                if (j > i) {
                    tmp.add(s.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s.length()) {
            tmp.add(s.substring(i));
        }
        return tmp.toArray(new String[tmp.size()]);
    }

    public static void main(String[] args) {

        Scanner InWord = new Scanner(System.in);
        Scanner InText = new Scanner(System.in);
        System.out.print("Enter Text: ");
        String s = InText.nextLine();
        final String sentences[] = s.split("[.!?]\\s*");
        String[] r = divide(s);
        System.out.println("Words from entered text:");

        for (int i = 0; i < r.length; i++)
            System.out.println('"' + r[i] + '"');

        System.out.println("***************************");
        System.out.println("Words with the same first and last letter:");
        String [] SS = s.split("[\\s.,!??!0-9]+");
        int z = 0;
        for(String S1:SS) {

            if(S1.charAt(0)==S1.charAt(S1.length()-1)) {
                System.out.println(S1);
                z++;
            }

            if(z == 0)
                System.out.println("No words");

        }

        Container container = new Container(r);

        System.out.println("Enter word that you would like to Add/Find");
        String str = InWord.nextLine();
        System.out.println("Operations:");
        System.out.println("1 - Add Word");
        System.out.println("2 - Find entered word");
        System.out.println("3 - Display Array");
        System.out.println("4 - Exit");
        System.out.println("Enter Number");
        int k = InWord.nextInt();

        if(k == 1){
            container.AddElement(str);
            for (String item : container) {
                System.out.println(item);
            }
        }

        else if(k == 2){
            System.out.println(container.FindElement(str));
        }

        else if(k == 3) {
            for (int i =0; i < r.length; i++)
                System.out.println(r[i]);
        }

        else if(k == 4){
            System.out.println("Goodbye");
            return;
        }
    }
}
