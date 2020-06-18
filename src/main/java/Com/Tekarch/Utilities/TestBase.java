package Com.Tekarch.Utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Com.Report_Utility.Listener;
import Com.Report_Utility.Report_Utility;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	public static Report_Utility re = new Report_Utility();
	public static AndroidDriver<WebElement> driver = null;
	public static Listener lst =  new Listener();

	public static CommonUtility obj_coUtility = new CommonUtility();
	public static WebdriverUtility driverUtility = new WebdriverUtility();
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeSuite
	public void TriggerinBeforeSuiteDependency() throws Exception {
		obj_coUtility.LoadPropertyFile();
		obj_coUtility.LoadLog4jPropertyFile();
	}

	@AfterMethod
	public void ScreenShotReport() throws Exception {
		re.TakeScreenShot();
		log.info("Screenshot taken Successfully");
	}

	@AfterSuite
	public void tearDownDependency() {
		driverUtility.DriverQuit();
		log.info("Webdriver Closed");
	}

}
