package org.example.db;

public class Book {
    private int id;
    private String name;
    private int createdYear;
    private int authorId;

    public Book(int id, String name, int createdYear, int authorId) {
        this.id = id;
        this.name = name;
        this.createdYear = createdYear;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCreatedYear() {
        return createdYear;
    }

    public int getAuthorId() {
        return authorId;
    }
}
