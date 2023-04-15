package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Xpath_Text {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //define the chrome driver you will use to perform the automation test
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.Google.com");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='About']")).click();


    }// end of main
}// end of class

