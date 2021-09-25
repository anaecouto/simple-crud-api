package com.example.demo.repository

import com.example.demo.model.Books
import org.springframework.data.repository.CrudRepository

interface BooksRepository : CrudRepository<Books, Long>