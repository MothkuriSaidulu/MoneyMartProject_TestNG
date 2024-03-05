package PageObject;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class Page_004_DashBoardPage extends AbstractClass {

	WebDriver driver;

	public Page_004_DashBoardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	@FindBy(xpath = "//div[@class='header-items'] //a[text()='Sign Out']")
//	@FindBy(xpath = "//a[text()='Sign Out']")	
//  @FindBy(linkText = "Sign Out")

	@FindBy(xpath = "//a[text()='Sign Out']") // //a[text()='Sign Out']
	private WebElement signOut;

	@FindBy(xpath = "//div[@class='mm-user-dash__cta mm-loan-status'] //button[1]")
	private WebElement Installment;

	@FindBy(xpath = "//div[@class='mm-user-dash__cta mm-loan-status'] //button[2]")
	private WebElement cashAdvance;

	@FindBy(xpath = "//div[@class='mm-page-loader__wrapper']")
	private WebElement loader;

	@FindBy(css = "h3[class='mm-user-dash__headh2']")
	private WebElement customer_First_Last_Name;

	@FindBy(css = "span[class*='mm-form-field__message']")
	private WebElement SignIn_Error;

// Actions
	public void click_On_SignOut() throws Exception {

		waitForElementToBeVisible(signOut, "signOut");

		click(signOut, "User Clicked On Sign Out Button");

	}

	public void select_Installment_Loan() throws IOException, InterruptedException {

		if (customer_First_Last_Name.isDisplayed()) {
			System.out.println("User Successfully Sign In");
			waitForElementToBeVisible(Installment, "Installment");

			Thread.sleep(5000);

			click(Installment, "Select Installment Loan");

		} else {
			waitForElementToBeVisible(SignIn_Error, "Sign in error msg");
			System.out.println(SignIn_Error.getText());
		}

	}

	public void select_Cash_Advance() throws IOException {

		waitForElementToBeVisible(cashAdvance, "cashAdvance");

		click(cashAdvance, "Select Cash Advance Loan");
	}

}