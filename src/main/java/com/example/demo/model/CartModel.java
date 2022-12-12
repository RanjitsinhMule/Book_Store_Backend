package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CartModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cartId", nullable = false)
	Long cartId;

	@OneToOne
	@JoinColumn(name = "userId")
	UserModel user;

	@ManyToOne
	@JoinColumn(name = "bookId")
	BookModel book;

	int quantity;

	public CartModel(UserModel user, BookModel book, int quantity) {
		this.user = user;
		this.book = book;
		this.quantity = quantity;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public BookModel getBook() {
		return book;
	}

	public void setBook(BookModel book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
