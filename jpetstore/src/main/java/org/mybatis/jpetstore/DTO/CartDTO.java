package org.mybatis.jpetstore.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CartDTO implements Serializable {

	private static final long serialVersionUID = 8329559983943337176L;

	private final Map<String, CartItemDTO> itemMap = Collections.synchronizedMap(new HashMap<>());
	private final List<CartItemDTO> itemList = new ArrayList<>();

	public Iterator<CartItemDTO> getCartItems() {
		return itemList.iterator();
	}

	public List<CartItemDTO> getCartItemList() {
		return itemList;
	}

	public int getNumberOfItems() {
		return itemList.size();
	}

	public Iterator<CartItemDTO> getAllCartItems() {
		return itemList.iterator();
	}

	public boolean containsItemId(String itemId) {
		return itemMap.containsKey(itemId);
	}

	/**
	 * Adds the item.
	 *
	 * @param item      the item
	 * @param isInStock the is in stock
	 */
	public void addItem(ItemDTO item, boolean isInStock) {
		CartItemDTO cartItem = itemMap.get(item.getItemId());
		if (cartItem == null) {
			cartItem = new CartItemDTO();
			cartItem.setItem(item);
			cartItem.setQuantity(0);
			cartItem.setInStock(isInStock);
			itemMap.put(item.getItemId(), cartItem);
			itemList.add(cartItem);
		}
		cartItem.incrementQuantity();
	}

	/**
	 * Removes the item by id.
	 *
	 * @param itemId the item id
	 *
	 * @return the item
	 */
	public ItemDTO removeItemById(String itemId) {
		CartItemDTO cartItem = itemMap.remove(itemId);
		if (cartItem == null) {
			return null;
		} else {
			itemList.remove(cartItem);
			return cartItem.getItem();
		}
	}

	/**
	 * Increment quantity by item id.
	 *
	 * @param itemId the item id
	 */
	public void incrementQuantityByItemId(String itemId) {
		CartItemDTO cartItem = itemMap.get(itemId);
		cartItem.incrementQuantity();
	}

	public void setQuantityByItemId(String itemId, int quantity) {
		CartItemDTO cartItem = itemMap.get(itemId);
		cartItem.setQuantity(quantity);
	}

	/**
	 * Gets the sub total.
	 *
	 * @return the sub total
	 */
	public BigDecimal getSubTotal() {
		return itemList.stream()
				.map(cartItem -> cartItem.getItem().getListPrice().multiply(new BigDecimal(cartItem.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
