package com.planittesting.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShopTest extends BaseTest {
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
