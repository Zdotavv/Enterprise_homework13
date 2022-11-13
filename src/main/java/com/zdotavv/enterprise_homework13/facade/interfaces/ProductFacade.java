package com.zdotavv.enterprise_homework13.facade.interfaces;

import com.zdotavv.enterprise_homework13.dto.ProductDto;
import com.zdotavv.enterprise_homework13.exceptions.NotFoundException;

import java.util.List;

public interface ProductFacade {
    ProductDto createProduct(ProductDto productDto)throws NotFoundException;;

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(ProductDto productDto) throws NotFoundException;

    ProductDto getById(ProductDto productDto) throws NotFoundException;

    List<ProductDto> getAllProducts();
}
