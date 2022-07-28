package com.sebadev.bookAPISpringBoot.controller;

import com.sebadev.bookAPISpringBoot.model.Book;
import com.sebadev.bookAPISpringBoot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private final BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list = (List<Book>) service.list();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Optional<Book> optional = service.get(id);
        if(optional.isPresent()){
            Book book = optional.get();
            return ResponseEntity.ok().body(book);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        if(book.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        Book newBook = service.create(book);
        return ResponseEntity.ok().body(newBook); //Añadir validaciones
    }
    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        if(book.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Book updatedBook = service.update(book);
        return ResponseEntity.ok().body(updatedBook); //añadir validaciones
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        if(service.exists(id)){
            service.delete(id);
            return ResponseEntity.ok().body("book deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
