package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    @ApiOperation("Get all Supermarket Products")
    @ApiResponse(responseCode = "200",description = "OK")
    public ResponseEntity<List<Product>>  getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "PRODUCT NOT FOUND")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true, example = "7") @PathVariable("id") int productId) {
        return ResponseEntity.of(productService.getProduct(productId));
    }

//    otra manera de hacerlo pero mas largo
//    @GetMapping("/category/{id}")
//    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId) {
//        return productService.getByCategory(categoryId)
//                .map(products -> new ResponseEntity(products, HttpStatus.OK) )
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        return ResponseEntity.of(productService.getByCategory(categoryId));
    }

    @PostMapping("/")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        return new ResponseEntity(this.productService.delete(productId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
