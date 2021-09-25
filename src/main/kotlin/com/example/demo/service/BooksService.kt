package com.example.demo.service

import com.example.demo.model.Books
import com.example.demo.repository.BooksRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class BooksService {

    @Autowired
    lateinit var booksRepository: BooksRepository

    @GetMapping
    fun list(): List<Books> {
        return booksRepository.findAll().toList()
    }

    @PostMapping
    fun add(@RequestBody book: Books): Books {
        return booksRepository.save(book)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody book: Books): Books {
        if (booksRepository.existsById(id)) {
//            val safeBook = Books(id, book.name, book.number)
            val safeBook = book.copy(id)
            return booksRepository.save(safeBook)
        }
        return Books()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id)
        }
    }
}