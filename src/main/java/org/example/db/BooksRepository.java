package org.example.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BooksRepository {
    private Connection connection = null;

    public BooksRepository() {
        connection = DbConnector.getInstance().getConnection();
    }

    public void addNewBook(Book book) throws Exception {
        Statement statement = connection.createStatement();

        String insertQuery = String.format("INSERT INTO books (name, created_year, author_id) VALUES ('%s',%d, %d);", book.getName(), book.getCreatedYear(), book.getAuthorId());

        statement.executeUpdate(insertQuery);

        statement.close();
    }

    public ArrayList<Book> getAllBooksByAuthorId(int findAuthorId) {
        ArrayList<Book> books = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String selectQuery = String.format("SELECT * FROM books WHERE author_id = %d ORDER BY id ASC", findAuthorId);

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int createdYear = resultSet.getInt("created_year");
                int authorId = resultSet.getInt("author_id");

                books.add(new Book(id, name, createdYear, authorId));
            }

            resultSet.close();

            statement.close();
        } catch (Exception e) {
            System.out.println("Ошибка запроса к базе данных");
        }

        return books;
    }
}
