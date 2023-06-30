package org.mybatis.jpetstore.controller;

import java.util.List;

import org.mybatis.jpetstore.domain.Category;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST JpetStore")
@RestController
@RequestMapping
public class CatalogController {

	@Autowired
	private CatalogService catalogService;

	@ApiOperation(value = "Retorna a lista de categorias")
	@GetMapping(value = "/category")
	public ResponseEntity<List<Category>> getCategoryList() {
		List<Category> category = catalogService.getCategoryList();
		return ResponseEntity.ok(category);
	} // TESTADO

	@ApiOperation(value = "Retorna a categoria pelo id da categoria")
	@GetMapping(value = "/category/{categoryId}")
	public ResponseEntity<Category> getCategory(@PathVariable String categoryId) {
		Category category = catalogService.getCategory(categoryId);
		return ResponseEntity.ok(category);
	} // TESTADO

	@ApiOperation(value = "Retorna o produto pelo id do produto")
	@GetMapping(value = "/product{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable String productId) {
		Product product = catalogService.getProduct(productId);
		return ResponseEntity.ok(product);
	} // TESTADO

	@ApiOperation(value = "Retorna a listas de produto de uma categoria")
	@GetMapping(value = "/product/{categoryId}")
	public ResponseEntity<List<Product>> getProductListByCategory(String categoryId) {
		List<Product> product = catalogService.getProductListByCategory(categoryId);
		return ResponseEntity.ok(product);
	} // TESTADO

	/**
	 * Search product list.
	 *
	 * @param keywords the keywords
	 *
	 * @return the list
	 */
	
	@ApiOperation(value = "Retorna a lista de produtos a partir de uma sequência de string que contenha no nome do produto")
	@GetMapping(value = "/product")
	public ResponseEntity<List<Product>> searchProductList(String keywords) {
		List<Product> product = catalogService.searchProductList(keywords);
		return ResponseEntity.ok(product);
	} // TESTADO
	
	@ApiOperation(value = "Retorna a lista de itens a partir do id do produto")
	@GetMapping(value = "/item/{productId}")
	public ResponseEntity<List<Item>> getItemListByProduct(@PathVariable String productId) {
		List<Item> item = catalogService.getItemListByProduct(productId);
		return ResponseEntity.ok(item);
	} // TESTADO
	
	@ApiOperation(value = "Retorna o item  a partir do seu id")
	@GetMapping(value = "/item")
	public ResponseEntity<Item> getItem(String itemId) {
		Item item = catalogService.getItem(itemId);
		return ResponseEntity.ok(item);
	} // TESTADO
	
	@ApiOperation(value = "Verifica item em estoque")
	@GetMapping(value = "/item/{status}")
	public ResponseEntity<Boolean> isItemStock(@RequestParam(value = "status") String itemId) {
		Boolean booleano = catalogService.isItemInStock(itemId);
		return ResponseEntity.ok(booleano);
	} // TESTADO

}