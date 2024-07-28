package com.example.booksrestapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    @Column(name = "\"year\"")
    private String year;

}
