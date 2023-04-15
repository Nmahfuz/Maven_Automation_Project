package Day7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_SelectStatement {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //maximize
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
     //navigate to mortgage calculator page
        driver.navigate().to("https://www.mortgagecalculator.org");

        Thread.sleep(2000);

        //select start month as April from the dropdown using select function
        //store the start month locator as an WebElement

        WebElement srtMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //select the function of the dropdown locator
        Select startMonthDropdown = new Select(srtMonth);
        //select by visible text
       // startMonthDropdown.selectByVisibleText("Apr");
        //select by value
        //startMonthDropdown.selectByValue("4");
        //select by index
        //startMonthDropdown.selectByIndex(3);




    }//end of main
}//end of class
