package com.zdotavv.enterprise_homework13.service.interfaces;

import com.zdotavv.enterprise_homework13.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework13.model.Cart;

import java.util.List;

public interface CartService {
    Cart createCartByPersonId(Long idPerson) throws NotFoundException;

    Cart addProductByProductIdAndCartId(Long idCart, Long idProduct) throws NotFoundException;

    Cart removeProductByProductIdAndCartId(Long idCart, Long idProduct) throws NotFoundException;

    void removeAllProductsFromCartById(Long idCart)throws NotFoundException;

    List<Cart> getAllCarts();

    Cart getCartById(Long idCart) throws NotFoundException;

    void removeCartById(Long idCart) throws NotFoundException;
}
