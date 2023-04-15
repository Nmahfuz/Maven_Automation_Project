package ActionItem6;

import ReusableLibrary.ReusableAnnotation;
import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static ReusableLibrary.ReusableAnnotation.driver;

public class FidelisCare extends ReusableAnnotation {
    @Test(priority = 1)
    public void getDentalCoverage() throws InterruptedException {
        driver.navigate().to("https://www.fideliscare.org");
        //click on search field
        ReusableMethods.clickMethodByIndex(driver, "//a[@class='dropdown-toggle']", 1, "Search Field");
        //enter dental coverage on search field
        Thread.sleep(3000);
        ReusableMethods.sendKeysMethodindex(driver, "//input[@class='form-control search-input']", 1, "dental coverage", "search field");
        //click on search icon
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='fal fa-search']", 1, "Search");
        String result = ReusableMethods.captureTextMethod(driver, "//*[@id='resInfo-0']", "Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Search Number for " + arrayResult[1]);
        Thread.sleep(3000);
        ReusableMethods.clickMethod(driver, "//a[@class='gs-title']", "Link");
    }//end of test 1

    @Test(dependsOnMethods = "getDentalCoverage")
    public void enterInfo() throws InterruptedException {
        //switch to new tab
        ReusableMethods.switchToTabByIndex(driver, 1, "tab");
        Thread.sleep(2000);
        // type in first name the name box
        ReusableMethods.sendKeysMethod(driver, "//*[@id='firstName']", "John", "First name box");
        Thread.sleep(2000);
        //type in Last name  to the box
        ReusableMethods.sendKeysMethod(driver, "//*[@id='lastName']", "Doe", "Last Name Box");
        Thread.sleep(1000);
        //enter zipcode on the zipcode field
        ReusableMethods.sendKeysMethod(driver, "//*[@id='zipCode']", "11232", "Zipcode Field");
        Thread.sleep(1500);
        //enter phone number
        ReusableMethods.sendKeysMethod(driver, "//*[@id='phoneNumber']", "7185936187", "phone number");
        //click on Kings from dropdown
        ReusableMethods.clickMethod(driver, "//*[text()='Kings']", "Kings County ");
        Thread.sleep(1000);
        ReusableMethods.sendKeysMethod(driver, "//*[@id='email']", "JDOE1234@gmail.com", "Email");
        //click on check box
        ReusableMethods.clickMethodByIndex(driver, "//*[@for='contactMe']", 1, "Contact me checkbox");
        //click on the contact me box
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='btn btn-primary']", 4, "Contact me box");
        //capture text
        String Result = ReusableMethods.captureTextMethod(driver, "//*[@class='alert alert-success']", "text");
        String[] splitText = Result.split(" A representative");
        System.out.println(splitText[0]);
        //close the driver
        driver.close();
    }// end of test 2

    @Test(dependsOnMethods = {"getDentalCoverage", "enterInfo"})
    public void TestCase3() {
        ReusableMethods.switchToTabByIndex(driver, 0, "switched tab");
        //click on login
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='dropdown-toggle']", 0, "login");
        //click on the member online portal
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='link-external']", 0, "memebr link");
        //switch back to the tab
        ReusableMethods.switchToTabByIndex(driver, 1, "switch back to first tab");
        //capture the text
        String result = ReusableMethods.captureTextMethod(driver, "//*[@class='tipsContentText']", "Text");
        System.out.println(result);

    }// end of test 3
}//end of class




