package PageObject;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.AbstractClass;

public class Page_007_Verify_Your_Income_Page extends AbstractClass {

	public WebDriver driver;

	public Page_007_Verify_Your_Income_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Verify Your Income']")
	private WebElement page_caption;

	@FindBy(xpath = "//div[@id='express']//div[@class='box-content']")
//	@FindBy(xpath = "//div[@id='express']//p[1]")
	private WebElement Flinks_income;

	@FindBy(xpath = "//div[@id='standard']")
	private WebElement manual_income;

	@FindBy(xpath = "//div[@class='mm-modal__dialog']")
	private WebElement dialog_window;

	@FindBy(xpath = "//span[contains(text(),'Terms and Conditions')]/preceding-sibling::span")
	private WebElement check_Box_One;
// Unique X path when two same x paths besides
	@FindBy(xpath = "//label[@class='mm-checkbox__label ']/preceding-sibling::label//span")
	private WebElement check_Box_Two;

	@FindBy(xpath = "//button[contains(text(),'Agree and Continue')]")
	private WebElement agree_button;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement Cancel_btn;

	@FindBy(xpath = "//iframe[@title='iframe']")
	private WebElement iframe;

	@FindBy(xpath = "//a[@data-institution='FlinksCapital']")
	private WebElement Flinks_Capital;

	@FindBy(css = "input#username")
	private WebElement Flinks_UserName;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement Flinks_Password;

	@FindBy(xpath = "//input[@id='f-input-3']")
	private WebElement Authentication_Question;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement contnue_button;

	@FindBy(xpath = "//i[@class='fa fa-copy']")
	WebElement copy_button;

	public void select_Flinks_Income() throws IOException, InterruptedException {

		verifyText_For_PageCaption(page_caption, "Verify Your Income", "verify User on  Verify Your Income page");

		click(Flinks_income, "click on flinks");

		waitForElementToBeVisible(dialog_window, "wait for ");

		click(check_Box_One, "Click on first check box");

		waitForElementToBeVisible(check_Box_Two, "wait for 2nd check visable");

		click(check_Box_Two, "click on 2ndcheck box");

		waitForElementToBeVisible(agree_button, "wait for agree button");

		click(agree_button, "Click on agree button");

		Thread.sleep(10000);

		System.out.println("Print This Text after wait");

		driver.switchTo().frame(iframe);

		waitForElementToBeVisible(Flinks_Capital, "Flinks button");

		click(Flinks_Capital, "User Trying to click on flinks button");

		String Flinks_User = properties("FlinksUserID");

		enterText(Flinks_UserName, Flinks_User, "Enter flinks user name");

		String flinks_Password = properties("FlinksPassword");

		enterText(Flinks_Password, flinks_Password, "Enter Flinks Password");

		click(contnue_button, "User Clicked on Continue button");

// Copy text
		click(copy_button, "click on copy button");

		click(Authentication_Question, "user clicked on Authentication Question");

// Paste text
		Authentication_Question.sendKeys(Keys.CONTROL + "V");

		click(contnue_button, "User Clicked on Continue button");
	}

}
