package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.base_class.BasePage;

import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

public class HomeUnicefPage extends BasePage {


    private By donateButton = By.cssSelector("a[data-label='Donate']");

    private By pressCentreButton = By.id("block-unicef-base-secondary-menu");

    private By whatWeDoSection = By.cssSelector("a.dropdown-toggle.is-parent-item > span");

    private By researchAndReportsSection = By.cssSelector(".dropdown-toggle.is-parent-item.active:nth-of-type(2)");

    private By whatWeDoLinks = By.cssSelector("ul > li > ul > li > a > span:nth-child(1)");

    private  By searchButton = By.className("btn--input-search");

    private By searchInput = By.id("edit-query-inpt-pop");

    private By numberOfResults = By.className("number-of-results");

    private By mainImage = By.cssSelector(".b-lazy");

    private By readMoreButton = By.cssSelector("a.btn.btn-donate[data-action='/emergencies/children-gaza-need-lifesaving-support'][data-label='Read more']");

    private By middleSectionLinks = By.cssSelector("div > a > div > span");







    public void GetHomePage() {
        driver.get("https://www.unicef.org/");
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

    public void hoverStoriesSection() throws InterruptedException {
        WebElement element = driver.findElements(whatWeDoSection).get(2);
        Thread.sleep(100);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverAboutUnicefSection() throws InterruptedException {
        WebElement element = driver.findElements(whatWeDoSection).get(3);
        Thread.sleep(100);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverTakeActionSection() throws InterruptedException {
        WebElement element = driver.findElements(whatWeDoSection).get(4);
        Thread.sleep(100);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    public void clickAllAreasLink() throws InterruptedException {
        driver.findElement(whatWeDoLinks).click();
        Thread.sleep(100);
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

    public void otherLinks(String elementToClick, String expectedUrl) {
        int elementIndex = Integer.parseInt(elementToClick);

        List<WebElement> allAreasLinks = driver.findElements(whatWeDoLinks);

        if (elementIndex >= 1 && elementIndex <= allAreasLinks.size()) {
            allAreasLinks.get(elementIndex - 1).click();
            try {
                WebDriverWait wait = new WebDriverWait(driver, 2);
                wait.until(ExpectedConditions.urlToBe(expectedUrl));
            } catch (TimeoutException e) {
                System.err.println("Timeout waiting for URL to be: " + expectedUrl);
            }
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(expectedUrl, currentUrl);
        } else {
            System.err.println("Error: Element index out of bounds");
        }
    }

    public void clickMiddleSectionLink(String elementToClick, String expectedUrl) throws InterruptedException {
        int elementIndex = Integer.parseInt(elementToClick);
        List<WebElement> allAreasLinks = driver.findElements(middleSectionLinks);

        if (elementIndex >= 1 && elementIndex <= allAreasLinks.size()) {
            WebElement element = allAreasLinks.get(elementIndex - 1);

            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.urlToBe(expectedUrl));
            } catch (TimeoutException e) {
                System.err.println("Timeout waiting for URL to be: " + expectedUrl);
            } catch (Exception e) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", element);
            }
            Thread.sleep(500);
            String currentUrl = driver.getCurrentUrl();
            if (!expectedUrl.equals(currentUrl)) {
                // Sometimes the links will open in new tabs, this will check if another tab has beenn opened with the expected url
                Set<String> allTabs = driver.getWindowHandles();
                for (String tab : allTabs) {
                    driver.switchTo().window(tab);
                    currentUrl = driver.getCurrentUrl();
                    if (expectedUrl.equals(currentUrl)) {
                        Assert.assertEquals(expectedUrl, currentUrl);
                        return;
                    }
                }
                System.err.println("Error: Tab with URL " + expectedUrl + " not found");
            } else {
                Assert.assertEquals(expectedUrl, currentUrl);
            }
        } else {
            System.err.println("Error: Element index out of bounds");
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

    public  void clickSearchButton() throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(100);
    }

    public void insertDatainSearchInput() throws InterruptedException {
        driver.findElement(searchInput).sendKeys("Brazil");
        Thread.sleep(100);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }

    public boolean doesSearchContainResults() {
        WebElement element = driver.findElement(numberOfResults);
        String text = element.getText();
        return text.contains("results");
    }

    public void isMainImageDisplayed(){
        List<WebElement> mainImageElements = driver.findElements(mainImage);
        if (!mainImageElements.isEmpty()) {
            WebElement mainImageElement = mainImageElements.get(0);
            Assert.assertTrue("Main image is not displayed.", mainImageElement.isDisplayed());
        } else {
            Assert.fail("Main image element not found.");
        }
    }

    public void isMainReadMoreButtonIsClickable() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(readMoreButton));
        Assert.assertNotNull("Read more button is clickable", button);
    }

}
