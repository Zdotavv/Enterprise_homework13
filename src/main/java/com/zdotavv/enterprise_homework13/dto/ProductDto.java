package com.zdotavv.enterprise_homework13.dto;

import com.zdotavv.enterprise_homework13.model.Shop;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {

    private Long idProduct;

    private String name;

    private BigDecimal price;

    private Shop shop;

    private Long IdShop;
}
