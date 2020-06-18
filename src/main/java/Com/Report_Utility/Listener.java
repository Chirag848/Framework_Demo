package Com.Report_Utility;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is :"+result.getName());					
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :"+result.getName());
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext result) {
		System.out.println(result.getName()+" test case started");
	}

	public void onFinish(ITestContext context) {

	}

}
