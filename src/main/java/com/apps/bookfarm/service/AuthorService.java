package com.apps.bookfarm.service;

import com.apps.bookfarm.model.Author;

public interface AuthorService {
    Iterable<Author> getAuthors();
    void addNewAuthor(Author author);
    void removeAuthor(Long id);
}
