package Day4_030523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.xpath;

public class T1_GoogleHome {

        public static void main(String[] args) throws InterruptedException {

            //setup your driver through web driver manager
            WebDriverManager.chromedriver().setup();

            //define the chrome driver that you will use for automation test
            WebDriver driver = new ChromeDriver();

            //navigate to google homepage
            driver.navigate().to("https://www.google.com");
            //maximize the browser
            //driver.manage().window().maximize();//windows
            // driver.manage().window().fullscreen();//mac

            //wait for two seconds
            Thread.sleep(2000);

            //enter keyword bmw to search field
            driver.findElement(xpath("//*[@name='q']")).sendKeys("BMW");

            //click on google search button
            driver.findElement(xpath("//*[@name='btnK']")).submit();

            //whenever you go to a new page or navigate, always use 2-3 seconds wait to pause your script a bit
            Thread.sleep(2000);

            //capture the search resutls using the .getText()

            String result = driver.findElement(xpath("//*[@id='result-stats']")).getText();
            //System.out.println("Search results: " + result);
            //print out only the number
            String[] arrayResult = result.split(" ");
            System.out.println("Search Number:" + arrayResult[1]);
            String newResult = result.replace("(","").replace(")","");
            System.out.println("New Result: " + newResult);
            //print out only the number

            //simply close/quit the driver/browser
            driver.quit();


            //simply close the driver/browser
            //driver.close();

        }// end of main
    }//end of class

