package com.techion.techion.controller;

import com.techion.techion.entity.Product;
import com.techion.techion.error.ProductNotFoundException;
import com.techion.techion.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    // ProductService productService = new ProductServiceImpl()
    @Autowired
    private ProductService productService;

    /*
    * GET /api/product/products
    * Return a list of all products
    * */
    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(name = "query", required = false) String searchName) {
        log.info("[ProductController: getProducts()]");
        log.info("searchName: {}", searchName);
        return productService.getProducts(searchName);
    }

    /*
    * POST /api/product/products
    * Save a new product to the database
    * new product: in the Request Body (payload)
    * */
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        log.info("[ProductController: addProduct()]");
        log.info(product.toString());
        return productService.addProduct(product);
    }

    /*
    * GET /api/product/products/{id}
    * Return the product with given id(if it exists)
    * */
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
        return productService.getProductById(productId);
    }

    /*
    * PUT /api/product/products/{id}
    * path variable: product id
    * request body: data to be updated (payload)
    * update product with given id
    * */
    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody Product newProductObject) throws ProductNotFoundException {
        return productService.updateProduct(productId, newProductObject);
    }

    /*
    * DELETE /api/product/products/{id}
    * path variable: product id
    * delete product with given id
    * */
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
        return productService.deleteProduct(productId);
    }

}
