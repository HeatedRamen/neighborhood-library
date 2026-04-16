package com.pluralsight;

public class Book {
    // Variables in the book class
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructure function assuming that a book starts off as not checked out
    Book(){
        this.id = 0;
        this.isbn = "";
        this.title = "";
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters and Setters for the variables
    public int getID(){return this.id;}
    public void setID(int id){ this.id = id;}

    public String getISBN(){return this.isbn;}
    public void setISBN(String isbn){this.isbn = isbn;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public boolean getIsCheckedOut(){return this.isCheckedOut;}
    public void setIsCheckedOut(boolean isCheckedOut){this.isCheckedOut = isCheckedOut;}

    public String getCheckedOutTo(){return this.checkedOutTo;}
    public void setCheckedOutTo(String checkedOutTo){this.checkedOutTo = checkedOutTo;}

    public void checkOut(String name){
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }
    public void checkIn(){
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }
}
