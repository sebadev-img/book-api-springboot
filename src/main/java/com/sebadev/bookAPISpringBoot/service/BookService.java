package com.sebadev.bookAPISpringBoot.service;

import com.sebadev.bookAPISpringBoot.model.Book;
import com.sebadev.bookAPISpringBoot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    BookRepository repository;


    @Override
    public Book create(Book book) {
        return repository.save(book);
    }

    @Override
    public Collection<Book> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Boolean exists(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Book update(Book book) {
        if(repository.existsById(book.getId())){
            return repository.save(book);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
