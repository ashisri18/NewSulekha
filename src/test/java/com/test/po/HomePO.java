package com.test.po;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import io.appium.java_client.ios.IOSDriver;
public class HomePO {
	IOSDriver driver=null;

	public HomePO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]")
	private WebElement eleSeachRsltLstItm2;
	public WebElement getEleSeachRsltLstItm2()
	{
		return eleSeachRsltLstItm2;
	}
	
	@FindBy(xpath="//UIAStaticText[@name='Popular Categories']")
	private WebElement elePopularCtgrsTxt;
	public WebElement getElePopularCtgrsTxt()
	{
		return elePopularCtgrsTxt;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleFirstOption;
	public WebElement getEleFirstOption(){
		return eleFirstOption;
	}

	@FindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[2]/UIAButton[3]")
	private WebElement eleLocationTxtFld;
	public WebElement getEleLocationTxtFld()
	{
		return eleLocationTxtFld;
	}
	
	@FindBy(xpath="//*[@name='CONTINUE']")
	private WebElement eleContinueBtn;
	public WebElement getEleContinueBtn()
	{
		return eleContinueBtn;
	}


	@FindBy(id="What service do you need?")
	private WebElement eleSearchTxtFld;
	public WebElement getEleSearchTxtFld()
	{
		return eleSearchTxtFld;
	}



	@FindBy(xpath="//UIAButton[@name='Clear text']")
	private WebElement eleClearTextBtn;
	public WebElement getEleClearTextBtn()
	{
		return eleClearTextBtn;
	}

	@FindBy(xpath="//UIAStaticText[@name='Home']")
	private WebElement eleHomeIcn;
	public WebElement getEleHomeIcn()
	{
		return eleHomeIcn;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[2]/UIACollectionCell/UIAStaticText")
	private List<WebElement> elePopularCtgrsLst;
	public List<WebElement> getElePopularCtgrsLst()
	{
		return elePopularCtgrsLst;
	}



	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]")
	private WebElement eleSearchResultLst;
	public WebElement getEleSearchResultLst()
	{
		return eleSearchResultLst;
	}


	@FindBy(xpath="//UIATableCell[@name='Ambulance Services in Bangalore']")
	private WebElement eleAmbulanceServicesLstItm;
	public WebElement getEleAmbulanceServicesLstItm()
	{
		return eleAmbulanceServicesLstItm;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleBrowserBussRadioBtn;
	public WebElement getEleBrowserBussRadioBtn()
	{
		return eleBrowserBussRadioBtn;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleNotificationLstItm;
	public WebElement getEleNotificationLstItm()
	{
		return eleNotificationLstItm;
	}


	@FindBy(xpath="//*[@name='VIEW LISTING']")
	private WebElement eleViewListingBtn;
	public WebElement getEleViewListingBtn()
	{
		return eleViewListingBtn;
	}


	@FindBy(xpath="//UIAStaticText[@name='My shortlist']")
	private WebElement eleShortListLnk;
	public WebElement getEleShortListLnk()
	{
		return eleShortListLnk;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleSeachRsltLstItm;
	public WebElement getEleSeachRsltLstItm()
	{
		return eleSeachRsltLstItm;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	private WebElement eleHomeAppliancesIcn;
	public WebElement getEleHomeAppliancesIcn(){
		return eleHomeAppliancesIcn;
	}
	
	
	@FindBy(xpath="//UIAButton[@name='ic favorite white 18dp']")
	private WebElement eleRemoveShotIcn;
	public WebElement getEleRemoveShotIcn()
	{
		return eleRemoveShotIcn;
	}



	@FindBy(xpath="//UIAButton[@name='More']")
	private WebElement eleMoreIcn;
	public WebElement getEleMoreIcn()
	{
		return eleMoreIcn;
	}


	@FindBy(xpath="//UIAButton[@name='SHORTLIST']")
	private WebElement eleShortlistTab;
	public WebElement getEleShortlistTab()
	{
		return eleShortlistTab;
	}

	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleLocalitiesList;
	public WebElement getEleLocalitiesList(){
		return eleLocalitiesList;
	}

	@FindBy(xpath="//UIAButton[@name='Return']")
	private WebElement eleKeyboardReturnBtn;
	public WebElement getEleKeyboardReturnBtn()
	{
		return eleKeyboardReturnBtn;
	}
	
	@FindBy(xpath="//UIAButton[@name='Done']")
	private WebElement eleDoneBtn;
	public WebElement getEleDoneBtn()
	{
		return eleDoneBtn;
	}
	

	@FindBy(xpath="//UIAButton[@name='Back Ipad']")
	private WebElement eleBackArwIcn;
	public WebElement getEleBackArwIcn()
	{
		return eleBackArwIcn;
	}


	/* @Description- to navigate to application home page vis skip button.
	 * @Author- Yashi Priya
	 */
	public void navigateToHomeWOLogin(WelcomePO welcomePo, HomePO homePo)
	{		
		welcomePo.toHandleAlertPopup();
		welcomePo.getEleSkipBtn().click();
		Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
		NXGReports.addStep("Home page is displayed", LogAs.PASSED, null);


	}

	/* @Description- to search the requested need
	 * @Author- Lakshmi
	 */
	public void searchNeed(String sNeed) throws InterruptedException
	{
		Thread.sleep(4000);
		driver.tap(1,8,72,3000);
		getEleSearchTxtFld().sendKeys(sNeed);
		getEleDoneBtn().click();
		Assert.assertTrue(getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
		NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
	}
}

