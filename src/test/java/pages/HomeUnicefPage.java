package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.base_class.BasePage;

import org.openqa.selenium.interactions.Actions;

public class HomeUnicefPage extends BasePage {


    private By donateButton = By.cssSelector("a[data-label='Donate']");
    private By closeAdButton = By.cssSelector("button[data-qa='global-close']");

    private By pressCentreButton = By.id("block-unicef-base-secondary-menu");

    private By whatWeDoSection = By.cssSelector("a.dropdown-toggle.is-parent-item > span");

    private By allAreasLink = By.cssSelector("ul > li > ul > li > a > span:nth-child(1)");




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
        driver.findElement(allAreasLink).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.unicef.org/what-we-do", currentUrl);

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
