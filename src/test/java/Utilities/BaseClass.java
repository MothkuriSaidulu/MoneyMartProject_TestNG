package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

// Import Page Classes

import PageObject.Page_004_DashBoardPage;
import PageObject.Page_005_WelcomePage;
import PageObject.Page_007_Verify_Your_Income_Page;
import PageObject.Page_008_EmployerInformation;
import PageObject.Page_009_Picra_Screen;
import PageObject.Page_001_HomePage;
import PageObject.Page_002_SignInPage;
import PageObject.Page_003_SignUpPage;

public class BaseClass {

	public WebDriver driver;

	public Page_001_HomePage HomePageObject;
	public Page_002_SignInPage SignInPageObject;
	public Page_003_SignUpPage SignUpPageObject;
	public Page_004_DashBoardPage DashBoardObject;
	public Page_005_WelcomePage wellComeObject;
	public Page_007_Verify_Your_Income_Page IncomePageObject;
	public Page_008_EmployerInformation EmployerInformationOObject;
	public Page_009_Picra_Screen Picra_Screen_Page_Object;
	
	public WebDriver initiateBrowser() throws IOException {

		Properties prop = new Properties();

		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);

		String browserName = prop.getProperty("Browser");

		if (browserName.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();

		} else if(browserName.contains("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		return driver;
	}

// Every test execution below method will execute first
	@BeforeMethod
	public void launchWebUrl() throws IOException {
		driver = initiateBrowser();

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);
		String url = prop.getProperty("Url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}

	
	// put static to access in another class
	public static ExtentReports getExtentReport() {
		// get the path for store report in project.
		// get class for creating report.
		// get report from above class and give it to

		String reportPath = System.getProperty("user.dir" + "\\Report\\Report.xml");

		ExtentSparkReporter makeReport = new ExtentSparkReporter(reportPath);
		makeReport.config().setDocumentTitle("Money Mart Report");
		makeReport.config().setReportName("Money mart extent report");

		ExtentReports testResult = new ExtentReports();
		testResult.attachReporter(makeReport);
		testResult.setSystemInfo("Saidachary", "Testing Engineer");
		return testResult;

	}

}