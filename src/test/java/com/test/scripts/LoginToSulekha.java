/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Test scripts of Login
 * @module			:		Login
 * @testmethod		:	   	InvalidLogin()
 * @testmethod		:	   	UnRegMobJoinSulekha()
 * @testmethod		:	   	UnRegEmailJoinSulekha()
 * @testmethod		:	   	ValidLoginViaEmailID()
 * @testmethod		:	   	ValidLoginViaMobileNum()
 * @testmethod		:	   	GoogleLogin()
 * @testmethod		:	   	UnRegGoogleLogin()
 * @testmethod		:	   	HandleAlertPopup()
 * @testmethod		:	   	GoogleInvalidOtp()
 * @testmethod		:	   	SixDigitVerificationCode()
 * @testmethod		:	   	ValidOtp()
 * @testmethod		:	   	TandCApplyLnk()
 */							
package com.test.scripts;

import java.util.HashMap;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.test.baselib.BaseLib;
import com.test.baselib.GenericLib;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MorePO;
import com.test.po.UpdateAccountPO;
import com.test.po.WelcomePO;
import io.appium.java_client.ios.IOSElement;

public class LoginToSulekha extends BaseLib {

	String sTestData=null;
	String[] sData=null;
	LoginPO loginPo;
	WelcomePO welcomePo;
	HomePO homePo;
	UpdateAccountPO updateAccountPo;
	MorePO morePo;
	JavascriptExecutor js=null;
	HashMap<String, String> scrollObject=null;

	/* @TestCaseID: Login_01
	 * @Description: Tap over LOGIN button without entering any values in Email ID/Mobile number field and verify.
	 * 				 To tap over "login" button by entering invalid mobileno
	 * 				 To tap over "login" button by entering invalid emailid
	 * 				 To tap over "login" button by entering unregistered email id
	 * 				 To tap over "login" button by entering unregistered mobile number
	 * 				 To tap over "login" button by entering registered mobileno and no password
	 * 				 To tap over "login" button by entering registered emailid and no password
	 * 				 Tap over Cancel button displayed on the alert for unregistered emailID.
	 * 				 Tap over Cancel button displayed on the alert for unregistered Mobile number.
	 * 				 To Tap over LOGIN and enter valid Email ID and invalid Password and verify.
	 * 				 To Tap over LOGIN and enter valid Mobile number and invalid Password and verify.
	 * 				 To tap over "Show" link of password field in login page
	 * 				 To tap over "Hide" link of password field in login page
	 * 				 To tap over "forgot password" link in Login page.
	 * 				 To enter a valid mobile number in Via SMS in Forgot password? Page and tap on Send button
	 * 				 To enter a valid Email ID in Via email in Forgot password? Page and tap on Send button
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="To tap over login button without entering login credentials, with invalid credentials, unregistered credentials,without password and invalid password, to tap over show and hide link and forgot password link,To receive password via sms and email.")
	public void InvalidLogin()
	{
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		sTestData="Login_02";
		sData=GenericLib.toReadExcelData(sTestData);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed");
			NXGReports.addStep("Login page is successfully displayed", LogAs.PASSED, null);
			
			//Tap over LOGIN button without entering any values in Email ID/Mobile number field and verify.
			loginPo.getEleLoginBtn().click();
			Assert.assertTrue(loginPo.getEleEmailMobPopup().isDisplayed(), "Enter email / mobile number alert is not displayed");
			NXGReports.addStep("Enter email / mobile number alert is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleOKBtn().click();
			
			//To tap over "login" button by entering invalid mobileno
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("1234567890");
			try
			{
				loginPo.getEleLoginBtn().click();
			}
			catch(Exception e)
			{
				homePo.getEleKeyboardReturnBtn().click();
				loginPo.getEleLoginBtn().click();
			}
			Assert.assertTrue(loginPo.getEleInValidMobNumPopup().isDisplayed(), "An alert popup saying Invalid mobile number, try again is not displayed");
			NXGReports.addStep("An alert 'Invalid mobile number, try again' is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleOKBtn().click();
			
			//To tap over "login" button by entering invalid emailid
			loginPo.getEleEmailmob1TxtFld().clear();
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("abcdefgh");
			try
			{
				loginPo.getEleLoginBtn().click();
			}
			catch(Exception e)
			{
				homePo.getEleKeyboardReturnBtn().click();
				loginPo.getEleLoginBtn().click();
			}
			Assert.assertTrue(loginPo.getEleValidEmailPopup().isDisplayed(), "An alert popup saying Enter valid email is not displayed");
			NXGReports.addStep("An alert saying 'Enter valid email' is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleOKBtn().click();
			
			//To tap over "login" button by entering registered mobileno and no password
			loginPo.getEleEmailmob1TxtFld().clear();
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("8971222976");
			try
			{
				loginPo.getEleLoginBtn().click();
			}
			catch(Exception e)
			{
				homePo.getEleKeyboardReturnBtn().click();
				homePo.getEleKeyboardReturnBtn().click();
				loginPo.getEleLoginBtn().click();
			}
			Assert.assertTrue(loginPo.getEleEnterPwdPopup().isDisplayed(), "An alert popup saying Enter your Password is not displayed");
			NXGReports.addStep("An alert popup saying Enter your Password is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleOKBtn().click();
			
			//To tap over "login" button by entering registered emailid and no password
			loginPo.getEleEmailmob1TxtFld().clear();
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("cbt.automation2@gmail.com");
			try
			{
				loginPo.getEleLoginBtn().click();
			}
			catch(Exception e)
			{
				homePo.getEleKeyboardReturnBtn().click();
				loginPo.getEleLoginBtn().click();
			}
			Assert.assertTrue(loginPo.getEleEnterPwdPopup().isDisplayed(), "An alert popup saying Enter your Password is not displayed");
			NXGReports.addStep("An alert popup saying Enter your Password is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleOKBtn().click();
			
			//To tap over "login" button by entering unregistered email id and Tap over Cancel button displayed on the alert for unregistered emailID.
			loginPo.getEleEmailmob1TxtFld().clear();
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("cbt.automation4@gmail.com");
			loginPo.getElePwddTxtFld().click();
			Assert.assertTrue(loginPo.getEleUnRegEmailPopup().isDisplayed(), "An alert popup saying The email id you have entered does not belong to any account is not displayed");
			NXGReports.addStep("An alert saying The email id you have entered does not belong to any account is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleCancelBtn().click();
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed when cancelled");
			NXGReports.addStep("Login page is successfully displayed when cancelled", LogAs.PASSED, null);
			
			//To tap over "login" button by entering unregistered mobile number and Tap over Cancel button displayed on the alert for unregistered mobile number.
			loginPo.getEleEmailmob1TxtFld().clear();
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("8871890235");
			loginPo.getElePwddTxtFld().click();
			Assert.assertTrue(loginPo.getEleUnRegMobPopup().isDisplayed(), "An alert popup saying Something went worng message is not displayed");
			NXGReports.addStep("An alert popup saying Something went worng message is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(loginPo.getEleUnRegMobnumPopup().isDisplayed(),"An alert popup saying The mobile number you just entered does not belong to Sulekha's account is not displayed");
			NXGReports.addStep("An alert popup saying The mobile number you just entered does not belong to Sulekha's account is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleCancelBtn().click();
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed when cancelled");
			NXGReports.addStep("Login page is successfully displayed when cancelled", LogAs.PASSED, null);
			
			//To Tap over LOGIN and enter valid Email ID and invalid Password and verify.
			loginPo.getEleEmailmob1TxtFld().clear();
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("cbt.automation2@gmail.com");
			((IOSElement) driver.findElement(By.id("Password"))).setValue("cabt");
			try
			{
				loginPo.getEleLoginBtn().click();
			}
			catch(Exception e)
			{
				homePo.getEleKeyboardReturnBtn().click();
				loginPo.getEleLoginBtn().click();
			}
			Assert.assertTrue(loginPo.getEleIncorrectPwdPopup().isDisplayed(), "An alert popup saying Incorrect password is not displayed");
			NXGReports.addStep("An alert popup saying Incorrect password is successfully displayed", LogAs.PASSED, null);
			driver.switchTo().alert().accept();
			
			//To Tap over LOGIN and enter valid Mobile number and invalid Password and verify.
			loginPo.getEleEmailmob1TxtFld().clear();
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("8971222976");
			((IOSElement) driver.findElement(By.id("Password"))).setValue("cabt");
			try
			{
				loginPo.getEleLoginBtn().click();
			}
			catch(Exception e)
			{
				homePo.getEleKeyboardReturnBtn().click();
				loginPo.getEleLoginBtn().click();
			}
			Assert.assertTrue(loginPo.getEleIncorrectPwdPopup().isDisplayed(), "An alert popup saying Incorrect password is not displayed");
			NXGReports.addStep("An alert popup saying Incorrect password is successfully displayed", LogAs.PASSED, null);
			driver.switchTo().alert().accept();
			
			//To tap over "Show" link of password field in login page
			((IOSElement) driver.findElement(By.id("Password"))).setValue("cbt@123");
			Assert.assertTrue(loginPo.getEleSHOWLnk().isDisplayed(), "Show Link is not displayed");
			NXGReports.addStep("Show Link is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleSHOWLnk().click();
			Assert.assertTrue(loginPo.getEleHIDELnk().isDisplayed(), "Hide Link is not displayed");
			NXGReports.addStep("Hide Link is successfully displayed and the password entered is readable and not encrypted", LogAs.PASSED, null);
			
			//To tap over "Hide" link of password field in login page
			loginPo.getEleHIDELnk().click();
			Assert.assertTrue(loginPo.getEleSHOWLnk().isDisplayed(), "Show Link is not displayed");
			NXGReports.addStep("Show Link is successfully displayed", LogAs.PASSED, null);
			
			//To tap over "forgot password" link in Login page.
			loginPo.getEleForgotPwdLnk().click();
			Assert.assertTrue(loginPo.getEleForgotPwdTxt().isDisplayed(), "Forgot password page is not displayed");
			NXGReports.addStep("Forgot password page is successfully displayed", LogAs.PASSED, null);
			
			//To enter a valid mobile number in Via SMS in Forgot password? Page and tap on Send button
			//loginPo.getEleViaSMSOpt().click();
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).clear();
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("8971222976");
			loginPo.getEleSendBtn().click();
			Assert.assertTrue(loginPo.getEleWeSentPwdPopup().isDisplayed(), "we've sent password to mobile number alert is not displayed");
			NXGReports.addStep("we've sent password to mobile number alert is displayed", LogAs.PASSED, null);
			loginPo.getEleOKBtn().click();
			
			//To enter a valid Email ID in Via email in Forgot password? Page and tap on Send button
			loginPo.getEleForgotPwdLnk().click();
			loginPo.getEleViaEmailOpt().click();
			Assert.assertTrue(loginPo.getEleEnterEmailTxtFld().isDisplayed(), "Email Id text Feild in forgot Password page is not displayed");
			NXGReports.addStep("Email Id text Feild in forgot Password page is successfully displayed", LogAs.PASSED, null);
			((IOSElement) driver.findElement(By.id("Enter a valid email ID"))).setValue("cbt.automation@gmail.com");
			loginPo.getEleSendBtn().click();
			Assert.assertTrue(loginPo.getEleWeSentPwdtoMailPopup().isDisplayed(), "we've mailed your password to email alert is not displayed");
			NXGReports.addStep("we've mailed your password to email alert is displayed", LogAs.PASSED, null);
			
		}
			catch(Exception e)
			{	
				NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				throw e;
			}
		}


	/* @TestCaseID: Login_06
	 * @Description: Tap over Join Sulekha button displayed on the alert for unregistered mobile number.
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="Tap over Join Sulekha button displayed on the alert for unregistered mobile number.")
	public void UnRegMobJoinSulekha()
	{	
		sTestData="Login_06";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("8871890234");
			loginPo.getElePwddTxtFld().click();
			Assert.assertTrue(loginPo.getEleUnRegMobPopup().isDisplayed(),"An alert popup saying The mobile number you just entered does not belong to Sulekha's account is not displayed");
			NXGReports.addStep("An alert popup saying The mobile number you just entered does not belong to Sulekha's account is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleJoinSulekhaBtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join Now Sulekha page is not displayed");
			NXGReports.addStep("Join Now Sulekha page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_07
	 * @Description: Tap over Join Sulekha button displayed on the alert for unregistered emailID.
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="Tap over Join Sulekha button displayed on the alert for unregistered emailID.")
	public void UnRegEmailJoinSulekha()
	{	
		sTestData="Login_07";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("cbt.automation4@gmail.com");
			loginPo.getElePwddTxtFld().click();
			Assert.assertTrue(loginPo.getEleUnRegEmailPopup().isDisplayed(), "An alert popup saying The email id you have entered does not belong to any account is not displayed");
			NXGReports.addStep("An alert saying The email id you have entered does not belong to any account is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleJoinSulekhaBtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join Sulekha page is not displayed");
			NXGReports.addStep("Join Sulekha page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: Login_4
	 * @Description: To Tap over LOGIN and enter valid Email ID and valid Password and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="To Tap over LOGIN and enter valid Email ID and valid Password and verify.")
	public void ValidLoginViaEmailID()
	{
		sTestData="Login_16";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			((IOSElement) driver.findElement(By.id("Email / mobile"))).setValue("cbt.automation2@gmail.com");
			((IOSElement) driver.findElement(By.id("Password"))).setValue("cbt@123");
			try
			{
				loginPo.getEleLoginBtn().click();
			}
			catch(Exception e)
			{
				homePo.getEleKeyboardReturnBtn().click();
				loginPo.getEleLoginBtn().click();
			}
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_5
	 * @Description: To Tap over LOGIN and enter valid Mobile number and valid Password and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=true,description="To Tap over LOGIN and enter valid Mobile number and valid Password and verify.")
	public void ValidLoginViaMobileNum()
	{
		sTestData="Login_17";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(homePo, sData);
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: login_22
	 * @Descripyion: To login through google+
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=true,description="To login through google+")
	public void GoogleLogin() throws Exception
	{
		sTestData="Login_22";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login link is not displayed");
			NXGReports.addStep("Google+ login link is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleGoogleLoginLnk().click();
			Thread.sleep(5000);
			//Switching from app to webview
			Set<String> contextHandles=driver.getContextHandles();
			for(String contextHandle:contextHandles){
				if(contextHandle.contains("WEBVIEW")){
					driver.context(contextHandle);
				}
			}
			Assert.assertTrue(loginPo.getEleGoogleEmailTxtFld().isDisplayed(),"Google login screen is not displayed");
			NXGReports.addStep("Google login screen is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleGoogleEmailTxtFld().sendKeys(sData[3]);
			loginPo.getEleGoogleNextBtn().click();
			loginPo.getEleGooglePwdTxtFld().sendKeys(sData[4]);
			loginPo.getEleGoogleSignInBtn().click();
			Thread.sleep(10000);
			driver.context("NATIVE_APP");
			driver.tap(1, 218,434,1);
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);

			//Clean up code
			try{
				homePo.getEleMoreIcn().click();
				updateAccountPo.getEleLogoutBtn().click();
				updateAccountPo.getEleLoginBtn().click();
				welcomePo.getEleLoginLnk().click();
				loginPo.getEleGoogleLoginLnk().click();
				Thread.sleep(10000);
				driver.tap(1,182,79,1);
				driver.tap(1,182,79,1);
				Thread.sleep(10000);
				driver.tap(1,207,278,1);
				Thread.sleep(5000);
			//Switching from webview to native app
			Set<String> contextHandles1=driver.getContextHandles();
			for(String contextHandle1:contextHandles1){
				if(contextHandle1.contains("WEBVIEW")){
					driver.context(contextHandle1);
				}
			}
			loginPo.getEleGmailSignLink().click();
			Thread.sleep(10000);
			loginPo.getEleGmailRemoveBtn().click();
			loginPo.getEleGmailAccountBtn().click();
			loginPo.getEleGmailRemoveBtn().click();
			Thread.sleep(1000);

		}
			catch(Exception e){
				
			}
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: login_24
	 * @Descripyion: Check the Create Account page for unregistered user when logged in through Facebook or G+
	 * 				 Enter a valid mobile number and email id in create account page and tap on Create button.
	 * @Author: Yashi Priya*/
	@Test(priority=7,enabled=true,description="To check google+ create account page and enter valid mobile/email id and create   account.")
	public void UnRegGoogleLogin() throws Exception
	{
		sTestData="Login_24";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try{
			
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			loginPo.getEleGoogleLoginLnk().click();
			loginPo.googleLogin(sData, welcomePo);
			Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
			NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
			Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
			NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
			Assert.assertTrue(loginPo.getEleEmailTxt().isDisplayed(), "Email text field is not displayed");
			NXGReports.addStep("Email text field is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(loginPo.getEleMobileNumTxtFld().isDisplayed(),"mobile number text field is not dispalyed");
			NXGReports.addStep("mobile number text field is successfully dispalyed", LogAs.PASSED, null);
			//Enter a valid mobile number and email id in create account page and tap on Create button
			((IOSElement) driver.findElement(By.id("Please Enter Name"))).setValue("Automation");
			((IOSElement) driver.findElement(By.id("Please enter mobile number"))).setValue("8105013728");
			loginPo.getEleCreateBtn().click();
			Assert.assertTrue(welcomePo.getEleCodeViaSMSTxt().isDisplayed(), "New verification code is not received vis SMS.");
			NXGReports.addStep("New OTP is received successfully via sms", LogAs.PASSED, null);
			Assert.assertTrue(loginPo.getEleOtpTxt().isDisplayed(),"User should not navigated to OTP page and OTP should be received via SMS to the entered mobile number.");
			NXGReports.addStep("User should be navigated to OTP page and OTP should be received via SMS to the entered mobile number.", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
		
	
	/* @TestCaseID: login_24
	 * @Descripyion:Tap over Create button without entering Mobile number
	 *             	Enter invalid Mobile number and tap over Create button.
	 *             	Tap over Create button without entering Email ID
	 *             	Tap over Create button without entering Name.
	 * @Author: Yashi Priya*/
	@Test(priority=8,enabled=true,description="Tap create button without and with invalid mobile number and without email id and name.")
	public void HandleAlertPopup() throws Exception
	{
		sTestData="Login_24";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			loginPo.getEleGoogleLoginLnk().click();
			loginPo.googleLogin(sData, welcomePo);
			
			//Tap over Create button without entering Mobile number
			((IOSElement) driver.findElement(By.id("Please Enter Name"))).setValue("Automation");
			loginPo.getEleCreateBtn().click();
			Assert.assertTrue(loginPo.getEle10DigitNumberPopUp().isDisplayed(),"An alert with message 'Enter valid mobile number' should not displayed");
			NXGReports.addStep("An alert with message 'Enter valid mobile number' should be displayed", LogAs.PASSED, null);
			
			//Enter invalid Mobile number and tap over Create button.
			loginPo.getEleMobileNumTxt().clear();
			((IOSElement) driver.findElement(By.id("Please enter mobile number"))).setValue("123456789");
			loginPo.getEleCreateBtn().click();
			Assert.assertTrue(loginPo.getEleInvalidMobilePopup().isDisplayed(),"An alert with message 'Invalid mobile number, try again' should not displayed");
			NXGReports.addStep("An alert with message 'Invalid mobile number, try again' should be displayed", LogAs.PASSED, null);
			
			//Tap over Create button without entering Email ID
			loginPo.getEleEmailTxt().clear();
			loginPo.getEleMobileNumTxt().clear();
			((IOSElement) driver.findElement(By.id("Please enter mobile number"))).setValue("8105013728");
			loginPo.getEleCreateBtn().click();
			Assert.assertTrue(loginPo.getEleEnterValidEmailPopup().isDisplayed(),"An alert with message 'Enter valid email' should not displayed");
			NXGReports.addStep("An alert with message 'Enter valid email' should be displayed", LogAs.PASSED, null);
			
			//Tap over Create button without entering Name.
			loginPo.getEleNameTxt().clear();
			loginPo.getEleCreateBtn().click();
			Assert.assertTrue(loginPo.getEleNamePopup().isDisplayed(),"An alert with message 'Enter your name' should not displayed");
			NXGReports.addStep("An alert with message 'Enter your name' should be displayed", LogAs.PASSED, null);
			
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: login_26
	 * @Descripyion:Check entering invalid OTP 
	 * @Author:Yashi Priya*/
	@Test(priority=9,enabled=true,description="Check entering invalid OTP")
	public void GoogleInvalidOtp() throws Exception
	{
		sTestData="Login_26";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			loginPo.getEleGoogleLoginLnk().click();
			loginPo.googleLogin(sData, welcomePo);
			Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
			NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
			Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
			NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
			((IOSElement) driver.findElement(By.id("Please Enter Name"))).setValue("Automation");
			Assert.assertTrue(loginPo.getEleMobileNumTxtFld().isDisplayed(),"mobile number text field is not dispalyed");
			NXGReports.addStep("mobile number text field is successfully dispalyed", LogAs.PASSED, null);
			((IOSElement) driver.findElement(By.id("Please enter mobile number"))).setValue("8105013728");
			loginPo.getEleCreateBtn().click();
			Assert.assertTrue(loginPo.getEleOtpTxt().isDisplayed(),"User should not navigated to OTP page and OTP should be received via SMS to the entered mobile number.");
			NXGReports.addStep("User should be navigated to OTP page and OTP should be received via SMS to the entered mobile number.", LogAs.PASSED, null);
			((IOSElement) driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]"))).sendKeys("123456");
			Assert.assertTrue(loginPo.getEleCorrectOtpPopup().isDisplayed(),"An alert message enter valid verification code popup is not displayed");
			NXGReports.addStep("An alert message enter valid verification code popup is successfully displayed", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}



	}
	/* @TestCaseID: login_27
	 * @Descripyion:Check entering less than 6-digit verification code
	 * @Author: Yashi Priya*/
	@Test(priority=10,enabled=true,description="Check entering less than 6-digit verification code")
	public void SixDigitVerificationCode() throws Exception
	{
		sTestData="Login_27";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			loginPo.getEleGoogleLoginLnk().click();
			loginPo.googleLogin(sData, welcomePo);
			Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
			NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
			Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
			((IOSElement) driver.findElement(By.id("Please Enter Name"))).setValue("Automation");
			Assert.assertTrue(loginPo.getEleMobileNumTxtFld().isDisplayed(),"mobile number text field is not dispalyed");
			((IOSElement) driver.findElement(By.id("Please enter mobile number"))).setValue("8105013728");
			loginPo.getEleCreateBtn().click();
			Assert.assertTrue(loginPo.getEleOtpTxt().isDisplayed(),"User should not navigated to OTP page and OTP should be received via SMS to the entered mobile number.");
			NXGReports.addStep("User should be navigated to OTP page and OTP should be received via SMS to the entered mobile number.", LogAs.PASSED, null);
			((IOSElement) driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]"))).setValue("9999");
			welcomePo.getEleDoneBtn().click();
			try{
			Assert.assertTrue(welcomePo.getEle6DigitCodePopup().isDisplayed(),"An alert message enter 6-digit verification code  popup is not displayed");
			NXGReports.addStep("An alert message enter 6-digit verification code  popup is successfully displayed", LogAs.PASSED, null);
			}catch(Exception e){
			Assert.assertTrue(welcomePo.getEleCodeViaSMSTxt().isDisplayed(), "New verification code is not received vis SMS.");
			NXGReports.addStep("New OTP is received successfully via sms", LogAs.PASSED, null);
			Assert.assertTrue(loginPo.getEleOtpTxt().isDisplayed(),"User should not navigated to OTP page and OTP should be received via SMS to the entered mobile number.");
			NXGReports.addStep("User should be navigated to OTP page and OTP should be received via SMS to the entered mobile number.", LogAs.PASSED, null);
		}

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: login_24
	 * @Descripyion:Enter valid OTP 
	 * @Author: Yashi Priya*/
	@Test(priority=11,enabled=true,description="Enter valid OTP")
	public void ValidOtp() throws Exception
	{
		sTestData="Login_24";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			loginPo.getEleGoogleLoginLnk().click();
			loginPo.googleLogin(sData, welcomePo);
			((IOSElement) driver.findElement(By.id("Please Enter Name"))).setValue("Automation");
			Assert.assertTrue(loginPo.getEleMobileNumTxtFld().isDisplayed(),"mobile number text field is not dispalyed");
			NXGReports.addStep("mobile number text field is successfully dispalyed", LogAs.PASSED, null);
			((IOSElement) driver.findElement(By.id("Please enter mobile number"))).setValue("8105013728");
			loginPo.getEleCreateBtn().click();
			Assert.assertTrue(loginPo.getEleOtpTxt().isDisplayed(),"User should not navigated to OTP page and OTP should be received via SMS to the entered mobile number.");
			NXGReports.addStep("User should be navigated to OTP page and OTP should be received via SMS to the entered mobile number.", LogAs.PASSED, null);
			((IOSElement) driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]"))).sendKeys("999999");
			Thread.sleep(10000);
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);
	
		//clean up code
		try{
			homePo.getEleMoreIcn().click();
			updateAccountPo.getEleLogoutBtn().click();
			updateAccountPo.getEleLoginBtn().click();
			welcomePo.getEleLoginLnk().click();
			loginPo.getEleGoogleLoginLnk().click();
			Thread.sleep(10000);
			driver.tap(1,182,79,1);
			driver.tap(1,182,79,1);
			Thread.sleep(10000);
			driver.tap(1,207,278,1);
			Thread.sleep(5000);
		//Switching from webview to native app
		Set<String> contextHandles1=driver.getContextHandles();
		for(String contextHandle1:contextHandles1){
			if(contextHandle1.contains("WEBVIEW")){
				driver.context(contextHandle1);
			}
		}
		loginPo.getEleGmailSignLink().click();
		Thread.sleep(10000);
		loginPo.getEleGmailRemoveBtn().click();
		loginPo.getEleGmailAccountBtn().click();
		loginPo.getEleGmailRemoveBtn().click();
		Thread.sleep(1000);

	}
		catch(Exception e){
			
		}
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: login_12
	 * @Descripyion: Tap over T&C apply link and verify.
	 * 				 Tap over SKIP link and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=12,enabled=true,description="To tap T and C link and Skip link in login page.")
	public void TandCApplyLnk() throws Exception
	{
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{
			//tap T & C link and verify
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			Assert.assertTrue(welcomePo.getEleTermsCLnk().isDisplayed(), "Terms and Condition link is not displayed");
			NXGReports.addStep("Terms and condition link is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleTermsCLnk().click();
			Assert.assertTrue(welcomePo.getEleTermsCTxt().isDisplayed(), "Sulekha Terms and conditions page is not displayed");
			NXGReports.addStep("Sulekha Terms and conditions page is successfully displayed", LogAs.PASSED, null);
			
			//Tap over SKIP link and verify.
			welcomePo.getEleBackIcn().click();
			Assert.assertTrue(welcomePo.getEleSkipLnk().isDisplayed(), "Skip is not displayed");
			NXGReports.addStep("Skip button is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleSkipLnk().click();
			Thread.sleep(3000);
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "User is not navigated to Home page");
			NXGReports.addStep("User be navigated to Home page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

}
