package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Cart extends BasePage {
   
    private static final Object Double = null;

	public Cart(WebDriver driver) {
		super(driver);
	}

    public Object getPrice(String productName) {
        var price = getValue("Item", productName, "Price");
        return Double;
    }

	public Integer getQuantity(String productName) {
        var quantityElement = getValue("Item", productName, "Quantity");
        return Integer.parseInt((String) ((Object) ((By) quantityElement).findElements((SearchContext) 
        By.className("input-mini ng-pristine ng-valid ng-valid-number ng-valid-min"))));
    }

    
}
