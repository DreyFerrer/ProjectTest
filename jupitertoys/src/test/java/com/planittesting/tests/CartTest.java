package com.planittesting.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.model.pages.HomePage;

public class CartTest extends BaseTest {
    
        @Test
        void checkCartPrice() {
            var product = ((HomePage) open(HomePage.class))
                .clickShopMenu()
                .validateProduct(getTitle().equals("Bear"));
            
				
            Object price;
			Object cartPrice;
			assertEquals(price, cartPrice);
        }
    
   

		private Object clickCartMenu() {
			return null;
		}

		private Object getTitle() {
			return null;
		}

		private Object open(Class<HomePage> class1) {
			return null;
		}
    
}
