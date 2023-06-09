package org.mybatis.jpetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

public class CartItem implements Serializable {

	private static final long serialVersionUID = 6620528781626504362L;

	private Item item;
	private int quantity;
	private boolean inStock;
	private BigDecimal total;

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
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

	public void incrementQuantity() {
		quantity++;
		calculateTotal();
	}

	private void calculateTotal() {
		total = Optional.ofNullable(item).map(Item::getListPrice).map(v -> v.multiply(new BigDecimal(quantity)))
				.orElse(null);
	}

}
