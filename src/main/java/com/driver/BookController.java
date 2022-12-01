package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController
{
    @Autowired
    BookService bookService;



    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book)
    {
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookByid(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.ACCEPTED);
    }


    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> findAllBooks()
    {
        return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam("author") String author)
    {
        return new ResponseEntity<>(bookService.findBooksByAuthor(author), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> findBooksByGenre(@RequestParam("genre") String genre)
    {
        return new ResponseEntity<>(bookService.findBooksByAuthor(genre), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") int id)
    {
        bookService.deleteBookById(id);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBooks()
    {
        bookService.deleteAllBooks();
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

}
