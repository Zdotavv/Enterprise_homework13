package com.zdotavv.enterprise_homework10.facade.interfaces;

import com.zdotavv.enterprise_homework10.dto.ShopDto;
import com.zdotavv.enterprise_homework10.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework10.model.Shop;

import java.util.List;

public interface ShopFacade {
    ShopDto createShop(ShopDto shopDto);

    void deleteShop(ShopDto shopDto) throws NotFoundException;

    ShopDto getShopById(ShopDto shopDto) throws NotFoundException;

    List<ShopDto> getAllShops();
}
