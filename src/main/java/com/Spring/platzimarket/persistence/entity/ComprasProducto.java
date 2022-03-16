package com.Spring.platzimarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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
}
