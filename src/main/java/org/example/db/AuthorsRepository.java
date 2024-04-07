package org.example.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AuthorsRepository {
    private Connection connection = null;

    public AuthorsRepository() {
        connection = DbConnector.getInstance().getConnection();
    }

    public void addNewAuthor(Author author) throws Exception {
        Statement statement = connection.createStatement();

        String insertQuery = String.format("INSERT INTO authors (name, country) VALUES ('%s','%s');", author.getName(), author.getCountry());

        statement.executeUpdate(insertQuery);

        statement.close();
    }

    public ArrayList<Author> getAllAuthors() {
        ArrayList<Author> authors = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String selectQuery = String.format("SELECT * FROM authors ORDER BY id ASC");

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");

                authors.add(new Author(id, name, country));
            }

            resultSet.close();

            statement.close();
        } catch (Exception e) {
            System.out.println("Ошибка запроса к базе данных");
        }

        return authors;
    }
}
