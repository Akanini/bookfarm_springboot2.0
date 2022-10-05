package com.apps.bookfarm.service;

import com.apps.bookfarm.model.Author;

public interface BookService {

    public static void getAllBook() {

    }
    public Iterable<BookId> getbookId();
    public void addNewbook(Author author);
    public void removeIsbn(int isbn);
}