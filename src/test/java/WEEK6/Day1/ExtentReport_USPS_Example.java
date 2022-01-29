package WEEK6.Day1;

import DAY1_08JAN.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ExtentReport_USPS_Example extends Reusable_Annotations {

    @Test()
    public void uspsTest(){
        //navigate to usps
        logger.log(LogStatus.INFO,"Navigate to Usps Home Page");
        driver.navigate().to("https://www.usps.com");

        //hover to the quick tool tab
        Reusable_Actions_Loggers.mouseHover(driver,"//*[text() = 'Quick Tools']", logger, "Quick Tool");

        //click on track a package
        Reusable_Actions_Loggers.clickMethod(driver, "//*[text() = 'Track a Package']", logger, "Track Package");

        //enter a tracking number
        Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@id ='tracking-input']", "111111111111", logger, "Tracking Number");

        //click on track button
        Reusable_Actions_Loggers.clickMethod(driver, "//*[text() = 'Track']",logger,"Track");






    }//end of test


}//end of java
