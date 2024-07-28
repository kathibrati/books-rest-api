package com.example.booksrestapi.service;

import com.example.booksrestapi.model.Book;
import com.example.booksrestapi.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {
    @Autowired
    BookService bookService;

    @MockBean
    BookRepository bookRepository;

    @Test
    void testFindBooks() {
        when(bookRepository.findAll()).thenReturn(List.of(
                Book.builder()
                        .title("Harry Potter")
                        .author("JK Rowling")
                        .year("2000")
                        .build(),
                Book.builder()
                        .title("Meister Proper")
                        .author("JK Cleaning")
                        .year("1995")
                        .build(),
                Book.builder()
                        .title("Merlin")
                        .author("Arthur King")
                        .year("1990")
                        .build()
        ));

        assertThat(bookService.findBooks("Harry Potter")).hasSize(1);

    }
}