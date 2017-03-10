/***********************************************************************
 * @author 			:	  Yashi Priya
 * @description		: 	  Test scripts of More Test 
 * @module			:	  MoreTest
 * @testmethod		:	  MoreScreenAndShortlist() 	
 * @testmethod		:	  ListMyBuisnessPage()
 * @testmethod		:	  NotificationPage()
 * @testmethod		:	  RemoveMyShortlist()	
 * @testmethod		:	  PostedReview()
 * @testmethod		:	  AnyReview()
 */
package com.test.scripts;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.test.baselib.GenericLib;
import com.test.baselib.SampleBaseLib;
import com.test.po.BusinessProfilePO;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MorePO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;
import io.appium.java_client.ios.IOSElement;

public class More extends SampleBaseLib
{
	String sTestData;
	String[] sData = null;
	String sNeed;
	WelcomePO welcomePo = null;
	LoginPO loginPo = null;
	HomePO homePo = null;
	MorePO morePo = null;
	BusinessProfilePO businessprofilePo=null;
	PostNeedPO postneedPo=null;
	MyNeedsDashboardPO myneeddashboardPo=null;
	JavascriptExecutor js=null;
	HashMap<String, String> scrollObject=null;
	
	@BeforeClass
	public void login() throws InterruptedException
	{
		sTestData="SDLDwithoutType_01";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		morePo=new MorePO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		postneedPo=new PostNeedPO(driver);
		myneeddashboardPo=new MyNeedsDashboardPO(driver);
			
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
	 * @TestCaseID: More_01
	 * @Description: Tap on More in Home page
	 * 			     Check tapping on "Shortlists"
	 * @Author: Yashi Priya
	 */
	@Test(priority = 1, enabled =true,description="Tap on More in Home page and tap on shortlist link.")
	public void MoreScreenAndShortlist() 
	{
		sTestData = "More_01";
		sData = GenericLib.toReadExcelData(sTestData);
		try 
		{
			//Tap on More in Home page
			Assert.assertTrue(homePo.getEleMoreIcn().isDisplayed(), "More icon in Home screen is not displayed");
			NXGReports.addStep("More icon in Home screen is successfully displayed", LogAs.PASSED, null);
			homePo.getEleMoreIcn().click();
			Assert.assertTrue(homePo.getEleShortListLnk().isDisplayed(), "Shortlist Link is not displayed");
			NXGReports.addStep("Shortlist Link is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleListMyBusinessLnk().isDisplayed(), "List My Business Link is not displayed");
			NXGReports.addStep("List My Business Link is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getElePropRentLnk().isDisplayed(), "Properties/Rentals Link is not displayed");
			NXGReports.addStep("Properties/Rentals Link is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleProfileAndSettingTxt().isDisplayed(), "Profile & Setting text is not displayed");
			NXGReports.addStep("Profile & Setting text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleCharwithusTxt().isDisplayed(), "Chat with us text is not displayed");
			NXGReports.addStep("Chat with us text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleUpdateMyAccLnk().isDisplayed(), "Update my account Link is not displayed under Profile & Setting");
			NXGReports.addStep("Update my account Link is successfully displayed under Profile & Setting", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleLogoutLnk().isDisplayed(), "Logout Link is not displayed under Profile & Setting");
			NXGReports.addStep("Logout Link is successfully displayed under Profile & Setting", LogAs.PASSED, null);
			
			//Check tapping on "Shortlists"
			homePo.getEleShortListLnk().click();
			Assert.assertTrue(morePo.getEleShortlistedBusiLst().isDisplayed(), "Shortlist page is not displayed with all the user shortlisted businesses");
			NXGReports.addStep("Shortlist page is successfully displayed with all the user shortlisted businesses", LogAs.PASSED, null);

		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/*
	 * @TestCaseID: More_02
	 * @Description: Check tapping on "List my business"
	 * @Author: Yashi Priya
	 */
	@Test(priority = 2, enabled =true,description="Check tapping on 'List my business'")
	public void ListMyBuisnessPage() 
	{
		sTestData = "More_01";
		sData = GenericLib.toReadExcelData(sTestData);
		
		try 
		{
			Assert.assertTrue(homePo.getEleMoreIcn().isDisplayed(), "More icon in Home screen is not displayed");
			NXGReports.addStep("More icon in Home screen is successfully displayed", LogAs.PASSED, null);
			homePo.getEleMoreIcn().click();
			morePo.getEleListMyBusinessLnk().click();
			Assert.assertTrue(morePo.getEleAddBuisnessTxt().isDisplayed(), "List My Business page is not displayed");/*Verify the element in appium inspector on iOS*/
			NXGReports.addStep("List My Business page is successfully displayed", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/*
	 * @TestCaseID: Notification_03
	 * @Description: View notification and verify
	 * 				 Tap on the notification displayed
	 * @Author: Yashi Priya
	 */
	@Test(priority = 3, enabled =true,description="View notification and tap on any of it.")
	public void NotificationPage() throws Exception 
	{
		sTestData = "Notification_02";
		sData = GenericLib.toReadExcelData(sTestData);
	
		try 
		{
			//View notification and verify
			morePo.getEleNotificationTab().click();
			Assert.assertTrue(morePo.getEleNotificationTxt().isDisplayed(), "Notifications page is not displayed");
			NXGReports.addStep("Notifications page is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleNotificationListItm().isDisplayed(),"Notification is not displayed with need name");
			NXGReports.addStep("Notification is successfully displayed with need name", LogAs.PASSED, null);
			Thread.sleep(10000);
			Assert.assertTrue(morePo.getEleNumberofBusinessTxt().isDisplayed(), "Need name is not displayed with number of businesses matched");
			NXGReports.addStep("Need name is successfully displayed with number of businesses matched", LogAs.PASSED, null);
			
			//Tap on the notification displayed
			postneedPo.getEleNotificationListItm().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "Responses page is not displayed");
			NXGReports.addStep("Responses page is successfully displayed", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/*
	 * @TestCaseID: RmvShortlist_04
	 * @Description: Remove shortlist and verify.
	 * @Author: Yashi Priya
	 */
	@Test(priority = 4, enabled =true,description="Remove shortlist and verify.")
	public void RemoveMyShortlist() throws Exception 
	{
		sTestData = "More_01";
		sData = GenericLib.toReadExcelData(sTestData);
		String sBusinessName=null;
		String sBusinessName1=null;
		try 
		{
			myneeddashboardPo.getEleDashboardBtn().click();
			try{
				driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
			}catch(Exception e){
				driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).click();
			}
			driver.findElement(By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[3]")).click();
			Thread.sleep(3000);
			welcomePo.getEleBackArwIcn().click();
			homePo.getEleBackArwIcn().click();
			homePo.getEleMoreIcn().click();
			homePo.getEleShortListLnk().click();
			sBusinessName=driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")).getText();
			System.out.println(sBusinessName);
			Thread.sleep(3000);
			homePo.getEleRemoveShotIcn().click();
			sBusinessName1=sBusinessName=driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")).getText();
			System.out.println(sBusinessName1);
			Assert.assertFalse(sBusinessName.equals(sBusinessName1), "Shortlist is not removed in the shortlist page");
			NXGReports.addStep("Shortlist is successfully removed in the shortlist page", LogAs.PASSED, null);
			

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: My Reviews_05
	 * @Description: Check whether review posted by the user is displayed in Reviews page.
	 * @Author: Yashi Priya*///bug- posted review is not displayed in the reviews page.
	@Test(priority=5,enabled=true,description="Check whether review posted by the user is displayed in Reviews page.")
	public void PostedReview() throws Exception
	{
		sTestData="My Reviews_01";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{	
			myneeddashboardPo.getEleDashboardBtn().click();
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
			myneeddashboardPo.getEleReviewLink().click();
			myneeddashboardPo.getEleYesBtn().click();
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(), "A popup to post a review is not displayed");
			NXGReports.addStep("A popup to post a review is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.toTapOnRatingBar();
			Assert.assertTrue(businessprofilePo.getEleWriteyourreviewTxtFld().isDisplayed(), "Write your review text field is not displayed");
			NXGReports.addStep("Write your review text field is successfully displayed", LogAs.PASSED, null);
			((IOSElement) driver.findElement(By.id("Enter a minimum of 25 characters"))).setValue(sData[10]);
			homePo.getEleKeyboardReturnBtn().click();
			businessprofilePo.getElePOSTREVIEWBtn().click();
			Thread.sleep(10000);
			morePo.getEleMyReviewIcn().click();
			Assert.assertTrue(morePo.getEleReviewsLstItm().getText().equals(sData[10]), "The review is not displayed under Reviews tab");
			NXGReports.addStep("The review is successfully displayed under Reviews tab", LogAs.PASSED, null);
			}

		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/*
	 * @TestCaseID: My Reviews_06
	 * @Description: Tap on any review displayed in My reviews page
	 * @Author: Yashi Priya
	 */
	@Test(priority = 6, enabled =true,description="Tap on any review displayed in My reviews page")
	public void AnyReview() 
	{
		sTestData = "My Reviews_02";
		sData = GenericLib.toReadExcelData(sTestData);
		
		try 
		{
			morePo.getEleMyReviewIcn().click();
			morePo.getEleReviewsLstItm().click();
			Assert.assertTrue(businessprofilePo.getEleReviewDetailView().isDisplayed(), "User is not navigated to detailed view of the review");
			NXGReports.addStep("User is successfully navigated to detailed view of the review", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


}




