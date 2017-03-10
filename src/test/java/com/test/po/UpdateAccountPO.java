package com.test.po;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import io.appium.java_client.ios.IOSDriver;
public class UpdateAccountPO
{
	IOSDriver driver=null;

	public UpdateAccountPO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@name='Update my account']") 
	private WebElement eleUpdatemyaccBtn;
	public WebElement getEleUpdatemyaccBtn()
	{
		return eleUpdatemyaccBtn;
	}

	@FindBy(xpath="//*[@name='CHANGE PASSWORD']") 
	private WebElement eleChangePwdBtn;
	public WebElement getEleChangePwdBtn()
	{
		return eleChangePwdBtn;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]") 
	private WebElement eleChangePwdBtn1;
	public WebElement getEleChangePwdBtn1()
	{
		return eleChangePwdBtn1;
	}

	@FindBy(xpath="//UIAStaticText[@name='Change password']") 
	private WebElement eleChangePwdTxt;
	public WebElement getEleChangePwdTxt()
	{
		return eleChangePwdTxt;
	}


	@FindBy(xpath="//*[@name='CANCEL']") 
	private WebElement eleCancelBtn;
	public WebElement getEleCancelBtn()
	{
		return eleCancelBtn;
	}
	@FindBy(id="Enter your current Password") 
	private WebElement eleCurrentPwdFld;
	public WebElement getEleCurrentPwdFld()
	{
		return eleCurrentPwdFld;
	}
	@FindBy(id="Enter your new Password") 
	private WebElement elenewPwdFld;
	public WebElement getElenewPwdFld()
	{
		return elenewPwdFld;
	}

	@FindBy(id="Name") 
	private WebElement eleNameFld;
	public WebElement getEleNameFld()
	{
		return eleNameFld;
	}

	@FindBy(xpath="//*[@name='Profile Information']") 
	private WebElement eleProfileInformationTxt;
	public WebElement getEleProfileInformationTxt()
	{
		return eleProfileInformationTxt;
	}

	@FindBy(id="Mobile Number") 
	private WebElement eleMobileNmuberFld;
	public WebElement getEleMobileNmuberFld()
	{
		return eleMobileNmuberFld;
	}

	@FindBy(id="Retype Password") 
	private WebElement eleRetypenewPwdFld;
	public WebElement getEleRetypenewPwdFld()
	{
		return eleRetypenewPwdFld;
	}
	@FindBy(xpath="//*[@name='Name']") 
	private WebElement eleUsernameTxt;
	public WebElement getEleUsernameTxt()
	{
		return eleUsernameTxt;
	}
	@FindBy(xpath="//*[@name='Mobile Number']") 
	private WebElement eleMobnoTxt;
	public WebElement getEleMobnoTxtFld()
	{
		return eleMobnoTxt;
	}

	@FindBy(xpath="//*[@name='SAVE PROFILE']")
	private WebElement eleSaveProfileBtn;
	public WebElement getEleSaveProfileBtn()
	{
		return eleSaveProfileBtn;
	}


	@FindBy(id="Email 24")
	private WebElement eleUpdateAccEmailTxt;
	public WebElement getEleUpdateAccEmailTxt()
	{
		return eleUpdateAccEmailTxt;
	}

	@FindBy(id="Account settings")
	private WebElement eleAccountSettingsTxt;
	public WebElement getEleAccountSettingsTxt()
	{
		return eleAccountSettingsTxt;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")
	private WebElement eleUserNameTxt;
	public WebElement getEleUserNameTxt()
	{
		return eleUserNameTxt;
	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")
	private WebElement eleMobileTxt;
	public WebElement getEleMobileTxt()
	{
		return eleMobileTxt;
	}


	@FindBy(xpath="//*[@name='Logout']") 
	private WebElement eleLogoutBtn;
	public WebElement getEleLogoutBtn()
	{
		return eleLogoutBtn;
	}

	@FindBy(xpath="//*[@name='Login']") 
	private WebElement eleLoginBtn;
	public WebElement getEleLoginBtn()
	{
		return eleLoginBtn;
	}

	public void navigateToUpdateAcc(HomePO homePo)
	{
		homePo.getEleMoreIcn().click();
		Assert.assertTrue(getEleLogoutBtn().isDisplayed(), "More screen is not displayed");
		NXGReports.addStep("More screen is successfully displayed", LogAs.PASSED, null);
		getEleUpdatemyaccBtn().click();
	}
}
