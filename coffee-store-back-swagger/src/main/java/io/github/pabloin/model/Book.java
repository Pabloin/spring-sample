package io.github.pabloin.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book {

    private Long id;
    private String text;
    private String autor;

    public Book() {
        this((long) 9, "PAblo" );
    }

    
    public Book(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAutor() {
        return text;
    }

    @JsonIgnore
    public boolean isBlank() {
        return text == null || text.isBlank();
    }
}
