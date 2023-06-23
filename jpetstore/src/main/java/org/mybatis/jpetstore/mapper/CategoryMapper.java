package org.mybatis.jpetstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.jpetstore.domain.Category;

@Mapper
public interface CategoryMapper {

	List<Category> getCategoryList();

	Category getCategory(String categoryId);

}
