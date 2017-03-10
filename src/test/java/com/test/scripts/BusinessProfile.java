/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Test scripts of Business Profile page
 * @module			:		Business Profile
 * @testmethod		:	   	BusinessProfilePageAndPostReview()
 * @testmethod		:	   	CallIcon()
 * @testmethod		:	   	SMSTap()
 * @testmethod		:	   	ShortlistTap()
 * @testmethod		:	   	RemoveShortlistTap()
 * @testmethod		:	   	NotificationIcon()
 * @testmethod		:	   	WorkPhoneNumber()
 * @testmethod		:	   	AddressTap()
 * @testmethod		:	   	EmailIcon()
 * @testmethod		:	   	WebIcon()
 * @testmethod		:	   	BusinessWebsiteLnk()
 * @testmethod		:	   	AnyReview()
 * @testmethod		:		SubmitReview()
 */
package com.test.scripts;


import java.util.concurrent.TimeUnit;
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



public class BusinessProfile extends SampleBaseLib{
	String sTestData=null;
	String[] sData=null;
	String sNeed;
	HomePO homePo=null;
	MyNeedsDashboardPO myneedsdashboardPo=null;
	BusinessProfilePO businessprofilePo=null;
	LoginPO loginPo=null;
	WelcomePO welcomePo=null;
	MorePO morePo=null;
	PostNeedPO postneedPo;

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
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
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

	/* @TestCaseID: BusinessProfile_01
	 * @Description: To check the Business Profile page and verify all the elements present in the page.
	 * 				 To check the Services offered section
	 * 				 To tap on More reviews link
	 * 				 To tap on "write review" icon and verify the popup.
	 * 				 Tap on "Post Review" without rating/reviewing in Rate & review page
	 * 				 Tap on "Post Review" only rating and without entering review in Rate & review page
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=false,description="Check the Business Profile page and tap over “more reviews link” , “write review  icon” and post a review without rating/reviewing and only  by rating.")
	public void BusinessProfilePageAndPostReview() throws Exception
	{
		sTestData="BusinessProfile_01";
		sData=GenericLib.toReadExcelData(sTestData);
		

		try
		{
			//To check the Business Profile page and verify all the elements present in the page.
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			Assert.assertTrue(businessprofilePo.getEleBusinessNameTxt().isDisplayed(), "Name of the business is not displayed");
			NXGReports.addStep("Name of the business is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleBusinessLocation().isDisplayed(), "Business location is not displayed");
			NXGReports.addStep("Business location is successfully displayed", LogAs.PASSED, null);
			/*Assert.assertTrue(businessprofilePo.getEleBusinessScore1().isDisplayed(), "Business sco
			 * re is not displayed");
			NXGReports.addStep("Business score is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleBusinessWorkinghoursTxt().isDisplayed(), "Business Working hours in the business profile screen is not displayed");
			NXGReports.addStep("Business Working hours in the business profile screen is successfully displayed", LogAs.PASSED, null);
			//rating bar cannot be identified.
			Assert.assertTrue(businessprofilePo.getEleBusinessContactTxt().isDisplayed(), "Business Contact person in the business profile screen is not displayed");
			NXGReports.addStep("Business Contact person in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleCallIcoN().isDisplayed(), "Call icon in the business profile screen is not displayed");
			NXGReports.addStep("Call icon in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleSMSIcn().isDisplayed(), "SMS icon in the business profile screen is not displayed");
			NXGReports.addStep("SMS icon in the business profile screen is successfully displayed", LogAs.PASSED, null);	
			Assert.assertTrue(businessprofilePo.getEleShotList().isDisplayed(), "Shortlist icon in the business profile screen is not displayed");
			NXGReports.addStep("Shortlist icon in the business profile screen is successfully displayed", LogAs.PASSED, null);
			//Assert.assertTrue(businessprofilePo.getEleNotificationIcn().isDisplayed(), "Notification icon in the business profile screen is not displayed");
			//NXGReports.addStep("Notification icon in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleBusinessWorkTxt().isDisplayed(), "Work of the business in the business profile screen is not displayed");
			NXGReports.addStep("Work of the business in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleWorkPhoneNumTxt().isDisplayed(), "Work phone number in the business profile screen is not displayed");
			NXGReports.addStep("Work phone number in the business profile screen is successfully displayed", LogAs.PASSED, null);
			
			Assert.assertTrue(businessprofilePo.getEleAddressIcn().isDisplayed(), "Address of the business in the business profile screen is not displayed");
			NXGReports.addStep("Address of the business in the business profile screen is successfully displayed", LogAs.PASSED, null);
			try
			{
				driver.scrollTo("Landmark");
				Assert.assertTrue(businessprofilePo.getEleBusinessLandmarkTxt().isDisplayed(), "Landmark of the business in the business profile screen is not displayed");
				NXGReports.addStep("Landmark of the business in the business profile screen is successfully displayed", LogAs.PASSED, null);

			}
			catch(Exception e)
			{
				NXGReports.addStep("Landmark of the business in the business profile screen is not displayed", LogAs.PASSED, null);
			}
			driver.scrollTo("Email");
			Assert.assertTrue(businessprofilePo.getEleEmailIcn().isDisplayed(), "Business EmailID in the business profile screen is not displayed");
			NXGReports.addStep("Business EmailID in the business profile screen is successfully displayed", LogAs.PASSED, null);
			driver.scrollTo("About");
			Assert.assertTrue(businessprofilePo.getEleBusinessAboutTxt().isDisplayed(), "Business About section in the business profile screen is not displayed");
			NXGReports.addStep("Business About section in the business profile screen is successfully displayed", LogAs.PASSED, null);
			driver.scrollTo("Services offered");
			Assert.assertTrue(businessprofilePo.getEleServicesOfrdTxt().isDisplayed(), "Business Services offered in the business profile screen is not displayed");
			NXGReports.addStep("Business Services offered in the business profile screen is successfully displayed", LogAs.PASSED, null);
			
			//To check the Services offered section
			Assert.assertTrue(businessprofilePo.getEleServicesOfrdLst().isDisplayed(),"List of services offered by the business is not displayed");
			NXGReports.addStep("List of services offered by the business is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleViewMoreBtn().isDisplayed(), "View more button is not displayed");
			NXGReports.addStep("View more button is displayed", LogAs.PASSED, null);
			driver.scrollTo("Twitter");
			Assert.assertTrue(businessprofilePo.getEleWebsiteIcn().isDisplayed(), "Business website in the business profile screen is not displayed");
			NXGReports.addStep("Business website in the business profile screen is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.scrollToReviewsAfterWebsite();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Assert.assertTrue(businessprofilePo.getEleReviewLnk().isDisplayed(), "Business reviews section in the business profile screen is not displayed");
			NXGReports.addStep("Business reviews section in the business profile screen is successfully displayed", LogAs.PASSED, null);
			
			//To tap on More reviews link
			businessprofilePo.toTestMoreReview();
			
			//To tap on "write review" icon and verify the popup.	
			businessprofilePo.getEleWriteReviewBtn().click();
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(), "A popup to post a review is not displayed");
			NXGReports.addStep("A popup to post a review is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleWriteyourreviewTxtFld().isDisplayed(), "a popup with a write your review text field is not displayed");
			NXGReports.addStep("a popup with a write your review text field is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getElePOSTREVIEWBtn().isDisplayed(), "a popup with a post review button is not displayed");
			NXGReports.addStep("a popup with a post review button is successfully displayed", LogAs.PASSED, null);
			
			//Tap on "Post Review" without rating/reviewing in Rate & review page
			businessprofilePo.getElePOSTREVIEWBtn().click();
			Assert.assertTrue(businessprofilePo.getEleRateBusinessAlertPopup().isDisplayed(), "An alert popup saying Rate this business before you submit is not displayed");
			NXGReports.addStep("An alert popup saying Rate this business before you submit is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();
			
			//Tap on "Post Review" only rating and without entering review in Rate & review page
			businessprofilePo.toTapOnRatingBar();
			Assert.assertTrue(businessprofilePo.getElePOSTREVIEWBtn().isDisplayed(), "post review button is not displayed");
			NXGReports.addStep("post review button is displayed", LogAs.PASSED, null);
			businessprofilePo.getElePOSTREVIEWBtn().click();
			Assert.assertTrue(businessprofilePo.getEleReviewPostedToast().isDisplayed(),"Review is not posted");
			NXGReports.addStep("Review is successfully posted", LogAs.PASSED, null);*/
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_02
	 * @Description: To tap on call icon in the business profile page.
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=false,description="To tap on call icon in the business profile page.")
	public void CallIcon() throws Exception
	{
		sTestData="BusinessProfile_02";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		businessprofilePo.getEleCallIcoN().click();
		businessprofilePo.handlingCall();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_03
	 * @Description: To tap on SMS icon and verify if message popup is displayed.
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=false,description="To tap on SMS icon and verify if message popup is displayed.")
	public void SMSTap() throws Exception
	{
		sTestData="BusinessProfile_03";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{	
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			businessprofilePo.getEleSMSIcn().click();
			Assert.assertTrue(businessprofilePo.getEleNewMsgTxt().isDisplayed(), "Message popup is not displayed");
			NXGReports.addStep("Message popup is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleSMSToTxtFld().isDisplayed(), "Message popup is not displayed with the To: field");
			NXGReports.addStep("Message popup is successfully displayed with the To: field", LogAs.PASSED, null);
			Assert.assertFalse(businessprofilePo.getEleBusinessPhnNumTxt().getText().isEmpty(), "Message popup is not displayed with the To: field containing business number");
			NXGReports.addStep("Message popup is successfully displayed with the To: field containing business number", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_04
	 * @Description: To tap on Shortlist icon and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=false,description="To tap on Shortlist icon and verify.")
	public void ShortlistTap() throws Exception
	{
		sTestData="BusinessProfile_04";
		sData=GenericLib.toReadExcelData(sTestData);
		String sBusinessName=null;
		
		try
		{	
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			businessprofilePo.getEleShortlistIcn().click();
			/*driver.closeApp();
			Thread.sleep(10000);
			driver.launchApp();
			homePo.getEleMoreIcn().click();
			Assert.assertTrue(homePo.getEleShortListLnk().isDisplayed(), "More page is not displayed");
			NXGReports.addStep("More page is successfully displayed", LogAs.PASSED, null);
			homePo.getEleShortListLnk().click();
			Assert.assertEquals(businessprofilePo.getEleShortlistItm().isDisplayed(),"Shortlisted business is not seen under shortlist tab");
			NXGReports.addStep("Shortlisted business is successfully seen under shortlist tab", LogAs.PASSED, null);*/
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_05
	 * @Description: To tap on Remove Shortlist icon and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=false,description="To tap on Remove Shortlist icon and verify.")
	public void RemoveShortlistTap() throws Exception
	{
		sTestData="BusinessProfile_05";
		sData=GenericLib.toReadExcelData(sTestData);
		String sBusinessName=null;
		
		try
		{
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo, sData[7]);
		/*sBusinessName=businessprofilePo.getEleBusinessNameTxt().getText();
		welcomePo.getEleBackArwIcn().click();
		Assert.assertTrue(businessprofilePo.getGetQuotesBtn().isDisplayed(), "Get Quotes page for the business is not displayed");
		NXGReports.addStep("Get Quotes screen for the business is displayed", LogAs.PASSED, null);
		welcomePo.getEleBackArwIcn().click();
		Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
		NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);
		homePo.getEleMoreIcn().click();
		Assert.assertTrue(homePo.getEleShortListLnk().isDisplayed(), "More page is not displayed");
		NXGReports.addStep("More page is successfully displayed", LogAs.PASSED, null);
		homePo.getEleShortListLnk().click();
		Assert.assertEquals(sBusinessName, businessprofilePo.getEleShortlistItm().getText(),"Shortlisted business is not seen under shortlist tab");
		NXGReports.addStep("Shortlisted business is successfully seen under shortlist tab", LogAs.PASSED, null);
		businessprofilePo.getEleRemoveShortlistIcn().click();
		Assert.assertTrue(businessprofilePo.getEleShortlistItm().isDisplayed(),"Shortlisted business is still seen under shortlist tab");
		NXGReports.addStep("Shortlisted business is no more seen under shortlist tab", LogAs.PASSED, null);
		welcomePo.getEleBackArwIcn().click();
		morePo.getEleHomeIcn().click();
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo, sData[7]);
		Assert.assertTrue(businessprofilePo.getEleShortlistIcn().isDisplayed(), "Remove shortlist icon is not changed to shortlist icon");
		NXGReports.addStep("Remove shortlist icon is successfully changed to shortlist icon", LogAs.PASSED, null);*/

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_06
	 * @Description: To tap on Notification icon in the business profile page.
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=false,description="To tap on Notification icon in the business profile page.")
	public void NotificationIcon() throws Exception
	{
		sTestData="BusinessProfile_06";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{
			postneedPo.getEleNotificationLnk().click();
			Assert.assertTrue(homePo.getEleNotificationLstItm().isDisplayed(), "User is not navigated to notification page");
			NXGReports.addStep("User is successfully navigated to notification page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_07
	 * @Description: Tap on the phone number displayed under Work section
	 * @Author: Yashi Priya*/
	@Test(priority=7,enabled=false,description="Tap on the phone number displayed under Work section")
	public void WorkPhoneNumber() throws Exception
	{
		sTestData="BusinessProfile_07";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{	
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		businessprofilePo.getEleWorkPhoneNumTxt().click();
		businessprofilePo.handlingCall();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: BusinessProfile_08
	 * @Description: To tap on the address icon associated with Address
	 * @Author: Yashi Priya*/
	@Test(priority=8,enabled=false,description="To tap on the address icon associated with Address")
	public void AddressTap() throws Exception
	{
		sTestData="BusinessProfile_08";
		sData=GenericLib.toReadExcelData(sTestData);
	
		try
		{	
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			//businessprofilePo.getEleAddressIcn().click();
			//Assert.assertTrue(businessprofilePo.getEleBusiMapLocationTxt().isDisplayed(),"Business location is not displayed on the map");
			//NXGReports.addStep("Business location is successfully displayed on the map", LogAs.PASSED, null);
			
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_09
	 * @Description: Tap on the Email id displayed under Email section
	 * @Author: Yashi Priya*/
	@Test(priority=9,enabled=false,description="Tap on the Email id displayed under Email section")
	public void EmailIcon() throws Exception
	{
		sTestData="BusinessProfile_09";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{	
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		businessprofilePo.getEleEmailIcn().click();
		Assert.assertTrue(businessprofilePo.getEleNewMsgTxt().isDisplayed(), "Device specific Email Centre is not opened");
		NXGReports.addStep("Device specific Email Centre is opened", LogAs.PASSED, null);
		Assert.assertFalse(businessprofilePo.getEleBusinessEmailAddress().getText().isEmpty(), "Device specific Email Centre  with prepopulated business email id is not displayed");
		NXGReports.addStep("Device specific Email Centre  with prepopulated business email id is successfully displayed", LogAs.PASSED, null);
		Assert.assertFalse(businessprofilePo.getEleEmailMsgBody().getText().isEmpty(), "Device specific Email Centre  with Need name is not opened");
		NXGReports.addStep("Device specific Email Centre  with Need name is successfully opened", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_10
	 * @Description: To tap on the web icon of the business in the business profile page.
	 * @Author: Yashi Priya*/
	@Test(priority=10,enabled=false,description="To tap on the web icon of the business in the business profile page.")
	public void WebIcon() throws Exception
	{
		sTestData="BusinessProfile_10";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{	
		businessprofilePo.navigateToBusinessProfile1(homePo, myneedsdashboardPo,sData[7],postneedPo);
		driver.scrollTo("Website");
		businessprofilePo.getEleBusinessWebImg().click();
		Assert.assertTrue(businessprofilePo.getEleWebsiteLnk().isDisplayed(), "Business website page is not displayed");
		NXGReports.addStep("Business website page is successfully displayed", LogAs.PASSED, null);
		
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


/* @TestCaseID: BusinessProfile_12
	 * @Description: Tap on Website of the business
	 * @Author: Yashi Priya*/
	@Test(priority=11,enabled=false,description="Tap on Website of the business")
	public void BusinessWebsiteLnk() throws Exception
	{
		sTestData="BusinessProfile_12";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{	
		businessprofilePo.navigateToBusinessProfile1(homePo, myneedsdashboardPo, sData[7], postneedPo);
		driver.scrollTo("Website");
		businessprofilePo.getEleBusinessWebImg().click();
		Assert.assertTrue(businessprofilePo.getEleWebsiteLnk().isDisplayed(), "Business website page is not displayed");
		NXGReports.addStep("Business website page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: BusinessProfile_13
	 * @Description: To tap on any review-bug 
	 * @Author: Yashi Priya*/
	@Test(priority=12,enabled=false,description=" To tap on any review")
	public void AnyReview() throws Exception
	{
		sTestData="BusinessProfile_13";
		sData=GenericLib.toReadExcelData(sTestData);
		
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


	/* @TestCaseID: BusinessProfile_18
	 * @Description:Submit the review
	 * @Author: Yashi Priya*/
	@Test(priority=13,enabled=true,description="Submit the review")
	public void SubmitReview() throws Exception
	{
		sTestData="BusinessProfile_18";
		sData=GenericLib.toReadExcelData(sTestData);
		
		try
		{	
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			NXGReports.addStep("Search Screen is successfully displayed", LogAs.PASSED, null);
			homePo.getEleSearchTxtFld().sendKeys("Battery rentals");
			homePo.getEleDoneBtn().click();
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			homePo.getEleFirstOption().click();
			Thread.sleep(4000);
			homePo.getEleViewListingBtn().click();
			businessprofilePo.getEleGetQuotesForBusinessLstItm().click();
			NXGReports.addStep("Get quotes listing button is successfully displayed", LogAs.PASSED, null);
			Thread.sleep(2000);
			Assert.assertTrue(businessprofilePo.getEleBusinessNameTxt().isDisplayed(), "Business Profile page is not displayed");
			NXGReports.addStep("Business Profile page is successfully displayed", LogAs.PASSED, null);
		businessprofilePo.scrollToReviews();
		businessprofilePo.getEleWriteReviewBtn().click();
		NXGReports.addStep("Write review button is successfully displayed", LogAs.PASSED, null);
		businessprofilePo.testRateBusiAlert(welcomePo);
		businessprofilePo.toTapOnRatingBar();
		Assert.assertTrue(businessprofilePo.getEleWriteyourreviewTxtFld().isDisplayed(), "Write your review text field is not displayed");
		NXGReports.addStep("Write your review text field is successfully displayed", LogAs.PASSED, null);
		businessprofilePo.getEleWriteyourreviewTxtFld().sendKeys(sData[8]);
		NXGReports.addStep("Review text field is successfully displayed", LogAs.PASSED, null);
		homePo.getEleKeyboardReturnBtn().click();
		NXGReports.addStep("Dashboard screen is successfully displayed", LogAs.PASSED, null);
		businessprofilePo.getElePOSTREVIEWBtn().click();
		NXGReports.addStep("Review screen is successfully displayed", LogAs.PASSED, null);
		
		
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

}







