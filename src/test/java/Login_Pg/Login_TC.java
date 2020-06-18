package Login_Pg;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.omg.PortableServer.RequestProcessingPolicyOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Com.Report_Utility.Listener;
import Com.Report_Utility.Report_Utility;
import Com.Tekarch.Utilities.TestBase;
import Com.Tekarch.Utilities.WebdriverUtility;
@Listeners(Listener.class)

public class Login_TC extends TestBase {

	@Test
	public void TC_LoginPg() throws Exception {

		Logger log = Logger.getLogger(getClass().getSimpleName());
		re.CreateReport();
		re.CreateTestCase("LoginTestCase");
		WebdriverUtility.WebdriverLaunch("ch");
		log.info("Webdriver launched");

		WebdriverUtility.LoginFunction("tekarch");
		log.info("Login done Successfully");

	}

}
