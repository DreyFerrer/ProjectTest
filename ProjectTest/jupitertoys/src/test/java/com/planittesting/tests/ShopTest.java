package com.planittesting.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.jupitertoys.model.pages.HomePage;

public class ShopTests extends BaseTestSuite {
    @Test
    public void validateProductPrice() {
        var productPrice = open(HomePage.class)
            .clickShopMenu()
            .getProduct(p -> p.getTitle().equals("Teddy Bear"))
            .getPrice();
        
        assertEquals(productPrice, 12.99);
    }

    @Test
    public void validateCanBuyProduct() {
        var count = open(HomePage.class)
            .clickShopMenu()
            .getProduct(p -> p.getPrice().equals(12.99))
            .clickBuyButton()
            .getCartCount();
        
        assertEquals(2, count);
    }
}
