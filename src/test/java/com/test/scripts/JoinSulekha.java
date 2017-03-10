/***********************************************************************
* @author 			:		Yashi Priya
* @description		: 		Test scripts of Join Sulekha 
* @module			:		Join Sulekha
* @testmethod		:	   	InvalidValidMobileNum()
* @testmethod		:	   	OTPTimeAndResendCode()
* @testmethod		:	   	InvalidValidOtp()
* @testmethod		:	   	TermsAndCondition()
* @testmethod		:	   	SkipLnk()
* @testmethod		:	   	LoginLnk()
*/
package com.test.scripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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
import com.test.po.WelcomePO;
import io.appium.java_client.ios.IOSElement;

public class JoinSulekha extends BaseLib 
{
	String sTestData=null;
	String[] sData=null;
	WelcomePO welcomePo;
	HomePO homePo;
	LoginPO loginPo;

	/* @TestCaseID: Join Sulekha_01
	 * @Description: Tap over "join now" without entering mobile number
	 * 				 Tap over "join now" by entering invalid mobile number
	 * 				 Tap over "join now" button by entering valid mobile number
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="To tap join now button without mobile number, invalid mobile number and with valid mobile number.")
	public void InvalidValidMobileNum() throws Exception
	{
		sTestData="Join Sulekha_01";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		loginPo= new LoginPO(driver);
		try
		{	
			welcomePo.getEleOKBtn().click();
			welcomePo.getEleJOINSULEKHABtn().click();
			
			//Tap over "join now" without entering mobile number
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleMobileAlertPopup().isDisplayed(), "An alert with message Enter your mobile number is not displayed");
			NXGReports.addStep("An alert with message Enter your mobile number is successfully displayed", LogAs.PASSED, null);
			driver.switchTo().alert().accept();
			
			//Tap over "join now" by entering invalid mobile number
			((IOSElement) driver.findElement(By.id("Mobile number"))).setValue("1234567890");
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleInvalidMobileAlertPopup().isDisplayed(), "An alert with message Invalid mobile number, try again is not displayed");
			NXGReports.addStep("An alert with message Invalid mobile number, try again is successfully displayed", LogAs.PASSED, null);
			driver.switchTo().alert().accept();
			
			//Tap over "join now" button by entering valid mobile number
			loginPo.getEleEmailmob1TxtFld().clear();
			driver.switchTo().alert().accept();
			((IOSElement) driver.findElement(By.id("Mobile number"))).setValue("8105013728");
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleOTPCodeTxtFld().isDisplayed(), "Verification OTP screen is not displayed");
			NXGReports.addStep("Verification OTP screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_02
	 * @Description: Checking OTP time limit
	 *             : Tap on Resend code button displayed in OTP page after 120 seconds time up
	 *             : Check entering the OTP received through SMS
	 * @Author: Yashi Priya
	 */
	@Test(priority=2,enabled=true,description="To check otp time limit, resend code button, received otp through sms")
	public void OTPTimeAndResendCode() throws Exception
	{
		sTestData="Join Sulekha_05";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	
			//Checking OTP time limit
			welcomePo.getEleOKBtn().click();
			welcomePo.getEleJOINSULEKHABtn().click();
			((IOSElement) driver.findElement(By.id("Mobile number"))).setValue("8105013728");
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleOTPTimeLimitTxt().isDisplayed(), "A time limit of 120 seconds is not displayed");
			NXGReports.addStep("A time limit of 120 seconds is successfully displayed", LogAs.PASSED, null);
			driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
			Assert.assertTrue(welcomePo.getEleRESENDCODEBtn().isDisplayed(), "ResendCode button is not displayed after 120 seconds ");
			NXGReports.addStep("After 120 seconds, ResendCode button is successfully displayed.", LogAs.PASSED, null);
			
			//Tap on Resend code button displayed in OTP page after 120 seconds time up
			welcomePo.getEleRESENDCODEBtn().click();
			Assert.assertTrue(welcomePo.getEleCodeViaSMSTxt().isDisplayed(), "New verification code is not received vis SMS.");
			
			//Check entering the OTP received through SMS
			NXGReports.addStep("New OTP is received successfully via sms", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleOTPTimeLimitTxt().isDisplayed(), "A time limit of 120 seconds is not displayed");
			NXGReports.addStep("A time limit of 120 seconds is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOTPCodeTxtFld().sendKeys(sData[2]);
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home screen is not displayed");
			NXGReports.addStep("Home screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_03
	 * @Description: Tap over done button without entering the otp
	 *             : Check entering invalid otp
	 *             : Check entering less than 6 digit verfication code.
	 *             : To tap over edit icon in the OTP page and verify if join sulekha page appears.
	 *             : Check entering the received OTP.
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="To tap Done button without otp, with invalid otp,with less than 6 digit otp, and tap edit icon and enter received otp")
	public void InvalidValidOtp() throws Exception{
		sTestData="Join Sulekha_09";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		try{	
			//Tap over done button without entering the otp
			welcomePo.getEleOKBtn().click();
			welcomePo.getEleJOINSULEKHABtn().click();
			((IOSElement) driver.findElement(By.id("Mobile number"))).setValue("8105013728");
			welcomePo.getEleJOINNOWBtn().click();
			welcomePo.getEleOTPCodeTxtFld().click();
			welcomePo.getEleDoneBtn().click();
			Assert.assertTrue(welcomePo.getEleValidCodePopup().isDisplayed(), "An alert message to enter verification code is not displayed ");
			NXGReports.addStep("An alert message to enter valid verification code is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleOKBtn().click();
			Thread.sleep(6000);
			
			//Check entering invalid otp
			welcomePo.getEleOTPCodeTxtFld().sendKeys("123456");
			Assert.assertTrue(welcomePo.getEleValidCodePopup().isDisplayed(),"An alert message enter valid verification code popup is not displayed");
			NXGReports.addStep("An alert message enter valid verification code popup is successfully displayed", LogAs.PASSED, null);
			Thread.sleep(6000);
			loginPo.getEleOKBtn().click();
			Thread.sleep(6000);
			
			//Check entering less than 6 digit verfication code.
			welcomePo.getEleOTPCodeTxtFld().clear();
			welcomePo.getEleOTPCodeTxtFld().sendKeys("9999");
			welcomePo.getEleDoneBtn().click();
			Assert.assertTrue(welcomePo.getEle6DigitCodePopup().isDisplayed(),"An alert message enter 6-digit verification code  popup is not displayed");
			NXGReports.addStep("An alert message enter 6-digit verification code  popup is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleOKBtn().click();
			Assert.assertTrue(welcomePo.getEleEditIcn().isDisplayed(), "Edit icon in otp page is not displayed");
			NXGReports.addStep("Edit icon in otp page is successfully displayed", LogAs.PASSED, null);
			
			//To tap over edit icon in the OTP page and verify if join sulekha page appears.
			welcomePo.getEleEditIcn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			
			//Check entering the received OTP.
			loginPo.getEleEmailmob1TxtFld().clear();
			driver.switchTo().alert().accept();
			welcomePo.getEleMobileNoTxtFld().sendKeys(sData[1]);
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleOTPCodeTxtFld().isDisplayed(),"Verification OTP screen is not displayed");
			NXGReports.addStep("Verification OTP screen is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOTPCodeTxtFld().sendKeys(sData[2]);
			
			
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: Join Sulekha_4
	 * @Description: To tap over "T & C" link in the join sulekha page
	 * 				 Tap over Back button from Terms and conditions page.
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="To tap T and C link in join sulekha page and navigating back from t and c page.")
	public void TermsAndCondition()
	{
		welcomePo=new WelcomePO(driver);
		try
		{	
			
			welcomePo.getEleOKBtn().click();
			welcomePo.getEleJOINSULEKHABtn().click();
			
			//To tap over "T & C" link in the join sulekha page
			Assert.assertTrue(welcomePo.getEleTermsCLnk().isDisplayed(),"T and C link is not displayed in join sulekha page");
			NXGReports.addStep("T and C link is successfully displayed in join sulekha page", LogAs.PASSED, null);
			welcomePo.getEleTermsCLnk().click();
			Assert.assertTrue(welcomePo.getEleTermsCTxt().isDisplayed(), "T & C screen is not displayed");
			NXGReports.addStep("T & C screen is successfully displayed", LogAs.PASSED, null);
			
			//Tap over Back button from Terms and conditions page.
			welcomePo.getEleBackIcn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join Sulekha screen is not displayed");
			NXGReports.addStep("Join Sulekha screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_5
	 * @Description: To tap over "skip" link in join sulekha page and verify if home page is displayed
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=true,description=" To tap over 'skip' link in join sulekha page and verify if home page is displayed")
	public void SkipLnk() throws Exception
	{
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	
			
			welcomePo.getEleOKBtn().click();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleSkipLnk().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleSkipLnk().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home screen is not displayed");
			NXGReports.addStep("Home screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_6
	 * @Description: To tap over "login" link in the join sulekha page and verify if "login page is displayed
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=true,description="To tap over 'login' link in the join sulekha page and verify if 'login page is displayed")
	public void LoginLnk()
	{
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		try
		{	
			
			welcomePo.getEleOKBtn().click();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleLoginLnk().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleLoginLnk().click();
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login screen is not displayed");
			NXGReports.addStep("Login screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


}
