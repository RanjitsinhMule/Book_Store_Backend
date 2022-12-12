package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ResponseEntity;
import com.example.demo.model.CartModel;

@Repository
public interface ICartRepo extends JpaRepository<CartModel, Long> {

	void save(ResponseEntity cartDetails);

}
