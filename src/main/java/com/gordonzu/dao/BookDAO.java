package com.gordonzu.dao;

import com.gordonzu.model.Author;
import com.gordonzu.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"deprecation", "CatchMayIgnoreException"})
public class BookDAO implements IBookDAO{

    static {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException ex) {

        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookstore", "postgres", "Xxxc0nfig");
    }

    private void closeConnection(Connection connection) {
        if (connection == null)
            return;
        try {
            connection.close();
        }
        catch (SQLException ex) {
        }
    }

    public List<Book> findAllBooks() {
        List<Book> result = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();

        String sql = "select * from BOOK inner join AUTHOR on BOOK.ID = AUTHOR.BOOK_ID";
        Connection conn = null;

        try {
            conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("ID"));
                book.setBookTitle(resultSet.getString("BOOK_TITLE"));
                book.setCategoryId(resultSet.getLong("CATEGORY_ID"));
                author.setBookId(resultSet.getLong("BOOK_ID"));
                author.setFirstName(resultSet.getString("FIRST_NAME"));
                author.setLastName(resultSet.getString("LAST_NAME"));
                authorList.add(author);
                book.setAuthors(authorList);
                book.setPublisherName(resultSet.getString("PUBLISHER"));
                result.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return result;
    }

    public List<Book> searchBooksByKeyword(String keyword) {
        List<Book> result = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();

        String sql = "select * from BOOK inner join AUTHOR on BOOK.ID = AUTHOR.BOOK_ID"
                + " where BOOK_TITLE like '%"
                + keyword.trim()
                + "%'"
                + " or FIRST_NAME like '%"
                + keyword.trim()
                + "%'"
                + " or LAST_NAME like '%" + keyword.trim() + "%'";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("ID"));
                book.setBookTitle(resultSet.getString("BOOK_TITLE"));
                book.setPublisherName(resultSet.getString("PUBLISHER"));
                author.setFirstName(resultSet.getString("FIRST_NAME"));
                author.setLastName(resultSet.getString("LAST_NAME"));
                author.setBookId(resultSet.getLong("BOOK_ID"));
                authorList.add(author);
                book.setAuthors(authorList);
                result.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

}
