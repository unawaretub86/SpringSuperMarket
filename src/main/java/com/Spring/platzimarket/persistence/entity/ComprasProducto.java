package com.Spring.platzimarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter @Setter @ToString
@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

//    se usa cuando la pk es compuesta dada por otra clase
    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;

    private BigDecimal total;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_compra", updatable = false, insertable = false)
    private Compra compra;


    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;
}
