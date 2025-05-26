package ru.test.model.classes;

import ru.test.model.enums.Category;

public class Book {
    private String title;
    private String author;
    private String description;
    private Category category;

    private int count;
    private int price;

    public Book (String title, String author, String description, Category category, int count, int price){
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.count = count;
        this.price = price;
    }

    public Book(){

    }


    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }
    public Category getCategory() {
        return category;
    }
    public int getCount() {
        return count;
    }
    public int getPrice() {
        return price;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
