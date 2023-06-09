package org.mybatis.jpetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;


/**
 * The Class LineItem.
 *
 * @author Eduardo Macarron
 */
public class LineItem implements Serializable {

	private static final long serialVersionUID = 6804536240033522156L;

	private int orderId;
	private int lineNumber;
	private int quantity;
	private String itemId;
	private BigDecimal unitPrice;
	private Item item;
	private BigDecimal total;

	public LineItem() {
	}

	/**
	 * Instantiates a new line item.
	 *
	 * @param lineNumber the line number
	 * @param cartItem   the cart item
	 */
	public LineItem(int lineNumber, CartItem cartItem) {
		this.lineNumber = lineNumber;
		this.quantity = cartItem.getQuantity();
		this.itemId = cartItem.getItem().getItemId();
		this.unitPrice = cartItem.getItem().getListPrice();
		this.item = cartItem.getItem();
		calculateTotal();
	}
	
//   BUILD PATTERN DESING 
	public LineItem lineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
		return this;	
	}
	
	public LineItem quantity(CartItem cartItem) {
		this.quantity = cartItem.getQuantity();
		return this;
	}
	
	public LineItem itemId(CartItem cartItem) {
		this.itemId = cartItem.getItem().getItemId();
		return this;
	}
	
	public LineItem unitPrice(CartItem cartItem) {
		this.unitPrice = cartItem.getItem().getListPrice();
		return this;
	}
	
	public LineItem item(CartItem cartItem) {
		this.item = cartItem.getItem();
		return this;
	}
//   BUILD PATTERN DESING 
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitprice) {
		this.unitPrice = unitprice;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
		calculateTotal();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		calculateTotal();
	}

	private void calculateTotal() {
		total = Optional.ofNullable(item).map(Item::getListPrice).map(v -> v.multiply(new BigDecimal(quantity)))
				.orElse(null);
	}

}
