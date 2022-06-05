package com.techion.techion.service;

import com.techion.techion.entity.Product;
import com.techion.techion.error.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    // get all products which contain the given name (if any)
    public List<Product> getProducts(String searchName);

    // save a new product to the database
    public Product addProduct(Product product);

    // get product with given productId
    public Product getProductById(Long productId) throws ProductNotFoundException;

    // update product with given productId
    public Product updateProduct(Long productId, Product newProductObject) throws ProductNotFoundException;

    // delete a product with given productId
    public String deleteProduct(Long productId) throws ProductNotFoundException;
}
