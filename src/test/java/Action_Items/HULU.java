package Action_Items;

import DAY1_08JAN.Reusable_Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class HULU {


        //declare the driver outside of the annotations
        WebDriver driver;


        @BeforeSuite
        public void SetTheDriver() throws InterruptedException {
                driver = Reusable_Actions.setDriver();

        }//end of preconditions

        @Test (priority = 1)
        public void huluAccount () throws InterruptedException {

                //first set the arraylists to fill in for the desired loop and project

                //create array list for email
                ArrayList<String> email = new ArrayList<>();
                email.add("MountainDue@yahoo.com");
                email.add("Pepsiicoal@gmail.com");


                //create an arraylist for passwords
                ArrayList<String> password = new ArrayList<>();
                password.add("dewmounatin123");
                password.add("colaforever24");


                //create an arraylist for Name
                ArrayList<String> name = new ArrayList<>();
                name.add("Doritos");
                name.add("Lays");

                //create an arraylist for Birth Month
                ArrayList<String> month = new ArrayList<>();
                month.add("January");
                month.add("July");

                //create an arraylist for Birth Day
                ArrayList<String> day = new ArrayList<>();
                day.add("11");
                day.add("4");

                //create an arraylist for Birth Year
                ArrayList<String> year = new ArrayList<>();
                year.add("1998");
                year.add("2000");

                //create an arraylist for Gender
                ArrayList<String> gender = new ArrayList<>();
                gender.add("Male");
                gender.add("Female");

                //create a loop so that the program will run each array listed
                for (int i = 0; i < email.size(); i++) {

                        //navigate to Hulu website ( place inside loop so it can repeat for the second time )
                        driver.navigate().to("https://www.hulu.com");
                        Thread.sleep(2000);

                        //place all actions within the loop to execute

                        //Step 1: Verify if title is correct says "Stream TV and Movies"
                        String actualTitle = driver.getTitle();
                        if (actualTitle.contains("Stream TV and Movies")) {
                                System.out.println("Title matches for Hulu");
                        } else {
                                System.out.println("Title doesn't match. Actual title is " + actualTitle);
                        }// end of title verification




                        //Step 2: Scroll to the bottom of the page using Javascript Executor - Pixels
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("window.scrollBy(0,3500)");

                        //Step 3:Click on Select Button for 30 day trial
                        Reusable_Actions.clickMethod(driver, "//*[@class = 'button--cta button--black plan-card__cta plan-card__0_cta button--black ']", " selectButton");

                        //Step 4:Enter in Your email
                        Reusable_Actions.sendKeysMethod(driver, "//*[@id = 'email']", email.get(i), " enter_Email");

                        //Step 5:Enter Password
                        Reusable_Actions.sendKeysMethod(driver, "//*[@id = 'password']", password.get(i), " enter_Password");

                        //Step 6:Enter Name
                        Reusable_Actions.sendKeysMethod(driver, "//*[@id = 'firstName']", name.get(i), " enter_Name");

                        //Step 7:Click Birth Month and select January
                        Reusable_Actions.clickMethod(driver, "//*[text()='Month']", "Birthday Month");
                        Thread.sleep(2000);
                        Reusable_Actions.clickMethod(driver, "//*[text()='" + month.get(i) + "']" , "January");

                        //Step 8:Click Birth Day
                        Reusable_Actions.clickMethod(driver, "//*[text() = 'Day']", "Day");
                        Thread.sleep(2000);
                        Reusable_Actions.clickMethod(driver, "//*[text()= '" + day.get(i) + "']", "Date");

                        //Step 9:Click Birth Year
                        Reusable_Actions.clickMethod(driver, "//*[text() = 'Year']", "Year");
                        Thread.sleep(2000);
                        Reusable_Actions.clickMethod(driver, "//*[text()= '" + year.get(i) + "']", "Birth Year");

                        //Step 10:Enter Gender
                        Reusable_Actions.clickMethod(driver, "//*[text() = 'Select']", "Gender");
                        Thread.sleep(2000);
                        Reusable_Actions.clickMethod(driver, "//*[text() = '" + gender.get(i) + "']", "What are you?");

                        //Step 11:Click on Continue Button
                        Reusable_Actions.clickMethod(driver, "//*[@class = 'button button--continue ']", "Continue");
                        Thread.sleep(10000);

                        //Step 12:Capture the subscription price and print it
                        System.out.println(Reusable_Actions.getTextMethod(driver, "//*[text()= '$6.99/mo' ]", "Subscription"));
                        Thread.sleep(2000);

                        //Step 13:Capture Due today amount and Print it
                        System.out.println(Reusable_Actions.getTextMethod(driver, "//*[@class = 'ledger__summary']", "Due Today"));
                        Thread.sleep(2000);
                        
                        //Step 14: clear all cookies so the information isn't stored and can be used again
                        driver.manage().deleteAllCookies();
                }//end of loop
        }//end of Test 1

        //Test 2 that depends on the previous Test using dependsOnMethods = " previous class "
        @Test (dependsOnMethods = "huluAccount")
                public void huluLogin () throws InterruptedException {

                //navigate to hulu website
                driver.navigate().to("https://www.hulu.com/welcome");

                //click on the login button onn top right
                Reusable_Actions.clickMethod(driver, "//*[text() = 'Log In']", "Log in Button");

                //enter email in the text box
                Reusable_Actions.sendKeysMethod(driver,"//*[@id = 'email_id']", "MountainDue@yahoo.com", "email");

                //enter password in the text box
                Reusable_Actions.sendKeysMethod(driver,"//*[@class = 'jsx-4282396490 hulu-login-input']", "dewmounatin123", "password");

                //Click on Log In Button
                Reusable_Actions.clickMethod(driver, "//*[text() = 'LOG IN']", "Log IN");
                Thread.sleep(3000);

        }// end of test 2

      @AfterSuite
        //close window
        public void closeDriver() {
                driver.quit();
        }

}// end of class
