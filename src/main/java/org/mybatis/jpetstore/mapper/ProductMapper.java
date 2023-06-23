package org.mybatis.jpetstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.jpetstore.domain.Product;

@Mapper
public interface ProductMapper {

	List<Product> getProductListByCategory(String categoryId);

	Product getProduct(String productId);

	List<Product> searchProductList(String keywords);

}
