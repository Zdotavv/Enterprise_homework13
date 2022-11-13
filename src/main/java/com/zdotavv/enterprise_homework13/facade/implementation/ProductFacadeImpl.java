package com.zdotavv.enterprise_homework13.facade.implementation;

import com.zdotavv.enterprise_homework13.converters.ProductConverter;
import com.zdotavv.enterprise_homework13.dto.ProductDto;
import com.zdotavv.enterprise_homework13.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework13.facade.interfaces.ProductFacade;
import com.zdotavv.enterprise_homework13.model.Product;
import com.zdotavv.enterprise_homework13.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.zdotavv.enterprise_homework13.converters.ProductConverter.convertProductToProductDto;

@Component
public class ProductFacadeImpl implements ProductFacade {
    @Autowired
    private ProductService productService;
    @Override
    public ProductDto createProduct(ProductDto productDto) throws NotFoundException {
        Product Product=productService.createProduct(productDto.getName(), productDto.getPrice(), productDto.getIdShop());
    return convertProductToProductDto(Product);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product Product = productService.updateProduct(productDto.getIdProduct(), productDto.getName(),
                productDto.getPrice(), productDto.getIdShop());
        return convertProductToProductDto(Product);
    }

    @Override
    public void deleteProduct(ProductDto productDto) throws NotFoundException {
    productService.deleteProduct(productDto.getIdProduct());
    }

    @Override
    public ProductDto getById(ProductDto productDto) throws NotFoundException {
        Product product=productService.getById(productDto.getIdProduct());
        return convertProductToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream().map(ProductConverter::convertProductToProductDto)
                .collect(Collectors.toList());
    }
}
