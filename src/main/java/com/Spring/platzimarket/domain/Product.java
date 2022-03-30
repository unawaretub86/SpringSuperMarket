package com.Spring.platzimarket.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter @Setter
public class Product  {

    private int productId;
    private String name;
    private long categoryId;
    private BigDecimal price;
    private int stock;
    private boolean active;
    private Category category;


}
