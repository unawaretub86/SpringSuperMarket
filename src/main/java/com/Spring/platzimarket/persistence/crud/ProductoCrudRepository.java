package com.Spring.platzimarket.persistence.crud;

import com.Spring.platzimarket.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//la clase es producto y su llave primaria es integer
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

//    query que se evita con los query methods , tenerlos en cuenta por que dan mayo flexibilidad (pilas con los nombres)
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
