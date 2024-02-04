package Stepdefination;

import org.testng.annotations.Test;

import PageObject.Page_004_DashBoardPage;
import PageObject.Page_005_WelcomePage;
import PageObject.Page_007_Verify_Your_Income_Page;
import PageObject.Page_001_HomePage;
import PageObject.Page_002_SignInPage;
import PageObject.Page_003_SignUpPage;
import Utilities.BaseClass;

public class TC01_SignUP_IL_Loan_Origination_Flow extends BaseClass {

	@Test
	public void signUp() throws Exception {
//		browser and url takecare by base class

		HomePageObject = new Page_001_HomePage(driver);
//		HomePageObject.selectProvince();
		HomePageObject.click_On_SignIn_SignUp();

		SignInPageObject = new Page_002_SignInPage(driver);
		SignInPageObject.click_On_SignUp();

		SignUpPageObject = new Page_003_SignUpPage(driver);

		SignUpPageObject.send_First_Name();
		SignUpPageObject.send_Last_Name();
		SignUpPageObject.select_Date_Of_Birth();
		SignUpPageObject.send_Phone_Number();
		SignUpPageObject.send_Email_ID();
		SignUpPageObject.select_Security_Option();
		SignUpPageObject.select_Security_Ans();
		SignUpPageObject.set_Password();
		SignUpPageObject.click_On_Create_Btn();
		
		DashBoardObject = new Page_004_DashBoardPage(driver);
//		DashBoardObject.click_On_SignOut();
		
		
		DashBoardObject.select_Installment_Loan();
		
		wellComeObject = new Page_005_WelcomePage(driver);
		wellComeObject.select_Province();
		wellComeObject.enter_Address();
		wellComeObject.select_Rent();
		wellComeObject.click_On_CheckBox();
		wellComeObject.click_On_ContinueBtn();
		
		IncomePageObject = new Page_007_Verify_Your_Income_Page(driver);
		IncomePageObject.select_Flinks_Income();
		
		
		
		
		
		
	}
	
//	@Test(dependsOnMethods = { "signUp"} )
//	public void signInWithExsitingCustomer() throws Exception {
//
//		HomePageObject = new Page_001_HomePage(driver);
//		
//		HomePageObject.clickOnSignInSignUp();
//
//		SignInPageObject = new Page_002_SignInPage(driver);
//		SignUpPageObject = new Page_003_SignUpPage(driver);
//
//		SignInPageObject.sendEmailID(SignUpPageObject.sendEmailID());
//		SignInPageObject.sendPassword(SignUpPageObject.setPassword());
//		SignInPageObject.clickOnSignInBtn();
//
//	}


}
