package PageObject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(xpath = "//label[@class='mm-checkbox__label ']/preceding-sibling::label//span")
	private WebElement check_Box_Two;

	@FindBy(xpath = "//button[contains(text(),'Agree and Continue')]")
	private WebElement agree_button;

	public void select_Flinks_Income() throws IOException, InterruptedException {

		waitForElementToBeVisible(page_caption, "wait for page verification");

		verifyText_For_PageCaption(page_caption, "Verify Your Income", "verify User on  Verify Your Income page");

		click(Flinks_income, "click on flinks");

		waitForElementToBeVisible(dialog_window, "wait for ");

		click(check_Box_One, "Click on first check box");

		waitForElementToBeVisible(check_Box_Two, "wait for 2nd check visable");

		click(check_Box_Two, "click on 2ndcheck box");

		waitForElementToBeVisible(agree_button, "wait for agree button");

		click(agree_button, "Click on agree button");

	}

}
