package PageObject;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.AbstractClass;

public class Page_001_HomePage extends AbstractClass {

	public WebDriver driver;

	public Page_001_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, xpath = "//div[@class='header__nav-top'] //span[text()='Sign In / Sign Up']")
	private WebElement sign_in_signUp;

	@FindBy(how = How.XPATH, xpath = "//select[@id='selectState_menutop']")
	private WebElement provincesDropDown;

	// //select[@id='selectState_menutop'] //option
	@FindBy(how = How.XPATH, xpath = "//select[@id='selectState_menutop'] //option")
	private List<WebElement> provinceslist;

//  Actions
	
	public void select_Province( ) throws IOException {

		provincesDropDown.click();

		String ConfiProvinceName = properties("Province");
		
		for (int i = 0; i < provinceslist.size(); i++) {
			String provinceName = provinceslist.get(i).getText();
			if (provinceName.contains(ConfiProvinceName)) {
				provinceslist.get(i).click();
				break;
			}

		}
	}
	
	public void click_On_SignIn_SignUp() throws IOException {
		
		waitForElementToBeVisible(sign_in_signUp, "sign_in_signUp");
		
		
		
		Assert.assertEquals(driver.getTitle(), "Quick Loans | Money Mart");
		sign_in_signUp.click();
	}


}
