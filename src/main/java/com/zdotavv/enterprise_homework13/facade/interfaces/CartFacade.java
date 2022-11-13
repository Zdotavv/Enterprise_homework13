package com.zdotavv.enterprise_homework13.facade.interfaces;

import com.zdotavv.enterprise_homework13.dto.CartDto;
import com.zdotavv.enterprise_homework13.dto.PersonDto;
import com.zdotavv.enterprise_homework13.exceptions.NotFoundException;

import java.util.List;

public interface CartFacade {
    CartDto createCartByPersonId(PersonDto personDto) throws NotFoundException;

    CartDto addProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException;

    CartDto removeProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException;

    void removeAllProductsFromCartById(CartDto cartDto)throws NotFoundException;

    List<CartDto> getAllCarts();

    CartDto getCartById(CartDto cartDto) throws NotFoundException;

    void removeCartById(CartDto cartDto) throws NotFoundException;
}
