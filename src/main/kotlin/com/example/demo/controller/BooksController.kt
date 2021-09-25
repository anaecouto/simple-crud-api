package com.example.demo.controller

import com.example.demo.model.Books
import com.example.demo.service.BooksService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("example")
class BooksController(private val booksService: BooksService) {

    @GetMapping
    fun list(): List<Books> {
        return booksService.list()
    }

    @PostMapping
    fun add(@RequestBody book: Books): Books {
        return booksService.add(book)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody book: Books): Books {
        return booksService.alter(id, book)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        return booksService.delete(id)
    }
}