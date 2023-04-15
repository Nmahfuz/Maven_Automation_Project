package ReusableLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableMethods_Logger {
    //create a return method to return the web driver you are going to use on your test classes
    //static command allows your method to be global
    public static WebDriver defineChromeDriver() {
        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("incognito");
        //options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //set maximized for mac users
        driver.manage().window().maximize();

        return driver;

    }//end of web driver method

    //return method will execute your statements along with returning some conditions/value
    //example of return methods are only WebDriver method & getText action

    //void method will only perform the action but won't return anything
    //void actions are click, sendKeys, scrolling, submit, select, mouse hover, clear

    //click action is one of the type of void method

    //capture a text and return it using return method
    public static String captureTextMethod(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from element " + elementName);
            logger.log(LogStatus.PASS,"Successfully captured a text from element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text from element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
        return  result;
    }//end of get text method

    //click action is one of the type of void method

    //submit action is one of the type of void method
    public static void submitMethod(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submit on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of submit method
    //click action is one of the type of void method
    public static void clickMethod(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click method


    //click action is one of the type of void method
    public static void clickMethodByIndex(WebDriver driver,String xpath,int index,ExtentTest logger,String elementName){
        WebDriverWait wait =  new WebDriverWait(driver,10);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click method by index

    //click action is one of the type of void method
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
            logger.log(LogStatus.PASS,"Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to enter a value on element " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of sendkeys method

    //click action is one of the type of void method
    public static void sendKeysMethodindex(WebDriver driver, String xpath, int index, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on element " + elementName + ": " + e);
        }
    }//end of send keys index method



    //capture a text using the SelectByText Method
    public static void selectByTextMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select elementByText = new Select(element);
            elementByText.selectByVisibleText(userValue);
            System.out.println("Successfully selected element by text " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select element by text " + elementName + ": " + e);
        }
    }//end of select by text method

    // Method to scroll to a web element
    public static void scrollByElement(WebDriver driver, String xpath, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("Successfully scrolled into view " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll into view " + elementName + ": " + e);
        }//end of exception
    }//end of scroll into view method

    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, String elementName) {
        //store the xpath in boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState == expectedValue) {
                System.out.println("Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element  " + elementName + " " + e);
        }//end of exception
    }//end of verifyBooleanStatement

    public static void switchToTabByIndex(WebDriver driver, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        try {

            driver.switchTo().window(tabs.get(index));
            System.out.println("Succesfully switched to " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to switch to " + elementName + " because " + e);
        }//end of exception
    }//end of select method

    public static void scrollByPixel(WebDriver driver, String scrollValue) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollValue);
    }//end of scrollByPixel
    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!! " + e);
        }
    }//end of getScreenshot method
}

