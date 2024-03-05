package PageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class Page_010_Employer_Info extends AbstractClass {

	public WebDriver driver;

	public Page_010_Employer_Info(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='gs-accept']")
	private WebElement Continue_btn;

	public void Click_On_Continue() throws InterruptedException, IOException {
		scrollToView(Continue_btn);

		click(Continue_btn, "User Cliecked on Contnue button");

	}

}
