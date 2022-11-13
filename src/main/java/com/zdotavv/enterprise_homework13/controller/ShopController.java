package com.zdotavv.enterprise_homework13.controller;


import com.zdotavv.enterprise_homework13.dto.ShopDto;
import com.zdotavv.enterprise_homework13.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework13.facade.interfaces.ShopFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(path="/shop")
@Slf4j
public class ShopController {

    private final ShopFacade shopFacade;

    public ShopController(ShopFacade shopFacade) {
        this.shopFacade = shopFacade;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String shopIndex(Model model) {
        String message = "Shop start page";
        model.addAttribute("message", message);
        return "/shop/shopIndex";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createShopView(Model model) {
        model.addAttribute("shop", new ShopDto());
        return "/shop/createShop";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createShop(@ModelAttribute("shop") ShopDto shopDto) {
        shopFacade.createShop(shopDto);
        log.info("New shop is created with name [{}]", shopDto.getName());
        return "/shop/createShopSuccess";
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getShopByIdView(Model model) {
        model.addAttribute("shopById", new ShopDto());
        return "/shop/getShop";
    }
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getShopById(@ModelAttribute("shopById") ShopDto shopDto, Model model) throws NotFoundException {
        ShopDto shopById = shopFacade.getShopById(shopDto);
        model.addAttribute("shopById", shopById);
        return "/shop/getShopSuccess";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteShopByIdView(Model model) {
        model.addAttribute("shop", new ShopDto());
        return "/shop/deleteShop";
    }
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteShop(@ModelAttribute("shop") ShopDto shopDto) throws NotFoundException {
        shopFacade.deleteShop(shopDto);
        log.info("Shop with name [{}} and ID [{}] is deleted", shopDto.getName(), shopDto.getIdShop());
        return "/shop/deleteShopSuccess";
    }
    @GetMapping( "/all")
    public String getAllShops(Model model) {
        model.addAttribute("all", shopFacade.getAllShops());
        return "/shop/allShops";
    }
}
