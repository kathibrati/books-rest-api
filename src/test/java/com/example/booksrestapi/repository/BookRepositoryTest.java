package com.example.booksrestapi.repository;

import com.example.booksrestapi.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        List<Book> books = List.of(Book.builder()
                        .title("Gebrüder Grummel")
                        .author("Brudersons")
                        .year("1990")
                        .build(),
                Book.builder()
                        .title("Lost Wheel")
                        .author("Wolfgang Aufpasser")
                        .year("2003")
                        .build(),
                Book.builder()
                        .title("Lost Wheel")
                        .author("Tyra Gone")
                        .year("2001")
                        .build()
        );
        bookRepository.saveAll(books);
    }

    @Test
    void findAllBooks() {
        assertThat(bookRepository.count()).isGreaterThan(0);
    }


    @Test
    void findByYear() {
        Optional<Book> result = bookRepository.findByYear("1990");

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getYear()).isEqualTo("1990");

    }

    @Test
    void findAllByTitle() {
        List<Book> bookListWheels = bookRepository.findAllByTitle("Lost Wheel");
        List<Book> bookList = bookRepository.findAllByTitle("Lost");

        assertThat(bookListWheels).hasSize(2);
        assertThat(bookList.size()).isEqualTo(0);
    }

}