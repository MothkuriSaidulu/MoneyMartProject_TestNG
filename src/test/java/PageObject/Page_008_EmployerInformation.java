package PageObject;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class Page_008_EmployerInformation extends AbstractClass {

	public WebDriver driver;

	public Page_008_EmployerInformation(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@aria-label='phone']")
//	@FindBy(xpath = "//input[@placeholder='XXX-XXX-XXXX']")
	private WebElement emp_Phone;

	@FindBy(xpath = "//button[@id='gs-accept']")
	private WebElement continue_button;

	@FindBy(css = "button#gs-exit")
	private WebElement Cancel_Btn;

	public void employer_Phone() throws IOException, InterruptedException {

		javaScriptExcutor("window.scrollBy(0 , 350)", emp_Phone);
		System.out.println("Print this");

		emp_Phone.sendKeys("9010100822");

		System.out.println("Print this after  enter ph number");

	}

	public void click_On_Continue() throws IOException, InterruptedException {

		Thread.sleep(6000);

		scrollToView(continue_button);

		Thread.sleep(6000);

		click(continue_button, "User Clicked on continue button");

	}

}
