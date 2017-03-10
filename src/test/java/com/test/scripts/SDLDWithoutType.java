/***********************************************************************
x * @author 			:	  Yashi Priya
 * @description		: 	  Test scripts of SDLD Without Type test
 * @module			:	  SDLDWithoutType
 * @testmethod		:	  TellUsMore() 	
 * @testmethod		:	  TellusMoreFldWithValue()
 * @testmethod		:	  SubmitWithNeedNameAttribute()
 * @testmethod		:	  SubmitWithAdditionalInfoAttribute()	
 */

package com.test.scripts;

import org.openqa.selenium.By;
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
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.UpdateAccountPO;
import com.test.po.WelcomePO;

import io.appium.java_client.ios.IOSElement;

public class SDLDWithoutType extends SampleBaseLib {

	String sTestData=null;
	String[] sData=null;
	String sNeed;
	PostNeedPO postneedPo;
	HomePO homePo;
	LoginPO loginPo;
	WelcomePO welcomePo;
	MyNeedsDashboardPO myNeedsDashboardPo;
	UpdateAccountPO updateAccountPO;
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
		updateAccountPO=new UpdateAccountPO(driver);
		myNeedsDashboardPo = new MyNeedsDashboardPO(driver);
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

	/* @TestCaseID: SDLDwithoutType_01
	 * @Description: To check if user is shown question with "Tell us more" label for this case.
	 * 				 To Tap over NEXT button without entering any value in Tell us more field.
	 * 				 Tap on NEXT in Contact information page.
	 * 				 To check in Confirm and submit page when value is not provided in "Tell us more" field. 
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="To check tell us more label and navigate to confirm and submit page without any value entered in tell us more field .")
	public void TellUsMore() throws Exception
	{
		sTestData="SDLDwithoutType_01";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		
		try
		{
			//To check if user is shown question with "Tell us more" label for this case.
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			
			//To Tap over NEXT button without entering any value in Tell us more field.
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "User is not redirected to Contact information page.");
			NXGReports.addStep("User is successfully redirected to Contact information page.", LogAs.PASSED, null);
			
			//Tap on NEXT in Contact information page.
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);
			
			//To check in Confirm and submit page when value is not provided in "Tell us more" field.
			Assert.assertTrue(postneedPo.getEleNeedLabel().isDisplayed(), "User is not displayed with Need label");
			NXGReports.addStep("User is not displayed with Need label", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleNeedNameTxt().isDisplayed(), "User is not displayed with Need name");
			NXGReports.addStep("User is successfully displayed with Need name", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleCityLabel().isDisplayed(), "User is not displayed with City label");
			NXGReports.addStep("User is successfully displayed with City label", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleCityNameTxt().isDisplayed(), "User is not displayed with City name");
			NXGReports.addStep("User is successfully displayed with City name", LogAs.PASSED, null);
		
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	

	/* @TestCaseID: SDLDwithoutType_02
	 * @Description: To check in Confirm and submit page when value is provided in "Tell us more" field.
	 * 				 To tap over EDIT icon for the Additional info/ Need  in Confirm and submit page.
	 * 				 To tap over NEXT button after updating the Additional Info.
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="To check confirm and submit page when value is provided in tell us more field ,and edit  and update additional info.")
	public void TellusMoreFldWithValue() throws Exception
	{
		sTestData="SDLDwithoutType_05";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
	
		try
		{
			//To check in Confirm and submit page when value is provided in "Tell us more" field.
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			Thread.sleep(3000);
			WebElement e1 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextView[1]/UIAStaticText[1]"));
			e1.click();
			Thread.sleep(3000);
			driver.getKeyboard().pressKey("Top 10 Neurologists in Bangalore.");
			homePo.getEleDoneBtn().click();
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			//Assert.assertTrue(postneedPo.getEleAdditionalInfoLabel().isDisplayed(), "User is not displayed with Additional info label");
			//NXGReports.addStep("User is successfully displayed with Additional info label", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.geteleUserCommentTxt().isDisplayed(), "User comment is not displayed in confirm and submit page");
			NXGReports.addStep("User comment is successfully displayed", LogAs.PASSED, null);
			//Assert.assertTrue(postneedPo.getEleCityLabel().isDisplayed(), "User is not displayed with City label");
			//NXGReports.addStep("User is successfully displayed with City label", LogAs.PASSED, null);
			//Assert.assertTrue(postneedPo.getEleCityNameTxt().isDisplayed(), "User is not displayed with City name");
			//NXGReports.addStep("User is successfully displayed with City name", LogAs.PASSED, null);
			
			//To tap over EDIT icon for the Additional info/ Need  in Confirm and submit page.
			postneedPo.getEleAdditionalInfoEditIcn().click();
			Assert.assertTrue(postneedPo.getEleTellusmoreTxt().isDisplayed(), "User is not navigated to the specific questionnaire.");
			NXGReports.addStep("User is navigated to the specific questionnaire.", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleFormPagingTxt2().isDisplayed(), "User is not navigated to the specific questionnaire.");
			NXGReports.addStep("User is navigated to the specific questionnaire.", LogAs.PASSED, null);
			
			//To tap over NEXT button after updating the Additional Info.
			//postneedPo.geteleUserCommentTxt().clear();
			//homePo.getEleKeyboardReturnBtn().click();
			WebElement e2 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextView[1]/UIAStaticText[1]"));
			e2.click();
			Thread.sleep(3000);
			driver.getKeyboard().pressKey("Top 10 Neurologists in Bangalore.");
			homePo.getEleDoneBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "User is not redirected to Contact information page.");
			NXGReports.addStep("User is successfully redirected to Contact information page.", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	
	/* @TestCaseID: SDLDwithoutType_03
	 * @Description: To Tap over SUBMIT button in Confirm and submit page when need name is passed as attribute value.
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="To Tap over SUBMIT button in Confirm and submit page when need name is passed as attribute value.")
	public void SubmitWithNeedNameAttribute() throws Exception
	{
		sTestData="SDLDwithoutType_08";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		
		try
		{
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleSubmitRequestBtn().click();
			try{
				driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).click();
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "Not redirecting to response page");
				NXGReports.addStep("redirecting to response page", LogAs.PASSED, null);
			}catch(Exception e){
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "Not redirecting to response page");
				NXGReports.addStep("redirecting to response page", LogAs.PASSED, null);
			}

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithoutType_04
	 * @Description: Tap over SUBMIT button in Confirm and submit page when Additional info is passed as attribute value.
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="Tap over SUBMIT button in Confirm and submit page when Additional info is passed as attribute value.")
	public void SubmitWithAdditionalInfoAttribute() throws Exception
	{
		sTestData="SDLDwithoutType_09";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
	
		try
		{	
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			WebElement e2 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextView[1]/UIAStaticText[1]"));
			e2.click();
			Thread.sleep(3000);
			driver.getKeyboard().pressKey("Top 10 Neurologists in Bangalore.");
			homePo.getEleDoneBtn().click();
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleSubmitRequestBtn().click();
			//Assert.assertTrue(driver.findElement(By.xpath("//UIAStaticText[@name='Thank you']")).isDisplayed(), "Thank you screen is not displayed");
			//NXGReports.addStep("Thank you screen is displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboardPo.getEleNeedsLstItm().getText().equals("Neurologists"), "User is not navigated to Needs List page with the newly posted need");
			NXGReports.addStep("User is successfully navigated to Needs List page with the newly posted need", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboardPo.getEleNeedNotiSMSTxt().isDisplayed(), "user is not redirected to Need list page with status Fetching matching experts for your requirement");
			NXGReports.addStep("user is successfully redirected to Need list page with status Fetching matching experts for your requirement", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


}
