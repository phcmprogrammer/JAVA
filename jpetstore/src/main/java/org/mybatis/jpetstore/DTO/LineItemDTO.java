package org.mybatis.jpetstore.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;


/**
 * The Class LineItem.
 *
 * @author Eduardo Macarron
 */
public class LineItemDTO implements Serializable {

	private static final long serialVersionUID = 6804536240033522156L;

	private int orderId;
	private int lineNumber;
	private int quantity;
	private String itemId;
	private BigDecimal unitPrice;
	private ItemDTO item;
	private BigDecimal total;

	public LineItemDTO() {
	}

	/**
	 * Instantiates a new line item.
	 *
	 * @param lineNumber the line number
	 * @param cartItem   the cart item
	 */
	public LineItemDTO(int lineNumber, CartItemDTO cartItem) {
		this.lineNumber = lineNumber;
		this.quantity = cartItem.getQuantity();
		this.itemId = cartItem.getItem().getItemId();
		this.unitPrice = cartItem.getItem().getListPrice();
		this.item = cartItem.getItem();
		calculateTotal();
	}
	
//   BUILD PATTERN DESING 
	public LineItemDTO lineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
		return this;	
	}
	
	public LineItemDTO quantity(CartItemDTO cartItem) {
		this.quantity = cartItem.getQuantity();
		return this;
	}
	
	public LineItemDTO itemId(CartItemDTO cartItem) {
		this.itemId = cartItem.getItem().getItemId();
		return this;
	}
	
	public LineItemDTO unitPrice(CartItemDTO cartItem) {
		this.unitPrice = cartItem.getItem().getListPrice();
		return this;
	}
	
	public LineItemDTO item(CartItemDTO cartItem) {
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

	public ItemDTO getItem() {
		return item;
	}

	public void setItem(ItemDTO item) {
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
		total = Optional.ofNullable(item).map(ItemDTO::getListPrice).map(v -> v.multiply(new BigDecimal(quantity)))
				.orElse(null);
	}

}
