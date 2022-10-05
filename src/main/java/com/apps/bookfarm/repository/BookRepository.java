package com.apps.bookfarm.repository;

import com.apps.bookfarm.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
}

