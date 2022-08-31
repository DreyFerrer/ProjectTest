package com.planittesting.model.pages;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage extends BasePage<ShopPage> {

    public ShopPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(d -> driver.findElements(By.cssSelector("[data-locator='product']")).size()>0);
    }

    public List<Product> getProducts() {
        return driver.findElements(By.cssSelector("[data-locator='product']"))
            .stream()
            .map(e -> new Product(e))
            .toList();
    }

    public List<Product> getProducts(Function<Product, Boolean> strategy) {
        return getProducts()
            .stream()
            .filter(strategy::apply)
            .toList();
    }

    public Product getProduct(Function<Product, Boolean> strategy) {
        return getProducts(strategy::apply)
            .stream()
            .findFirst()
            .orElseThrow();
    }

}