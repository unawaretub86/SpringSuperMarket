package com.Spring.platzimarket.domain.repository;

import com.Spring.platzimarket.domain.Product;

import java.util.List;
import java.util.Optional;

//este le indica a todos los repositorios como se deben comportar,
//para que cualquier repo , implemente estos metodos
public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
