package Day13_040823;

import ReusableLibrary.ReusableAnnotation;
import ReusableLibrary.ReusableMethods_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import static ReusableLibrary.ReusableAnnotation.driver;



public class T2_Staple_Logger extends ReusableAnnotation {
    @Test(priority = 1)
    public void searchForIphoneonStaples(){
        logger.log(LogStatus.INFO,"Navigate to Staples home page");
        //navigate to staples home page
        driver.navigate().to("https://www.staples.com");

        //type on search field using sendkeys method
        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='searchInput']","iphone",logger,"Search Field");

        //click on the search icon
        ReusableMethods_Logger.clickMethod(driver,"//*[@class='search-bar-input__searchIcon']",logger,"Search Icon");
    }//end of test 1

    @Test(priority = 2)
    public void printOutSearchResultsForIphone() throws InterruptedException {
        //click on first image by index
        ReusableMethods_Logger.clickMethodByIndex(driver,"//*[@class='standard-tile__image standard-tile__image_hover']",0,logger,"Iphone Image");

        //click on add to the cart button
        ReusableMethods_Logger.clickMethodByIndex(driver,"//*[@id='ctaButton']",0,logger,"Add to cart");

        //capture the starting price and print it out
        Thread.sleep(3000);
        String result = ReusableMethods_Logger.captureTextMethod(driver,"//*[contains(text(),'starting at')]",logger,"Starting Price");
        System.out.println("Iphone result is " + result);
        logger.log(LogStatus.INFO,"Iphone result is " + result);
    }//end of test 2
}
