package DAY1_08JAN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Implicit_Wait_UPS {
    public static void main(String[] args) throws InterruptedException {

    WebDriver driver = Reusable_Actions.setDriver();

    //declare and define your global implicit wait for all web elements
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    //navigate to UPS
        driver.navigate().to("https://www.ups.com/us/en/Home.page");

    //Click on Track
    driver.findElement(By.xpath("//*[text()='Tracking']")).click();

    //Click On Track a Package
    driver.findElement(By.xpath("//*[text()='Track a Package']")).click();

    //close window
    Thread.sleep(2000);
    driver.close();

    }//end of main
}//end of java
