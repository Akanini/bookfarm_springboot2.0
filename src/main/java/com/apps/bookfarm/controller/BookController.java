package com.apps.bookfarm.controller;

import com.apps.bookfarm.model.Author;
import com.apps.bookfarm.model.Book;
import com.apps.bookfarm.repository.BookRepository;
import com.apps.bookfarm.service.BookService;
import com.apps.bookfarm.serviceimpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BookController {
    private final BookRepository bookRepository ;
    private final BookServiceImpl bookService;

    @Autowired
    public BookController(BookRepository bookRepository, BookServiceImpl bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }
    @GetMapping("/books")
     Iterable<Book> allBook (){
        return bookService.getBooks();
    }


    @GetMapping("/books/{author}")
        Book oneBook (@PathVariable String title){ return bookService.findByTitle(title).orElseThrow(()-> new BookNotFoundException(title));}

    @PostMapping("/books")
        public void addNewBook(@RequestBody Book newBook) { bookService.addNewBook(newBook); }

    @DeleteMapping("/books/{isbn}")
    void deleteAuthor(@PathVariable int isbn) {bookRepository.deleteByIsbn(isbn);
    }


    @GetMapping("/books}")
    List<Books> book (@PathVariable Long id){
        return bookService.findByBookid(id);
    }


    @PutMapping("books/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable  Long bookId){
        return BookRepository.findBybookId(id).map(book -> {
            book.setBookAuthor(newBook.getAuthorName());
            book.setIsbn(newBook.getIsbn());
            return bookService.save(newBook);
        }).orElseGet(()->{newBook.setBookId(id);
            return bookService.save(newAuthor);
        });
    }
}
