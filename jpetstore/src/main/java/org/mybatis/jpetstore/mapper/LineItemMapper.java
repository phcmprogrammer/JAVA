package org.mybatis.jpetstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.jpetstore.domain.LineItem;

@Mapper
public interface LineItemMapper {

	List<LineItem> getLineItemsByOrderId(int orderId);

	void insertLineItem(LineItem lineItem);

}
