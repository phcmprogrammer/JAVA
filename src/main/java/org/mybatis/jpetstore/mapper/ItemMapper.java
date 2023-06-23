package org.mybatis.jpetstore.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.jpetstore.domain.Item;

@Mapper
public interface ItemMapper {

	void updateInventoryQuantity(Map<String, Object> param);

	int getInventoryQuantity(String itemId);

	List<Item> getItemListByProduct(String productId);

	Item getItem(String itemId);

}
