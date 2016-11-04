/*
 * @(#) ProductBean.java - 06/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */
package com.softtek.java.academy.web.lesson3.bean;

import java.util.Date;

import org.json.JSONObject;

import com.softtek.java.academy.web.lesson2.bean.ProductBean;

/**
 * SubClass of <code>ProductBean</code> to serialize its instance to JSON format.
 *
 * @author luisf.robles
 */
public class ProductJSONBean extends ProductBean {
	// -------------
	// Constructors
	// -------------

	/**
	 * <code>Default Constructor</code>.
	 */
	public ProductJSONBean() {		
	}
	
	/**
	 * <code>Initialization Constructor</code>.
	 *
	 * @param pProductId	Product ID
	 * @param pProductName	Product Name
	 * @param pStock		Product Stock
	 * @param pPrice		Product Price
	 * @param pExpiration	Product Expiration
	 */
	public ProductJSONBean(long pProductId, String pProductName, int pStock,
			double pPrice, Date pExpiration) {
		super(pProductId, pProductName, pStock, pPrice, pExpiration);
	}
	
	// ----------------
	// Functionalities
	// ----------------

	/* (non-Javadoc)
	 * 
	 * Serializing a JavaBean to an XML String.
	 */
	/** {@inheritDoc} */
	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		JSONObject attJson = new JSONObject();
		attJson.put("productId",this.getProductId());
		attJson.put("productName", this.getProductName());
		attJson.put("stock", this.getStock());
		attJson.put("price", this.getPrice());
		attJson.put("expiration", this.getExpiration());
		json.put("productBean",attJson);

		return json.toString();
	}
}
