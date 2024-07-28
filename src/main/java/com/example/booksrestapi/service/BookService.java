package com.example.booksrestapi.service;

import com.example.booksrestapi.model.Book;
import com.example.booksrestapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findBooks(String title) {

        return bookRepository
                .findAll()
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .toList();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }
}
