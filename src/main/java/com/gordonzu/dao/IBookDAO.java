package com.gordonzu.dao;

import com.gordonzu.model.Book;
import com.gordonzu.model.Category;

import java.util.List;

public interface IBookDAO {

    List<Book> findAllBooks();

    List<Book> searchBooksByKeyword(String keyword);

    /*List<Category> findAllCategories();

    void insert(Book book);

    void update(Book book);

    void delete(Long bookId);
*/
}
