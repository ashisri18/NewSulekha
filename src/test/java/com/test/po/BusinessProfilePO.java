package com.test.po;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

public class BusinessProfilePO {
	IOSDriver driver = null;
	JavascriptExecutor js = null;
	HashMap<String, String> scrollObject = null;

	public BusinessProfilePO(IOSDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]


	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleBusinessNameTxt;

	public WebElement getEleBusinessNameTxt() {
		return eleBusinessNameTxt;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleBusinessTxt;

	public WebElement getEleBusinessTxt() {
		return eleBusinessTxt;
	}
	@FindBy(xpath ="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	private WebElement eleNeedNameTxt;

	public WebElement getEleNeedNameTxt() {
		return eleNeedNameTxt;
	}
	

	@FindBy(id = "Review posted successfully")
	private WebElement eleReviewPostedToast;

	public WebElement getEleReviewPostedToast() {
		return eleReviewPostedToast;
	}
	

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleShortlistNameTxt;

	public WebElement getEleShortlistNameTxt() {
		return eleShortlistNameTxt;
	}


	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleBusinessLocation;

	public WebElement getEleBusinessLocation() {
		return eleBusinessLocation;
	}

	@FindBy(xpath = "//UIAButton[@name='WRITE REVIEW']")
	private WebElement eleWriteReviewBtn;

	public WebElement getEleWriteReviewBtn() {
		return eleWriteReviewBtn;
	}

	@FindBy(id = "About")
	private WebElement eleBusinessAboutTxt;

	public WebElement getEleBusinessAboutTxt() {
		return eleBusinessAboutTxt;
	}

	@FindBy(id = "Contact person")
	private WebElement eleBusinessContactTxt;

	public WebElement getEleBusinessContactTxt() {
		return eleBusinessContactTxt;
	}

	@FindBy(id = "Contact person")
	private WebElement eleBusinessHours;

	public WebElement getEleBusinessHours() {
		return eleBusinessContactTxt;
	}

	@FindBy(xpath = "//UIATableCell[@name='Work']")
	private WebElement eleBusinessWorkTxt;

	public WebElement getEleBusinessWorkTxt() {
		return eleBusinessWorkTxt;
	}
	

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]")
	private WebElement eleBusinessReviwsTxt;

	public WebElement getEleBusinessReviwsTxt() {
		return eleBusinessReviwsTxt;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]")
	private WebElement eleBusinessMobileNumTxt;

	public WebElement getEleBusinessMobileNumTxt() {
		return eleBusinessMobileNumTxt;
	}

	@FindBy(xpath = " //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIAStaticText[3]")
	private WebElement eleBusinessLandmarkTxt;

	public WebElement getEleBusinessLandmarkTxt() {
		return eleBusinessLandmarkTxt;
	}

	@FindBy(id = "Working hours")
	private WebElement eleBusinessWorkinghoursTxt;

	public WebElement getEleBusinessWorkinghoursTxt() {
		return eleBusinessWorkinghoursTxt;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAButton[1]")
	private WebElement eleBusinessScore;

	public WebElement getEleBusinessScore() {
		return eleBusinessScore;
	}
	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[6]")
	private WebElement eleBusinessScore1;

	public WebElement getEleBusinessScore1() {
		return eleBusinessScore1;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIAStaticText[1]]")
	private WebElement eleAddressIcn;

	public WebElement getEleAddressIcn() {
		return eleAddressIcn;
	}

	@FindBy(xpath = " //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[2]")
	private WebElement eleWorkPhoneNumTxt;

	public WebElement getEleWorkPhoneNumTxt() {
		return eleWorkPhoneNumTxt;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[12]/UIAStaticText[1]")
	private WebElement eleWebsiteIcn;

	public WebElement getEleWebsiteIcn() {
		return eleWebsiteIcn;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")
	private WebElement eleBusinessEmailAddress;

	public WebElement getEleBusinessEmailAddress() {
		return eleBusinessEmailAddress;
	}

	@FindBy(xpath = "//UIATextView[@name='Message body']")
	private WebElement eleEmailMsgBody;

	public WebElement getEleEmailMsgBody() {
		return eleEmailMsgBody;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Email']")
	private WebElement eleEmailIcn;

	public WebElement getEleEmailIcn() {
		return eleEmailIcn;
	}

	@FindBy(xpath = "//UIAButton[@name='Directions']")
	private WebElement eleGoogleMapDirectionsIcn;

	public WebElement getEleGoogleMapDirectionsIcn() {
		return eleGoogleMapDirectionsIcn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='NO THANKS']")
	private WebElement eleGoogleMapNOTHANKSbtn;

	public WebElement getEleGoogleMapNOTHANKSbtn() {
		return eleGoogleMapNOTHANKSbtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Services offered']")
	private WebElement eleServicesOfrdTxt;

	public WebElement getEleServicesOfrdTxt() {
		return eleServicesOfrdTxt;
	}

	@FindBy(id = "Pest Control Services Bed Bugs Pest Control Cockroach Pest Control")
	private WebElement eleServicesOfrdLst;

	public WebElement getEleServicesOfrdLst() {
		return eleServicesOfrdLst;
	}
	
	@FindBy(xpath ="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]")
	private WebElement eleFormPagingTxt;

	public WebElement getEleFormPagingTxt() {
		return eleFormPagingTxt;
	}

	@FindBy(xpath = " //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]")
	private WebElement eleRatingList;

	public WebElement getEleRatingList() {
		return eleRatingList;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Reviews']")
	private WebElement eleReviewLnk;

	public WebElement getEleReviewLnk() {
		return eleReviewLnk;
	}


	@FindBy(xpath = " //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleReviewTxt1;

	public WebElement getEleReviewTxt1() {
		return eleReviewTxt1;
	}

	@FindBy(xpath = "//UIAStaticText[@name='The Google Maps app isn’t on your phone']")
	private WebElement eleUseGoogleMapPopup;

	public WebElement getEleUseGoogleMapPopup() {
		return eleUseGoogleMapPopup;
	}

	@FindBy(xpath = "//UIAButton[@name='VIEW MORE REVIEWS']")
	private WebElement eleVIEWMOREREVIEWSBtn;

	public WebElement getEleVIEWMOREREVIEWSBtn() {
		return eleVIEWMOREREVIEWSBtn;
	}

	@FindBy(xpath = "//UIAButton[@name='writeReviewIcon']")
	private WebElement eleWriteReviewIcn;

	public WebElement getEleWriteReviewIcn() {
		return eleWriteReviewIcn;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	private WebElement eleSMSIcn;

	public WebElement getEleSMSIcn() {
		return eleSMSIcn;
	}

	@FindBy(xpath = "//UIAButton[@name='Button']")
	private WebElement eleShortlistIcn;

	public WebElement getEleShortlistIcn() {
		return eleShortlistIcn;
	}

	@FindBy(xpath = "//UIAButton[@name='float sort']")
	private WebElement elefloatsortBtn;

	public WebElement getElefloatsortBtn() {
		return elefloatsortBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Sort by score']")
	private WebElement eleSortByScoreBtn;

	public WebElement getEleSortByScoreBtn() {
		return eleSortByScoreBtn;
	}

	@FindBy(id = "Sort by default")
	private WebElement eleSortByDefaultBtn;

	public WebElement getEleSortByDefaultBtn() {
		return eleSortByDefaultBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Sort by rating']")
	private WebElement eleSortByRatingBtn;

	public WebElement getEleSortByRatingBtn() {
		return eleSortByRatingBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Rate this business']")
	private WebElement eleRatingBusiTxt;

	public WebElement getEleRatingBusiTxt() {
		return eleRatingBusiTxt;
	}

	@FindBy(xpath = "//UIAButton[@name='Get Best Quotes']")
	private WebElement eleGetQuotesBtn;

	public WebElement getGetQuotesBtn() {
		return eleGetQuotesBtn;
	}

	@FindBy(xpath = "//*[@name='callIcon']")
	private WebElement eleCallIcon;

	public WebElement getEleCallIcon() {
		return eleCallIcon;
	}

	@FindBy(xpath ="//UIAApplication[1]/UIAWindow[1]/UIAMapView[1]/UIAPopover[1]/UIAStaticText[1]")
	private WebElement eleBusiMapLocationTxt;

	public WebElement getEleBusiMapLocationTxt() {
		return eleBusiMapLocationTxt;
	}

	@FindBy(xpath = "//UIAStaticText[@name='You've shortlisted this business']")
	private WebElement eleShortlistTost;

	public WebElement getEleShortlistTost() {
		return eleShortlistTost;
	}

	@FindBy(xpath = "//UIAStaticText[@name='You have removed this business contact from your shortlist']")
	private WebElement eleRemoveShortlistTost;

	public WebElement getEleRemoveShortlistTost() {
		return eleRemoveShortlistTost;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")
	private WebElement eleBusinessPhnNumTxt;

	public WebElement getEleBusinessPhnNumTxt() {
		return eleBusinessPhnNumTxt;
	}

	@FindBy(xpath = "//UIAButton[@name='Add Contact']")
	private WebElement eleAddContactBtn;

	public WebElement getEleAddContactBtn() {
		return eleAddContactBtn;
	}

	@FindBy(xpath = "(//UIACollectionCell/UIAImage)[1]")
	private WebElement eleImageLstItm;

	public WebElement getEleImageLstItm() {
		return eleImageLstItm;
	}

	@FindBy(xpath = "//UIAButton[@name='POST REVIEW']")
	private WebElement elePOSTREVIEWBtn;

	public WebElement getElePOSTREVIEWBtn() {
		return elePOSTREVIEWBtn;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIAScrollView[1]")
	private WebElement eleRateBusinessAlertPopup;

	public WebElement getEleRateBusinessAlertPopup() {
		return eleRateBusinessAlertPopup;
	}

	@FindBy(xpath = "//UIATextField[@name='To:']")
	private WebElement eleSMSToTxtFld;

	public WebElement getEleSMSToTxtFld() {
		return eleSMSToTxtFld;
	}

	@FindBy(xpath = "//UIAStaticText[@name='New Message']")
	private WebElement eleNewMsgTxt;

	public WebElement getEleNewMsgTxt() {
		return eleNewMsgTxt;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]")
	private WebElement eleImageDisplay;

	public WebElement getEleImageDisplay() {
		return eleImageDisplay;
	}

	@FindBy(id = "Photos / videos")
	private WebElement eleBusinessImg;

	public WebElement getEleBusinessImg() {
		return eleBusinessImg;
	}

	@FindBy(xpath = "//UIAButton[@name='View more']")
	private WebElement eleViewMoreBtn;

	public WebElement getEleViewMoreBtn() {
		return eleViewMoreBtn;
	}

	@FindBy(xpath = "//UIAButton[@name='View less']")
	private WebElement eleViewLessBtn;

	public WebElement getEleViewLessBtn() {
		return eleViewLessBtn;
	}

	@FindBy(xpath = "//UIAButton[@name='Back to Sulekha']")
	private WebElement eleBacktoSulekhaBtn;

	public WebElement getEleBacktoSulekhaBtn() {
		return eleBacktoSulekhaBtn;
	}

	@FindBy(id = "Pest Control Services Bed Bugs Pest Control Cockroach Pest Control Corporate Pest Control Mosquito Fogging Post Construction Pest Control Pre Construction Pest Control Residential Pest Control")
	private WebElement eleMoreServicesTxtView;

	public WebElement getEleMoreServicesTxtView() {
		return eleMoreServicesTxtView;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]")
	private WebElement eleReviewLst;

	public WebElement getEleReviewLst() {
		return eleReviewLst;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]")
	private WebElement eleReviewDetailView;

	public WebElement getEleReviewDetailView() {
		return eleReviewDetailView;
	}

	@FindBy(id = "Enter a minimum of 25 characters")
	private WebElement eleWriteyourreviewTxtFld;

	public WebElement getEleWriteyourreviewTxtFld() {
		return eleWriteyourreviewTxtFld;
	}
	 

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")
	private WebElement eleBusinessWebImg;

	public WebElement getEleBusinessWebImg() {
		return eleBusinessWebImg;
	}

	@FindBy(xpath ="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleGetQuotesForBusinessLstItm;

	public WebElement getEleGetQuotesForBusinessLstItm() {
		return eleGetQuotesForBusinessLstItm;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleShortlistItm;

	public WebElement getEleShortlistItm() {
		return eleShortlistItm;
	}

	@FindBy(xpath ="//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleRadioBtn;

	public WebElement getEleRadioBtn() {
		return eleRadioBtn;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleBrowserBussRadioBtn;

	public WebElement getEleBrowserBussRadioBtn() {
		return eleBrowserBussRadioBtn;
	}

	@FindBy(xpath ="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell")
	private List<WebElement> eleMoreReviewsTable;

	public List<WebElement> getEleMoreReviewsTable() {
		return eleMoreReviewsTable;
	}

	@FindBy(xpath = "//UIAButton[@name='ic star border black 36dp 3x']")
	private WebElement eleRemoveShortlistIcn;

	public WebElement getEleRemoveShortlistIcn() {
		return eleRemoveShortlistIcn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Reviews']")
	private WebElement eleReviewsIcn;

	public WebElement getEleReviewsIcn() {
		return eleReviewsIcn;
	}

	@FindBy(xpath = "//UIAButton[@name='Cancel']")
	private WebElement eleCancelBtn;

	public WebElement getEleCancelBtn() {
		return eleCancelBtn;
	}

	@FindBy(xpath = "//UIAButton[@name='callIcon']")
	private WebElement eleCallBtn;

	public WebElement getEleCallBtn() {
		return eleCallBtn;
	}
	
	@FindBy(xpath = "//UIAButton[@name='call whiteIcon']")
	private WebElement eleCallIcn;

	public WebElement getEleCallIcn() {
		return eleCallIcn;
	}
	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
	private WebElement eleCallIcoN;

	public WebElement getEleCallIcoN() {
		return eleCallIcoN;
	}

	
	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[3]")
	private WebElement eleShotList;

	public WebElement getEleShotList() {
		return eleShotList;
	}


	@FindBy(xpath = "//UIAButton[@name='smsIcon']")
	private WebElement eleSmsBtn;

	public WebElement getEleSmsBtn() {
		return eleSmsBtn;
	}

	@FindBy(xpath = "//UIAImage[@name='notificationWhiteIcon.png']")
	private WebElement eleNotificationIcn;

	public WebElement getEleNotificationIcn() {
		return eleNotificationIcn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='NOTIFICATION']")
	private WebElement eleNOTIFICATIONTxt;

	public WebElement getEleNOTIFICATIONTxt() {
		return eleNOTIFICATIONTxt;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Website']")
	private WebElement eleWebsiteLnk;

	public WebElement getEleWebsiteLnk() {
		return eleWebsiteLnk;
	}

	@FindBy(xpath = "//UIAButton[@name='End call']")
	private WebElement eleEndCallBtn;

	public WebElement getEleEndCallBtn() {
		return eleEndCallBtn;
	}

	@FindBy(xpath = "//*[@name='calling…']")
	private WebElement eleCallingTxt;

	public WebElement getEleCallingTxt() {
		return eleCallingTxt;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[11]/UIAStaticText[3]")
	private WebElement eleReviewTxt;

	public WebElement getEleReviewTxt() {
		return eleReviewTxt;
	}

	/*
	 * @Description- To navigate to Business Profile Page
	 * 
	 * @Author- Yashi Priya
	 */
	public void navigateToBusinessProfile(HomePO homePo, MyNeedsDashboardPO myneedsdashboardPo,String Sneed)
			throws InterruptedException {
		Thread.sleep(4000);
		driver.tap(1,8,72,3000);
		homePo.getEleSearchTxtFld().sendKeys(Sneed);
		NXGReports.addStep("Search text field is successfully displayed", LogAs.PASSED, null);
		homePo.getEleDoneBtn().click();
		NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
		homePo.getEleFirstOption().click();
		homePo.getEleViewListingBtn().click();
		getEleGetQuotesForBusinessLstItm().click();
		NXGReports.addStep("Get quotes listing button is successfully displayed", LogAs.PASSED, null);
		Thread.sleep(2000);
		Assert.assertTrue(getEleBusinessNameTxt().isDisplayed(), "Business Profile page is not displayed");
		NXGReports.addStep("Business Profile page is successfully displayed", LogAs.PASSED, null);
	}
	
	public void navigateToBusinessProfile1(HomePO homePo, MyNeedsDashboardPO myneedsdashboardPo, String sNeed,PostNeedPO postneedPo)
			throws InterruptedException {
		Thread.sleep(4000);
		driver.tap(1,8,72,3000);
		homePo.getEleSearchTxtFld().sendKeys(sNeed);
		NXGReports.addStep("Search text field is successfully displayed", LogAs.PASSED, null);
		homePo.getEleDoneBtn().click();
		NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
		homePo.getEleFirstOption().click();
		Thread.sleep(4000);
		postneedPo.getEleFormRadioBtn1().click();
		homePo.getEleContinueBtn().click();
		homePo.getEleViewListingBtn().click();
		getEleGetQuotesForBusinessLstItm().click();
		NXGReports.addStep("Get quotes listing button is successfully displayed", LogAs.PASSED, null);
		Thread.sleep(2000);
		Assert.assertTrue(getEleBusinessNameTxt().isDisplayed(), "Business Profile page is not displayed");
		NXGReports.addStep("Business Profile page is successfully displayed", LogAs.PASSED, null);
	}


	/*
	 * @Description- To scroll to reviews links after scrolling till website
	 * 
	 * @Author- Yashi Priya
	 */
	public void scrollToReviewsAfterWebsite() {
		int i = 1;
		while (i > 0) {
			try {
				js = (JavascriptExecutor) driver;
				scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				if (eleReviewLnk.isDisplayed())
					break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/*
	 * @Description- To scroll to reviews links .
	 * 
	 * @Author- Yashi Priya
	 */
	public void scrollToReviews() {

		for (int i = 0; i <= 5; i++) {
			try {
				js = (JavascriptExecutor) driver;
				scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/*
	 * @Description- To Handle Sim Popup after clicking on call icon
	 * 
	 * @Author- Yashi Priya
	 */
	public void handlingCall() throws InterruptedException {
		try {
			Thread.sleep(6000);
			driver.switchTo().alert().accept();
			NXGReports.addStep("No sim in the device popup is displayed and handled", LogAs.PASSED, null);

		} catch (Exception e) {
			Thread.sleep(6000);
			Assert.assertTrue(getEleCallingTxt().isDisplayed(), "Call is not triggered to the business");
			NXGReports.addStep("Call is successfully triggered to the business", LogAs.PASSED, null);
			Assert.assertTrue(getEleEndCallBtn().isDisplayed(), "End call button is not displayed");
			NXGReports.addStep("End call button is Successfully displayed", LogAs.PASSED, null);
		}
	}

	/*
	 * @Description- To navigate to the post a review popup
	 * 
	 * @Author- Yashi Priya
	 */
	public void navigateToPostReviewPopup() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getEleVIEWMOREREVIEWSBtn().click();
		NXGReports.addStep("viewnore review button is successfully displayed", LogAs.PASSED, null);
		getEleWriteReviewIcn().click();
		NXGReports.addStep("Write review button is successfully displayed", LogAs.PASSED, null);
		Assert.assertTrue(getEleRatingBusiTxt().isDisplayed(), "A popup to post a review is not displayed");
		NXGReports.addStep("A popup to post a review is successfully displayed", LogAs.PASSED, null);
	}

	/*
	 * @Description- To test the alert popup saying Rate this business before
	 * you submit.
	 * 
	 * @Author- Yashi Priya
	 */
	public void testRateBusiAlert(WelcomePO welcomePo) {
		getElePOSTREVIEWBtn().click();
		NXGReports.addStep("Postreview button is successfully",LogAs.PASSED, null);
		Assert.assertTrue(getEleRateBusinessAlertPopup().isDisplayed(),
				"An alert popup saying Rate this business before you submit is not displayed");
		NXGReports.addStep("An alert popup saying Rate this business before you submit is successfully displayed",
				LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();

	}

	/*
	 * @Description- To tap on the rating bar displayed in Post a review popup.
	 * 
	 * @Author- Yashi Priya
	 */
	public void toTapOnRatingBar() throws InterruptedException {
		Thread.sleep(2000);
		new TouchAction((MobileDriver) driver).longPress(100, 200).release().perform();
		Thread.sleep(3000);

	}

	/*
	 * @Description- To test the list of reviews after clicking on View More
	 * Reviews link.
	 * 
	 * @Author- Yashi Priya
	 */
	public void toTestMoreReview() {
		int j = 2;
		try {
			Assert.assertTrue(getEleVIEWMOREREVIEWSBtn().isDisplayed(),
					"More reviews link in the business profile screen is not displayed");
			NXGReports.addStep("More reviews link in the business profile screen is successfully displayed",
					LogAs.PASSED, null);
			getEleVIEWMOREREVIEWSBtn().click();
			Assert.assertTrue(getEleWriteReviewBtn().isDisplayed(),
					"Reviews page with the write review icon is not displayed");
			NXGReports.addStep("Reviews page with the write review icon is successfully displayed", LogAs.PASSED, null);
			for (int i = 0; i < getEleMoreReviewsTable().size(); i++) {
				if (i > j) {
					js = (JavascriptExecutor) driver;
					scrollObject = new HashMap<String, String>();
					scrollObject.put("direction", "down");
					js.executeScript("mobile: scroll", scrollObject);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Assert.assertTrue(getEleMoreReviewsTable().get(i).isDisplayed(),
							"More reviews of the business are not displayed");
					NXGReports.addStep("More reviews of the business are successfully displayed", LogAs.PASSED, null);
					j = j + 2;
				} else {
					Assert.assertTrue(getEleMoreReviewsTable().get(i).isDisplayed(),
							"More reviews of the business are not displayed");
					NXGReports.addStep("More reviews of the business are successfully displayed", LogAs.PASSED, null);

				}
			}
		} catch (Exception e) {
			NXGReports.addStep("More reviews link in the business profile screen is not displayed", LogAs.PASSED, null);
			Assert.assertTrue(getEleWriteReviewBtn().isDisplayed(),
					"Write review button in the business profile screen is not displayed");
			NXGReports.addStep("Write review button in the business profile screen is successfully displayed",
					LogAs.PASSED, null);

		}
	}
}
