package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class Page_006_AboutPage extends AbstractClass {

	WebDriver driver;

	public Page_006_AboutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	
	
	
}
