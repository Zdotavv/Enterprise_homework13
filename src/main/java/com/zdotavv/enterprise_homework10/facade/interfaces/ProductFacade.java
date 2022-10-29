package com.zdotavv.enterprise_homework10.facade.interfaces;

import com.zdotavv.enterprise_homework10.dto.ProductDto;
import com.zdotavv.enterprise_homework10.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework10.model.Product;

import java.util.List;

public interface ProductFacade {
    ProductDto createProduct(ProductDto productDto)throws NotFoundException;;

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(ProductDto productDto) throws NotFoundException;

    ProductDto getById(ProductDto productDto) throws NotFoundException;

    List<ProductDto> getAllProducts();
}
