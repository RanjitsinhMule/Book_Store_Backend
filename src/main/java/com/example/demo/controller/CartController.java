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
import com.example.demo.DTO.CartDto;
import com.example.demo.service.ICartService;


@RestController
@RequestMapping("/Cart")
@CrossOrigin("http://localhost:3000")
public class CartController {

	@Autowired
	ICartService cartService;

	@PostMapping("/add")
	public ResponseEntity addBook(@RequestBody CartDto cartDto) {
		ResponseEntity add = cartService.addBook(cartDto);
		return new ResponseEntity(add, "Cart details added succesfully");
	}

	@GetMapping("/getAll")
	public ResponseEntity findAll() {
		List<CartDto> cartList = cartService.findAll();
		return new ResponseEntity(cartList, "All cart list");
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity findById(@PathVariable Long Id) {
		CartDto cart = cartService.findById(Id);
		return new ResponseEntity(cart, "All details cart list using Id");
	}

	@DeleteMapping("/delete/{ID}")
	public ResponseEntity deleteById(@PathVariable Long Id) {
		cartService.deleteById(Id);
		return new ResponseEntity(cartService, "Cart data is deleted succesfully");
	}

	@PutMapping("/update")
	public ResponseEntity editData(@RequestParam Long Id, @RequestBody CartDto cartDto) {
		CartDto cart = cartService.updateCartData(Id, cartDto);
		return new ResponseEntity(cart, "Data is updated successfully");
	}
}
