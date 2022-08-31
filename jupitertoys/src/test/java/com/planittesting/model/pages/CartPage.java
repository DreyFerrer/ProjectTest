package com.planittesting.jupitertoys.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planittesting.jupitertoys.model.components.ui.Table;

public class CartPage extends BasePage<CartPage> {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Double getPrice(String productName) {
        var priceAsString = getTable().getValue("Item", productName, "Price").getText();
        return Double.parseDouble(priceAsString.replace("$", ""));
    }

    public Integer getQuantity(String productName) {
        var quantityElement = getTable().getValue("Item", productName, "Quantity");
        return Integer.parseInt(quantityElement.findElement(By.cssSelector("[data-locator='item-quantity']")).getText());
    }

    public Double getSubtotal(String productName) {
        var subtotalAsString = getTable().getValue("Item", productName, "Subtotal").getText();
        return Double.parseDouble(subtotalAsString.replace("$", ""));
    }
    
    private Table getTable() {
        return new Table(driver.findElement(By.id("cart-items")));
    }
}