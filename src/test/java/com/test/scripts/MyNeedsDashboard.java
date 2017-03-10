/***********************************************************************
 * @author 			:	   RAGHU KIRAN MR
 * @description		: 	   Test scripts of MyNeedDashboad
 * @module			:	   MyNeedDashboad
 * @testmethod		:	   CheckStatusNotificationTriggered()
 * @testmethod		:	   AutomaticRefeshDatePostDashboardpage() 
 * @testmethod		:	   ResponsesPage()
 * @testmethod		:	   WriteReviewLinkPostReview() 
 * @testmethod		:	   NotFinalized()
 * @testmethod		:	   DismissPopup()
 * @testmethod		:	   SelectNotHappyQuoteComments()
 * @testmethod		:	   CancelPopupVerifyCancelledShortlist()
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
import com.test.po.MorePO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
public class MyNeedsDashboard extends SampleBaseLib{
	String sTestData;
	String[] sData=null;
	String sNeed;
	WelcomePO welcomePo;
	LoginPO loginPo;
	HomePO homePo;
	PostNeedPO postneedPo;
	MDLDPO mdldPo;
	MyNeedsDashboardPO myNeedsDashboadrdpo;
	BusinessProfilePO businessprofilePo;
	MorePO morePo;

	@BeforeClass
	public void login() throws InterruptedException
	{
		sTestData="SDLDwithoutType_01";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];

		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);	
		postneedPo=new PostNeedPO(driver);
		mdldPo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
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


	/* @TestCaseID:myNeedsDashboadrd_01
	 * @Description:Check the Status "Its taking time to get matching business for you need" in dashboard
	 *             :Check the Notification is triggered
	 * @Author:RaghuKiran MR*/
	@Test(priority=1,enabled=true,description="Check the Status 'It's taking time to get matching business for your need' in Dashboard and check if notification is triggere")
	public void CheckStatusNotificationTriggered() throws Exception
	{
		sTestData="myNeedsDashboadrd_01";
		sData=GenericLib.toReadExcelData(sTestData);	
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{

			myNeedsDashboadrdpo.searchNeeds(homePo, mdldPo, postneedPo,sData[7]);
			//Check the Notification is triggered
			try{
				welcomePo.getEleBackIcn().click();
			}catch(Exception e){

			}
			Assert.assertTrue(postneedPo.getEleNotificationLnk().isDisplayed(),"Notification icon is not displayed");
			NXGReports.addStep("Notification icon is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNotificationLnk().click();
			Assert.assertTrue(homePo.getEleNotificationLstItm().isDisplayed(),"Posted need is not displayed under notifications");
			NXGReports.addStep("Posted need is successfully displayed under notifications", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_02
	 * @Description:Check for automatic refresh
	 *             :Check for date of posted need
	 *             :Tap over any need displayed in dashboard
	 * @Author:RaghuKiran MR*/
	@Test(priority=2,enabled=true,description="Check for automatic refresh and date of posted need and tap on any need in dashboard.")
	public void AutomaticRefeshDatePostDashboardpage() throws Exception
	{
		sTestData="myNeedsDashboadrd_02";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			myNeedsDashboadrdpo.getEleDashboardBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCountNeedNumber().isDisplayed(),"Number of business match count is not displayed on the dashboard page");
			NXGReports.addStep("Number of business match count is successfully displayed on the dashboard page", LogAs.PASSED, null);
			//Check for date of posted need
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDataPostedOption().isDisplayed(),"Data on which the need is posted should not displayed on the need page");
			NXGReports.addStep("Data on which the need is posted should be displayed on the need page", LogAs.PASSED, null);
			//Tap over any need displayed in dashboard
			myNeedsDashboadrdpo.getEleNeedArrowBtn().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_03
	 * @Description:Check the Responses page
	 *             :Tap on the call icon displayed on the business 
	 *             :Tap on the score displayed on the business
	 *             :Check the Summary tab
	 *             :Tap on "Select & review" button displayed on the business
	 *             :Tap No button displayed on "Got your job done from business name..?" alert
	 *             :Tap Yes button displayed on "Got your job done from business name..?" alert
	 * @Author:RaghuKiran MR*/
	@Test(priority=3,enabled=true,description="Check the Responses page and tap on call icon and score and 'Select & review' button displayed and check summary tab. Tap No/yes button displayed on 'Got your job done from business name..?' alert")
	public void ResponsesPage() throws Exception
	{
		sTestData="myNeedsDashboadrd_03";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldPo, postneedPo,sData[7]);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNameofBusinessTxt().isDisplayed(),"Name of the business is not displayed");
			NXGReports.addStep("Name of the business is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleLocationNameTxt().isDisplayed(),"Location Name is not displayed");
			NXGReports.addStep("Location Name is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleReviewLink().isDisplayed(),"Review link is not displayed");
			NXGReports.addStep("Review link is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCallIcon().isDisplayed(),"Call icon is not displayed");
			NXGReports.addStep("Call icon is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().isDisplayed(),"Not Finalised Businees button is not dispalyed");
			NXGReports.addStep("Not Finalised Businees button is successfully dispalyed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleScoreIcon().isDisplayed(),"Score icon is not displayed");
			NXGReports.addStep("Score icon is successfully displayed", LogAs.PASSED, null);
			//Tap on the call icon displayed on the business 
			myNeedsDashboadrdpo.getEleCallIcon().click();
			businessprofilePo.handlingCall();
			//Tap on the score displayed on the business
			Assert.assertTrue(myNeedsDashboadrdpo.getEleScoreIcon().isDisplayed(),"Score icon is not displayed");
			NXGReports.addStep("Score icon is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleSummaryTab().isDisplayed(),"Summary tab is not displayed");
			NXGReports.addStep("Summary tab is successfully displayed", LogAs.PASSED, null);
			//Check the Summary tab
			myNeedsDashboadrdpo.getEleSummaryTab().click();
			//Assert.assertTrue(myNeedsDashboadrdpo.getEleSummaryNeedList().isDisplayed(),"Summary of the need should is not displayed");
			//NXGReports.addStep("Summary of the need should is successfully displayed", LogAs.PASSED, null);
			//Tap on "Select & review" button displayed on the business
			postneedPo.getEleResponsesTab().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleReviewLink().isDisplayed(),"Review link is not displayed");
			NXGReports.addStep("Review link is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleReviewLink().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleJobAlertPopup().isDisplayed(),"Alert with the message'Got your job done from business name is not displayed");
			NXGReports.addStep("Alert with the message'Got your job done from business name is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNoBtn().isDisplayed(),"No button is not displayed");
			NXGReports.addStep("No button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleYesBtn().isDisplayed(),"Yes button is not displayed");
			NXGReports.addStep("yes button is successfully displayed", LogAs.PASSED, null);
			//Tap No button displayed on "Got your job done from business name..?" alert
			myNeedsDashboadrdpo.getEleNoBtn().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
			//Tap Yes button displayed on "Got your job done from business name..?" alert
			myNeedsDashboadrdpo.getEleReviewLink().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleYesBtn().isDisplayed(),"Alert with the message'Got your job done from business name….?with No and Yes button' is not displayed");
			NXGReports.addStep("Alert with the message'Got your job done from business name….?with No and Yes button' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleYesBtn().click();
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(),"User should not navigated to Rate and review page");
			NXGReports.addStep("User should be navigated to Rate and review page", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_04
	 * @Description:Check whether Write review link is displayed when user discard to review the business
	 *             :Check posting the review in Rate and review page
	 * @Author:RaghuKiran MR*/
	@Test(priority=4,enabled=true,description="Check whether Write review link is displayed when user discard to review the business and check posting the review in rate and review page.")
	public void WriteReviewLinkPostReview() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldPo, postneedPo,sData[7]);
			myNeedsDashboadrdpo.getEleReviewLink().click();
			NXGReports.addStep(" Select and review link is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleYesBtn().isDisplayed(),"Alert with the message'Got your job done from business name….?with No and Yes button' is not displayed");
			NXGReports.addStep("Alert with the message'Got your job done from business name….?with No and Yes button' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleYesBtn().click();
			NXGReports.addStep("Yes button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(),"User should not navigated to Rate and review page");
			NXGReports.addStep("User should not navigated to Rate and review page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleBackIcn().click();
			morePo.getEleNeedResponsTxt().click();
			businessprofilePo.scrollToReviews();
			businessprofilePo.getEleVIEWMOREREVIEWSBtn().click();
			myNeedsDashboadrdpo.getEleWriteReviewBtn().click();
			//Check posting the review in Rate and review page
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(),"User should not navigated to Rate and review page");
			NXGReports.addStep("User should not navigated to Rate and review page", LogAs.PASSED, null);
			Thread.sleep(2000);
			new TouchAction((MobileDriver)driver).longPress(100,200).release().perform();
			Thread.sleep(2000);
			Assert.assertTrue(businessprofilePo.getEleWriteyourreviewTxtFld().isDisplayed(), "Write your review text field is not displayed");
			NXGReports.addStep("Write your review text field is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleWriteyourreviewTxtFld().sendKeys(sData[10]);
			homePo.getEleKeyboardReturnBtn().click();
			businessprofilePo.getElePOSTREVIEWBtn().click();
			NXGReports.addStep("Post review button is successfully displayed", LogAs.PASSED, null);
			Thread.sleep(2000);
			Assert.assertTrue(businessprofilePo.getEleCallIcoN().isDisplayed(),"Review is not posted");
			NXGReports.addStep("Review is successfully posted", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_04
	 * @Description:Tap over "NOT FINALIZED" button
	 *             :Select "I didn't received calls from businesses" and verify.
	 * @Author:RaghuKiran MR*/
	@Test(priority=5,enabled=true,description="Tap over 'NOT FINALIZED' button and Select 'I didn't received calls from businesses' and verify.")
	public void NotFinalized() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldPo, postneedPo,sData[7]);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().isDisplayed(), "Not finalished business button is not displayed");
			NXGReports.addStep("Not finalished business button is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Thread.sleep(10000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDidntReceiveCallOption().isDisplayed(),"Popup with message 'I didn't received calls from businesses' is not displayed");
			NXGReports.addStep("Popup with message 'I didn't received calls from businesses' is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleImnothappywiththeQuotesPopup().isDisplayed(),"Popup with message 'I'm not happy with the quote I received' is not displayed");	
			NXGReports.addStep("I'm not happy with the quote I received' is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleIdonthavethisneedanymorePopup().isDisplayed(),"Popup with message 'I don't have this need anymore' is not displayed");
			NXGReports.addStep("Popup with message 'I don't have this need anymore' is successfully displayed", LogAs.PASSED, null);
			Thread.sleep(6000);
			//Select "I didn't received calls from businesses" and verify.
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDidntReceiveCallOption().isDisplayed(),"Popup with message 'I didn't received calls from businesses' is not displayed");
			NXGReports.addStep("Popup with message 'I didn't received calls from businesses' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleDidntReceiveCallOption().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDismissBtn().isDisplayed(),"Alert with the message 'We will get business to call you back with quotes message and Dismiss button' is not dispalyed");
			NXGReports.addStep("Alert with the message 'We will get business to call you back with quotes message and Dismiss button' is successfully dispalyed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_04
	 * @Description:Tap on "Dismiss" button displayed on the pop up
	 * @Author:RaghuKiran MR*/
	@Test(priority=6,enabled=true,description="Tap on 'Dismiss' button displayed on the pop up")
	public void DismissPopup() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldPo, postneedPo,sData[7]);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDidntReceiveCallOption().isDisplayed(),"Popup with message 'I didn't received calls from businesses' is not displayed");
			NXGReports.addStep("Popup with message 'I didn't received calls from businesses' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleDidntReceiveCallOption().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDismissBtn().isDisplayed(),"Alert with the message 'We will get business to call you back with quotes message and Dismiss button' is not dispalyed");
			NXGReports.addStep("Alert with the message 'We will get business to call you back with quotes message and Dismiss button' is successfully dispalyed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleDismissBtn().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_04
	 * @Description:Select "I'm not happy with the quote I received" and verify- More quotes
	 *             :Enter the comments in more quotes pop up and tap Send
	 * @Author:RaghuKiran MR*/
	@Test(priority=7,enabled=true,description="Select 'I'm not happy with the quote I received' and verify- More quotes and Enter the comments in more quotes pop up and tap Send.")
	public void SelectNotHappyQuoteComments() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldPo, postneedPo,sData[7]);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleImnothappywiththeQuotesPopup().isDisplayed(),"Popup with message 'I'm not happy with the quote I received' is not displayed");	
			NXGReports.addStep("Popup with message 'I'm not happy with the quote I received' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleImnothappywiththeQuotesPopup().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleTellusMorePopup().isDisplayed(),"A pop up window with message 'Type in additional details about your need. We'll have businesses call you.,textbox,Send and Cancel buttons' should not displayed");
			NXGReports.addStep("A pop up window with message 'Type in additional details about your need. We'll have businesses call you.,textbox,Send and Cancel buttons' should be displayed", LogAs.PASSED, null);
			//Enter the comments in more quotes pop up and tap Send
			myNeedsDashboadrdpo.getEleTellusMoreNeedPopup().sendKeys(sData[9]);
			homePo.getEleKeyboardReturnBtn().click();
			myNeedsDashboadrdpo.getEleSendBtn().click();
			myNeedsDashboadrdpo.getEleDismissBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleRequestedQuotesTxt().isDisplayed(),"You have requested more quotes message should not displayed in response page");
			NXGReports.addStep("You have requested more quotes message should be displayed in response page", LogAs.PASSED, null);
			Thread.sleep(3000);
			welcomePo.getEleBackIcn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleMoreQuotesTxt().isDisplayed(), "More quotes message is not displayed in dashboard page");
			NXGReports.addStep("More quotes message is successfully displayed in dashboard page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_8
	 * @Description:Tap on "Cancel" button displayed on the pop up
	 *             :Select "I don't have this need anymore" and verify-Cancelled
	 *             :Perform 'Shortlist' operation from Mobile and verify in 'My Shortlist' section
	 * @Author:RaghuKiran MR*/
	@Test(priority=8,enabled=true,description="Tap on 'Cancel' button displayed on the pop up and select 'I don't have this need anymore'. Shortlist the business and verify in My shortlists section")
	public void CancelPopupVerifyCancelledShortlist() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldPo, postneedPo,sData[7]);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCancelBtn().isDisplayed(),"Cancel button is not displayed");
			NXGReports.addStep("Cancel button is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleCancelBtn().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
			//Select "I don't have this need anymore" and verify-Cancelled
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleIdonthavethisneedanymorePopup().isDisplayed(),"Popup with message 'I don't have this need anymore' is not displayed");
			NXGReports.addStep("Popup with message 'I don't have this need anymore' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleIdonthavethisneedanymorePopup().click();
			myNeedsDashboadrdpo.getEleDismissBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCancelledNeedTxt().isDisplayed(),"You have cancelled this need meesage is not dispalyed");
			NXGReports.addStep("You have cancelled this need meesage is successfully dispalyed", LogAs.PASSED, null);
			//Perform 'Shortlist' operation from Mobile and verify in 'My Shortlist' section
			myNeedsDashboadrdpo.getEleResponsesPostBtn().click();
			Assert.assertTrue(businessprofilePo.getEleShortlistIcn().isDisplayed(), "Short list button is not displayed");
			//NXGReports.addStep("Short list button is successfully displayed", LogAs.PASSED, null);
			/*driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[3]")).click();
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[2]")).click();
			Thread.sleep(3000);
			welcomePo.getEleBackArwIcn().click();
			welcomePo.getEleBackIcn().click();
			homePo.getEleMoreIcn().click();
			Assert.assertTrue(homePo.getEleShortListLnk().isDisplayed(), "More page is not displayed");
			NXGReports.addStep("More page is successfully displayed", LogAs.PASSED, null);
			homePo.getEleShortListLnk().click();
			Assert.assertTrue(businessprofilePo.getEleShortlistItm().isDisplayed(), "Shortlisted business is not seen under Shortlist tab");
			NXGReports.addStep("Shortlisted business is successfully seen under shortlist tab", LogAs.PASSED, null);*/

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}
