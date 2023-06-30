package org.mybatis.jpetstore.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.jpetstore.domain.Category;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.mapper.CategoryMapper;
import org.mybatis.jpetstore.mapper.ItemMapper;
import org.mybatis.jpetstore.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service("catalogService")
public class CatalogServiceImpl {

	private CategoryMapper categoryMapper;
	private ItemMapper itemMapper;
	private ProductMapper productMapper;

	public CatalogServiceImpl(CategoryMapper categoryMapper, ItemMapper itemMapper, ProductMapper productMapper) {
		this.categoryMapper = categoryMapper;
		this.itemMapper = itemMapper;
		this.productMapper = productMapper;
	}

	public List<Category> getCategoryList() {
		return categoryMapper.getCategoryList();
	}

	public Category getCategory(String categoryId) {
		return categoryMapper.getCategory(categoryId);
	}

	public Product getProduct(String productId) {
		return productMapper.getProduct(productId);
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productMapper.getProductListByCategory(categoryId);
	}

	/**
	 * Search product list.
	 *
	 * @param keywords the keywords
	 *
	 * @return the list
	 */
	public List<Product> searchProductList(String keywords) {
		List<Product> products = new ArrayList<>();
		for (String keyword : keywords.split("\\s+")) {
			products.addAll(productMapper.searchProductList("%" + keyword.toLowerCase() + "%"));
		}
		return products;
	}

	public List<Item> getItemListByProduct(String productId) {
		return itemMapper.getItemListByProduct(productId);
	}

	public Item getItem(String itemId) {
		return itemMapper.getItem(itemId);
	}

	public boolean isItemInStock(String itemId) {
		return itemMapper.getInventoryQuantity(itemId) > 0;
	}
}