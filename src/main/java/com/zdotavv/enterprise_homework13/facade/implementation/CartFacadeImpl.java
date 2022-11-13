package com.zdotavv.enterprise_homework13.facade.implementation;

import com.zdotavv.enterprise_homework13.converters.CartConverter;
import com.zdotavv.enterprise_homework13.dto.CartDto;
import com.zdotavv.enterprise_homework13.dto.PersonDto;
import com.zdotavv.enterprise_homework13.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework13.facade.interfaces.CartFacade;
import com.zdotavv.enterprise_homework13.model.Cart;
import com.zdotavv.enterprise_homework13.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.zdotavv.enterprise_homework13.converters.CartConverter.convertCartToCartDto;


@Component
public class CartFacadeImpl implements CartFacade {

    @Autowired
    private CartService cartService;

    @Override
    public CartDto createCartByPersonId(PersonDto personDto) throws NotFoundException {
        Cart Cart = cartService.createCartByPersonId(personDto.getIdPerson());
        return convertCartToCartDto(Cart);
    }

    @Override
    public CartDto addProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException {
        Cart cart = cartService.addProductByProductIdAndCartId(cartDto.getIdCart(), cartDto.getIdProduct());
        return convertCartToCartDto(cart);
    }

    @Override
    public CartDto removeProductByProductIdAndCartId(CartDto cartDto) throws NotFoundException {
        Cart removeFromCart = cartService.removeProductByProductIdAndCartId(cartDto.getIdCart(), cartDto.getIdProduct());
        return convertCartToCartDto(removeFromCart);
    }

    @Override
    public void removeAllProductsFromCartById(CartDto cartDto) throws NotFoundException {
        cartService.removeAllProductsFromCartById(cartDto.getIdCart());
    }

    @Override
    public List<CartDto> getAllCarts() {
        return cartService.getAllCarts().stream().map(CartConverter::convertCartToCartDto)
                .collect(Collectors.toList());
    }

    @Override
    public CartDto getCartById(CartDto cartDto) throws NotFoundException {
        Cart cart = cartService.getCartById(cartDto.getIdCart());
        return convertCartToCartDto(cart);
    }

    @Override
    public void removeCartById(CartDto cartDto) throws NotFoundException {
        cartService.removeCartById(cartDto.getIdCart());
    }
}
