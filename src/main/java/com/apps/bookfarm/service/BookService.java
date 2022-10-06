package com.apps.bookfarm.service;

import com.apps.bookfarm.model.Author;

public interface BookService {

    static void getAllBook() {

    }
    Iterable<BookId> getbookId();
    void addNewbook(Author author);
    void removeIsbn(int isbn);
}