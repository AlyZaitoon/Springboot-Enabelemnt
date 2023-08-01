package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookRepository;
import com.example.demo.entities.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	public List<Book> listAll(){
		return bookRepository.findAll();
	}
}
