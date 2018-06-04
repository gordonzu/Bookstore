package com.gordonzu.itest;

import static org.junit.Assert.*;

import com.gordonzu.dao.BookDAO;
import com.gordonzu.dao.IBookDAO;
import com.gordonzu.model.Book;
import org.junit.Test;

import java.util.List;

public class BookstoreIT
{
    private static IBookDAO bookDao = new BookDAO();

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void daoObjectShouldNotBeNull() {
        assertNotNull(bookDao);
    }

    @Test
    public void getAllBooks() {
        List<Book> books = bookDao.findAllBooks();
        assertEquals(12, books.size());
    }

    @Test
    public void getByKeyword() {
        List<Book> books = bookDao.searchBooksByKeyword("Groovy");
        assertEquals(2, books.size());

        List<Book> authors = bookDao.searchBooksByKeyword("Josh");
        assertEquals(2, authors.size());

        List<Book> books2 = bookDao.searchBooksByKeyword("Recipes");
        assertEquals(3, books2.size());

    }
}

