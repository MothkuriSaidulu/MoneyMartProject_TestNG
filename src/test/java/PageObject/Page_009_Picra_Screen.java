package PageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class Page_009_Picra_Screen extends AbstractClass {

	public WebDriver driver;

	public Page_009_Picra_Screen(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='mm-checkbox__box']")
	private WebElement Check_Box;

	@FindBy(xpath = "//button[@id='gs-accept']")
	private WebElement Agree_Button;

	public void Select_Check_Box_And_Agree_Btn_On_Picra_Screen() throws IOException {

		click(Check_Box, "user click on check box");

		click(Agree_Button, "User Clicked On Agree button");
	}

}
