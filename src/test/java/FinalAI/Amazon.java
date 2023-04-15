package FinalAI;

import ReusableLibrary.ReusableAnnotation;
import ReusableLibrary.ReusableMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Amazon extends ReusableAnnotation {

    @Test(priority = 1)
    public void AmazonBedsheets() throws InterruptedException {
        //navigate to amazon website
        driver.navigate().to("https://www.amazon.com");
        //type on the search field for bedsheets
        ReusableMethods.sendKeysMethod(driver, "//*[@id='twotabsearchtextbox']", "Bedsheets", "Search");
        //Click on the search icon
        ReusableMethods.clickMethod(driver, "//*[@class='nav-search-submit nav-sprite']", "Search icon");
        Thread.sleep(3000);
        //click on the second bedsheet
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='s-image']", 2, "Bedsheet");
        Thread.sleep(3000);
        //click on the color red
        ReusableMethods.clickMethodByIndex(driver, "//*[@class = 'a-button a-button-toggle image-swatch-button']", 4, "Red");
    }// End of Test one

    @Test (priority = 2)
    public void amazonPillows() throws InterruptedException {
        Thread.sleep(3000);
        //add the bedsheets
        ReusableMethods.clickMethod(driver,"//*[@id='add-to-cart-button']","Add to cart");
        //return back to the main page by clicking on the amazon logo
        ReusableMethods.clickMethod(driver,"//*[@class='nav-logo-link nav-progressive-attribute']","Amazon logo");
        //search up pillow covers
        ReusableMethods.sendKeysMethod(driver, "//*[@id='twotabsearchtextbox']", "pillow covers", "Search");
        Thread.sleep(3000);
        // click on search icon
        ReusableMethods.clickMethod(driver, "//*[@class='nav-search-submit nav-sprite']", "Search icon");
        //capture the search result
        String searchAmount = ReusableMethods.captureTextMethod(driver,"//*[@class='a-section a-spacing-small a-spacing-top-small']", "Results");
        String [] resultNumber = searchAmount.split(" ");
        System.out.println("The search result is " + resultNumber[3]);

    }//end of test two

    @Test (priority = 3)
    public void amazonBlanket() throws InterruptedException {
        Thread.sleep(3000);
        //return back to the main page by clicking on the amazon logo
        ReusableMethods.clickMethod(driver, "//*[@class='nav-logo-link nav-progressive-attribute']", "Amazon logo");
        //search up blankets
        ReusableMethods.sendKeysMethod(driver, "//*[@id='twotabsearchtextbox']", "Blankets", "Search");
        // click on search icon
        ReusableMethods.clickMethod(driver, "//*[@class='nav-search-submit nav-sprite']", "Search icon");
        //click on the first searched up option
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='s-image']", 0, "First Blanket");
        Thread.sleep(2000);
        //click add to cart
        ReusableMethods.clickMethod(driver,"//*[@id='add-to-cart-button']","Add to cart");
    }//end of test three

        @Test (priority = 4)
         public void amazonPictureFrame () throws InterruptedException {
            //return back to the main page by clicking on the amazon logo
            ReusableMethods.clickMethod(driver, "//*[@id='nav-logo-sprites']", "Amazon logo");
            Thread.sleep(4000);
            //search up picture frames
            ReusableMethods.sendKeysMethod(driver,"//*[@id='twotabsearchtextbox']","frames","search");
            Thread.sleep(3000);
            //click on the search icon
            ReusableMethods.clickMethod(driver, "//*[@class='nav-search-submit nav-sprite']", "Search icon");
            //click on the second option for frames
            ReusableMethods.clickMethodByIndex(driver,"//*[@class='a-size-base-plus a-color-base a-text-normal']",1,"Second frame");
            Thread.sleep(4000);
            //add it to the cart
            ReusableMethods.clickMethod(driver,"//*[@id='add-to-cart-button']","Add to cart");

        }//end of test four
        @Test (priority = 5)
    public void signIntoAmazon (){
            //return back to the main page by clicking on the amazon logo
            ReusableMethods.clickMethod(driver, "//*[@id='nav-logo-sprites']", "Amazon logo");
            //sign in into amazon account
            ReusableMethods.clickMethod(driver, "//*[@id = 'nav-link-accountList']","Sign into Amazon");
            //Enter username or email
            ReusableMethods.sendKeysMethod(driver,"//*[@id='ap_email']","Sign in","Log in");
        }//end of test five
         }//end of class
//end of action item



