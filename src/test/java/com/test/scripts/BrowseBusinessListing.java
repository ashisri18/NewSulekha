/***********************************************************************
 * @author 			:		RaghuKiran MR 
 * @description		: 		Test scripts of BrowseBusinessListing 
 * @module			:		BrowserBusinessListing
 * @testmethod		:	    fillLink()
 * @testmethod		:	   	browseBusinessListingPage()
 * @testmethod		:	   	floatSortBtn()
 */
package com.test.scripts;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.test.baselib.BaseLib;
import com.test.baselib.GenericLib;
import com.test.baselib.SampleBaseLib;
import com.test.po.BusinessProfilePO;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MDLDPO;
import com.test.po.MorePO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;

public class BrowseBusinessListing extends SampleBaseLib {
	String sTestData=null;
	String[] sData=null;
	String sNeed;
	HomePO homePo=null;
	PostNeedPO postneedPo;
	MyNeedsDashboardPO myneedsdashboardPo=null;
	BusinessProfilePO businessprofilePo=null;
	LoginPO loginPo=null;
	WelcomePO welcomePo=null;
	MorePO morePo=null;
	MDLDPO mdldpo=null;

	/* @TestCaseID:BusinessProfilePage_01
	 * @Description:Select any item in Browse business listing and verify.
	 * @Author: RaghuKiran*/

	@BeforeClass
	public void login() throws InterruptedException
	{
		sTestData="SDLDwithoutType_01";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];

		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		myneedsdashboardPo = new MyNeedsDashboardPO(driver);
		businessprofilePo = new BusinessProfilePO(driver);
		morePo = new MorePO(driver);
		mdldpo = new MDLDPO(driver);
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
	/* @TestCaseID:BusinessProfilePage_01
	 * @Description:Select any item in Browse business listing and verify
	 * @Author: RaghuKiran*/
	@Test(priority=1,enabled=true,description="Select any item in Browse business listing and verify.")
	public void businessProfilePage() throws Exception
	{
		sTestData="BrowseBusinessListing_01";
		sData=GenericLib.toReadExcelData(sTestData);

		try{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.searchNeed(sData[7]);
			homePo.getEleFirstOption().click();
			Thread.sleep(2000);
			postneedPo.getEleFormRadioBtn1().click();
			Assert.assertTrue(homePo.getEleContinueBtn().isDisplayed(),"Continue button is not displayed");
			NXGReports.addStep("Continue button is successfully displayed", LogAs.PASSED, null);
			homePo.getEleContinueBtn().click();
			Assert.assertTrue(homePo.getEleViewListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleViewListingBtn().click();
			Assert.assertTrue(businessprofilePo.getEleGetQuotesForBusinessLstItm().isDisplayed(), "Business listing page is not displayed");
			NXGReports.addStep("Business listing page is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleGetQuotesForBusinessLstItm().click();
			Assert.assertTrue(businessprofilePo.getEleBusinessNameTxt().isDisplayed(),"User is not navigated to business profile page");
			NXGReports.addStep("User is successfully navigated to business profile page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:Needposting_02
	 * @Description:Tap over "Tap to fill.." link and verify whether user is redirected to need form.
	 * @Author: RaghuKiran*/
	@Test(priority=2,enabled=true,description="Tap over 'Tap to fill' link and verify whether user is redirected to need form.")
	public void fillLink() throws Exception
	{
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);

		try{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.searchNeed(sData[7]);
			homePo.getEleFirstOption().click();
			Thread.sleep(2000);
			homePo.getEleViewListingBtn().click();
			Thread.sleep(3000);
			Assert.assertTrue(businessprofilePo.getGetQuotesBtn().isDisplayed(),"Get Quotes button is not displayed");
			NXGReports.addStep("Get Quotes button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getGetQuotesBtn().click();
			Thread.sleep(3000);
			Assert.assertTrue(businessprofilePo.getEleNeedNameTxt().isDisplayed(), "Need name text is not displayed");
			NXGReports.addStep("Need name text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(),"User should not navigated to LCF of the need");
			NXGReports.addStep("User should be navigated to LCF of the need", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}


	}
	/* @TestCaseID:BusinessProfilePage_03
	 * @Description:Tap over CALL icon and verify.
	 *             :Tap over Sms icon and verify
	 *             :Tap on shortList icon and verify.
	 *             :
	 * @Author: RaghuKiran*/
	@Test(priority=3,enabled=true,description="To tap over call , sms and shortlist icons and verify.")
	public void browseBusinessListingPage() throws Exception
	{
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);

		try{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.searchNeed(sData[7]);
			homePo.getEleFirstOption().click();
			Thread.sleep(2000);
			homePo.getEleViewListingBtn().click();
			Assert.assertTrue(businessprofilePo.getEleCallBtn().isDisplayed(),"Call icon is not displayed");
			NXGReports.addStep("Call icon is successfully displayed", LogAs.PASSED, null);
			Thread.sleep(6000);
			businessprofilePo.getEleCallBtn().click();
			businessprofilePo.handlingCall();
			Thread.sleep(6000);
			Assert.assertTrue(businessprofilePo.getEleSmsBtn().isDisplayed(),"Sms icon is not displayed");
			NXGReports.addStep("Sms icon  is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleSmsBtn().click();
			Assert.assertTrue(businessprofilePo.getEleNewMsgTxt().isDisplayed(), "Message popup is not displayed");
			NXGReports.addStep("Message popup is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleSMSToTxtFld().isDisplayed(), "Message popup is not displayed with the to field containing business number");
			NXGReports.addStep("Message popup is successfully displayed with the to field containing business number", LogAs.PASSED, null);
			businessprofilePo.getEleCancelBtn().click();
			//Tap on shortList icon and verify.
			postneedPo.getShortlistIcon().click();

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:BusinessProfilePage_06
	 * @Description:Tap on the Sort button displayed on right corner of business listing page
	 *             :Tap on Sort by score from sort option
	 *             :Tap on Sort by rating from sort option.
	 *             :Tap on Sort by default from sort option
	 *         
	 * @Author: RaghuKiran*/
	@Test(priority=4,enabled=true,description="Tap on the Sort button displayed in business listing page and tap on “sort by score”, “sort by rating” and “sort by default” options.")
	public void floatSortBtn() throws Exception
	{
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);
		String sScoreValue=null;
		String svalue=null;
		String sRatingvalue=null;
		String sRatingvalue1=null;
		String sBusinessName=null;
		String sBusinessName1=null;

		try{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.searchNeed(sData[7]);
			homePo.getEleFirstOption().click();
			Thread.sleep(2000);
			homePo.getEleViewListingBtn().click();
			sScoreValue = myneedsdashboardPo.getEleScoreTxt().getText();
			sRatingvalue=businessprofilePo.getEleRatingList().getText();
			sBusinessName= businessprofilePo.getEleBusinessNameTxt().getText();
			Assert.assertTrue(businessprofilePo.getElefloatsortBtn().isDisplayed(),"Float sort button is not displayed");
			NXGReports.addStep("Float sort button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getElefloatsortBtn().click();
			Assert.assertTrue(businessprofilePo.getEleSortByScoreBtn().isDisplayed(),"Sort By Score button is not displayed");
			NXGReports.addStep("Sort By Score button is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}


	}


}
