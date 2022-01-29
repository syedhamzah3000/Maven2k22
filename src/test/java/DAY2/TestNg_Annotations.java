package DAY2;

import DAY1_08JAN.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.ArrayList;

public class TestNg_Annotations {

    //declare the webdriver outside of the annotation methods so it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of precondition

    @Test
    public void googleSearchLoop(){
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Tesla");

        for(int i = 0; i < cars.size(); i++){
            //navigating to google
            driver.navigate().to("https://www.google.com");
            //entering a unique keyword from array list
            Reusable_Actions.sendKeysMethod(driver,"//*[@name='q']",cars.get(i),"Search Field");

        }

    }//end of test

    @AfterSuite
    public void endSession(){
        driver.quit();
    }
}//end of java
