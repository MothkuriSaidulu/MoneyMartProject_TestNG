package PageObject;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class Page_003_SignUpPage extends AbstractClass {

	public WebDriver driver;

	public Page_003_SignUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='mm-login-page__title']")
	private WebElement signUpText;

	// Type 1
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	private WebElement firstName_txt;

	// Type 2
	// By userName2 = By.xpath("//input[@id='userEmail']");

	// Type 3
	@FindBy(css = "input[name='lastName']")
	private WebElement lastName_txt;

//	@FindBy(css = "button[class='arrowbtn']")	
	@FindBy(xpath = "//input[@placeholder='YYYY/MM/DD']")
	private WebElement DOB_btn;

	@FindBy(xpath = "//div[@class='mm-calendar__wrapper'] //select[@name='year']")
	private WebElement yearDropDown;

	@FindBy(xpath = "//select[@name='year'] //option")
	private List<WebElement> yearsList;

	@FindBy(xpath = "//div[@class='mm-calendar__wrapper'] //select[@name='month']")
	private WebElement monthDropDown;

	@FindBy(how = How.XPATH, using = "//select[@name='month'] //option")
	private List<WebElement> monthList;

	@FindBy(xpath = "//div[@class='mm-calendar__wrapper'] //div[@class='mm-calendar__day ']")
	private List<WebElement> daysList;

	@FindBy(css = "input[name='phoneNumber']")
	private WebElement phoneNumber_txt;

	@FindBy(css = "input[name='email']")
	private WebElement email_txt;

	@FindBy(xpath = "//span[@class='mm-select']")
	private WebElement securityDropDown;

	@FindBy(xpath = "//div[@class='mm-dropdown__menu'] //button")
	private List<WebElement> securityOptions;

	@FindBy(css = "input[aria-label='securityQuesAns']")
	private WebElement securityQuesAns;

	@FindBy(xpath = "//input[@name='newPassword']")
	private WebElement newPassword_txt;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement confirmPassword_txt;

	@FindBy(xpath = "//button[@value='Create Account']")
	private WebElement CreateAccountBtn;

	@FindBy(xpath = "//div[@class='mm-alert mm-alert--success']")
	private WebElement successMessage;


	
// Actions
	public void send_First_Name() throws IOException {
	

		enterText(firstName_txt, "jimm", "User trying To Enter First Name");
	}

	public void send_Last_Name() {
//		lastName_txt.sendKeys("mike" + randomString());

//		enterText(lastName_txt, "Mike" + randomString(), "Enter last Name");

		lastName_txt.sendKeys("mike");

	}

	public void select_Date_Of_Birth() throws IOException, InterruptedException {

//		DOB_btn.sendKeys(generateDynamicDOB());

		enterText(DOB_btn, generateDynamicDOB(), "User Entering Date Of Birth");

//		DOB_btn.click();
//
//		waitForElementToBeVisible(yearDropDown, "yearDropDown");
//		yearDropDown.click();
//
////		Properties prop = new Properties();
////		FileInputStream file = new FileInputStream("config.properties");
////		prop.load(file);
////		String configYear = prop.getProperty("Year");
//
//		String configYear = properties("Year");
//
//// Select year
//
//		for (int i = 0; i < yearsList.size(); i++) {
//			String webYear = yearsList.get(i).getText();
//			if (webYear.contains(configYear)) {
//				yearsList.get(i).click();
//
//			}
//		}
//
//// Select Month
//		waitForElementToBeVisible(monthDropDown, "monthDropDown");
//
////		String configMonth = prop.getProperty("Month");
//		String configMonth = properties("Month");
//
//		for (int i = 0; i < monthList.size(); i++) {
//			String webYear = monthList.get(i).getText();
//			if (webYear.contains(configMonth)) {
//				monthList.get(i).click();
//			}
//		}
//// Select day
//		waitListOFWebElementsToAppear(daysList);
////		String configDay = prop.getProperty("Date");
//
//		String configDay = properties("Date");
//
//		for (int i = 0; i < daysList.size(); i++) {
//			String webYear = daysList.get(i).getText();
//			if (webYear.contains(configDay)) {
//				daysList.get(i).click();
//			}
//		}
	}

	public void send_Phone_Number() throws IOException {

		enterText(phoneNumber_txt, randomPhoneNumber(), "User Entering Phone Number");

	}

	public void send_Email_ID() {
		String emailID = "Saida" + randomString() + "@yopmail.com";
		System.out.println(emailID);
		enterText(email_txt, emailID, "User Entered Email ID");

	}

	public void select_Security_Option() throws IOException {
		securityDropDown.click();

		String configSecurityOption = properties("SecurityOptions");

		for (int i = 0; i < securityOptions.size(); i++) {
			String option = securityOptions.get(i).getText();
//			System.out.println(option);
			if (option.contains(configSecurityOption)) {
				securityOptions.get(i).click();
				break;
			}
		}
	}

	public void select_Security_Ans() throws IOException {

		String configSelectSecurityAns = properties("SelectSecurityAns");
		enterText(securityQuesAns, configSelectSecurityAns, "User Entering configSelectSecurityAns");

	}

	public void set_Password() {
		String password = "Chary@" + randomNumeric();
		System.out.println(password);
		enterText(newPassword_txt, password, "User Entering Password");
		enterText(confirmPassword_txt, password, "User Entering Confirm passord");

	}

	public void click_On_Create_Btn() throws IOException, InterruptedException {

		
		click(CreateAccountBtn, "User Clicking On Create Button");

		Thread.sleep(10000);

		verifyText_For_PageCaption(successMessage, "Sign Up succeeded.", "Sign Up succeeded., hence Passed");
		Thread.sleep(10000);

	}
}