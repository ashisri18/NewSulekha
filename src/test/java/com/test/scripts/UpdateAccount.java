/***********************************************************************
 * @author 			:	   RAGHU KIRAN MR
 * @description		: 	   Test scripts of UpdateAccount
 * @module			:	   UpdateAccount
 * @testmethod		:	   UpdateMyAccountPageChangePassword()
 * @testmethod		:	   ChangeMobNum()
 * @testmethod		:	   ChangeUsername()
 */
package com.test.scripts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.test.baselib.GenericLib;
import com.test.baselib.SampleBaseLib;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MorePO;
import com.test.po.PostNeedPO;
import com.test.po.UpdateAccountPO;
import com.test.po.WelcomePO;
import io.appium.java_client.ios.IOSElement;

public class UpdateAccount extends SampleBaseLib {
	String sTestData;
	String[] sData = null;
	String sNeed;
	WelcomePO welcomePo = null;
	LoginPO loginPo = null;
	HomePO homePo = null;
	UpdateAccountPO updateAccountPo = null;
	PostNeedPO postneedPo=null;
	MorePO morePo=null;
	@BeforeClass
	public void login() throws InterruptedException
	{
		sTestData="SDLDwithoutType_01";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];

		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo=new UpdateAccountPO(driver);
		postneedPo=new PostNeedPO(driver);
		morePo=new MorePO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(homePo, sData);
			Thread.sleep(3000);
			driver.closeApp();
			Thread.sleep(3000);
		}catch(Exception e){
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/*
	 * @TestCaseID: UpdateAccount_02
	 * @Description: Check the Update my account page.
	 *             : Tap on Change Password button displayed in Update my account page
	 *             : Enter the valid values for Change password and tap on the button
	 *             : Verify the logout button is displayed in the more page
	 * @Author: RaghuKiran MR
	 */
	@Test(priority=1, enabled=true,description="Check the Update my account page and change the password and verify logout button in more page")
	public void UpdateMyAccountPageChangePassword() throws Exception {
		sTestData = "UpdateAccount_02";
		sData = GenericLib.toReadExcelData(sTestData);

		try {
			Assert.assertTrue(homePo.getEleMoreIcn().isDisplayed(), "Home screen with more tab is not displayed");
			NXGReports.addStep("Home screen More tab is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.navigateToUpdateAcc(homePo);
			Assert.assertTrue(updateAccountPo.getEleUpdateAccEmailTxt().isDisplayed(),"Email id is not displayed");
			NXGReports.addStep("Email id is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleChangePwdBtn().isDisplayed(),"Change password button is not displayed");
			NXGReports.addStep("Change password button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo. getEleUserNameTxt().isDisplayed(),"Username text is not displayed");
			NXGReports.addStep("Change password button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleMobileTxt().isDisplayed(),"Mobile text is not displayed");
			NXGReports.addStep("Mobile text is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.getEleChangePwdBtn().click();
			Assert.assertTrue(updateAccountPo.getEleChangePwdTxt().isDisplayed(), "Change password popup is not displayed");
			NXGReports.addStep("Change password popup is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleCurrentPwdFld().isDisplayed(), "Current password field is not displayed");
			NXGReports.addStep("Current password field is Successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getElenewPwdFld().isDisplayed(),"New password field is not displayed");
			NXGReports.addStep("New password field is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleRetypenewPwdFld().isDisplayed(),"Retype new password field is not displayed");
			NXGReports.addStep("Retype new password field  is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleCancelBtn().isDisplayed(), "Cancel button is not displayed");
			NXGReports.addStep("Cancel button is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.getEleCancelBtn().click();
			updateAccountPo.getEleChangePwdBtn().click();
			((IOSElement) driver.findElement(By.id("Enter your current Password"))).setValue("cbt@123");
			((IOSElement) driver.findElement(By.id("Enter your new Password"))).setValue("cbt@1234");
			((IOSElement) driver.findElement(By.id("Retype Password"))).setValue("cbt@1234");
			homePo.getEleKeyboardReturnBtn().click();
			Thread.sleep(5000);
			driver.tap(1,18,375,2000);
			Thread.sleep(5000);
			Assert.assertTrue(updateAccountPo.getEleChangePwdBtn().isDisplayed(), "Password is not changed");
			NXGReports.addStep("Password is  changed", LogAs.PASSED, null);
			//cLeanup code
			updateAccountPo.getEleChangePwdBtn().click();
			((IOSElement) driver.findElement(By.id("Enter your current Password"))).setValue("cbt@1234");
			((IOSElement) driver.findElement(By.id("Enter your new Password"))).setValue("cbt@123");
			((IOSElement) driver.findElement(By.id("Retype Password"))).setValue("cbt@123");
			homePo.getEleKeyboardReturnBtn().click();
			Thread.sleep(5000);
			driver.tap(1,18,375,2000);
			Thread.sleep(5000);
			welcomePo.getEleBackIcn().click();
			homePo.getEleMoreIcn().click();
			Assert.assertTrue(updateAccountPo.getEleLogoutBtn().isDisplayed(), "Logout button is not displayed in More screen");
			NXGReports.addStep("Logout button is successfully displayed in More screen", LogAs.PASSED, null);
			updateAccountPo.getEleLogoutBtn().click();
			Assert.assertTrue(updateAccountPo.getEleLoginBtn().isDisplayed(), "Login screen is not displayed.");
			NXGReports.addStep("Login screen is successfully displayed", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}

	}


	/*
	 * @TestCaseID: UpdateAccount_03   
	 * @Description: Change the mobile number and tap on Save profile button
	 * @Author: RaghuKiran MR
	 */
	@Test(priority=2, enabled=true,description=" Change the mobile number and tap on Save profile button")
	public void ChangeMobNum() throws Exception {
		sTestData = "UpdateAccount_03";
		sData = GenericLib.toReadExcelData(sTestData);

		try {

			loginPo.loginViaMore(sData, homePo, morePo, updateAccountPo);
			updateAccountPo.navigateToUpdateAcc(homePo);
			driver.findElement(By.id("8105013728")).clear();
			((IOSElement) driver.findElement(By.id("Mobile Number"))).setValue("9980622771");
			homePo.getEleDoneBtn().click();
			Assert.assertTrue(updateAccountPo.getEleSaveProfileBtn().isDisplayed(), "Save profile button is not displayed");
			NXGReports.addStep("Save profile button is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.getEleSaveProfileBtn().click();
			Assert.assertTrue(welcomePo.getEleOTPCodeTxtFld().isDisplayed(),"Verification code text field is not displayed");
			NXGReports.addStep("Verification code text field is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOTPCodeTxtFld().sendKeys(sData[2]);
			Assert.assertTrue(updateAccountPo.getEleMobileTxt().getText().equals("9980622771"), "Mobile number is not update");
			NXGReports.addStep("Mobile number is successfully update", LogAs.PASSED, null);
			//cleanup code
			driver.findElement(By.id("9980622771")).clear();
			((IOSElement) driver.findElement(By.id("Mobile Number"))).setValue("8105013728");
			homePo.getEleDoneBtn().click();
			updateAccountPo.getEleSaveProfileBtn().click();
			Thread.sleep(2000);
		} catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/*
	 * @TestCaseID: UpdateAccount_03
	 * @Description: Change the name and tap on Save profile button
	 * @Author: RaghuKiran MR
	 */
	@Test(priority=3, enabled=true,description="Change the name and tap on Save profile button")
	public void ChangeUsername() {
		sTestData = "UpdateAccount_03";
		sData = GenericLib.toReadExcelData(sTestData);

		try {
			updateAccountPo.navigateToUpdateAcc(homePo);
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).clear();
			((IOSElement) driver.findElement(By.id("Name"))).sendKeys(sData[5]);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(updateAccountPo.getEleSaveProfileBtn().isDisplayed(),"Save profile button is not displayed");
			NXGReports.addStep("Save profile button is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.getEleSaveProfileBtn().click();
			updateAccountPo.getEleUpdatemyaccBtn().click();
			Assert.assertTrue(updateAccountPo. getEleUserNameTxt().getText().equals("Automation"), "Name of the user is not updated");
			NXGReports.addStep("Name of the user is successfully updated", LogAs.PASSED, null);
			//clean up code
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).clear();
			driver.findElement(By.id("Name")).sendKeys("Automation");
			homePo.getEleKeyboardReturnBtn().click();
			updateAccountPo.getEleSaveProfileBtn().click();
		} catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

}
