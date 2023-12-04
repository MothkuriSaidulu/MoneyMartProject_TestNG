package Stepdefination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class EndToEnd {
	
	
	@Test
	public void signup() throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://qac.moneymart.ca/home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[@class='header__nav-top'] //span[text()='Sign In / Sign Up']")).click();
		
//		driver.findElement(By.linkText("/my-account/sign-up")).click();
		driver.findElement(By.xpath("//a[@href='/my-account/sign-up']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("saidachary");
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Mothkuri");
		driver.findElement(By.cssSelector("button[class='arrowbtn']")).click();
		Thread.sleep(6);

		
// Select Year
		driver.findElement(By.xpath("//div[@class='mm-calendar__wrapper'] //select[@name='year']")).click();
		
	 	List<WebElement> years= driver.findElements(By.xpath("//select[@name='year'] //option"));
		
	 	for(int i = 0 ; i < years.size(); i++)
	 	{
	 		String year = years.get(i).getText();
	 		if(year.equalsIgnoreCase("1994"))
	 		{
	 			System.out.println(year);
	 			years.get(i).click();
	 			break;
	 		}
	 	}
// Select Month

	 	driver.findElement(By.xpath("//div[@class='mm-calendar__wrapper'] //select[@name='month']")).click();
	 	
	 	 List<WebElement> months =  driver.findElements(By.xpath("//select[@name='month'] //option"));
	 	
	 	for(int i = 0 ; i < months.size() ; i++)
	 	{
	 		String month = months.get(i).getText();
	 		if (month.contains("August")) 
	 		{
	 			System.out.println(month);
	 			months.get(i).click();
	 			break;
			}
	 	}

// Select Day
	 	
	 	List<WebElement>  days = driver.findElements(By.xpath("//div[@class='mm-calendar__wrapper'] //div[@class='mm-calendar__day ']"));

	 	for(int i = 0 ; i < days.size(); i++)
	 	{
	 		String day = days.get(i).getText();
	 		
	 		if (day.contains("18")) 
	 		{
	 			days.get(i).click();
	 			break;
			}
	 	}
	 	
// phone number
	 	Thread.sleep(6);

	 	driver.findElement(By.cssSelector("input[name='phoneNumber']")).sendKeys("9010100822");
	 	driver.findElement(By.cssSelector("input[name='email']")).sendKeys("saidachary@yopmail.com");
	 	
// Security Quetion
	 	driver.findElement(By.xpath("//span[@class='mm-select']")).click();
	 	Thread.sleep(6);
	 	List<WebElement> options = driver.findElements(By.xpath("//div[@class='mm-dropdown__menu'] //button"));

//	 	Select sel = new Select(securityQuetion);
//	 	sel.selectByVisibleText("What was your childhood nickname?");	 	
//	 	List<WebElement> options = sel.getAllSelectedOptions();
//	 	
	 	for(int i = 0 ; i < options.size(); i++)
	 	{
	 		String option = options.get(i).getText();
	 		System.out.println(option);
	 		if (option.contains("What was your childhood nickname?")) 
	 		{
	 			options.get(i).click();
	 			break;
				
			}
	 	}
	 	Thread.sleep(6);

	 	driver.findElement(By.cssSelector("input[aria-label='securityQuesAns']")).sendKeys("Chary");
	 	
	 	driver.findElement(By.xpath("//input[@name='newPassword']")).sendKeys("Chary@123");
	 	
	 	driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Chary@123");
	 	
//	 	driver.findElement(By.xpath("//button[@value='Create Account']")).click();
	 	//		driver.close();
	}

}
