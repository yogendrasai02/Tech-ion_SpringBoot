package com.techion.techion.service;

import com.techion.techion.entity.Product;
import com.techion.techion.error.ProductNotFoundException;
import com.techion.techion.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // get all products after applying filters (if any)
    @Override
    public List<Product> getProducts(String searchName) {
        if(searchName == null)
            return productRepository.findAll();
        else
            return productRepository.findByNameContainingIgnoreCase(searchName);
    }

    // save a product to db
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // get a product with given productId
    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        Product product = productRepository.findById(productId)
                .orElse(null);
        if(product == null) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        return product;
    }

    // update product with given id
    @Override
    public Product updateProduct(Long productId, Product newProductObject) throws ProductNotFoundException {
        Product existingProductObj = productRepository.findById(productId).orElse(null);
        if(existingProductObj == null) {
            // product with given id does not exist
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        // update the necessary fields
        if(newProductObject.getName() != null && !newProductObject.getName().isBlank())
            existingProductObj.setName(newProductObject.getName());
        if(newProductObject.getBrand() != null && !newProductObject.getBrand().isBlank())
            existingProductObj.setBrand(newProductObject.getBrand());
        if(newProductObject.getDescription() != null && !newProductObject.getDescription().isBlank())
            existingProductObj.setDescription(newProductObject.getDescription());
        if(newProductObject.getPrice() != null)
            existingProductObj.setPrice(newProductObject.getPrice());
        if(newProductObject.getStock() != null)
            existingProductObj.setStock(newProductObject.getStock());
        return productRepository.save(existingProductObj);
    }

    // delete a product with given productId
    public String deleteProduct(Long productId) throws ProductNotFoundException {
        try {
            productRepository.deleteById(productId);
        } catch(Exception e) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        return "Product deleted successfully";
    }

}
