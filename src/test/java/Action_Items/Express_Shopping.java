package Action_Items;

import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class Express_Shopping extends Reusable_Annotations {


    //declare the global variable before the annotations methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    @BeforeSuite
    public void setDriver(){

    }



}//end of java
