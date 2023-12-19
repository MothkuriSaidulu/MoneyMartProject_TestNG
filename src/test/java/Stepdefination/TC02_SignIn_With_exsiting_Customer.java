package Stepdefination;

import org.testng.annotations.Test;

import PageObject.Page_004_DashBoardPage;
import PageObject.Page_005_WelcomePage;
import PageObject.Page_007_Verify_Your_Income_Page;
import PageObject.Page_008_EmployerInformation;
import PageObject.Page_009_Picra_Screen;
import PageObject.Page_001_HomePage;
import PageObject.Page_002_SignInPage;
import Utilities.BaseClass;

public class TC02_SignIn_With_exsiting_Customer extends BaseClass {

	@Test
	public void signInWithExsitingCustomer() throws Exception {

		HomePageObject = new Page_001_HomePage(driver);
		HomePageObject.click_On_SignIn_SignUp();

		SignInPageObject = new Page_002_SignInPage(driver);
		SignInPageObject.send_EmailID();
		SignInPageObject.send_Password();
		SignInPageObject.click_On_SignIn_Btn();
		
		DashBoardObject = new Page_004_DashBoardPage(driver);
		DashBoardObject.select_Installment_Loan();
		
		wellComeObject = new Page_005_WelcomePage(driver);
		wellComeObject.select_Province();
		
		wellComeObject.enter_Address();
		wellComeObject.select_Rent();
		wellComeObject.click_On_CheckBox();
		wellComeObject.click_On_ContinueBtn();
		
		IncomePageObject = new Page_007_Verify_Your_Income_Page(driver);
		IncomePageObject.select_Flinks_Income();
		
		EmployerInformationOObject = new Page_008_EmployerInformation(driver);
//		EmployerInformationOObject.employer_Phone();
		EmployerInformationOObject.click_On_Continue();
		
		Picra_Screen_Page_Object = new Page_009_Picra_Screen(driver);
		Picra_Screen_Page_Object.Select_Check_Box_And_Agree_Btn_On_Picra_Screen();
		
		
	}

}
