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

    public void clickAllAreasLink() throws InterruptedException {
        driver.findElement(whatWeDoLinks).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.unicef.org/what-we-do", currentUrl);
    }

    public void clickAdolescentsLink() throws InterruptedException {
        // Find all matching elements for the CSS selector
        List<WebElement> allAreasLinks = driver.findElements(whatWeDoLinks);

        // Check if there are at least two matching elements
        if (allAreasLinks.size() >= 2) {
            // Click on the second matching element
            allAreasLinks.get(1).click();

            // Wait for the page to load
            Thread.sleep(2000); // Adjust the sleep time as needed

            // Verify if the current URL matches the expected URL
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://www.unicef.org/adolescence", currentUrl);
        } else {
            // Log an error if there are not enough matching elements
            System.err.println("Error: Not enough matching elements.");
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
