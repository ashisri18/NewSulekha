package com.test.po;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSDriver;

public class MorePO 
{
	IOSDriver driver=null;

	public MorePO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//UIAStaticText[@name='Shortlists']")
	private WebElement eleShortlistPageTxt;
	public WebElement getEleShortlistPageTxt()
	{
		return eleShortlistPageTxt;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleShortlistedItm;
	public WebElement getEleShortlistedItm()
	{
		return eleShortlistedItm;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[2]")
	private WebElement eleFormCheckBox1;
	public WebElement getEleFormCheckBox1()
	{
		return eleFormCheckBox1;
	}

	@FindBy(xpath="//UIAStaticText[@name='List My Business']")
	private WebElement eleListMyBusinessLnk;
	public WebElement getEleListMyBusinessLnk()
	{
		return eleListMyBusinessLnk;
	}

	@FindBy(xpath="//UIAButton[@name='Reviews']")
	private WebElement eleMyReviewIcn;
	public WebElement getEleMyReviewIcn()
	{
		return eleMyReviewIcn;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]")
	private WebElement eleNumberofBusinessTxt;
	public WebElement getEleNumberofBusinessTxt()
	{
		return eleNumberofBusinessTxt;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleReviewsLstItm;
	public WebElement getEleReviewsLstItm()
	{
		return eleReviewsLstItm;
	}
	

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]")
	private WebElement eleShortlistedBusiLst;
	public WebElement getEleShortlistedBusiLst()
	{
		return eleShortlistedBusiLst;
	}

	@FindBy(xpath="//UIAStaticText[@name='Property/Rental']")
	private WebElement elePropRentLnk;
	public WebElement getElePropRentLnk()
	{
		return elePropRentLnk;
	}

	@FindBy(xpath="//UIAButton[@name='Home']")
	private WebElement eleHomeIcn;
	public WebElement getEleHomeIcn()
	{
		return eleHomeIcn;
	}

	@FindBy(xpath="//UIAStaticText[@name='Call us']")
	private WebElement eleProfileAndSettingTxt;
	public WebElement getEleProfileAndSettingTxt()
	{
		return eleProfileAndSettingTxt;
	}
	@FindBy(xpath="//UIAStaticText[@name='Chat with us']")
	private WebElement eleCharwithusTxt;
	public WebElement getEleCharwithusTxt()
	{
		return eleCharwithusTxt;
	}
	@FindBy(xpath="//UIAStaticText[@name='Update my account']")
	private WebElement eleUpdateMyAccLnk;
	public WebElement getEleUpdateMyAccLnk()
	{
		return eleUpdateMyAccLnk;
	}
	@FindBy(xpath="//UIAStaticText[@name='Logout']")
	private WebElement eleLogoutLnk;
	public WebElement getEleLogoutLnk()
	{
		return eleLogoutLnk;
	}

	@FindBy(xpath="//UIAButton[@name='Notifications']")
	private WebElement eleNotificationTab;
	public WebElement getEleNotificationTab()
	{
		return eleNotificationTab;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleShortList1stItm;
	public WebElement getEleShortList1stItm()
	{
		return eleShortList1stItm;
	}

	@FindBy(xpath="//UIAStaticText[@name='Notifications']")
	private WebElement eleNotificationTxt;
	public WebElement getEleNotificationTxt()
	{
		return eleNotificationTxt;
	}

	@FindBy(xpath="//UIAStaticText[@name='Add Business']")
	private WebElement eleAddBuisnessTxt;
	public WebElement getEleAddBuisnessTxt()
	{
		return eleAddBuisnessTxt;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleNeedTxt;
	public WebElement getEleNeedTxt()
	{
		return eleNeedTxt;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleNeedResponsTxt;
	public WebElement getEleNeedResponsTxt()
	{
		return eleNeedResponsTxt;
	}
}
