package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.BookDto;

public interface IBookService {

	BookDto addBook(BookDto bookDto);

	List<BookDto> getAllBook();

	BookDto findById(Long bookId);

	void deleteById(Long bookId);

	BookDto findByBookName(String bookName);

	BookDto updateData(Long bookId, BookDto bookDto);


}
