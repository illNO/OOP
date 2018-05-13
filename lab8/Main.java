package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("-h")){
            Help h = new Help();
            h.execute();
        }

        if(args[0].equalsIgnoreCase("debug") || args[0].equalsIgnoreCase("-d")){
            Debug d = new Debug();
            d.execute();
            Execution ex = new Execution();
            ex.execute();
        }
    }
}
