/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Test scripts of Welcome. 
 * @module			:		Welcome
 * @testmethod		:	   	LocationAlertAndSkipBtn()
 * @testmethod		:	   	DontAllowLocation()
 * @testmethod		:	   	NotificationPermissionAlert()
 * @testmethod		:	   	DontAllowNotification()
 */

package com.test.scripts;

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
import com.test.po.MDLDPO;
import com.test.po.MorePO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;
public class WelcomePage extends BaseLib 
{
	String sTestData=null;
	String[] sData=null;
	WelcomePO welcomePo;
	HomePO homePo;
	LoginPO loginPo;
	PostNeedPO postneedPo;
	MyNeedsDashboardPO myNeedsDashboadrdpo;
	MDLDPO mdldpo;
	MorePO morePo;

	/* @TestCaseID: Welcome_01
	 * @Description: To check whether location permission alert is displayed on launching the app
	 * 				 Tap over "Allow" on location permission alert and verify
	 * 				 To tap over "skip" button and verify, should navigate to home page
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="To check location permission alert ,Allow location and tap on skip button in onboarding screen.")
	public void LocationAlertAndSkipBtn() throws Exception
	{
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{
			//To check whether location permission alert is displayed on launching the app
			Assert.assertTrue(welcomePo.getEleAllowSulekhaTxt().isDisplayed(), "Allow Sulekha to access your location text is not displayed");
			NXGReports.addStep("Allow Sulekha to access your location even when you are not using the app? text is displayed", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleAllowBtn().isDisplayed(), "Location permission alert popup with Allow button is not displayed");
			NXGReports.addStep("Location popup with Allow button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleDontAllowBtn().isDisplayed(), "Location permission alert popup with Dont Allow button is not displayed");
			NXGReports.addStep("Location popup with Dont Allow button is successfully displayed", LogAs.PASSED, null);
			
			//Tap over "Allow" on location permission alert and verify
			welcomePo.getEleAllowBtn().click();
			welcomePo.getEleOKBtn().click();
			Assert.assertTrue(welcomePo.getEleSkipBtn().isDisplayed(),"Notification popup is not handled");
			NXGReports.addStep("Notification popup is successfully handled", LogAs.PASSED, null);
			
			//To tap over "skip" button and verify, should navigate to home page
			welcomePo.getEleSkipBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Loging is skipped and Home screen is successfully handled", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleLocationTxtFld().getText().equals("Bangalore"),"City location is not displayed");
			NXGReports.addStep("Current city is successfully handled", LogAs.PASSED, null);
			}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	
	/* @TestCaseID: Welcome_02
	 * @Description: Tap over "Don't Allow" on location permission alert and verify
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="Tap over 'Don't Allow' on location permission alert and verify")
	public void DontAllowLocation()
	{
		sTestData="Welcome_02";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{
			Assert.assertTrue(welcomePo.getEleOKBtn().isDisplayed(), "Location permission alert popup is not displayed");
			NXGReports.addStep("Location permission alert popup is successfully displayed", LogAs.PASSED, null);
			//welcomePo.getEleDontAllowBtn().click();
			welcomePo.getEleOKBtn().click();
			Assert.assertTrue(welcomePo.getEleSkipBtn().isDisplayed(),"Notification popup is not handled");
			NXGReports.addStep("Notification popup is successfully handled", LogAs.PASSED, null);
			welcomePo.getEleSkipBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Login is skipped and Home screen is successfully displayed", LogAs.PASSED, null);
			//Assert.assertTrue(homePo.getEleLocationTxtFld().getText().equals("Enter your city"),"City location is displayed");
			//NXGReports.addStep("City is not displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Welcome_03
	 * @Description: Check whether Push notification permission alert is displayed on launching the app
	 * 				 Tap over "OK" on Push notification permission alert and verify
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="To check notification permission alert and tap on its OK button.")
	public void NotificationPermissionAlert() throws Exception
	{
		sTestData="Welcome_05";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		postneedPo=new PostNeedPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			//Check whether Push notification permission alert is displayed on launching the app
			Assert.assertTrue(welcomePo.getEleNotificationAlertTxt().isDisplayed(), "Sulekha would like to send you Notification text is not displayed");
			NXGReports.addStep("Sulekha would like to send you Notification text is displayed", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleDontAllowBtn().isDisplayed(), "Location permission alert popup with Dont Allow button is not displayed");
			NXGReports.addStep("Notification popup with Dont Allow button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleOKBtn().isDisplayed(), "Push notification permission alert popup is not displayed");
			NXGReports.addStep("Push notification permission with ok option is successfully displayed", LogAs.PASSED, null);
			
			//Tap over "OK" on Push notification permission alert and verify
			welcomePo.getEleOKBtn().click();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(homePo, sData);
			Thread.sleep(2000);
			//driver.tap(1, 107,142,1);
			driver.findElement(By.id("Home Appliances Repair & Services")).click();
			postneedPo.getEleAcTxt().click();
			Assert.assertTrue(homePo.getEleContinueBtn().isDisplayed(), "Fill the form and get free quotes button is not displayed");
			NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.PASSED, null);
			homePo.getEleContinueBtn().click();
			welcomePo.handleAcForm(mdldpo,sData);
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit request button is not displayed");
			NXGReports.addStep("Submit request button is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleSubmitRequestBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNeedNotiSMSTxt().isDisplayed(),"Push notification is not received to user mobile after need is distributed to businesses");
			NXGReports.addStep("Push notification is received to user mobile after need is distributed to businesses", LogAs.PASSED, null);

			
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	

	/* @TestCaseID: Welcome_04
	 * @Description: Tap over "Don't Allow" on Push notification permission alert
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description=" Tap over 'Don't Allow' on Push notification permission alert")  
	public void DontAllowNotification() throws Exception
	{
		sTestData="Welcome_06";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		postneedPo=new PostNeedPO(driver);
		morePo = new MorePO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			
			welcomePo.getEleDontAllowBtn().click();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(homePo, sData);
			Thread.sleep(2000);
			driver.findElement(By.id("Home Appliances Repair & Services")).click();
			postneedPo.getEleAcTxt().click();
			Assert.assertTrue(homePo.getEleContinueBtn().isDisplayed(), "Fill the form and get free quotes button is not displayed");
			NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.PASSED, null);
			homePo.getEleContinueBtn().click();
			welcomePo.handleAcForm(mdldpo,sData);
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit request button is not displayed");
			NXGReports.addStep("Submit request button is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleSubmitRequestBtn().click();
			
			try{
				welcomePo.getEleBackArwIcn().click();
				Assert.assertTrue(welcomePo.getEleMatchedBusiTxt().isDisplayed(),"Posted need is still displayed under notifications");
				NXGReports.addStep("Posted need is no more displayed under notifications", LogAs.PASSED, null);
			}catch(Exception e){
				Assert.assertTrue(welcomePo.getEleMatchedBusiTxt().isDisplayed(),"Posted need is still displayed under notifications");
				NXGReports.addStep("Posted need is no more displayed under notifications", LogAs.PASSED, null);
			}
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}


	
