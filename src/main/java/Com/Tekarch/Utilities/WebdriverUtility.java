package Com.Tekarch.Utilities;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Com.Report_Utility.Report_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverUtility {
	public static WebDriver driver;
	public static Report_Utility re = new Report_Utility();

	public static void WebdriverLaunch(String sBroswer) throws Exception {
		if (sBroswer.startsWith("ch")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else {
			System.out.println("Please Provide proper Broswer");
		}
		re.logger.log(LogStatus.INFO, "Webdriver Launched");

	}

	public static void LoginFunction(String sURL) throws Exception {

		if (sURL.contains("tekarch")) {
			driver.get(System.getProperty("TekarchURl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
			driver.findElement(By.id("email_field")).sendKeys(System.getProperty("TekarchemailId"));
			driver.findElement(By.id("password_field")).sendKeys(System.getProperty("TekarchPassWord"));
			// System.out.println(driver.findElement(By.xpath("//div[@id='login_div']")).getText());
			driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
			re.logger.log(LogStatus.INFO, "Login Successfully");
		}
		if (sURL.contains("salesforce")) {
			driver.get(System.getProperty("SalesForceURl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			waitforloadthepageElement(driver.findElement(By.id("username")));
			driver.findElement(By.id("username")).sendKeys(System.getProperty("SalesForceEmail"));
			driver.findElement(By.id("password")).sendKeys(System.getProperty("SalesForcePassword"));
			driver.findElement(By.id("Login")).click();
			re.logger.log(LogStatus.INFO, "Login Successfully");
		}
	}

	public static void waitforloadthepageElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void DriverQuit() {
		driver.quit();
	}
}
