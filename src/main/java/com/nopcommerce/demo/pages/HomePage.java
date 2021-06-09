package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility
{
    By topMenu = By.xpath("//ul[@class='top-menu notmobile']/child::li");
    public String menu = "Computers";

    public void clickOnTopMenu()
    {
        waitVisibilityOfElementLocated(topMenu,3);
        selectMenu(topMenu,menu);
    }
}
