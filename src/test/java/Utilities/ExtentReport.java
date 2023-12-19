package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	// put static to access in another class
	public static ExtentReports getExtentReport() {
		// get the path for store report in project.
		// get class for creating report.
		// get report from above class and give it to
		String reportPath = System.getProperty("user.dir") + "\\Reports\\report.html";
//		String reportPath = System.getProperty("user.dir" + "\\Report\\Reports.html");

		ExtentSparkReporter makeReport = new ExtentSparkReporter(reportPath);
		makeReport.config().setDocumentTitle("Money Mart Report");
		makeReport.config().setReportName("Money mart extent report");

		ExtentReports testResult = new ExtentReports();
		testResult.attachReporter(makeReport);
		testResult.setSystemInfo("Saidachary", "Testing Engineer");
		return testResult;

	}

}
