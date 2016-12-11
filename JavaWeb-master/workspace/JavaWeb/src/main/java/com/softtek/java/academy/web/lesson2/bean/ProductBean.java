/*
 * @(#) ProductBean.java - 05/08/2015 
 *
 * Copyright 2015 Softtek. All Rights Reserved.
 */
package com.softtek.java.academy.web.lesson2.bean;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.util.Date;

/**
 * Bean to generate Product details as XML.
 *
 * @author luisf.robles
 */
public class ProductBean {

	// ------------------
	// Static Properties
	// ------------------

	// -----------
	// Properties
	// -----------

	/**
	 * <code>productId</code>.
	 */
	private long productId;
	/**
	 * <code>productName</code>.
	 */
	private String productName;
	/**
	 * <code>stock</code>.
	 */
	private int stock;
	/**
	 * <code>price</code>.
	 */
	private double price;
	/**
	 * <code>expiration</code>.
	 */
	private Date expiration;
	
	// -------------
	// Constructors
	// -------------
	
	/**
	 * <code>Default Constructor</code>.
	 */
	public ProductBean() {		
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
	public ProductBean(long pProductId, String pProductName, int pStock,
			double pPrice, Date pExpiration) {
		super();
		productId = pProductId;
		productName = pProductName;
		stock = pStock;
		price = pPrice;
		expiration = pExpiration;
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
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		XMLEncoder xmlEncoder = new XMLEncoder(baos);
		xmlEncoder.writeObject(this);
		xmlEncoder.close();

		return baos.toString();
	}
	
	// --------------------
	// Setters and Getters
	// --------------------

	/**
	 * Gets value of <code>productId</code> property.
	 *
	 * @return The value of <code>productId</code>.
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * Sets the <code>pProductId</code> to the <code>productId</code> property.
	 *
	 * @param pProductId the new value for <code>productId</code>.
	 */
	public void setProductId(long pProductId) {
		productId = pProductId;
	}

	/**
	 * Gets value of <code>productName</code> property.
	 *
	 * @return The value of <code>productName</code>.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the <code>pProductName</code> to the <code>productName</code> property.
	 *
	 * @param pProductName the new value for <code>productName</code>.
	 */
	public void setProductName(String pProductName) {
		productName = pProductName;
	}

	/**
	 * Gets value of <code>stock</code> property.
	 *
	 * @return The value of <code>stock</code>.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Sets the <code>pStock</code> to the <code>stock</code> property.
	 *
	 * @param pStock the new value for <code>stock</code>.
	 */
	public void setStock(int pStock) {
		stock = pStock;
	}

	/**
	 * Gets value of <code>price</code> property.
	 *
	 * @return The value of <code>price</code>.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the <code>pPrice</code> to the <code>price</code> property.
	 *
	 * @param pPrice the new value for <code>price</code>.
	 */
	public void setPrice(double pPrice) {
		price = pPrice;
	}

	/**
	 * Gets value of <code>expiration</code> property.
	 *
	 * @return The value of <code>expiration</code>.
	 */
	public Date getExpiration() {
		return expiration;
	}

	/**
	 * Sets the <code>pExpiration</code> to the <code>expiration</code> property.
	 *
	 * @param pExpiration the new value for <code>expiration</code>.
	 */
	public void setExpiration(Date pExpiration) {
		expiration = pExpiration;
	}

}
