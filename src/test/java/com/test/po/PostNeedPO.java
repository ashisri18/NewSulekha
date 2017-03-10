package com.test.po;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

import io.appium.java_client.ios.IOSDriver;

public class PostNeedPO {
	String[] sData=null;
	IOSDriver driver=null;
	HomePO homePo=null;
	LoginPO loginPo=null;

	public PostNeedPO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath="//UIAStaticText[@name='Tell us more']")
	private WebElement eleTellusmoreTxt;
	public WebElement getEleTellusmoreTxt()
	{
		return eleTellusmoreTxt;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleRadioBtn;
	public WebElement getEleRadioBtn()
	{
		return eleRadioBtn;
	}
	//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]")
	private WebElement eleNeedList;
	public WebElement getEleNeedList()
	{
		return eleNeedList;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleNeedList1;
	public WebElement getEleNeedList1()
	{
		return eleNeedList1;
	}


	@FindBy(xpath="//UIAButton[@name='Back Ipad']")
	private WebElement eleBackArwIcn;
	public WebElement getEleBackArwIcn()
	{
		return eleBackArwIcn;
	}

	@FindBy(xpath="//UIAStaticText[@name='City']")
	private WebElement eleCityLabel;
	public WebElement getEleCityLabel()
	{
		return eleCityLabel;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]")
	private WebElement eleCityNameTxt;
	public WebElement getEleCityNameTxt()
	{
		return eleCityNameTxt;
	}

	@FindBy(xpath="//UIAStaticText[@name='Need']")
	private WebElement eleNeedLabel;
	public WebElement getEleNeedLabel()
	{
		return eleNeedLabel;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleNeedNameTxt;
	public WebElement getEleNeedNameTxt()
	{
		return eleNeedNameTxt;
	}



	@FindBy(xpath="//*[@name='Please enter value']")
	private WebElement eleAlertValuepopup;
	public WebElement getEleAlertValuepopup()
	{
		return eleAlertValuepopup;
	}
	@FindBy(xpath="//UIAButton[@name='Fill the form and get free quotes']")
	private WebElement eleFillformBtn;
	public WebElement getEleFillformBtn()
	{
		return eleFillformBtn;
	}
	@FindBy(id="Please select one option")
	private WebElement eleAlertSelectOneOption;
	public WebElement getEleAlertSelectOneOption(){
		return eleAlertSelectOneOption;
	}
	//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleFormRadioBtn;
	public WebElement getEleFormRadioBtn()
	{
		return eleFormRadioBtn;
	}
	

	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleFormRadioBtn1;
	public WebElement getEleFormRadioBtn1()
	{
		return eleFormRadioBtn1;
	}

	@FindBy(xpath="//UIAStaticText[@name='Contact Information']")
	private WebElement eleContactInfoTxt;
	public WebElement getEleContactInfoTxt()
	{
		return eleContactInfoTxt;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")
	private WebElement eleFormRadioBtn2;
	public WebElement getEleFormRadioBtn2()
	{
		return eleFormRadioBtn2;
	}

	@FindBy(xpath="//UIAButton[@name='RESPONSES']")
	private WebElement eleResponsesTab;
	public WebElement getEleResponsesTab()
	{
		return eleResponsesTab;
	}



	@FindBy(id="1 of 3")
	private WebElement eleFormPagingTxt;
	public WebElement getEleFormPagingTxt()
	{
		return eleFormPagingTxt;
	}

	@FindBy(id="1 of 2")
	private WebElement eleFormPagingTxt2;
	public WebElement getEleFormPagingTxt2()
	{
		return eleFormPagingTxt2;
	}

	@FindBy(xpath="//UIAButton[@name='NEXT']")
	private WebElement eleNextBtn;
	public WebElement getEleNextBtn()
	{
		return eleNextBtn;
	}

	@FindBy(xpath="//UIAButton[@name='Submit']")
	private WebElement eleSubmitRequestBtn;
	public WebElement getEleSubmitRequestBtn()
	{
		return eleSubmitRequestBtn;
	}

	@FindBy(xpath="//UIAStaticText[@name='Additional info']")
	private WebElement eleAdditionalInfoLabel;
	public WebElement getEleAdditionalInfoLabel()
	{
		return eleAdditionalInfoLabel;
	}

	@FindBy(id="Top 10 Neurologists in Bangalore.")

	private WebElement eleUserCommentTxt;

	public WebElement geteleUserCommentTxt()

	{

		return eleUserCommentTxt;

	}


	@FindBy(id="Provide any other specific details for your need")
	private WebElement eleTellusMoreTxtFld;
	public WebElement getEleTellusMoreTxtFld()
	{
		return eleTellusMoreTxtFld;
	}

	@FindBy(xpath="//UIAButton[@name='Notifications']")
	private WebElement eleNotificationLnk;
	public WebElement getEleNotificationLnk()
	{
		return eleNotificationLnk;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleNeedTxt;
	public WebElement getEleNeedTxt()
	{
		return eleNeedTxt;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleAcTxt;
	public WebElement getEleAcTxt()
	{
		return eleAcTxt;
	}

	

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[3]")
	private WebElement eleNeed;
	public WebElement getEleNeed()
	{
		return eleNeedTxt;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleNotificationListItm;
	public WebElement getEleNotificationListItm()
	{
		return eleNotificationListItm;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[4]/UIATableView[1]/UIATableCell[1]/UIAButton[1]")
	private WebElement eleEditIcn;
	public WebElement getEleEditIcn()
	{
		return eleEditIcn;
	}

	@FindBy(xpath="//UIAStaticText[@name='Select at least one option.']")
	private WebElement eleSelectAtleastOneOptAlertPopup;
	public WebElement getEleSelectAtleastOneOptAlertPopup()
	{
		return eleSelectAtleastOneOptAlertPopup;
	}

	@FindBy(xpath="//UIAButton[@name='smsIcon white']")

	private WebElement eleSmsIcon;

	public WebElement getEleSmsIcon(){

		return eleSmsIcon;

	}



	@FindBy(xpath="//UIAButton[@name='ic favorite outline white 18dp']")

	private WebElement eleShortlistIcon;

	public WebElement getShortlistIcon(){

		return eleShortlistIcon;

	}
	
	

	@FindBy(xpath="//UIAButton[@name='My Review Iphone']")
	private WebElement eleAdditionalInfoEditIcn;
	public WebElement getEleAdditionalInfoEditIcn()
	{
		return eleAdditionalInfoEditIcn;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleAdditionalInfoTxt;
	public WebElement getEleAdditionalInfoTxt()
	{
		return eleAdditionalInfoTxt;
	}

	@FindBy(id="Ambulance Services")
	private WebElement eleAmbulanceServicesTxt;
	public WebElement getEleAmbulanceServicesTxt()
	{
		return eleAmbulanceServicesTxt;
	}

	public void toSubmitNeed(MyNeedsDashboardPO myneedsdashboardPo)
	{
		getEleFormRadioBtn().click();
		getEleNextBtn().click();
		getEleNextBtn().click();
		getEleSubmitRequestBtn().click();
	}


	/* @Description- To navigate till Tell us More screen in SDLDwithoutType
	 * @Author- Yashi Priya*/
	public void toPostSdldWithoutType(HomePO homePo)
	{
		homePo.getEleFirstOption().click();
		homePo.getEleContinueBtn().click();
		Assert.assertTrue(getEleTellusmoreTxt().isDisplayed(), "User is not  displayed only with Tell us more field.");
		NXGReports.addStep("User is successfully displayed only with Tell us more field.",LogAs.PASSED, null);
	}
}
