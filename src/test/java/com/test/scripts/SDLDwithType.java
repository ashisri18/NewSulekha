/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Test scripts of SDLDwithType. 
 * @module			:		SDLDwithType
 * @testmethod		:	   	SDLDNeedWithType()
 * @testmethod		:	   	OptionAlert()
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
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;

public class SDLDwithType extends SampleBaseLib {
	String sTestData=null;
	String[] sData=null;
	String sNeed;
	PostNeedPO postneedPo;
	HomePO homePo;
	LoginPO loginPo;
	WelcomePO welcomePo;
	MyNeedsDashboardPO myNeedsDashboardPo;
	@BeforeClass
	public void login() throws InterruptedException
	{
		sTestData="SDLDwithType_01";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		myNeedsDashboardPo=new MyNeedsDashboardPO(driver);
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


	/* @TestCaseID: SDLDwithType_01
	 * @Description: Search for a SDLD need with type(Ex: Ambulance Services), and post a need.
	 * 				 Check if user is shown question with select options
	 * 				 Tap on NEXT in Contact information page,user should be navigated to Confirm and submit page."
	 * 				 Tap over EDIT icon for the attribute group questionnaire in Confirm and submit page,User should be navigated to that specific questionnaire.
	 * 				 Tap over NEXT button after updating.User should be navigated to Confirm and submit page after updating an attribute in the question page.
	 * 				 Tap over SUBMIT button in Confirm and submit page
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="Search for SDLD need with type and check if question with select options is displayed, tap on next in contact info page, edit attribute in confirm and submit page,update attribute and tap next and submit the need.")
	public void SDLDNeedWithType() throws Exception
	{
		sTestData="SDLDwithType_01";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		
		try
		{
			//Only one question form should be displayed followed by Contact Info page AND User should be shown a single select question with types to choose
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			homePo.getEleDoneBtn().click();
			//homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			homePo.getEleFirstOption().click();
			homePo.getEleContinueBtn().click();
			Assert.assertTrue(postneedPo.getEleFormPagingTxt().isDisplayed(), "More than one question form is displayed");
			NXGReports.addStep("Only one question form is displayed", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleFormRadioBtn().isDisplayed(), "User is not shown with a single select question with types to choose");
			NXGReports.addStep("User is successfully shown with a single select question with types to choose", LogAs.PASSED, null);
			postneedPo.getEleFormRadioBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "User is not followed to contact information screen");
			NXGReports.addStep("User is successfully followed to contact information screen", LogAs.PASSED, null);
			
			//Tap on NEXT in Contact information page,user should be navigated to Confirm and submit page."
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "Confirm and submit page is not displayed");
			NXGReports.addStep("Confirm and submit page is successfully displayed", LogAs.PASSED, null);
			
			//Tap over EDIT icon for the attribute group questionnaire in Confirm and submit page,User should be navigated to that specific questionnaire.
			Assert.assertTrue(postneedPo.getEleEditIcn().isDisplayed(), "Edit icon is not displayed in submit page");
			NXGReports.addStep("Edit icon is displayed in submit page", LogAs.PASSED, null);	
			postneedPo.getEleEditIcn().click();
			Assert.assertTrue(postneedPo.getEleFormRadioBtn().isDisplayed(), "User is not navigated to that specific questionnaire");
			NXGReports.addStep("User is successfully navigated to that specific questionnaire", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleFormPagingTxt().isDisplayed(), "Redirecting to Form page after clicking on edit icon is not successful");
			NXGReports.addStep("Redirecting to Form page after clicking on edit icon is successful", LogAs.PASSED, null);
			
			//Tap over NEXT button after updating.User should be navigated to Confirm and submit page after updating an attribute in the question page.
			Assert.assertTrue(postneedPo.getEleFormRadioBtn2().isDisplayed(), "User is not navigated to that specific questionnaire and thus the second radio button is not displayed");
			NXGReports.addStep("User is successfully navigated to that specific questionnaire with the second radio button displayed on the page", LogAs.PASSED, null);
			postneedPo.getEleFormRadioBtn2().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "Contact and Information page is not displayed");
			NXGReports.addStep("Contact and Information page is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "Confirm and submit page is not displayed");
			NXGReports.addStep("Confirm and submit page is successfully displayed", LogAs.PASSED, null);
			
			//Tap over SUBMIT button in Confirm and submit page
			postneedPo.getEleSubmitRequestBtn().click();
			try{
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed()&&myNeedsDashboardPo.getEleNotFinalisedBusinessBtn().isDisplayed(), "Not redirecting to response page");
				NXGReports.addStep("redirecting to response page", LogAs.PASSED, null);
			}catch(Exception e){
				driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).click();
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed()&&myNeedsDashboardPo.getEleNotFinalisedBusinessBtn().isDisplayed(), "Not redirecting to response page");
				NXGReports.addStep("redirecting to response page", LogAs.PASSED, null);
			}

		
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	
	/* @TestCaseID: SDLDwithType_02
	 * @Description: Tap on next button without choosing any option.
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="Tap on next button without choosing any option.")
	public void OptionAlert() throws Exception
	{
		sTestData="SDLDwithType_03";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		try
		{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			homePo.getEleDoneBtn().click();
			homePo.getEleFirstOption().click();
			homePo.getEleContinueBtn().click();
			Assert.assertTrue(postneedPo.getEleFormPagingTxt().isDisplayed(), "Form page for the particular need is not displayed");
			NXGReports.addStep("Form page for the particular need is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleNextBtn().isDisplayed(), "Please select atleast one option Alert popup is not displayed");
			NXGReports.addStep("Please select atleast one option Alert popup is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

}
