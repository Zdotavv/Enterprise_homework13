package com.zdotavv.enterprise_homework6.dto;

import com.zdotavv.enterprise_homework6.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDto {
    private Long idShop;
    private String name;
    private String link;
    private List<Product> products;

}
