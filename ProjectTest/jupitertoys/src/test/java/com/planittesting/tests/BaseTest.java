package com.planittesting.tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {
    WebDriver driver;

    @BeforeAll
    static void setupALl(){
        WebDriverManager.chromedriver().setup();
        

    }
    @BeforeEach
    void setup(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.navigate().to("https://jupiter.cloud.planittesting.com/");
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }
}
