package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComputerTest extends TestBase
{
    ComputerPage computerPage = new ComputerPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder()
    {
        computerPage.descendingOrder();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException
    {
        computerPage.ascendingOrder();
    }
}
