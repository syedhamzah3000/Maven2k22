package WEEK6.Day1;

import DAY1_08JAN.Reusable_Actions;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class GoogleSearch_DataDriven {

    WebDriver driver;

    public GoogleSearch_DataDriven() throws BiffException, IOException {
    }

    @BeforeSuite
    public void setDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of before suite

    @Test
    public void GoogleSearchDataDriven() throws BiffException, IOException {
        //Step 1: read the data from the excel sheet you created
         Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/GoogleSearch.xls"));
        // Step 2: locating the worksheet that you created for the workbook
         Sheet readableSheet = readableFile.getSheet(0);
        //will return the physical rows present on the sheet
        int rowCount = readableSheet.getRows();
        System.out.println("My row count is " + rowCount);

        //Step 3: create a writable file to mimic readable but you can also write back the results to this file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/GoogleSearch_Results.xls"),readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);//will return the physical rows present on the sheet
        int rowCount2 = writableSheet.getRows();
        System.out.println("My writable row count is " + rowCount2);

        //generate the for/while loop
        int i = 1;
        while( i < rowCount2){
        // store the countries list as a variable
        String countries = writableSheet.getCell(0,i).getContents();
        System.out.println("My values are " + countries);
        //increment
            i = i+1;
        }//end of loop

    } //end of test

}//end of java
