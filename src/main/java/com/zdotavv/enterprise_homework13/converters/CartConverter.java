package com.zdotavv.enterprise_homework13.converters;

import com.zdotavv.enterprise_homework13.dto.CartDto;
import com.zdotavv.enterprise_homework13.model.Cart;

public class CartConverter {

    public static CartDto convertCartToCartDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setIdCart(cart.getIdCart());
        cartDto.setPerson(cart.getPerson());
        cartDto.setProducts(cart.getProducts());
        cartDto.setSum(cart.getSum());
        return cartDto;
    }
}
