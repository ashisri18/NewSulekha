/***********************************************************************
 * @author 			:	RaghuKiran
 * @description		: 	Test scripts of NeedPosting 
 * @module			:	NeedPosting
 * @testmethod		:	NeedFormList()	
 * @testmethod		:	NeedFormLstWOOption()
 * @testmethod		:	BrowseBussinesslink()
 * @testmethod		:	BusinessLstWOOption()
 * @testmethod		:	NextWOChoosing()
 * @testmethod		:	OthersOptionNextBtnwithoutvalue()
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
import com.test.po.BusinessProfilePO;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MDLDPO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;
public class NeedPosting extends SampleBaseLib {
	String sTestData;
	String[] sData=null;
	String sNeed;
	WelcomePO welcomePo=null;
	LoginPO loginPo=null;
	HomePO homePo=null;
	PostNeedPO postneedPo=null;
	MDLDPO mdldPo=null;
	MyNeedsDashboardPO myNeedsDashboardPo=null;
	BusinessProfilePO businessprofilePo;



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
		myNeedsDashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		mdldPo=new MDLDPO(driver);
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


	/* @TestCaseID:Needposting_01
	 * @Description:Tap on the search box in the home page, enter a need name and tap on that search result need 
	 *             :Tap on any popular category and verify
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=1,enabled=true,description="Search for a need in home page and tap on any of the popular categories and verify.")
	public void SearchBoxPopularCategory() throws Exception{
		sTestData="Needposting_01";
		sData=GenericLib.toReadExcelData(sTestData);

		try{
				Thread.sleep(4000);
				driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleDoneBtn().click();
			//homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "An imtermediate pop-up will not displayed to chose need name");
			NXGReports.addStep("An imtermediate pop-up will be displayed to chose need name", LogAs.PASSED, null);
			homePo.getEleBackArwIcn().click();
			driver.findElement(By.id("Home Appliances Repair & Services")).click();
			Assert.assertTrue(homePo.getEleHomeAppliancesIcn().isDisplayed(),"An intermediate pop-up will not displayed to choose need name");
			NXGReports.addStep("An imtermediate pop-up will be displayed to chose need name", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleNeedList1().isDisplayed(), "Need list is not displayed");
			NXGReports.addStep("Need list is successfully displayed", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:Needposting_02
	 * @Description:Select a need from the list and tap on "Fill the form and get free quotes" button
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=2,enabled=true,description="Select a need from the list and tap on 'Fill the form and get free quotes' button")
	public void NeedFormList() throws Exception{
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);


		try{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleDoneBtn().click();
			homePo.getEleFirstOption().click();
			homePo.getEleContinueBtn().click();
			Thread.sleep(3000);
			Assert.assertTrue(businessprofilePo.getEleNeedNameTxt().isDisplayed(), "Need name text is not displayed");
			NXGReports.addStep("Need name text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(), "User should not redirected to the specific need form page");
			NXGReports.addStep("User should be redirected to the specific need form page", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:Needposting_02
	 * @Description:Tap on "Fill the form and get free quotes" button without choosing any option from the list
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=3,enabled=true,description="Tap on 'Fill the form and get free quotes' button without choosing any option from the list")
	public void NeedFormLstWOOption() throws Exception{
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);

		try{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleDoneBtn().click();
			homePo.getEleFirstOption().click();
			Thread.sleep(6000);
			homePo.getEleContinueBtn().click();
			Thread.sleep(3000);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleNextBtn().isDisplayed(), "Alert with message 'Please select one option' is not displayed");
			NXGReports.addStep("Alert with message 'Please select one option' is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:Needposting_02
	 * @Description:Select any need from the list and tap on "Browse bussinees listing" link
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=4,enabled=true,description="Select any need from the list and tap on 'Browse bussinees listing' link")
	public void BrowseBussinesslink() throws Exception{
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);

		try{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleDoneBtn().click();
			homePo.getEleFirstOption().click();
			Thread.sleep(6000);
			homePo.getEleViewListingBtn().click();
			Assert.assertTrue(businessprofilePo.getEleGetQuotesForBusinessLstItm().isDisplayed(), "Business listing page is not displayed");
			NXGReports.addStep("Business listing page is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getGetQuotesBtn().isDisplayed(), "Get quotes button is not displayed");
			NXGReports.addStep("Get quotes button is successfully displayed", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:Needposting_02
	 * @Description:Tap on "Browse business listing" link without choosing any option from the list
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=5,enabled=true,description="Tap on 'Browse business listing' link without choosing any option from the list")
	public void BusinessLstWOOption() throws Exception{
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);

		try{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleDoneBtn().click();
			homePo.getEleFirstOption().click();
			Thread.sleep(6000);
			postneedPo.getEleFormRadioBtn1().click();
			homePo.getEleContinueBtn().click();
			homePo.getEleViewListingBtn().click();
			Assert.assertTrue(businessprofilePo.getEleGetQuotesForBusinessLstItm().isDisplayed(), "Business listing page is not displayed");
			NXGReports.addStep("Business listing page is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getGetQuotesBtn().isDisplayed(), "Get quotes button is not displayed");
			NXGReports.addStep("Get quotes button is successfully displayed", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:Needposting_02
	 * @Description:In the need form Tap on the NEXT button without choosing any options
	 * @Author:RaghuKiran MR*/
	@Test(priority=6,enabled=true,description="In the need form Tap on the NEXT button without choosing any options")
	public void NextWOChoosing() throws Exception
	{
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleDoneBtn().click();
			homePo.getEleFirstOption().click();
			Thread.sleep(6000);
			homePo.getEleContinueBtn().click();
			Thread.sleep(3000);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldPo.getEleNextBtn().isDisplayed(), "An alert with please select atleast one optionis not displayed");
			NXGReports.addStep("An alert with please select atleast one optionis is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:Needposting_06
	 * @Description:Select "Others" as an Option in the question list
	 *             :Tap on next buton without providing any value in "Tell us more" field
	 * @Author:RaghuKiran MR*/
	@Test(priority=7,enabled=true,description="In need form choose 'Others' as an option and tap on next and tap next without entering any thing in tell us more field.")
	public void OthersOptionNextBtnwithoutvalue() throws Exception
	{
		sTestData="Needposting_06";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{

			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleDoneBtn().click();
			homePo.getEleFirstOption().click();
			homePo.getEleContinueBtn().click();
			Assert.assertTrue(mdldPo.getEleOthersBtn().isDisplayed(),"Other option is not displayed");
			NXGReports.addStep("Other option is successfully displayed", LogAs.INFO, null);
			mdldPo.getEleOthersBtn().click();
			mdldPo.getEleFormCheckArrowBox().click();
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
			postneedPo.getEleNextBtn().click();
			//Tap on next buton withoout providing any value in "Tell us more" field
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleNextBtn().isDisplayed(),"User should not displayed with the message 'Please enter value'");
			NXGReports.addStep("User should be displayed with the message 'Please enter value'", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}
