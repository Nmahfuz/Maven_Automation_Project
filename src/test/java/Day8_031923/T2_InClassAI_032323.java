package Day8_031923;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class T2_InClassAI_032323 {
    public static void main(String[] args) throws InterruptedException {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //add maximize for windows
        options.addArguments("start-maximized");

        //add incognito mode
        options.addArguments("incognito");

        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});


        //options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);

        //Arraylist of the places
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Mexico");
        countries.add("Canada");
        countries.add("Indonesia");


        for (int i = 0; i < countries.size(); i++) {
            //navigate to hotels.com page
            driver.navigate().to("https://www.hotels.com");
            Thread.sleep(1000);
            //Click on search field
            try {
                driver.findElement(By.xpath("//*[@data-stid='destination_form_field-menu-trigger']")).click();
                System.out.println("Successfully clicked search button");

            } catch (Exception e) {
                System.out.println("Failed clicked search button");
            }

            try {
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(countries.get(i));
                Thread.sleep(2000);
                System.out.println("Successfully typed within the search button");
                ArrayList<WebElement> countriesResults = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='destination_form_field-result-item']")));
                countriesResults.get(0).click();
            } catch (Exception e) {
                System.out.println("Failed typing within search button");
            }//end of typing exception

            //click on adult list
            try {
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
                System.out.println("Successfully clicked on adult list");
            } catch (Exception e) {
                System.out.println("Failed to click on adult list");
            }


            try {
                WebElement minusBtn = driver.findElement(By.xpath("//*[@class='uitk-layout-flex-item uitk-step-input-touch-target']"));
                minusBtn.click();
                System.out.println("Successfully changed adult list to 1");
            } catch (Exception e) {
                System.out.println("Failed to change adult list 1");
            }

            try {
                driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(3).click();
                System.out.println("Successfully change child list to 1");
            } catch (Exception e) {
                System.out.println("Failed to change child list to 1");
            }//end of changing child list to 1 exception
            Thread.sleep(2000);


            WebElement childAge = driver.findElement(By.xpath("//*[@class='uitk-field-select']"));
            Select dropDown = new Select(childAge);
            dropDown.selectByVisibleText("1");

            //click on Done
            try {
                WebElement Done = driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']"));
                Done.click();

            } catch (Exception e) {
                //print error statement
                System.out.println("Unable to click Done" + e);
            }

            try {
                WebElement Search = driver.findElement(By.xpath("//*[@id='search_button']"));
                Search.click();
            } catch (Exception e) {
                System.out.println("unable to click on the Search bar on top right corner" + e);
                Thread.sleep(2000);
            }
            //create ArrayList to click on the available hotels
            ArrayList<WebElement> resort = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));

            try {
                if (i == 0) {
                    resort.get(1).click();
                }
            } catch (Exception e) {

                System.out.println("First condition failed" + e);
            }
            Thread.sleep(2000);
            try {
                if (i == 1) {
                    resort.get(2).click();
                }
            } catch (Exception e) {
                //print error statement
                System.out.println("unable to run second condition " + e);
            }
            Thread.sleep(2000);
            try {
                if (i == 2) {
                    //click the 2nd resort
                    resort.get(1).click();
                }

            } catch (Exception e) {
                //The error statement should be able to print
                System.out.println("unable to run third condition" + e);
            }

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);

            try {
                WebElement resortAddress = driver.findElement(By.xpath("//*[@data-stid='content-hotel-address']"));
                //print address
                System.out.println("Address: ");
                System.out.println(resortAddress.getText());
            } catch (Exception e) {
                //print error statement
                System.out.println("unable to print address" + e);
            }
            Thread.sleep(2000);
            //close tab
            driver.close();

            driver.switchTo().window(tabs.get(0));


        } //end of loop
        driver.quit();


    }//end of main
}//end of class