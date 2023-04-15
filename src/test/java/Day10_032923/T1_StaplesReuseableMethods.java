package Day10_032923;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T1_StaplesReuseableMethods {
    public static void main(String[] args) throws InterruptedException {
        //set up your web driver
        WebDriver driver = ReusableMethods.defineChromeDriver();
        // navigate to the best buy website
        driver.navigate().to("https://www.bestbuy.com/");

        //type on search field using sendkeys method
        ReusableMethods.sendKeysMethod(driver, "//*[@id='gh-search-input']", "iphone", "search field");

        //click on the search icon
        ReusableMethods.clickMethod(driver, "//*[@class='header-search-button']", "Search Icon");

        // wait for the dropdown to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tb-select']")));

        // select the "Best Selling" option from the dropdown


        // wait for the search results to load
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='row no-gutters top-results-header']")));

        //click on the first iphone using the click by index method
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='sku-title']//a", 0, "First iPhone");

        //scroll down to "Learn About Totaltech"

        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Learn About Totaltech')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        js.executeScript("arguments[0].scrollIntoView(3000);", element);
        // Scroll to the element

    }//end of class
}//end of main