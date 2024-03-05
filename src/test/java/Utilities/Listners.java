package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listners extends BaseClass implements ITestListener {

	ExtentReports extent = ExtentReport.getExtentReport();

	// Each Test report it will collect and push to report
	ExtentTest test;
	ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentThread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentThread.get().log(Status.PASS, "This case is success");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentThread.get().fail(result.getThrowable()); // it will print the error in report

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			// getTestClass() --> This will refer class which is mentioned in .xml file.
			// getRealClass() --> This will refer actual class where methods present.
			// getField("driver") -->Test case driver we are getting here bcz driver is
			// class level not method level.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filePath = null;
		try {
			filePath = TakeScreenshot_Of_Failure(result.getMethod().getMethodName(), driver);

		} catch (Exception e) {
			// TODO: handle exception
		}

		extentThread.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		extentThread.get().skip(result.getThrowable());

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// we need to flush at the end of the test otherwise it will not create report
		extent.flush();

	}

}
