package com.softtek.academy.jstl.service;

import java.util.List;

import com.softtek.academy.jstl.domain.model.Cart;
import com.softtek.academy.jstl.repository.CartRepository;

public class CartService {
	
	private CartRepository cartRepository = new CartRepository();
	

	public List<Cart> list() {
		List<Cart> carts = cartRepository.list();
		
		return carts;
	}
	
	public Cart findOne(final Long cartId) {
		return cartRepository.findOne(cartId);
	}
	
	public Boolean update(final Cart cart) {
		if (this.isValidCart(cart)) {
			/*
			 * cartRepository.update(cart);
			 */
			return true;
		}
		
		return false;
	}
	
	private Boolean isValidCart(final Cart cart) {
		
		if (cart.getLinesAmount() == null) {
			return false;
		}
		
		if (cart.getShippingAmount() == null) {
			return false;
		}
		
		if (cart.getShipTo() == null || cart.getShipTo().getId().equals(0L)) {
			return false;
		}
		
		if (cart.getStatus() == null || cart.getStatus().getId().equals(0L)) {
			return false;
		}
		
		return true;
	}
	
}