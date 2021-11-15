package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {
    private List <BookDto> books = new ArrayList<>();

    //http://localhost:8080/book POST
    @PostMapping("book")
    public String addBook(@RequestBody BookDto book) {
        books.add(book);
        return "Raamat on andmebaasi lisatud";
    }


    //http://localhost:8080/book (GET)
    @GetMapping("book")
    public List<BookDto> getAllBooks() {

        return books;
    }

    //http://localhost:8080/book/1 (GET)
    @GetMapping("book/{id}")
    public BookDto getBook(@PathVariable("id") int id) {

        return books.get(id);

    }

    //http://localhost:8080/book/1 DELETE
    @DeleteMapping("book/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        books.remove(id);

        return "Kustutatud";

    }

    //http://localhost:8080/book/1   PUT
    @PutMapping("book/{id}")
    public void updateBook(@PathVariable("id") int id,
                             @RequestBody BookDto newBook ) {
        books.set(id, newBook);
    }

}
