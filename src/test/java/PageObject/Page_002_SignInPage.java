package PageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class Page_002_SignInPage extends AbstractClass {

	public WebDriver driver;

	public Page_002_SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Sign in to Money Mart']")
	private WebElement signInPageTitle;

	@FindBy(xpath = "//a[@href='/my-account/sign-up']")
	private WebElement signUp;

	@FindBy(id = "emailAddress")
	private WebElement emailID;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(css = "div.login_button_wrap")
	private WebElement signInbtn;

//	WebElement loader = driver.findElement(By.xpath("//div[@class='mm-page-loader__wrapper']"));

	@FindBy(xpath = "//div[@class='mm-page-loader__wrapper']")
	private WebElement loader;

// Actions

	public void click_On_SignUp() throws IOException {
		waitForElementToBeVisible(signInPageTitle, "signInPageTitle");
		System.out.println(signInPageTitle.getText());
		verifyText_For_PageCaption(signInPageTitle, "Sign in to Money Mart", "signInPageTitle, Hence passed");

		signUp.click();

	}

	public void send_EmailID() throws IOException {

//		emailID.sendKeys(email);
		String enailID = properties("EmailID");

		enterText(emailID, enailID, "Enter Email ID");

	}

	public void send_Password() throws IOException {

//		password.sendKeys(psd);	

		String ConfigPassword = properties("Password");

		enterText(password, ConfigPassword, "Enter Password");

	}

	public void click_On_SignIn_Btn() throws IOException {
//		signInbtn.click();
		click(signInbtn, "Click on Sign in button");
		
	}

}
