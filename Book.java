package com.company;

public class Book {
    int id;
    String title;
    String author;
    String isbn;
    double price;
    String category;
    String description;

    public Book(){

    }

    public Book(int id, String title, String author, String isbn, double price, String category, String description){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void printAllData() {
    	System.out.printf("%5s | %55s | %15s|\n%s| %15s| %15s","id: "+this.id,this.title,"ISBN: "+this.isbn,"price: "+ this.price,this.category,this.description+"\n\n");
    }
    
    public void printShort() {
        //System.out.println("ID: "+ this.getId() +"\tTitle: "+ this.getTitle() +"\tAuthor: "+ this.getAuthor() +"\tISBN: "+ this.getIsbn());
    	System.out.printf("%5s | %55s | %15s","id: "+this.id,this.title,"ISBN: "+this.isbn+"\n\n");
    	
    	
    }
}
