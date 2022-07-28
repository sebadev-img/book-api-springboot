package com.sebadev.bookAPISpringBoot.service;

import com.sebadev.bookAPISpringBoot.model.Book;

import java.util.Collection;
import java.util.Optional;

public interface IBookService {
    Book create(Book book);
    Collection<Book> list();
    Optional<Book> get(Long id);
    Boolean exists(Long id);
    Book update(Book book);
    Boolean delete(Long id);
}
