package com.Spring.platzimarket.persistence.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Getter @Setter @ToString
@Entity
@Table(name = "productos")
public class Producto {

//    siempre que una columna la pongamos diferente "por buenas practicas debemos poner el @Column o @Table con su nombre de db"
//    esto genera de manerea auto el valor primario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    @Column(name= "cantidad_stock")
    private Integer cantidadStock;

    private boolean estado;


//    mapping, eso evita que se borren o se actualice esta categoria, solo para recuperar a que categoria pertenece el producto
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;
}