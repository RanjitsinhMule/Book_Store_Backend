package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.BookDto;
import com.example.demo.model.BookModel;

@Repository
@EnableJpaRepositories
public interface IBookRepo extends JpaRepository<BookModel, Long> {
	

	Optional<BookModel> findByBookName(String bookName);

	BookDto save(BookDto book);

}
