package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.BookDto;
import com.example.demo.service.IBookService;

@RestController
@RequestMapping("/Book")
@CrossOrigin("http://localhost:3000")
public class BookController {

	@Autowired
	IBookService bookService;

	@PostMapping("/add")
	public ResponseEntity addBook(@RequestBody BookDto bookDto) {
		BookDto book = bookService.addBook(bookDto);
		return new ResponseEntity(book, "Book added Succesfully");
	}

	@GetMapping("/findAll")
	public List<BookDto> getAllDetails() {
		return this.bookService.getAllBook();
	}

	@GetMapping("/get/{bookId}")
	public ResponseEntity findById(@PathVariable Long bookId) {
		BookDto book = bookService.findById(bookId);
		return new ResponseEntity(book, "Book is found successfully");
	}

	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity deleteById(@PathVariable Long bookId) {
		bookService.deleteById(bookId);
		return new ResponseEntity(bookService, "Book is deleted succesfully");
	}

	@GetMapping("/getByBookName/{bookName}")
	public ResponseEntity getByBookName(@PathVariable String bookName) {
		BookDto book = bookService.findByBookName(bookName);
		return new ResponseEntity(book, "Book is found successfully");
	}

	@PutMapping("/update")
	public ResponseEntity editData(@RequestParam Long bookId, @RequestBody BookDto bookDto) {
		BookDto book = bookService.updateData(bookId, bookDto);
		return new ResponseEntity(book, "Data is updated successfully");
	}
}
