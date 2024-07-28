package com.example.booksrestapi.repository;

import com.example.booksrestapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String queryTitle);

    Optional<Book> findByYear(String year);

    List<Book> findAllByTitle(String title);
}
