package com.pluralsight;

import java.util.Scanner;

public class LibraryApp {

    // Make global input and book class
    private static Scanner input = new Scanner(System.in);
    private static Book[] bookCollection = new Book[20];

    public static void main(String[] args) {

        boolean isRunning = true;
        boolean inMenu = true;
        String userChoice;

        // Initializing books with some values
        bookCollection[0] = new Book(1, "67", "Blue Judas");
        bookCollection[1] = new Book(2, "68", "Red Judas");
        bookCollection[2] = new Book(3, "69", "Jumping Guy");
        bookCollection[3] = new Book(4, "70", "Jane Juliet");
        bookCollection[4] = new Book(5, "71", "Tuka Donka");
        bookCollection[5] = new Book(6, "73", "Curse Throater");
        bookCollection[6] = new Book(7, "74", "Bush Camper");
        bookCollection[7] = new Book(8, "75", "Potential Man");
        bookCollection[8] = new Book(9, "76" , "Electric Waffle");
        bookCollection[9] = new Book(10, "77" , "Retrial Lawyer");
        bookCollection[10] = new Book(11, "78" , "Bubble Pop Electric");
        bookCollection[11] = new Book(12, "79" , "Nah I'd Adapt");
        bookCollection[12] = new Book(13, "80" , "Ghost of the Zenin Clan");
        bookCollection[13] = new Book(14, "81" , "The Problem Child");
        bookCollection[14] = new Book(15, "82" , "Panda...");
        bookCollection[15] = new Book(16, "83" , "Salmon Roe Tuna Mayo");
        bookCollection[16] = new Book(17, "84" , "BROTHEEEER");
        bookCollection[17] = new Book(18, "85" , "Funniest Comedian");
        bookCollection[18] = new Book(19, "86" , "Shiesty Warrior");
        bookCollection[19] = new Book(20, "87" , "Besto Friendo");


        // Loop through menu until user decides to exit
        while(isRunning){
            displayHome();
            userChoice = input.nextLine();

        // Switch case based off user choice and display appropriate based off option
            switch(userChoice){
                // Display all checked in books and prompts user to check out a book or return to home
                case "1":
                    displayAvailable();
                    inMenu = true;
                    checkOutMenu();
                    userChoice = (input.nextLine()).toLowerCase();

                    // Loop through inner menu until user chooses the right option and returns to home menu when finished
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

                // Display all checked out books and prompt user to check in a book or return home
                case "2":
                    displayCheckedOut();
                    inMenu = true;
                    checkInMenu();
                    userChoice = input.nextLine().toLowerCase();

                    // Loop through inner menu until user chooses the right option and returns to home menu when finished
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

                // Exits the library home menu
                case "3":
                    isRunning = false;
                    break;

                // Case when user enters an invalid input
                default:
                    println("Please enter a valid option");
            }
        }
    }
    static void displayHome() {

        // Not so good-looking home menu print statement
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

        // Loops through array of book and checks if not null and checked in (not checked out) and outputs
        // title, id, isbn
        for (Book book : bookCollection){
            if(book != null && !book.getIsCheckedOut())
                System.out.printf("Book Title: %s, Book ID: %d, Book ISBN: %s\n", book.getTitle(), book.getID(), book.getISBN());
        }
    }
    static void checkOutMenu(){

        // Even worse-looking checkout display menu print statements
        println("""
                
                (c) Do you want to check out a book?
                (x)         Back to home""");
    }
    static void checkOutBook(){
        // Prompt user for the id of the book they want to check out and stores it
        println("Enter the ID of the book to check out");
        int bookID = input.nextInt();
        input.nextLine();
        boolean bookFound = false;

        // Loops through array of books to look for matching ID and make sure that book is already not checked out
        for (Book book : bookCollection){
            if (bookID == book.getID() && !book.getIsCheckedOut()){
                println("What is your name?");
                book.checkOut(input.nextLine());
                bookFound = true;
                break;
            }
        }
        // If book wasn't found / matched, let the user know and return back to home
        if (!bookFound){
            println("Book with that ID was not found");
        }
    }
    static void displayCheckedOut(){

        // Loops through array of book and checks if not null and checked out and output title, id, isbn
        for (Book book : bookCollection){
            if (book != null && book.getIsCheckedOut()){
                System.out.printf("Book Title: %s, Book ID: %d, Book ISBN: %s\n", book.getTitle(), book.getID(), book.getISBN());
            }
        }
    }
    static void checkInMenu(){

        // Even horrible-looking checkin display menu print statements
        println("""
                
                (c) Do you want to check in a book?
                (x)         Back to home""");
    }
    static void checkInBook(){

        // Prompt user for the id of the book they want to check in and store
        println("Enter the ID of the book to check out");
        int bookID = input.nextInt();
        input.nextLine();
        boolean bookFound = false;

        // Loops through array of books to look for matching ID and make sure that book is actually checked out
        for (Book book : bookCollection){
            if (bookID == book.getID() && book.getIsCheckedOut()){
                book.checkIn();
                bookFound = true;
                break;
            }
        }
        // If book wasn't found / matched, let the user know and return back to home
        if (!bookFound){
            println("Book with that ID was not found");
        }
    }
    // Shortcut println statement
    static void println(String message){System.out.println(message);}
}
