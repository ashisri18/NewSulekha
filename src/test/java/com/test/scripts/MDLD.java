/***********************************************************************
X * @author 			:	RaghuKiran
 * @description		: 	Test scripts of MDLD 
 * @module			:	MDLD
 * @testmethod		:	MDLDNeed() 	
 * @testmethod		:	FormPage()
 * @testmethod		:	NextWOChangeValueSubmitBtn()
 * @testmethod		:	OthersOption()
 * @testmethod		:	TellusMoreWithValue()
 * @testmethod		:	TellUsMoreWOValue()
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
import com.test.po.BusinessProfilePO;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MDLDPO;
import com.test.po.MorePO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.UpdateAccountPO;
import com.test.po.WelcomePO;
import io.appium.java_client.ios.IOSElement;
public class MDLD extends SampleBaseLib{
	String sTestData=null;
	String[] sData=null;
	String sNeed;
	PostNeedPO postneedPo;
	HomePO homePo;
	LoginPO loginPo;
	WelcomePO welcomePo;
	MDLDPO mdldpo;
	MyNeedsDashboardPO myNeedsDashboadrdpo;
	BusinessProfilePO businessprofilePo;
	MorePO morePo;
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
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		morePo=new MorePO(driver);
		updateAccountPO=new UpdateAccountPO(driver);
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

	/* @TestCaseID: MDLDTest_01
	 * @Description: Search for a MDLD need with type(Ex: Business intelligence & analytics training), and post a need.
	 * @Author:RaghuKiran MR*/
	@Test(priority=1,enabled=true,description="Search for a MDLD need with type(Ex: Business intelligence & analytics training), and post a need.")
	public void MDLDNeed() throws Exception
	{
		sTestData="MDLDTest_01";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			mdldpo.search(sData, homePo, postneedPo);
			mdldpo.handleForm(sData[8], postneedPo);
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit Request page is not displayed");
			NXGReports.addStep("Submit Request page is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleSubmitRequestBtn().click();
			try{
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
				NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
			}catch(Exception e){
				driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).click();
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
				NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
			}
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_02
	 * @Description:Check if user is shown question with select options
	 * 			   :Tap on the NEXT button without choosing any options
	 *             :Check if Choose locality question is displayed for B2U and U2B categories.
	 *             :Tap on NEXT in Contact information page.
	 *             :Tap over EDIT icon for the attribute group questionnaire in Confirm and submit page.
	 *             :Tap over NEXT button after updating.
	 * @Author:RaghuKiran MR*/
	@Test(priority=2,enabled=true,description="Check if user is shown question with select options and check without choosing any option , check for choose locality question, navigate to confirm and submit page and edit and update the attribute group questionnaire.")
	public void FormPage() throws Exception

	{
		sTestData="MDLDTest_02";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			mdldpo.search(sData, homePo,postneedPo);
			Assert.assertTrue(mdldpo.getEleQuestionLookingTxt().isDisplayed(),"Question text is not displayed");
			NXGReports.addStep("Question text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(),"Show question with  select options page is not displayed");
			NXGReports.addStep("Show question with  select options page is successfully displayed", LogAs.PASSED, null);
			//Tap on the NEXT button without choosing any options
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleNextBtn().isDisplayed(), "An alert with please select atleast one optionis not displayed");
			NXGReports.addStep("An alert with please select atleast one option is successfully displayed", LogAs.PASSED, null);
			//Check if Choose locality question is displayed for B2U and U2B categories.

			mdldpo.getEleFormCheckArrowBox1().click();
			mdldpo.getEleFormCheckArrowBox().click();
			driver.findElement(By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableView[1]/UIATableCell[1]")).click();
			Assert.assertTrue(mdldpo.getEleDestQuestTxt().isDisplayed(),"Destination question is not displayed");
			NXGReports.addStep("Destination question is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(mdldpo.getEleLocationTxt().getText().equals(sData[6]),"Location name is not displayed");
			NXGReports.addStep("Location name is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(mdldpo.getEleDestinationTxtBox().isDisplayed(),"Choose locality question should not displayed for both U2B and B2U categories");
			NXGReports.addStep("Choose locality question should is successfully displayed for both U2B and B2U categories", LogAs.PASSED, null);
			//Tap on NEXT in Contact information page.
			((IOSElement) driver.findElement(By.id("You can add upto 5 localitites"))).setValue("Jayanagar");
			homePo.getEleKeyboardReturnBtn().click();
			Thread.sleep(2000);
			mdldpo.getEleLocalitiesList().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully  displayed", LogAs.PASSED, null);	
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleNeedTxt().isDisplayed(), "Need text is not displayed in submit page");
			NXGReports.addStep("Need text is successfully displayed in submit page", LogAs.PASSED, null);	
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit Request page is not displayed");
			NXGReports.addStep("Submit Request page is successfully displayed", LogAs.PASSED, null);
			//Tap over EDIT icon for the attribute group questionnaire in Confirm and submit page.
			Assert.assertTrue(mdldpo.getEleEditicon().isDisplayed(),"Edit icon is not displayed");
			NXGReports.addStep("Edit icon is successfuly displayed", LogAs.PASSED, null);	
			mdldpo.getEleEditicon().click();
			Assert.assertTrue(mdldpo.getEleQuestionLookingTxt().isDisplayed(),"Question text is not displayed");
			NXGReports.addStep("Question text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(),"User should not navigated to that specific questionnaire");
			NXGReports.addStep("User should be navigated to that specific questionnaire", LogAs.PASSED, null);
			//Tap over NEXT button after updating.
			postneedPo.getEleNextBtn().click();
		//	Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(),"User should not navigated to the next question page");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(),"User should not navigated to the confirm and submit page");
			NXGReports.addStep("User should be navigated to the confirm and submit page", LogAs.PASSED, null);	
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_03
	 * @Description:Tap over NEXT button without changing any values.
	 *             :Tap over SUBMIT button in Confirm and submit page.
	 * @Author:RaghuKiran MR*/
	@Test(priority=3,enabled=true,description="Tap over NEXT button without changing any values and submit the need.")
	public void NextWOChangeValueSubmitBtn() throws Exception
	{
		sTestData="MDLDTest_08";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			mdldpo.search(sData, homePo,postneedPo);
			mdldpo.handleForm(sData[8],postneedPo);
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			postneedPo.getEleNextBtn().click();
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]/UIATableView[1]/UIATableCell[4]/UIAButton[1]")).click();
			mdldpo.getEleNextBtn().click();
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(),"User should not navigated to the confirm and submit page");
			NXGReports.addStep("User should be navigated to the confirm and submit page", LogAs.PASSED, null);	
			//Tap over SUBMIT button in Confirm and submit page.
			postneedPo.getEleSubmitRequestBtn().click();
			try{
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
				NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
			}catch(Exception e){
				driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]")).click();
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
				NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
			}
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_04
	 * @Description:Select "Others" as an Option in the question list
	 * @Author:RaghuKiran MR*/
	@Test(priority=4,enabled=true,description="Select 'Others' as an Option in the question list")
	public void OthersOption() throws Exception
	{
		sTestData="MDLDTest_10";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleFirstOption().click();
			homePo.getEleContinueBtn().click();
			mdldpo.getEleOthersBtn().click();
			mdldpo.getEleFormCheckArrowBox().click();
			mdldpo.getEleNextBtn().click();
			WebElement e2 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[4]/UIATextView[1]/UIAStaticText[1]"));
			e2.click();
			Thread.sleep(3000);
			driver.getKeyboard().pressKey("Top 10 Neurologists in Bangalore.");
			homePo.getEleDoneBtn().click();
			mdldpo.getEleNextBtn().click();
			//Submit a need with "Others" as an Option choosen for a question.
			driver.findElement(By.id("Add a locality")).sendKeys(sData[8]);
			Thread.sleep(2000);
			homePo.getEleKeyboardReturnBtn().click();
			homePo.getEleLocalitiesList().click();
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			mdldpo.getEleSubmitRequestBtn().click();
			Assert.assertTrue(mdldpo.getEleAdditionalinfoTxt().isDisplayed(),"Fetching matching business for your requrement text message is not displayed");
			NXGReports.addStep("Fetching matching business for your requrement text message is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_05
	 * @Description:Fill the LCF and POST a need for any SDLD need(Camera Dealears,User enters the text )
	 * @Author:RaghuKiran MR*/
	@Test(priority=5,enabled=true,description="Fill the LCF and POST a need for any SDLD need(Camera Dealears,User enters the text)")
	public void TellusMoreWithValue() throws Exception
	{
		sTestData="MDLDTest_12";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleFirstOption().click();
			homePo.getEleContinueBtn().click();
			Assert.assertTrue(postneedPo.getEleTellusmoreTxt().isDisplayed(), "User is not  displayed only with Tell us more field.");
			NXGReports.addStep("User is successfully displayed only with Tell us more field.",LogAs.PASSED, null);
			WebElement e2 = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextView[1]/UIAStaticText[1]"));
			e2.click();
			Thread.sleep(3000);
			driver.getKeyboard().pressKey("Top 10 Neurologists in Bangalore.");
			homePo.getEleDoneBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleAdditionalInfoTxt().isDisplayed(),"Additional information text is not displayed");
			NXGReports.addStep("Additional information text is successfully displayed", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: MDLDTest_06
	 * @Description:Fill the LCF and POST a need for any SDLD need(Camera Dealears,User without enters the text)
	 * @Author:RaghuKiran MR*/
	@Test(priority=6,enabled=true,description="Fill the LCF and POST a need for any SDLD need(Camera Dealears,User without enters the text)")
	public void TellUsMoreWOValue() throws Exception
	{
		sTestData="MDLDTest_12";
		sData=GenericLib.toReadExcelData(sTestData);

		try
		{
			Thread.sleep(4000);
			driver.tap(1,8,72,3000);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleFirstOption().click();
			homePo.getEleContinueBtn().click();
			Thread.sleep(3000);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleNeedNameTxt().isDisplayed(), "Need text is not displayed in submit page");
			NXGReports.addStep("Need text is successfully displayed in submit page", LogAs.PASSED, null);	
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit Request page is not displayed");
			NXGReports.addStep("Submit Request page is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}
