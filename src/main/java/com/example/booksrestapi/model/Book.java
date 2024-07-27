package com.example.booksrestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book {

    @Id
    private Long id;

    private String title;

    private String author;

    @Column(name = "\"year\"")
    private String year;

}
