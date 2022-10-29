package com.zdotavv.enterprise_homework10.service.interfaces;

import com.zdotavv.enterprise_homework10.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework10.model.Shop;

import java.util.List;


public interface ShopService {
    Shop createShop(Shop shop);

    void deleteShop(Long idShop) throws NotFoundException;

    Shop getShopById(Long idShop) throws NotFoundException;

    List<Shop> getAllShops();
}
