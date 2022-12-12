package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BookDto;
import com.example.demo.exceptions.BookException;
import com.example.demo.model.BookModel;
import com.example.demo.repository.IBookRepo;

@Service
public class BookService implements IBookService {

	@Autowired
	IBookRepo bookRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public BookDto addBook(BookDto bookDto) {
		BookModel book = modelMapper.map(bookDto, BookModel.class);
		bookRepo.save(book);
		return bookDto;
	}

	@Override
	public List<BookDto> getAllBook() {
		return bookRepo.findAll().stream().map(book -> modelMapper.map(book, BookDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public BookDto findById(Long bookId) {
		Optional<BookModel> book = bookRepo.findById(bookId);
		if (book.isEmpty()) {
			throw new BookException(" Book Id does not exist");
		}
		BookDto bookDto = modelMapper.map(book.get(), BookDto.class);
		return bookDto;
	}

	@Override
	public void deleteById(Long bookId) {
		if (bookRepo.findById(bookId).isPresent()) {
			bookRepo.deleteById(bookId);
		} else {
			throw new BookException("Book is not deleted");
		}
	}

	@Override
	public BookDto findByBookName(String bookName) {
		Optional<BookModel> findByName = bookRepo.findByBookName(bookName);
		if (findByName.isEmpty()) {
			throw new BookException("Book is not found");
		}
		BookDto bookDto = modelMapper.map(findByName.get(), BookDto.class);
		return bookDto;

	}

	@Override
	public BookDto updateData(Long bookId, BookDto bookDto) {
		BookModel editBook = bookRepo.findById(bookId).orElse(null);
		if (editBook != null) {
			BookModel book = modelMapper.map(bookDto, BookModel.class);
			book.setBookId(bookId);
			bookRepo.save(book);
			return bookDto;

		} else {
			throw new BookException("Id:" + bookId + " is not present");
		}
	}

}
