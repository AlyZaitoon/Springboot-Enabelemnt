package com.example.demo.services;



import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.demo.entities.Book;


@SpringBootTest
class BookServiceTest {




	    @Autowired
	    private BookService bookService;

	    @Test
	    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
	        List<Book> books = bookService.listAll();

	        Assert.assertEquals(books.size(), 3);
	    }
	}


