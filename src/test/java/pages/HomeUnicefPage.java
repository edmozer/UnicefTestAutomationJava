package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.base_class.BasePage;

import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomeUnicefPage extends BasePage {


    private By donateButton = By.cssSelector("a[data-label='Donate']");
    private By closeAdButton = By.cssSelector("button[data-qa='global-close']");

    private By pressCentreButton = By.id("block-unicef-base-secondary-menu");

    private By whatWeDoSection = By.cssSelector("a.dropdown-toggle.is-parent-item > span");

    private By researchAndReportsSection = By.cssSelector(".dropdown-toggle.is-parent-item.active:nth-of-type(2)");

    private By whatWeDoLinks = By.cssSelector("ul > li > ul > li > a > span:nth-child(1)");




    public void GetHomePage() {
        driver.get("https://www.unicef.org/");
    }

    public void clickDonateButton() {
        driver.findElement(donateButton).click();
    }

    public void clickCloseAdButton() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(closeAdButton).click();
    }

    public void hoverWhatWeDoSection(){
        WebElement element = driver.findElement(whatWeDoSection);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverResearchAndReportsSection(){
        WebElement element = driver.findElements(whatWeDoSection).get(1);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverStoriesSection(){
        WebElement element = driver.findElements(whatWeDoSection).get(1);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    public void clickAllAreasLink() throws InterruptedException {
        driver.findElement(whatWeDoLinks).click();
        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.unicef.org/what-we-do", currentUrl);
    }

    public void clickAdolescentsLink() throws InterruptedException {
        List<WebElement> allAreasLinks = driver.findElements(whatWeDoLinks);

        if (allAreasLinks.size() >= 2) {
            allAreasLinks.get(1).click();
            Thread.sleep(700);
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://www.unicef.org/adolescence", currentUrl);
        } else {

            System.err.println("Error: Url doesn't match");
        }
    }

    public void WhatWeDoOtherLinks(String elementToClick, String expectedUrl) throws InterruptedException {
        // Convert elementToClick from String to int
        int elementIndex = Integer.parseInt(elementToClick);

        List<WebElement> allAreasLinks = driver.findElements(whatWeDoLinks);

        if (elementIndex >= 1 && elementIndex <= allAreasLinks.size()) {
            allAreasLinks.get(elementIndex - 1).click();
            Thread.sleep(300);
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(expectedUrl, currentUrl);
        } else {
            System.err.println("Error: Element index out of bounds or URL doesn't match");
        }
    }


    public void childRightsLink() {
        List<WebElement> allAreasLinks = driver.findElements(whatWeDoLinks);

        if (allAreasLinks.size() >= 2) {
            allAreasLinks.get(3).click();
            String currentUrl3 = driver.getCurrentUrl();
            Assert.assertEquals("https://www.unicef.org/child-rights-convention", currentUrl3);
        } else {

            System.err.println("Error: Url doesn't match");
        }
    }


    public boolean isPressCentreButtonClickable() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(pressCentreButton));
            return button.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDonateButtonClickable() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(donateButton));
            return button.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }


}
