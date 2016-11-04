/*
 * @(#) ProductDAO.java - 06/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */
package com.softtek.java.academy.web.lesson3.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import com.softtek.java.academy.web.lesson2.bean.ProductBean;

/**
 * Dummy DAO to handle operations over Products.
 *
 * @author luisf.robles
 */
public class ProductDAO {
	// ------------------
	// Static Properties
	// ------------------

	// -----------
	// Properties
	// -----------

	private List<ProductBean> prodList;
	
	// -------------
	// Constructors
	// -------------

	/**
	 * <code>Default Constructor</code>.
	 */
	public ProductDAO() {
		this.populateProductList();
	}

	// ----------------
	// Functionalities
	// ----------------

	/**
	 * Get Product List.
	 *
	 * @return List of Products
	 */
	@SuppressWarnings("unchecked")
	public List<ProductBean> getProductList() {
		ArrayList<ProductBean> list  = (ArrayList<ProductBean>) this.prodList; 
		ArrayList<ProductBean> clone = null;
		
		clone = (ArrayList<ProductBean>) list.clone();
		
		return clone;
	}
	
	/**
	 * Populate a dummy Product List.
	 */
	private void populateProductList() {
		Date exp = new GregorianCalendar(2016, Calendar.AUGUST, 01).getTime();
		Random random = new Random();
		this.prodList = new ArrayList<ProductBean>();
		ProductBean bean = null;
		
		for(int i=0; i<15; i++) {
			bean = new ProductBean();
			bean.setProductId(random.nextInt(50));
			bean.setProductName("Product_"+i);
			bean.setPrice(random.nextDouble());
			bean.setExpiration(exp);
			bean.setStock(random.nextInt(1000));
			
			this.prodList.add(bean);
		}
	}
	
	// --------------------
	// Setters and Getters
	// --------------------
}
