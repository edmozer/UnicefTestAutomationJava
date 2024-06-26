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

    // In this section you will find selectors for the elements used in the code
    private By donateButton = By.cssSelector("a[data-label='Donate']");
    private By pressCentreButton = By.id("block-unicef-base-secondary-menu");
    private By headerMenusSection = By.cssSelector("a.dropdown-toggle.is-parent-item > span");
    private By researchAndReportsSection = By.cssSelector(".dropdown-toggle.is-parent-item.active:nth-of-type(2)");
    private By hoveredMenuLinks = By.cssSelector("ul > li > ul > li > a > span:nth-child(1)");
    private By searchButton = By.className("btn--input-search");
    private By searchInput = By.id("edit-query-inpt-pop");
    private By numberOfResults = By.className("number-of-results");
    private By mainImage = By.cssSelector(".b-lazy");
    private By readMoreButton = By.cssSelector("a.btn.btn-donate[data-action='/emergencies/children-gaza-need-lifesaving-support'][data-label='Read more']");
    private By middleSectionLinks = By.cssSelector("div > a > div > span");
    private By middleSection2Links = By.cssSelector("div > div > p > a");
    private By bottomPageLinks = By.cssSelector("h4.h4.white-bg.text-grey1");
    private By joinUnicefButton = By.cssSelector("a.btn.btn-donate.white-bg.accent-action.white-contained[data-action='/take-action'][data-label='Join UNICEF']");


// Here are the functions used to navigate, assert, validade and etc...

    public void GetHomePage() {
        //This gets the home page open
        driver.get("https://www.unicef.org/");
    }

    // This next one hovers the pointer over the What We Do Section and therefore another menu is dropped down
    // The following functions will also hover, but in different elements
    public void hoverWhatWeDoSection() {
        WebElement element = driver.findElement(headerMenusSection);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverResearchAndReportsSection() {
        WebElement element = driver.findElements(headerMenusSection).get(1);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverStoriesSection() throws InterruptedException {
        WebElement element = driver.findElements(headerMenusSection).get(2);
        Thread.sleep(100);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverAboutUnicefSection() throws InterruptedException {
        WebElement element = driver.findElements(headerMenusSection).get(3);
        Thread.sleep(100);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverTakeActionSection() throws InterruptedException {
        WebElement element = driver.findElements(headerMenusSection).get(4);
        Thread.sleep(100);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    // clickAllAreasLink and clickAdolescentsLink will click and validate on link in the menu that was dropped after hover
    public void clickAllAreasLink() throws InterruptedException {
        driver.findElement(hoveredMenuLinks).click();
        Thread.sleep(100);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.unicef.org/what-we-do", currentUrl);
    }

    public void clickAdolescentsLink() throws InterruptedException {
        List<WebElement> allAreasLinks = driver.findElements(hoveredMenuLinks);

        if (allAreasLinks.size() >= 2) {
            allAreasLinks.get(1).click();
            Thread.sleep(700);
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://www.unicef.org/adolescence", currentUrl);
        } else {

            System.err.println("Error: Url doesn't match");
        }
    }

    // This will click on other links and validate them. They are selected by the positions in the array.
// The position is defined by elementToClick parameter and expectedUrl asserts url of the clicked element
    public void otherLinks(String elementToClick, String expectedUrl) {
        int elementIndex = Integer.parseInt(elementToClick);

        List<WebElement> allAreasLinks = driver.findElements(hoveredMenuLinks);

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

    // Moving on, the middle of the page is divided in two sections, these two functions will validate them
    // Validation will work similarly to previous function
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
                throw new AssertionError("Error: Tab with URL " + expectedUrl + " not found");
            } else {
                Assert.assertEquals(expectedUrl, currentUrl);
            }
        } else {
            throw new AssertionError("Error: Element index out of bounds");
        }
    }

    public void clickMiddleSection2Link(String elementToClick, String expectedUrl) throws InterruptedException {
        Thread.sleep(100);
        int elementIndex = Integer.parseInt(elementToClick);
        List<WebElement> allAreasLinks = driver.findElements(middleSection2Links);

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
                throw new AssertionError("Error: Current URL " + currentUrl + " does not match expected URL " + expectedUrl);
            } else {
                Assert.assertEquals(expectedUrl, currentUrl);
            }
        } else {
            throw new AssertionError("Error: Element index out of bounds");
        }
    }

    public void bottomPageLink(String elementToClick, String expectedUrl) throws InterruptedException {
        Thread.sleep(100);
        int elementIndex = Integer.parseInt(elementToClick);
        List<WebElement> allAreasLinks = driver.findElements(bottomPageLinks);
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
                throw new AssertionError("Error: Tab with URL " + expectedUrl + " not found");
            } else {
                Assert.assertEquals(expectedUrl, currentUrl);
            }
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

    public void clickSearchButton() throws InterruptedException {
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

    public void isMainImageDisplayed() {
        List<WebElement> mainImageElements = driver.findElements(mainImage);
        if (!mainImageElements.isEmpty()) {
            WebElement mainImageElement = mainImageElements.get(0);
            Assert.assertTrue("Main image is not displayed.", mainImageElement.isDisplayed());
        } else {
            Assert.fail("Main image element not found.");
        }
    }

    public void isBottomImageDisplayed() {
        List<WebElement> mainImageElements = driver.findElements(mainImage);
        if (!mainImageElements.isEmpty()) {
            WebElement mainImageElement = mainImageElements.get(1);
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

    public void isJoinUnicefButtonIsClickable() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(joinUnicefButton));
        Assert.assertNotNull("Read more button is clickable", button);
    }

}
