package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AbstractClass;

public class Page_005_WelcomePage extends AbstractClass {

	public WebDriver driver;

	public Page_005_WelcomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[normalize-space()='Welcome!']")
	private WebElement WelCome_txt;

	@FindBy(xpath = "//button[@class='mm-select__value']")
	private WebElement ProvinceDropDown;

	@FindBy(xpath = "//div[@class='mm-dropdown']")
	private WebElement dropWindow;

//	@FindBy(how = How.XPATH, using = "//div[@class='mm-dropdown__menu'] //button")
	@FindBy(xpath = "//div[@class='mm-dropdown'] //button[@class='mm-dropdown__menu-item']")
	private List<WebElement> ProvinceList;

	@FindBy(xpath = "//button[text()='Agree and Continue']")
	private WebElement Agree_and_Continue;

	@FindBy(css = "input[name='address']")
	private WebElement currentAddress;

	@FindBy(xpath = "(//div[@class='pcaautocomplete pcatext' and contains(@style,'top')]//div[@class='pca pcalist'])[2]")
	private WebElement address1; // suggetion address

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement RentOption_Yes;

	@FindBy(xpath = "//button[text()='No']")
	private WebElement RentOption_No;

	@FindBy(xpath = "(//span[@class='mm-checkbox__box'])[1]")
	private WebElement checkBox_One;

	@FindBy(xpath = "(//span[@class='mm-checkbox__box'])[2]")
	private WebElement checkBox_two;

	@FindBy(css = "button[id='gs-accept']")
	private WebElement continueBtn;

// Actions

	public void select_Province() throws IOException, InterruptedException {

		waitForElementToBeVisible(WelCome_txt, "welCome");
		System.out.println(WelCome_txt.getText());
		verifyText_For_PageCaption(WelCome_txt, "Welcome!", "Welcome!, Hence Passed");

		click(ProvinceDropDown, "Click in select province drop down");
		waitForElementToBeVisible(dropWindow, "Province list displaying");

		for (int i = 0; i < ProvinceList.size(); i++) {

			// System.out.println("test " + i);

			String webProvinceName = ProvinceList.get(i).getText();
			System.out.println(webProvinceName);
			String configProvinceName = properties("ProvinceName");

			if (webProvinceName.contains("Manitoba")) {
				ProvinceList.get(i).click();
				waitForElementToBeVisible(Agree_and_Continue, "agree button");
				click(Agree_and_Continue, "click on agree button");
				break;
			}

			else if (webProvinceName.contains(configProvinceName)) {
				System.out.println(ProvinceList.get(i).getText());
				ProvinceList.get(i).click();
				break;
			}

		}

	}

	public void enter_Address() throws IOException, InterruptedException {

//		Thread.sleep(3000);

		String configAddress = properties("Address");

		waitForElementToBeClickable(currentAddress, "adress");

		enterText(currentAddress, configAddress, "enter current address");
		Thread.sleep(7000);

		Actions act = new Actions(driver);
		act.sendKeys(Keys.SPACE).perform();
		
		Thread.sleep(5000);

		click(address1, "second adrees");
		
		Thread.sleep(5000);

	}

	public void select_Rent() throws IOException, InterruptedException {
		String configRent = properties("RentOptions");

		scrollToView(RentOption_No);

		waitForElementToBeVisible(RentOption_No, "select rent no");

		if (configRent.equalsIgnoreCase("Yes")) {
			click(RentOption_Yes, "select rent yes");
		} else {
			click(RentOption_No, "Select rent no");
		}

	}

	public void click_On_CheckBox() {

		if (!checkBox_One.isSelected()) {
			checkBox_One.click();
			checkBox_two.click();
		}

	}

	public void click_On_ContinueBtn() throws IOException {
		waitForElementToBeVisible(continueBtn, "Click on continue button");
		click(continueBtn, "user clcked on continue button");

	}
}
