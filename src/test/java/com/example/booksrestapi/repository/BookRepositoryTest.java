package com.example.booksrestapi.repository;

import com.example.booksrestapi.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        Book grimmsTales = new Book(1L, "Gebrüder Grummel", "Brudersons", "1990");
        bookRepository.save(grimmsTales);
        Book reifenVerloren = new Book(2L, "Lost Wheel", "Wolfgang Aufpasser", "2003");
        bookRepository.save(reifenVerloren);
    }

    @Test
    void findAllBooks() {
        assertThat(bookRepository.count()).isGreaterThan(0);
    }
    @Test
    void findByTitle() {
        Book result = bookRepository.findByTitle("Lost Wheel").orElseThrow();

        assertThat(result.getTitle()).isEqualTo("Lost Wheel");
        assertThat(result.getId()).isEqualTo(2L);
    }

    @Test
    void findByYear() {
        Optional<Book> result = bookRepository.findByYear("1990");

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getYear()).isEqualTo("1990");

    }

}