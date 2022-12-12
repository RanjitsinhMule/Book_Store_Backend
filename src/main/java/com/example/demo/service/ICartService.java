package com.example.demo.service;

import java.util.List;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.CartDto;

public interface ICartService {

	ResponseEntity addBook(CartDto cartDto);

	List<CartDto> findAll();

	CartDto findById(Long id);

	void deleteById(Long id);

	CartDto updateCartData(Long id, CartDto cartDto);

}
