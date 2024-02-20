package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.base_class.BasePage;

public class HomeUnicefPage extends BasePage {

    private By donateButton = By.cssSelector("a[data-label='Donate']");
    private By closeAdButton = By.cssSelector("button[data-qa='global-close']");

    private By pressCentreButton = By.id("block-unicef-base-secondary-menu");


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



    public boolean isPressCentreButtonClickable() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(pressCentreButton));
            return button.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
