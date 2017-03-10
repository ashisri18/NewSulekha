package com.test.po;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class MDLDPO {
	String[] sData=null;
	IOSDriver driver=null;
	HomePO homePo=null;
	LoginPO loginPo=null;

	public MDLDPO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@name='Fill the form and get free quotes']")
	private WebElement eleFillformBtn;
	public WebElement getEleFillformBtn()
	{
		return eleFillformBtn;
	}
	 


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]")
	private WebElement eleShortlistsItem;
	public WebElement getEleShortlistsItem()
	{
		return eleShortlistsItem;
	}

	@FindBy(xpath="//*[@name='ic star border black 36dp 3x']")
	private WebElement eleShortlistsIcon;
	public WebElement getEleShortlistsIcon(){
		return eleShortlistsIcon;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[1]")
	private WebElement eleFormRadioBtn;
	public WebElement getEleFormRadioBtn()
	{
		return eleFormRadioBtn;
	}
	@FindBy(xpath="//*[@name='What are you looking for?']")
	private WebElement elequestiontxt;
	public WebElement getElequestiobtxt(){
		return elequestiontxt;
	}

	@FindBy(xpath="//*[@name='What do you want to be trained in?']")
	private WebElement eletrainedquestion;
	public WebElement getEletrainedquestion(){
		return eletrainedquestion;
	}

	@FindBy(xpath="//*[@name='Responses']")
	private WebElement eleResponsesTab;
	public WebElement getEleResponsesTab()
	{
		return eleResponsesTab;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleLocationList;
	public WebElement getEleLocationList(){
		return eleLocationList;
	}



	@FindBy(xpath="	//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleFormCheckBox;
	public WebElement getEleFormCheckBox()
	{
		return eleFormCheckBox;
	}
	 //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleFormCheckArrowBox;
	public WebElement getEleFormCheckArrowBox()
	{
		return eleFormCheckArrowBox;
	}
	@FindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleFormCheckArrowBox1;
	public WebElement getEleFormCheckArrowBox1()
	{
		return eleFormCheckArrowBox1;
	}
	
	
	@FindBy(xpath="//UIAStaticText[@name='Provide any other specific details for your need']")
	private WebElement eleTellusMoreTxtFld;
	public WebElement getEleTellusMoreTxtFld()
	{
		return eleTellusMoreTxtFld;
	}

	@FindBy(xpath="//UIAButton[@name='Done']")
	private WebElement eleDoneBtn;
	public WebElement getEleDoneBtn()
	{
		return eleDoneBtn;
	}
	
	//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]

	
	@FindBy(id="Add a locality")
	private WebElement elelocalityTxtFld;
	public WebElement getElelocalityTxtFld(){
		return elelocalityTxtFld;
	}
	
	@FindBy(id="Date")
	private WebElement eleDateTxtFld;
	public WebElement getEleDateTxtFld(){
		return eleDateTxtFld;
	}
	@FindBy(id="You can add upto 5 localitites")
	private WebElement eleDestinationTxtBox;
	public WebElement getEleDestinationTxtBox()
	{
		return eleDestinationTxtBox;
	}
	@FindBy(xpath="//*[@name='Return']")
	private WebElement eleReturnBtn;
	public WebElement getEleReturnBtn(){
		return eleReturnBtn;
	}

	@FindBy(xpath="//*[@name='NEXT']")
	private WebElement eleNextBtn;
	public WebElement getEleNextBtn()
	{
		return eleNextBtn;
	}

	@FindBy(id="Enter your location")
	private WebElement eleLocationTxtFld;
	public WebElement getEleLocationTxtFld(){
		return eleLocationTxtFld;

	}

	@FindBy(xpath="//UIAStaticText[@name='Surveillance DVR Solutions']")
	private WebElement eleNeedSummarypageTxt;
	public WebElement getEleNeedSummarypageTxt(){
		return eleNeedSummarypageTxt;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleLocalitiesList1;
	public WebElement getEleLocalitiesList1(){
		return eleLocalitiesList1;
	}
	
	 //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]/UIATableView[1]/UIATableCell[1]


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[4]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleLocalitiesList;
	public WebElement getEleLocalitiesList(){
		return eleLocalitiesList;
	}
	@FindBy(xpath="//UIAButton[@name='Submit']")
	private WebElement eleSubmitRequestBtn;
	public WebElement getEleSubmitRequestBtn()
	{
		return eleSubmitRequestBtn;
	}
	
	@FindBy(id="Home Appliances Repair & Services")
	private WebElement eleHomeAppliancesIcn;
	public WebElement getEleHomeAppliancesIcn(){
		return eleHomeAppliancesIcn;
	}

	
	@FindBy(xpath="//*[@name='Others']")
	private WebElement eleOthersBtn;
	public WebElement getEleOthersBtn(){
		return eleOthersBtn;

	}
	@FindBy(xpath="//*[@name='Notifications']")
	private WebElement eleNotificationLnk;
	public WebElement getEleNotificationLnk()
	{
		return eleNotificationLnk;
	}

	@FindBy(xpath="//*[@name='Business intelligence & analytics training']")
	private WebElement eleradioBtn;
	public 	WebElement getEleradioBtn(){
		return eleradioBtn;


	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[2]")

	private WebElement eleFormCheckBox1;

	public WebElement getEleFormCheckBox1()

	{

		return eleFormCheckBox1;

	}
	@FindBy(xpath="//*[@name='Pest control products & equipment dealers']")
	private WebElement eleRadioBtn;
	public WebElement getEleRadioBtn(){
		return eleRadioBtn;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]/UIATableView[1]/UIATableCell[1]/UIAButton[1]")
	private WebElement eleEditicon;
	public WebElement getEleEditicon(){
		return eleEditicon;
	}
	@FindBy(xpath="//*[@name='Contact Information']")
	private WebElement eleContactInformation;
	public WebElement getEleContactInformation(){
		return eleContactInformation;
	}		

	@FindBy(xpath="//*[@name='Select at least one option.']")
	private WebElement eleAlertQuestionPopup;
	public WebElement getEleAlertQuestionPopup(){
		return eleAlertQuestionPopup;
	}
	@FindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[2]")
	private WebElement eleCheckedformList;
	public WebElement getEleCheckedformList(){
		return eleCheckedformList;
	}
	@FindBy(id="Provide any other specific details for your need")
	private WebElement eleTellUsTxtFld;
	public WebElement getEleTellUsTxtFld(){
		return eleTellUsTxtFld;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]")
	private WebElement eleAdditionalinfoTxt;
	public WebElement getEleAdditionalinfoTxt(){
		return eleAdditionalinfoTxt;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[2]")
	private WebElement eleQuestionLookingTxt;
	public WebElement getEleQuestionLookingTxt(){
		return eleQuestionLookingTxt;
	}



	@FindBy(id="Home")
	private WebElement eleHomeBtn;
	public WebElement getEleHomeBtn(){
		return eleHomeBtn;
	}



	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[4]/UIAStaticText[2]")
	private WebElement eleDestQuestTxt;
	public WebElement getEleDestQuestTxt(){
		return eleDestQuestTxt;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[4]/UIAStaticText[3]")
	private WebElement eleLocationTxt;
	public WebElement getEleLocationTxt(){
		return eleLocationTxt;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleNeedTxt;
	public WebElement getEleNeedTxt(){
		return eleNeedTxt;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleFormArrow;
	public WebElement getEleFormArrow(){
		return eleFormArrow;
	}
	
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleNeedNameTxt;
	public WebElement getEleNeedNameTxt(){
		return eleNeedNameTxt;
	}
	@FindBy(id="Where do you want to take the classes?")
	private WebElement eleNextQuestionTxt;
	public WebElement getEleNextQuestionTxt(){
		return eleNextQuestionTxt;
	}
	
	@FindBy(xpath="//UIAButton[@name='Return']")
	private WebElement eleKeyboardReturnBtn;
	public WebElement getEleKeyboardReturnBtn()
	{
		return eleKeyboardReturnBtn;
	}


	public void search(String[] sData,HomePO homePo,PostNeedPO postneedPo) throws InterruptedException
	{

		Thread.sleep(4000);
		driver.tap(1,8,72,3000);
		homePo.getEleSearchTxtFld().sendKeys(sData[7]);
		homePo.getEleDoneBtn().click();
		homePo.getEleFirstOption().click();
		Thread.sleep(4000);
		postneedPo.getEleFormRadioBtn1().click();
		homePo.getEleContinueBtn().click();
		homePo.getEleContinueBtn().click();
	}
	public void handleForm(String sLocalitiesList,PostNeedPO postneedPo) throws InterruptedException
	{
		
		getEleFormCheckArrowBox1().click();
		getEleFormCheckArrowBox().click();
		driver.findElement(By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableView[1]/UIATableCell[1]")).click();
		((IOSElement) driver.findElement(By.id("You can add upto 5 localitites"))).setValue(sLocalitiesList);
		getEleKeyboardReturnBtn().click();
		Thread.sleep(2000);
		getEleLocalitiesList().click();
		postneedPo.getEleNextBtn().click();
	}


}
