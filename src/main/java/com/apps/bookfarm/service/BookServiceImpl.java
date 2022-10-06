package com.apps.bookfarm.service;

import com.apps.bookfarm.model.Author;

public interface BookServiceImpl implements BookService {
    @Override
    Iterable<Book> getBooks() {
        return null;
    }

    @Override
    void addNewbook(Author author) {

    }

    @Override
    void removeIsbn(int isbn) {

    }
}
