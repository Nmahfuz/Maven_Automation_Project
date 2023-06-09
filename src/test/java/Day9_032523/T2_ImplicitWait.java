package Day9_032523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class T2_ImplicitWait {
    public static void main(String[] args) throws InterruptedException {


        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        //options.addArguments("headless");
        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo home page
        driver.navigate().to("https://www.usps.com");
        //declare and define the mouse action

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions mouseAction = new Actions(driver);

        //hover to send tab to open up submodules/functionalities
        try{
            WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
            mouseAction.moveToElement(sendTab).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to Send Tab: " + e);
        }//end of send tab exception

        //click on Tracking using mouse click
        try{
            WebElement trackingLink = driver.findElements(By.xpath("//*[text()='Tracking']")).get(0);
            mouseAction.moveToElement(trackingLink).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to click on Tracking: " + e);
        }//end of tracking exception

        //type on Tracking Field using mouse click
        try{//find the unique xpath for the search field
            WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-inpur']"));
            //declare .click and SendKeys. It is important to do that because in some websites it will not let you just immediately type.
            mouseAction.moveToElement(trackingField).click().sendKeys("12345678").perform();
        } catch (Exception e) {//declare what you want to write out and find in your catch exception.
            System.out.println("Unable to type on Tracking Input: " + e);
        }//end of tracking input exception
        driver.quit();



    }//end of main
}//end of class
