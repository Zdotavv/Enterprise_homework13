package com.zdotavv.enterprise_homework13.facade.implementation;

import com.zdotavv.enterprise_homework13.converters.ShopConverter;
import com.zdotavv.enterprise_homework13.dto.ShopDto;
import com.zdotavv.enterprise_homework13.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework13.facade.interfaces.ShopFacade;
import com.zdotavv.enterprise_homework13.model.Shop;
import com.zdotavv.enterprise_homework13.service.interfaces.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.zdotavv.enterprise_homework13.converters.ShopConverter.convertShopDtoToShop;
import static com.zdotavv.enterprise_homework13.converters.ShopConverter.convertShopToShopDto;

@Component
public class ShopFacadeImpl implements ShopFacade {

    @Autowired
    private ShopService shopService;

    @Override
    public ShopDto createShop(ShopDto shopDto) {
       Shop Shop=shopService.createShop(convertShopDtoToShop(shopDto));
        return convertShopToShopDto(Shop);
    }

    @Override
    public void deleteShop(ShopDto shopDto) throws NotFoundException {
    shopService.deleteShop(shopDto.getIdShop());
    }

    @Override
    public ShopDto getShopById(ShopDto shopDto) throws NotFoundException {
       Shop getShop = shopService.getShopById(shopDto.getIdShop());
        return convertShopToShopDto(getShop);
    }

    @Override
    public List<ShopDto> getAllShops() {
        return shopService.getAllShops().stream().map(ShopConverter::convertShopToShopDto)
                .collect(Collectors.toList());
    }
}
