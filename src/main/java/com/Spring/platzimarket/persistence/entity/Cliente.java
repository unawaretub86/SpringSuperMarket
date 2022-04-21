package com.Spring.platzimarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Getter @Setter @ToString
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private Integer id;

    private String nombre;

    private String apellidos;

    private Integer celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cLiente")
    private List<Compra> compras;
}
