package com.example.booksrestapi.controller;

import com.example.booksrestapi.model.Book;
import com.example.booksrestapi.repository.BookRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    ResponseEntity<List<Book>> findAllBooks() {
        List<Book> response = bookRepository.findAll();
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    ResponseEntity<Book> findBookById(@PathVariable Long id) {
        Optional<Book> response = bookRepository.findById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byTitle")
    ResponseEntity<Book> findBookByTitle(@RequestParam String title) {
        Optional<Book> response = bookRepository.findByTitle(title);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
