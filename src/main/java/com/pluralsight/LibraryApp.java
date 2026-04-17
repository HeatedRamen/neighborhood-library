package com.pluralsight;

import java.util.Scanner;

public class LibraryApp {
    private static Scanner input = new Scanner(System.in);
    private static Book[] bookCollection = new Book[20];

    public static void main(String[] args) {

        boolean isRunning = true;
        boolean inMenu = true;
        String userChoice;

        bookCollection[0] = new Book(1, "67", "Blue Judas");
        bookCollection[1] = new Book(2, "68", "Red Judas");
        bookCollection[2] = new Book(3, "69", "Jumping Guy");
        bookCollection[3] = new Book(4, "70", "Jane Juliet");
        bookCollection[4] = new Book(5, "71", "Tuka Donka");
        bookCollection[5] = new Book(6, "73", "Curse Throater");
        bookCollection[6] = new Book(7, "74", "Bush Camper");
        bookCollection[7] = new Book(8, "75", "Potential Man");

        while(isRunning){
            displayHome();
            userChoice = input.nextLine();

            switch(userChoice){
                case "1":
                    displayAvailable();
                    inMenu = true;
                    checkOutMenu();
                    userChoice = (input.nextLine()).toLowerCase();

                    while (inMenu){
                        switch (userChoice) {
                            case "c":
                                checkOutBook();
                                inMenu = false;
                                break;
                            case "x":
                                inMenu = false;
                                break;
                            default:
                                println("Please enter a valid choice");
                                userChoice = (input.nextLine()).toLowerCase();
                        }
                    }
                    break;
                case "2":
                    displayCheckedOut();
                    inMenu = true;
                    checkInMenu();
                    userChoice = input.nextLine().toLowerCase();

                    while (inMenu){
                        switch (userChoice) {
                            case "c":
                                checkInBook();
                                inMenu = false;
                                break;
                            case "x":
                                inMenu = false;
                                break;
                            default:
                                println("Please enter a valid choice");
                                userChoice = (input.nextLine()).toLowerCase();
                        }
                    }
                    break;
                case "3":
                    isRunning = false;
                    break;
                default:
                    println("Please enter a valid option");
            }
        }
    }
    static void displayHome() {
        println("""
                ----------------------------------------------------
                |                                                   |
                |            (1).  Show Available Books             |
                |            (2). Show Checked Out Books            |
                |            (3).         Exit                      |
                |               Please select an option             |
                |                                                   |
                -----------------------------------------------------""");
    }
    static void displayAvailable(){
        for (Book book : bookCollection){
            if(book != null && !book.getIsCheckedOut())
                System.out.printf("Book Title: %s, Book ID: %d, Book ISBN: %s\n", book.getTitle(), book.getID(), book.getISBN());
        }
    }
    static void checkOutMenu(){
        println("""
                
                (c) Do you want to check out a book?
                (x)         Back to home""");
    }
    static void checkOutBook(){
        println("Enter the title of the book to check out");
        String bookName = input.nextLine();
        boolean bookFound = false;

        for (Book book : bookCollection){
            if (bookName.equalsIgnoreCase(book.getTitle())){
                println("What is your name?");
                book.checkOut(input.nextLine());
                bookFound = true;
                break;
            }
        }
        if (!bookFound){
            println("Book with that title was not found");
        }
    }
    static void displayCheckedOut(){
        for (Book book : bookCollection){
            if (book != null && book.getIsCheckedOut()){
                System.out.printf("Book Title: %s, Book ID: %d, Book ISBN: %s\n", book.getTitle(), book.getID(), book.getISBN());
            }
        }
    }
    static void checkInMenu(){
        println("""
                
                (c) Do you want to check in a book?
                (x)         Back to home""");
    }
    static void checkInBook(){
        println("Enter the title of the book to check out");
        String bookName = input.nextLine();
        boolean bookFound = false;

        for (Book book : bookCollection){
            if (bookName.equalsIgnoreCase(book.getTitle())){
                println("What is your name?");
                book.checkIn();
                bookFound = true;
                break;
            }
        }
        if (!bookFound){
            println("Book with that title was not found");
        }
    }


    static void println(String message){System.out.println(message);}
}
