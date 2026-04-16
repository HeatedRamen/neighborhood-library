package com.pluralsight;

import java.util.Scanner;

public class LibraryApp {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {


        Book[] bookCollection = new Book[20];
        boolean isRunning = true;

        while(isRunning){
            displayHome();
        }
    }
    static void displayHome(){
        println("""
                ----------------------------------------------------
                |                                                   |
                |            (1).  Show Available Books             |
                |            (2). Show Checked Out Books            |
                |            (3).         Exit                      |
                |                                                   |
                -----------------------------------------------------
                """);
    }
    static void println(String message){System.out.println(message);}
}
