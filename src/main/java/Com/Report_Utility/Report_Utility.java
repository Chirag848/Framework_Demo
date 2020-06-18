package Com.Report_Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.Tekarch.Utilities.WebdriverUtility;

public class Report_Utility {
	public static ExtentReports reports;
	public static ExtentTest logger;

	public void CreateReport() {
		String uniqueDateTime = new SimpleDateFormat("'SampleDemo_'yyMMddHmm''").format(new Date());
		String sPath = System.getProperty("user.dir") + "//ExtentReport//sampleReport_" + uniqueDateTime + ".html";
		reports = new ExtentReports(sPath); //it will start creating html report.
		
		}

	public void CreateTestCase(String sName) {
		logger = reports.startTest(sName);
	}

	public void EndTestCase() {
		reports.endTest(logger);
	}

	public void EndReport() {
		reports.flush();
		System.out.println("Report Done Successfully");
	}

	public void TakeScreenShot() throws Exception {
		TakesScreenshot ts = (TakesScreenshot)WebdriverUtility.driver; // screenshot set up is done
		File source = ts.getScreenshotAs(OutputType.FILE);//taking the screenshot and saving in into source
		String sPathofDestination = System.getProperty("user.dir")+"//ScreenShot//2.png";
		File dest = new File(sPathofDestination);
		FileUtils.copyFile(source, dest);
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathofDestination));
		Report_Utility.logger.log(LogStatus.PASS, "Test Case Passed");
		EndTestCase();
		EndReport();
	}
}
