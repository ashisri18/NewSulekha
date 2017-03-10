/***********************************************************************
* @author 			:		Yashi Priya
* @description		: 		Test scripts of Home
* @module			:		Home
* @testmethod		:	   	CityAndPopularCategories()
* @testmethod		:	   	SearchResult()
*/
package com.test.scripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
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
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;


public class Home extends SampleBaseLib {
	String sTestData;
	String[] sData=null;
	String sNeed;
	WelcomePO welcomePo=null;
	LoginPO loginPo=null;
	HomePO homePo=null;
	PostNeedPO postneedPo=null;
	JavascriptExecutor js=null;
	HashMap<String, String> scrollObject=null;
	
	@BeforeClass
	public void login() throws Exception
	{
		sTestData="SDLDwithoutType_01";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		postneedPo=new PostNeedPO(driver);
		try{
		welcomePo.toHandleAlertPopup();
		welcomePo.getEleSkipBtn().click();
		Thread.sleep(3000);
		driver.closeApp();
		Thread.sleep(3000);
		}catch(Exception e){
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
			
			
		}
	}


	/* @TestCaseID: Home_01
	 * @Description: Check city is displayed
	 * 				 Check if popular categories getting displayed in Home page
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="To check if city and popular categories are displayed in home page.")
	public void CityAndPopularCategories()
	{
		sTestData="Home_01";
		sData=GenericLib.toReadExcelData(sTestData);
	
		try
		{
			//Check city is displayed
			Assert.assertEquals(homePo.getEleLocationTxtFld().getText(),sData[6]);
			NXGReports.addStep("Currenty city is displayed", LogAs.PASSED, null);
			
			//Check if popular categories getting displayed in Home page
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Popular categories section is not displayed in the home page.");
			NXGReports.addStep("Popular categories section is successfully displayed in the home page.", LogAs.PASSED, null);
			for(int i=0;i<homePo.getElePopularCtgrsLst().size();i++)
			{
				if(homePo.getElePopularCtgrsLst().get(i).isDisplayed())
				{
					Assert.assertTrue(homePo.getElePopularCtgrsLst().get(i).isDisplayed(), homePo.getElePopularCtgrsLst().get(i).getText()+" icon is not displayed.");
					NXGReports.addStep(homePo.getElePopularCtgrsLst().get(i).getText()+" icon is successfully displayed", LogAs.PASSED, null);
				}
				else
				{
					js = (JavascriptExecutor) driver;
					scrollObject = new HashMap<String, String>();
					scrollObject.put("direction", "down");
					js.executeScript("mobile: scroll", scrollObject);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Assert.assertTrue(homePo.getElePopularCtgrsLst().get(i).isDisplayed(), homePo.getElePopularCtgrsLst().get(i).getText()+" icon is not displayed.");
					NXGReports.addStep(homePo.getElePopularCtgrsLst().get(i).getText()+" icon is successfully displayed", LogAs.PASSED, null);
				}
			}
		}
		catch(Exception e)
		{	NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
		}
	}

	/* @TestCaseID: Home_03
	 * @Description: Search for Need names/Keywords
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="Search for Need names/Keywords")
	public void SearchResult() throws Exception
	{
		sTestData="Home_03";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleDoneBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is displayed", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}
