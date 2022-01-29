package DAY1_08JAN;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.swing.interop.SwingInterOpUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseAction_USPS {

    public static void main(String[] args) throws InterruptedException {


        //Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        //Declare and Define the Chrome Options
        ChromeOptions options = new ChromeOptions();
        //Declare all the arguments needed
        //Maximize the Driver
        options.addArguments("start-maximized");
        //Set Incognito Mode
        options.addArguments("incognito");
        //Set as Headless(Running the Driver on Background)
        //options.addArguments("headless");
        //Define the Web Driver you are using
        WebDriver driver = new ChromeDriver(options);

        //Navigate to USPS
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);

        //Verify the Welcome "Page Title" Appears as Expected
        String actualTitle = driver.getTitle();

        //By using if else to compare expected with actual title
        if (actualTitle.equals("Welcome | USPS ")){
            System.out.println("Title Matches" + actualTitle);
        }else{
            System.out.println("Title does not match" + actualTitle);
        }// end of Page title


        //Declare Mouse Actions
        Actions mouseAction = new Actions(driver);


        //Hover over Send Tab to Open Up the Drop Down List
        try{
            WebElement sendTab = driver.findElement(By.xpath("//*(text()='Send']"));
                mouseAction.moveToElement(sendTab).perform();
        } catch (Exception e) {
            System.out.println("Unable to Hover to Send Tab" + e);
        } //end of Hover

        //Click on ZipCode
        try{
            WebElement zipCodeLookup = driver.findElement(By.xpath("//*(text()='Look Up Zip Code]"));
                mouseAction.moveToElement(zipCodeLookup).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to look up zip code" + e);
        }

        //Close Window
        Thread.sleep(2000);
        driver.close();


    }//end of main

}//end of java
