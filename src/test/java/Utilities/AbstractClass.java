package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractClass {

	public static WebDriver driver;

// loader
	By loader = By.xpath("//div[@class='mm-page-loader__wrapper']");

	public static final Logger logger = Logger.getLogger(AbstractClass.class.getName());

	public AbstractClass(WebDriver driver) {
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

// Waits	

	public static WebDriverWait applyWebDriverWait() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.ignoring(NoSuchElementException.class);
//		wait.ignoreAll(ElementNotVisibleException.class);
		wait.ignoring(ElementNotInteractableException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);

		return wait;
	}

	public static void waitForElementToBeVisible(WebElement locator, String elementDesc) throws IOException

	{

//		WebDriverWait wait = applyWebDriverWait();
//
//		wait.until(ExpectedConditions.visibilityOf(locator));

		try {

			logger.info(locator);
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.visibilityOf(locator));
		} catch (NoSuchElementException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not visible _due_to_the_Exception:- " + exception.getMessage());
		} catch (StaleElementReferenceException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not visible _due_to_the_Exception:- " + exception.getMessage());
		} catch (WebDriverException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not visible _due_to_the_Exception:- " + exception.getMessage());
		} catch (Exception exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not visible _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not visible _due_to_the_Exception:- " + exception.getMessage());
		}

	}

	public static void waitForElementToBeClickable(WebElement element, String elementDesc) throws IOException {
		try {
			// Thread.sleep(1000); //Added on 24-June-2022
			// Thread.sleep(500); //Added on 24-June-2022 Added for slow-down the speed/pace
			// Commented on 20-Oct-2022
			logger.info(element);
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not clickable _due_to_the_Exception:- " + exception.getMessage());
		} catch (StaleElementReferenceException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not clickable _due_to_the_Exception:- " + exception.getMessage());
		} catch (WebDriverException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not clickable _due_to_the_Exception:- " + exception.getMessage());
		} catch (Exception exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not clickable _due_to_the_Exception:- " + exception.getMessage());
		}
	}

	public void waitWebElementToInvisable(WebElement element, String elementDesc) {

		try {

			logger.info(element);
			WebDriverWait wait2 = applyWebDriverWait();
			wait2.until(ExpectedConditions.invisibilityOf(element));

		} catch (NoSuchElementException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not clickable _due_to_the_Exception:- " + exception.getMessage());
		} catch (StaleElementReferenceException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not clickable _due_to_the_Exception:- " + exception.getMessage());
		} catch (WebDriverException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not clickable _due_to_the_Exception:- " + exception.getMessage());
		} catch (Exception exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("<b>"+elementDesc+"</b>"+" is not clickable _due_to_the_Exception:-
			// "+exception.getMessage(), "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not clickable _due_to_the_Exception:- " + exception.getMessage());
		}

	}

// verify text

	public void verifyText_For_PageCaption(WebElement element, String ExpectedText, String elementDesc) {
		try {

			waitForElementToBeVisible(element, elementDesc);
			String Actual = element.getText();
			Actual = Actual.trim().toLowerCase();
			System.out.println("Actual text :   " + Actual);
			ExpectedText = ExpectedText.trim().toLowerCase();
			System.out.println("Expected Text :   " + ExpectedText);

			Assert.assertEquals(Actual, ExpectedText);
			logger.info("Actual and Expected texts are equal: Actual is: " + "<b>" + Actual + "</b>"
					+ " and Expected is: " + "<b>" + ExpectedText + "</b>");

		} catch (Exception e) {

			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : " + e.getMessage());
			// logEvent("Actual and expected texts are not matching for:
			// "+"<b>"+elementDesc+"</b>"+" due to the Exception: "+error.getMessage(),
			// "fail");
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "
					+ "Actual and expected texts are not matching for: " + "<b>" + elementDesc + "</b>"
					+ " due to the Exception: " + e.getMessage());

		}

	}

// Click method

	public static void click(WebElement element, String elementDesc) throws IOException {
		logger.info("--------	click wrapper method inside MyAction class is invoked successfully	--------");
		try {

			waitForElementToBeVisible(element, elementDesc);
			element.click();
			logger.info("--------	click wrapper method inside MyAction class is executed successfully	--------");

		} catch (NoSuchElementException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			//// logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(),
			//// "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"
					+ "User_unable_to_click_on_the_" + "<b>" + elementDesc + "</b>" + "_due_to_the_Exception:-"
					+ exception.getMessage());
		} catch (StaleElementReferenceException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(),
			// "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"
					+ "User_unable_to_click_on_the_" + "<b>" + elementDesc + "</b>" + "_due_to_the_Exception:-"
					+ exception.getMessage());
		} catch (WebDriverException exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(),
			// "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"
					+ "User_unable_to_click_on_the_" + "<b>" + elementDesc + "</b>" + "_due_to_the_Exception:-"
					+ exception.getMessage());
		} catch (Exception exception) {
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : " + exception.getMessage());
			// logEvent("User_unable_to_click_on_the_"+"<b>"+elementDesc+"</b>"+"_due_to_the_Exception:-"+exception.getMessage(),
			// "fail");
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT"
					+ "User_unable_to_click_on_the_" + "<b>" + elementDesc + "</b>" + "_due_to_the_Exception:-"
					+ exception.getMessage());
		}

	}

// Random Strings

//	public String dateOfBirth() {
//		
//		Random random = new Random();
//		int minDay = (int) LocalDate.of(1994, 1, 1).toEpochDay();
//		int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
//		long randomDay = minDay + random.nextInt(maxDay - minDay);
//
//		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
//		String randomDateOFBirth = randomBirthDate.toString();
//
////		System.out.println(randomBirthDate);
//		return randomDateOFBirth;
//		
//	}

	public static String generateDynamicDOB() {

		Calendar calendar = Calendar.getInstance();
		Random random = new Random();

		int minAge = 31; // Minimum required age (more than 30)
		int maxAge = 44; // Maximum required age (less than 45)
		int maxYearDiff = maxAge - minAge; // Maximum year difference between minAge and maxAge

		int yearDiff = random.nextInt(maxYearDiff + 1) + minAge; // Generate a random year difference between minAge and
																	// maxAge

		calendar.add(Calendar.YEAR, -yearDiff); // Subtract the year difference from the current year
		calendar.add(Calendar.DAY_OF_MONTH, -1); // Subtract 1 day to ensure age >= minAge

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String generateDynamicDOB = dateFormat.format(calendar.getTime());

		return generateDynamicDOB;
	}

	@SuppressWarnings("static-access")
	public String randomString() {
		String randaom = new RandomStringUtils().randomAlphabetic(6);
		return randaom;

	}

	@SuppressWarnings("static-access")
	public String randomPhoneNumber() {

		String randaomPhoneNumber = new RandomStringUtils().randomNumeric(10);
		return randaomPhoneNumber;

	}

	@SuppressWarnings("static-access")
	public String randomNumeric() {

		String randomNumericValue = new RandomStringUtils().randomNumeric(3);
		return randomNumericValue;

	}

// proprties

	public String properties(String value) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);
		String getProperty = prop.getProperty(value);

		return getProperty;
	}

// Send keys
	public void enterText(WebElement element, String textToEnter, String elementDesc) {
		logger.info("--------	EnterText wrapper method inside FalconActions class is invoked successfully	--------");

		try {
			waitForElementToBeVisible(element, elementDesc);
			element.click();
			element.clear();
			element.sendKeys(textToEnter);
			logger.info(
					"--------	EnterText wrapper method inside FalconActions class is executed successfully	--------");

		} catch (Exception e) {
			logger.error("ERROR WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : " + e.getMessage());
			// logEvent("User unable to enter text into the input field "+"<b>"+elementDesc
			// +"</b>"+" due to the Exception: "+error.getMessage(), "fail");
			Assert.fail("Exception : WHILE TRYING TO TYPE SPECIFIED TEXT INSIDE A WEB ELEMENT : "
					+ "User unable to enter text into the input field " + "<b>" + elementDesc + "</b>"
					+ " due to the Exception: " + e.getMessage());
		}

	}

// Scroll to view

	public JavascriptExecutor javaScriptExcutor(String script, Object element) throws InterruptedException {
//		WebElement element = driver.findElement(By.id("id_of_element"));
		JavascriptExecutor exe = (JavascriptExecutor) driver;

		exe.executeScript(script, element);
//		Thread.sleep(500);

		return exe;

	}

	public void scrollToView(WebElement element) throws InterruptedException {
		javaScriptExcutor("arguments[0].scrollIntoView(true);", element);

		// executeJavaScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);

		logger.info(element);

	}

}
