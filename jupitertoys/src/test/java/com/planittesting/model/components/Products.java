package com.planittesting.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Products {
        WebElement rootElement;
    
        public void Product(WebElement rootElement) {
            this.rootElement = rootElement;
        }
    
        public WebElement getTitle() {
            return rootElement.findElement(By.className("product-title ng-binding"));
        }
    
        public Double getPrice() {
            return Double.parseDouble(
                rootElement.findElement( By.className("product-price ng-binding"))
                .getText());    
        }
    
}
