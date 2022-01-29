package DAY1_08JAN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Wait_UPS {

    public static void main(String[] args) {

      WebDriver driver = Reusable_Actions.setDriver();

      //navigate to usps
        driver.navigate().to("https://www.ups.com/us/en/Home.page");

      //declaring explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);

      //Click on Track
      try{
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Tracking']"))).click();
      } catch (Exception e){
          System.out.println("Unable to click on Track" + e);
      } // end of Track

        //Click on Track a Package
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();
        } catch (Exception e){
            System.out.println("Unable to click on Track a Package" + e);
        } // end of Track a package




    }//end of main

}// end of java
