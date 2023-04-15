package Day9_032523;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.WebDriver;

public class T4_ReuseableConceptsUPS {
    public static void main(String[] args) throws InterruptedException {
        WebDriver Driver = ReusableMethods.defineChromeDriver();

        //navigate to ups website
        Driver.navigate().to("http://www.ups.com/us");

        //click on shipping
        //your explicit wait condition replaces your driver.findElement(s)
        //presenceOfAllElementsLocatedBy is same as findElements
        ReusableMethods.clickMethod(Driver, "//*[@id='mainNavDropdown1']", "Shipping Link");

        //click on Schedule a Pickup
        //when you see element not interactable exception then you have to use Thread.sleep for few seconds before
        Thread.sleep(2000);
        ReusableMethods.clickMethod(Driver, "//*[text()='Schedule a Pickup']", "Schedule a Pickup");


        //click on Freight
        ReusableMethods.clickMethod(Driver, "//*[text()='Freight']", "Freight");
    }//end of main
}//end of class












