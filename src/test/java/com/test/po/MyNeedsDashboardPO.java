
package com.test.po;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import io.appium.java_client.ios.IOSDriver;

public class MyNeedsDashboardPO {
	IOSDriver driver=null;
	public MyNeedsDashboardPO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]")
	private WebElement eleSecondOption;
	public WebElement getEleSecondOption(){
		return eleSecondOption;
	}


	@FindBy(id="Dashboard")
	private WebElement eleDashboardBtn;
	public WebElement getEleDashboardBtn(){
		return eleDashboardBtn;
	}



	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]")
	private WebElement eleCountNeedNumber;
	public WebElement getEleCountNeedNumber(){
		return eleCountNeedNumber;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[3]")
	private WebElement eleCountNeedNumber1;
	public WebElement getEleCountNeedNumber1(){
		return eleCountNeedNumber1;
	}
	


	@FindBy(xpath="//*[@name='Today']")
	private WebElement eleDataPostedOption;
	public WebElement getEleDataPostedOption(){
		return eleDataPostedOption;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleNameofBusinessTxt;
	public WebElement getEleNameofBusinessTxt(){
		return eleNameofBusinessTxt;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleLocationNameTxt;
	public WebElement getEleLocationNameTxt(){
		return eleLocationNameTxt;
	}


	@FindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[6]")
	private WebElement eleScoreIcon;
	public WebElement getEleScoreIcon(){
		return eleScoreIcon;
	}
	

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[6]")
	private WebElement eleScoreTxt;
	public WebElement getEleScoreTxt(){
		return eleScoreTxt;
	}

	@FindBy(xpath="//*[@name='SELECT & REVIEW']")
	private WebElement eleReviewLink;
	public WebElement getEleReviewLink(){
		return eleReviewLink;
	}


	@FindBy(xpath="//*[@name='callIcon']")
	private WebElement eleCallIcon;
	public WebElement getEleCallIcon(){
		return eleCallIcon;
	}

	@FindBy(id="Thank you for your valuable feedback!")
	private WebElement eleThankyouTxt;
	public WebElement getEleThankyouTxt(){
		return eleThankyouTxt;
	}

	@FindBy(xpath="//UIAButton[@name='VIEW DASHBOARD']")
	private WebElement eleVIEWDASHBOARDBtn;
	public WebElement getEleVIEWDASHBOARDBtn(){
		return eleVIEWDASHBOARDBtn;
	}
	
	@FindBy(xpath="//UIAStaticText[@name='My needs dashboard']")
	private WebElement eleMyNeedsDashboardTxt;
	public WebElement getEleMyNeedsDashboardTxt(){
		return eleMyNeedsDashboardTxt;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleNeedArrowBtn;
	public WebElement getEleNeedArrowBtn(){
		return eleNeedArrowBtn;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[3]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleNeedArrow;
	public WebElement getEleNeedArrow(){
		return eleNeedArrow;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleFinalisedNeedArrow;
	public WebElement getEleFinalisedNeedArrow(){
		return eleFinalisedNeedArrow;
	}


	@FindBy(xpath="//*[@name='NOT FINALISED BUSINESS?']")
	private WebElement eleNotFinalisedBusinessBtn;
	public WebElement getEleNotFinalisedBusinessBtn(){
		return eleNotFinalisedBusinessBtn;
	}



	@FindBy(xpath="//*[@name='It’s taking time to get the best set of matching experts. We’ll SMS you the info, shortly.']")
	private WebElement eleNeedNotiSMSTxt;
	public WebElement getEleNeedNotiSMSTxt(){
		return eleNeedNotiSMSTxt;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")
	private WebElement eleCityTxtField;
	public WebElement getEleCityTxtField(){
		return eleCityTxtField;
	}


	@FindBy(xpath="/UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleCityListOption;
	public WebElement getEleCityListOpion(){
		return eleCityListOption;
	}


	@FindBy(xpath="//*[@name='SUMMARY']")
	private WebElement eleSummaryTab;
	public WebElement getEleSummaryTab(){
		return eleSummaryTab;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[2]")
	private WebElement eleSummaryNeedList;
	public WebElement getEleSummaryNeedList(){
		return eleSummaryNeedList;
	}


	@FindBy(xpath="//*[@name='Got your job done from JPA Solutions Center of']")
	private WebElement eleReviewPopup;
	public WebElement getEleReviewPopup(){
		return eleReviewPopup;
	}


	@FindBy(xpath="//*[@name='NO']")
	private WebElement eleNoBtn;
	public WebElement getEleNoBtn(){
		return eleNoBtn;
	}


	@FindBy(xpath="//*[@name='YES']")
	private WebElement eleYesBtn;
	public WebElement getEleYesBtn(){
		return eleYesBtn;
	}




	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement elePostBtn;
	public WebElement getElePostBtn(){
		return elePostBtn;
	}


	@FindBy(xpath="//*[@name='writeReviewIcon']")
	private WebElement eleReviewBtn;
	public WebElement getEleReviewBtn(){
		return eleReviewBtn;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[1]")
	private WebElement eleDidntReceiveCallPopup;
	public WebElement getEleDidntReceiveCallOption(){
		return eleDidntReceiveCallPopup;
	}


	@FindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[2]")
	private WebElement eleImnothappywiththeQuotesPopup;
	public WebElement getEleImnothappywiththeQuotesPopup(){
		return eleImnothappywiththeQuotesPopup;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[3]")
	private WebElement eleIdonthavethisneedanymorePopup;
	public WebElement getEleIdonthavethisneedanymorePopup(){
		return  eleIdonthavethisneedanymorePopup;
	}


	@FindBy(xpath="//*[@name='DISMISS']")
	private WebElement eleDismissBtn;
	public WebElement getEleDismissBtn(){
		return  eleDismissBtn;
	}


	@FindBy(xpath="//*[@name='Tell us more about your specific needs. Our executive will get more suitable businesses.']")
	private WebElement eleTellusMorePopup;
	public WebElement getEleTellusMorePopup(){
		return  eleTellusMorePopup;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")
	private WebElement eleTellusMoreNeedPopup;
	public WebElement getEleTellusMoreNeedPopup(){
		return  eleTellusMoreNeedPopup;
	}


	@FindBy(xpath="//*[@name='SEND']")
	private WebElement eleSendBtn;
	public WebElement getEleSendBtn(){
		return eleSendBtn;
	}

	@FindBy(xpath="//*[@name='Got your job done from Apex Services Inc.?']")
	private WebElement 	eleJobAlertPopup;
	public WebElement getEleJobAlertPopup(){
		return eleJobAlertPopup;
	}


	@FindBy(xpath="//UIAButton[@name='WRITE A REVIEW']")
	private WebElement eleWriteReviewBtn;
	public WebElement getEleWriteReviewBtn(){
		return eleWriteReviewBtn;
	}
	
	@FindBy(xpath="//UIAButton[@name='MORE QUOTES']")
	private WebElement eleMoreQuotesTxt;
	public WebElement getEleMoreQuotesTxt(){
		return eleMoreQuotesTxt;
	}


	@FindBy(xpath="//*[@name='You have requested more quotes']")
	private WebElement eleRequestedQuotesTxt;
	public WebElement getEleRequestedQuotesTxt(){
		return  eleRequestedQuotesTxt;
	}


	@FindBy(xpath="//*[@name='You have cancelled this need']")
	private WebElement eleCancelledNeedTxt;
	public WebElement getEleCancelledNeedTxt(){
		return  eleCancelledNeedTxt;
	}


	@FindBy(xpath="//*[@name='Cancel']")
	private WebElement eleCancelBtn;
	public WebElement getEleCancelBtn(){
		return  eleCancelBtn;
	}


	@FindBy(xpath="//*[@name='Cancelled']")
	private WebElement eleCancelledTxt;
	public WebElement getEleCancelledTxt(){
		return  eleCancelledTxt;
	}


	@FindBy(xpath="//*[@name='ic star border black 36dp 3x']")
	private WebElement eleShortlistBtn;
	public WebElement getEleShortlistBtn(){
		return   eleShortlistBtn;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleResponsesPostBtn;
	public WebElement getEleResponsesPostBtn(){
		return  eleResponsesPostBtn;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleNeedsLstItm;
	public WebElement getEleNeedsLstItm(){
		return  eleNeedsLstItm;

	}

	@FindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleCityOption;

	public WebElement getEleCityOption(){

		return eleCityOption;
	}
	@FindBy(xpath="//*[@name='SHORTLIST']")
	private WebElement eleNeedShortlistBtn;
	public WebElement getEleNeedShortlistBtn(){
		return  eleNeedShortlistBtn;
	}


	@FindBy(xpath="//*[@name='GIVE FEEDBACK']")
	private WebElement eleGiveFeedbackBtn;
	public WebElement getEleGiveFeedbackBtn(){
		return eleGiveFeedbackBtn;
	}

	@FindBy(xpath="//UIAButton[@name='NEEDS']")
	private WebElement eleNeedsTab;
	public WebElement getEleNeedsTab(){
		return eleNeedsTab;
	}


	public void searchNeeds(HomePO homePo,MDLDPO mdldpo,PostNeedPO postneedPo,String sneeds) throws InterruptedException{
		Thread.sleep(4000);
		driver.tap(1,8,72,3000);
		homePo.getEleSearchTxtFld().sendKeys(sneeds);
		homePo.getEleDoneBtn().click();
		homePo.getEleFirstOption().click();
		homePo.getEleContinueBtn().click();
		postneedPo.getEleFormRadioBtn().click();
		NXGReports.addStep("Radio from page is successfully displayed", LogAs.PASSED, null);
		postneedPo.getEleNextBtn().click();
		NXGReports.addStep("Next button is successfully displayed", LogAs.PASSED, null);
		postneedPo.getEleNextBtn().click();
		postneedPo.getEleSubmitRequestBtn().click();
		NXGReports.addStep("Submit request button is successfully displayed", LogAs.PASSED, null);
		try{
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
		}catch(Exception e){
			Thread.sleep(3000);
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]")).click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
		}
	}

	public void dashboard(){

		Assert.assertTrue(getEleDashboardBtn().isDisplayed(),"Dashboard icon is not displayed");
		NXGReports.addStep("Dashboard icon is successfully displayed",LogAs.PASSED, null);
		getEleDashboardBtn().click();
		Assert.assertTrue(getEleNeedsTab().isDisplayed(),"User is not navigated to need dashboard page");
		NXGReports.addStep("User is successfully navigated to need dashboard page",LogAs.PASSED, null);
		getEleNeedArrowBtn().click();

	}

}
