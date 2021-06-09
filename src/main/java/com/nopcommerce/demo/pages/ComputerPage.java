package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ComputerPage extends Utility
{
    By computer = By.xpath("//ul[@class='top-menu notmobile']/child::li[1]");
    By desktop = By.xpath("//ul[@class = 'top-menu notmobile']/li[1]/ul[1]/li[1]/a");
    By addToCart = By.xpath("//div[@data-productid='1']/div[2]/div[3]/div[2]/button[3]");
    By processor = By.id("product_attribute_1");
    By ram = By.id("product_attribute_2");
    By radio_hdd_400 = By.id("product_attribute_3_7");
    By radio_os_vista_premium = By.id("product_attribute_4_9");
    By total_commander = By.id("product_attribute_5_12");
    By cart_btn = By.id("add-to-cart-button-1");
    By close_shopping_popup_bar = By.xpath("//span[@class='close']");

    public void descendingOrder()
    {
        mouseHoverToElement(computer);
        clickOnElement(desktop);
        selectByValueFromDropDown(By.id("products-orderby"), "6");
        sortInDescendingOrder(By.xpath("//h2[@class='product-tittle']"));
    }

    public void ascendingOrder() throws InterruptedException {
        mouseHoverToElement(computer);
        clickOnElement(desktop);
        selectByValueFromDropDown(By.id("products-orderby"), "5");
        sortInDescendingOrder(By.xpath("//h2[@class='product-tittle']"));
        waitVisibilityOfElementLocated(addToCart,5);
        mouseHoverToElement(addToCart);
        clickOnElement(addToCart);

        //Assert
        String expectedMessage1 = "Build your own computer";
        String actualMessage1 = getTextFromElement(By.xpath("//div[@data-productid='1']/div[1]/div[2]/div[1]/h1"));
        Assert.assertEquals("Build your own computer page is not there....", expectedMessage1, actualMessage1);

        selectByValueFromDropDown(processor, "1");
        selectByValueFromDropDown(ram, "5");
        clickOnElement(radio_hdd_400);
        clickOnElement(radio_os_vista_premium);
        clickOnElement(total_commander);

        //waitVisibilityOfElementLocated(price_value,10);
        Thread.sleep(10000);
        //Assert
        String expectedMessage2 = "$1,475.00";
        String actualMessage2 = getTextFromElement(By.id("price-value-1"));
        Assert.assertEquals("Wrong price match....", expectedMessage2, actualMessage2);

        clickOnElement(cart_btn);

        //Assert
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//div[@id='bar-notification']/div/p"));
        Assert.assertEquals("Not added to shopping cart....", expectedMessage3, actualMessage3);

        clickOnElement(close_shopping_popup_bar);
    }
}

