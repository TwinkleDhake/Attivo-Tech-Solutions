/* Q2. Create a class called Book with the following private fields:
title (String)
author (String)
ISBN (String)
Provide only getter methods to make the class read-only. 
Demonstrate how the fields can be accessed in the main method but not modified. */
class Book {
    private final String title;
    private final String author;
    private final String ISBN;
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getISBN() {
        return ISBN;
    }
}
public class EncapsulationBook {
    public static void main(String[] args) {
        Book book = new Book("The O P Tandon", "Lucent", "9780061122415");
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
    }
}