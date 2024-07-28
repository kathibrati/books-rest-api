package com.example.booksrestapi.controller;

import com.example.booksrestapi.model.Book;
import com.example.booksrestapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        List<Book> books = List.of(Book.builder()
                        .title("Peppa Grunz")
                        .author("Miss Piggy")
                        .year("1985")
                        .build(),
                Book.builder()
                        .title("Popel Bert")
                        .author("Berti Fuchs")
                        .year("1973")
                        .build());
        bookRepository.saveAll(books);
    }

    @Test
    void findAllBooks() throws Exception {

        mockMvc.perform(get("/api/books")).andExpect(status().isOk());

    }

    @Test
    void findBookById() throws Exception {
        mockMvc.perform(get("/api/books/2")).andExpect(status().isOk());
        mockMvc.perform(get("/api/books/99")).andExpect(status().isNotFound());

    }

    @Test
    void findBookByTitle() throws Exception {
        mockMvc.perform(get("/api/books/byTitle?title=Peppa Grunz")).andExpect(status().isOk());
        mockMvc.perform(get("/api/books/byTitle?title=Lost")).andExpect(status().isNotFound());
    }
}