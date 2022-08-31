package test.java.com.planittesting.tests;

import org.junit.jupiter.api.Test;

import com.planittesting.model.pages.BasePage;
import com.planittesting.model.pages.CartPage;
import com.planittesting.model.pages.HomePage;
import com.planittesting.model.pages.ShopPage;
import com.planittesting.tests.BaseTest;

public class CartTest extends BaseTest{
    
    @Test
    void validateCartPrices() {
        var product = ((BasePage<HomePage>) open(HomePage.class))
            .clickShopMenu()
            .getProduct(p -> p.getTitle("Teddy Bear").equals("Teddy Bear"));
        var price = ((Object) product).getPrice();
        ((Object) product).clickBuyButton(2);


        var cartPrice = ((BasePage<HomePage>) open(ShopPage.class))
            .clickCartMenu()
            .getPrice("Teddy Bear");
        assertEquals(price, cartPrice);
    }

    private BasePage<HomePage> open(Class<ShopPage> class1) {
        return null;
    }

    public Object open(Class<HomePage> class1) {
        return null;
    }

    public void assertEquals(Object price, Object cartPrice) {
    }


    @Test
    void validateCarttotal() {
        var cartPage = ((BasePage<CartPage>) ((BasePage<HomePage>) open(HomePage.class))
            .clickShopMenu()
            .getProduct(p -> p.getTitle(null).equals("Teddy Bear"))
            .clickBuyButton(2))
            .clickCartMenu();

        assertEquals(
            ((CartPage) cartPage).getQuantity("Teddy Bear") * ((CartPage) cartPage).getPrice("Teddy Bear"),
            ((CartPage) cartPage).getSubtotal("Teddy Bear"));
    }


}