package test.java.com.planittesting.tests;

import com.planittesting.tests.BaseTest;

public class CartTest extends BaseTest{
    
    @Test
    void validateCartPrices() {
        var product = ((Object) open(HomePage.class))
            .clickShopMenu()
            .getProduct(p -> p.getTitle().equals("Teddy Bear"));
        var price = ((Object) product).getPrice();
        ((Object) product).clickBuyButton(2);


        var cartPrice = ((Object) open(ShopPage.class))
            .clickCartMenu()
            .getPrice("Teddy Bear");
        assertEquals(price, cartPrice);
    }

    public Object open(Class<HomePage> class1) {
        return null;
    }

    public void assertEquals(Object price, Object cartPrice) {
    }


    @Test
    void validateCarttotal() {
        var cartPage = open(HomePage.class)
            .clickShopMenu()
            .getProduct(p -> p.getTitle().equals("Teddy Bear"))
            .clickBuyButton(2)
            .clickCartMenu(2);

        assertEquals(
            cartPage.getQuantity("Teddy Bear") * cartPage.getPrice("Teddy Bear"),
            cartPage.getSubtotal("Teddy Bear"));
    }


}