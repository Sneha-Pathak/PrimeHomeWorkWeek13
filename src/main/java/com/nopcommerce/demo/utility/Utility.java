package com.nopcommerce.demo.utility;

import com.nopcommerce.demo.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility extends BasePage
{
    /**
     *This method will click on element
     * @param by
     */
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

//    public void clickOnElement(WebElement element)
//    {
//        element.click();
//    }

    /**
     * This method will get text from element
     * @param by
     * @return
     */
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element
     * @param by
     * @param text
     */
    public void sendTextToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will select by value from dropdown
     * @param by
     * @param value
     */
    public void selectByValueFromDropDown(By by,String value)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);//select by value
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverToElement(By by)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method is used to select the menu
     * @param by
     * @param menu
     */
    public void selectMenu(By by,String menu)
    {
        List<WebElement> elementList = driver.findElements(by);
        for (WebElement element: elementList)
        {
            if(element.getText().equalsIgnoreCase(menu))
            {
                element.click();
                break;
            }
        }
    }

    /**
     * This method will used to select drop down menu by visible text
     * @param by
     * @param timeout
     * @return
     */
    public WebElement waitVisibilityOfElementLocated(By by,int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    public void sortInDescendingOrder(By by)
    {
        List<WebElement> elementList = driver.findElements(by);
        List<String> expected = new ArrayList<>();

        for (WebElement element: elementList)
        {
            expected.add(element.getText());
        }

        List<String> actual = new ArrayList<>();
        actual.addAll(expected);

        Collections.sort(actual);
        Assert.assertEquals("Not sorted",expected, actual);
    }
}
