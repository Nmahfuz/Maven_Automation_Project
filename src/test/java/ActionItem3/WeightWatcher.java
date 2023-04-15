package ActionItem3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WeightWatcher {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //maximize
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        // Wait for page to load and navigate to Weight Watchers workshop page
        driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

        // Create an ArrayList to store 3 different real zip codes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11412");
        zipCode.add("11101");
        zipCode.add("11375");



        for (int i = 0; i < zipCode.size(); i++) {

            driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipCode.get(i));


            driver.findElement(By.xpath("//*[@id='location-search-cta']")).submit();
            Thread.sleep(2000);

            ArrayList<WebElement> studio = new ArrayList<>(driver.findElements(By.xpath("//*[contains(text(),'WW Studio @ ')]")));
            ArrayList<WebElement> Address = new ArrayList<>(driver.findElements(By.className("address-3-YC0")));

            if (i==0){
                System.out.println("First address: " + Address.get(0).getText());
                studio.get(1).click();
            } else if (i==1){
                System.out.println("second address: " + Address.get(0).getText());
                studio.get(2).click();
            } else if (i==2){
                System.out.println("Third address: " + Address.get(0).getText());
                studio.get(3).click();
            }//end of statements
            Thread.sleep(2000);


            WebElement inPerson =driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("arguments[0].scrollIntoView(true);" , inPerson);

            System.out.println(driver.findElement(By.className("scheduleContainerMobile-1RfmF")).getText());

            driver.navigate().back();

            Thread.sleep(5000);

            driver.findElement(By.xpath("//*[@id='location-search']")).clear();



        }// end of for loop

        driver.quit();




    }//end of main
}//end of class
