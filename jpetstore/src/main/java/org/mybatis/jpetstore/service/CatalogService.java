package org.mybatis.jpetstore.service;

import java.util.List;

import org.mybatis.jpetstore.domain.Category;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;

public interface CatalogService {
	
	List<Category> getCategoryList();
	
	Category getCategory(String categoryId);
	
	Product getProduct(String productId);
	
	List<Product> getProductListByCategory(String categoryId);
	
	List<Product> searchProductList(String keywords);
	
	List<Item> getItemListByProduct(String productId);
	
	Item getItem(String itemId);
	
	boolean isItemInStock(String itemId);

}
