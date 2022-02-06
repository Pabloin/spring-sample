package io.github.pabloin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.pabloin.model.Book;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Book", description = "the Book API")
@RequestMapping("/book")
public class BookController {

    private Map<Long, Book> book;

    public BookController() {
        this.book = new HashMap<>();
        this.book.put(1l, new Book(1l, "The Chasm"));
        this.book.put(2l, new Book(2l, "A Dying Fall"));
    }

    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<Void> deleteById(Long id) {
        if (!exists(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        book.remove(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}", produces = { "application/json" })
	public ResponseEntity<Book> getById(Long id) {
        if (!exists(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        return ResponseEntity.ok(book.get(id));
    }

    @GetMapping(value = "", produces = { "application/json" })
    public ResponseEntity<List<Book>> getAll() {
        List<Book> m = book.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        return ResponseEntity.ok(m);
    }

	@PutMapping(value = "", produces = { "application/json" })
    public ResponseEntity<Void> add(Book Book) {
        if (exists(Book.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Already exists");
        }
        if (Book.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data");
        }
        book.put(Book.getId(), Book);
        return ResponseEntity.ok().build();
    }

    private boolean exists(Long id) {
        return book.containsKey(id);
    }
}
