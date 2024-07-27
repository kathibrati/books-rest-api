package com.example.booksrestapi.controller;

import com.example.booksrestapi.model.Book;
import com.example.booksrestapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        Book peppaPig = new Book(1L, "Peppa Grunz", "Miss Piggy", "1985");
        Book popelBert = new Book(2L, "Popel Bert", "Berti Fuchs", "1943");
        bookRepository.save(peppaPig);
        bookRepository.save(popelBert);
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
}