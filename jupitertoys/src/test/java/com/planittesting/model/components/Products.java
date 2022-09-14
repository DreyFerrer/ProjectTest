package com.planittesting.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Products {
        WebElement rootElement;
    
        public void Product(WebElement rootElement) {
            this.rootElement = rootElement;
        }
    
        public String getTitle() {
            return rootElement.findElement(By.className("product-title")).getText();
        }
    
        public Double getPrice() {
            return Double.parseDouble(
                rootElement.findElement( By.className("product-price"))
                .getText().replace("$",""));    
        }
    
}
