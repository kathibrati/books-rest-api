package com.example.booksrestapi.controller;

import com.example.booksrestapi.model.Book;
import com.example.booksrestapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    ResponseEntity<List<Book>> findAllBooks(@RequestParam(name = "title", required = false) String title) {
        List<Book> response = bookService.findBooks(title);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<Book> findBookById(@PathVariable Long id) {
        Optional<Book> response = bookService.findBookById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
