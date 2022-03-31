package com.Spring.platzimarket.domain.service;

import com.Spring.platzimarket.domain.Product;
import com.Spring.platzimarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//esto hace que iyecte el product repository, esta service sirve como intermediario entre el controlador y la capa repositorio
@Service
public class ProductService {

//    inicializa un nuevo product repository
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

//   mandamos a eliminar , luego vamos y hacemos un mapeo buscando el producto , si existe retorna true, si no false
    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
