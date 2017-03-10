package com.test.po;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class LoginPO {
	IOSDriver driver = null;
	WelcomePO welcomePo = null;
	HomePO homePo = null;

	public LoginPO(IOSDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// The mobile number you just entered does not belong to Sulekha's account.

	@FindBy(id = "The mobile number you just entered does not belong to Sulekha's account.")
	private WebElement eleUnRegMobnumPopup;

	public WebElement getEleUnRegMobnumPopup() {
		return eleUnRegMobnumPopup;

	}

	@FindBy(xpath = "//UIAButton[@name='LOGIN']")
	private WebElement eleLoginBtn;

	public WebElement getEleLoginBtn() {
		return eleLoginBtn;
	}

	@FindBy(id = "Email / mobile")
	private WebElement eleEmailmobTxtFld;

	public WebElement getEleEmailmobTxtFld() {
		return eleEmailmobTxtFld;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")
	private WebElement eleEmailmob1TxtFld;

	public WebElement getEleEmailmob1TxtFld() {
		return eleEmailmob1TxtFld;
	}

	@FindBy(id = "Password")
	private WebElement elePwdTxtFld;

	public WebElement getElePwddTxtFld() {
		return elePwdTxtFld;
	}

	@FindBy(xpath = "//UIAButton[@name='OK']")
	private WebElement eleOKBtn;

	public WebElement getEleOKBtn() {
		return eleOKBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Something went wrong!']")
	private WebElement eleUnRegMobPopup;

	public WebElement getEleUnRegMobPopup() {
		return eleUnRegMobPopup;

	}

	@FindBy(xpath = "//*[@name='Forgot password?']")
	private WebElement eleForgotPwdLnk;

	public WebElement getEleForgotPwdLnk() {
		return eleForgotPwdLnk;
	}

	@FindBy(xpath = "//UIAButton[@name='Join Sulekha']")
	private WebElement eleJoinSulekhaBtn;

	public WebElement getEleJoinSulekhaBtn() {
		return eleJoinSulekhaBtn;
	}

	@FindBy(id = "Email")
	private WebElement eleGoogleEmailTxtFld;

	public WebElement getEleGoogleEmailTxtFld() {
		return eleGoogleEmailTxtFld;
	}

	@FindBy(id = "account-chooser-link")
	private WebElement eleGmailSignLink;

	public WebElement getEleGmailSignLink() {
		return eleGmailSignLink;
	}

	@FindBy(id = "edit-account-list")
	private WebElement eleGmailRemoveBtn;

	public WebElement getEleGmailRemoveBtn() {
		return eleGmailRemoveBtn;
	}

	@FindBy(id = "choose-account-0")
	private WebElement eleGmailAccountBtn;

	public WebElement getEleGmailAccountBtn() {
		return eleGmailAccountBtn;
	}

	@FindBy(id = "next")
	private WebElement eleGoogleNextBtn;

	public WebElement getEleGoogleNextBtn() {
		return eleGoogleNextBtn;
	}

	@FindBy(xpath = "//UIACollectionCell[@name='Cancel']")
	private WebElement eleCancelBtn;

	public WebElement getEleCancelBtn() {
		return eleCancelBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Enter your Password']")
	private WebElement eleEnterPwdAlertPopup;

	public WebElement getEleEnterPwdPopup() {
		return eleEnterPwdAlertPopup;
	}

	@FindBy(xpath = "//UIAStaticText[@name='The mobile number you just entered does not belong to Sulekha's account.']")
	private WebElement eleUnregstrdErrorTxt;

	public WebElement getEleUnregstrdErrorTxt() {
		return eleUnregstrdErrorTxt;
	}

	@FindBy(xpath = "//UIAButton[@name='SHOW']")
	private WebElement eleSHOWLnk;

	public WebElement getEleSHOWLnk() {
		return eleSHOWLnk;
	}

	@FindBy(xpath = "//UIAButton[@name='HIDE']")
	private WebElement eleHIDELnk;

	public WebElement getEleHIDELnk() {
		return eleHIDELnk;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Incorrect password']")
	private WebElement eleIncorrectPwdPopup;

	public WebElement getEleIncorrectPwdPopup() {
		return eleIncorrectPwdPopup;
	}

	@FindBy(xpath = "//*[@name='Forgot password?']")
	private WebElement eleForgotPwdTxt;

	public WebElement getEleForgotPwdTxt() {
		return eleForgotPwdTxt;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Via SMS']")
	private WebElement eleViaSMSOpt;

	public WebElement getEleViaSMSOpt() {
		return eleViaSMSOpt;
	}

	@FindBy(id = "Enter mobile number")
	private WebElement eleEnterMobTxtFld;

	public WebElement getEleEnterMobTxtFld() {
		return eleEnterMobTxtFld;
	}

	@FindBy(id = "Enter a valid email ID")
	private WebElement eleEnterEmailTxtFld;

	public WebElement getEleEnterEmailTxtFld() {
		return eleEnterEmailTxtFld;
	}

	@FindBy(xpath = "//UIAButton[@name='EMAIL']")
	private WebElement eleViaEmailOpt;

	public WebElement getEleViaEmailOpt() {
		return eleViaEmailOpt;
	}

	@FindBy(xpath = "//UIAButton[@name='Send']")
	private WebElement eleSendBtn;

	public WebElement getEleSendBtn() {
		return eleSendBtn;
	}

	@FindBy(xpath ="//UIAApplication[1]/UIAWindow[1]/UIAButton[7]")
	private WebElement eleGoogleLoginLnk;

	public WebElement getEleGoogleLoginLnk() {
		return eleGoogleLoginLnk;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
	private WebElement eleFBAccountLnk1;

	public WebElement getEleFBAccountLnk1() {
		return eleFBAccountLnk1;
	}

	@FindBy(xpath = "//UIAButton[@name='CREATE']")
	private WebElement eleCreateBtn;

	public WebElement getEleCreateBtn() {
		return eleCreateBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Sign out']")
	private WebElement eleSignOutBtn;

	public WebElement getEleSignOutBtn() {
		return eleSignOutBtn;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]")
	private WebElement eleEmailLink;

	public WebElement getEailLink() {
		return eleEmailLink;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Invalid mobile number, try again']")
	private WebElement eleInValidMobNumPopup;

	public WebElement getEleInValidMobNumPopup() {
		return eleInValidMobNumPopup;
	}


	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]")
	private WebElement eleWeSentPwdPopup;

	public WebElement getEleWeSentPwdPopup() {
		return eleWeSentPwdPopup;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]")
	private WebElement eleWeSentPwdtoMailPopup;

	public WebElement getEleWeSentPwdtoMailPopup() {
		return eleWeSentPwdtoMailPopup;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Enter valid email']")
	private WebElement eleValidEmailPopup;

	public WebElement getEleValidEmailPopup() {
		return eleValidEmailPopup;
	}

	@FindBy(id = "The email id you have entered does not belong to any account")
	private WebElement eleUnRegEmailPopup;

	public WebElement getEleUnRegEmailPopup() {
		return eleUnRegEmailPopup;
	}

	@FindBy(id = "Please Enter Name")
	private WebElement eleNameTxtFld;

	public WebElement getEleNameTxtFld() {
		return eleNameTxtFld;
	}

	@FindBy(id = "Please enter mobile number")
	private WebElement eleMobileNumTxtFld;

	public WebElement getEleMobileNumTxtFld() {
		return eleMobileNumTxtFld;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")
	private WebElement eleNameTxt;

	public WebElement getEleNameTxt() {
		return eleNameTxt;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[3]")
	private WebElement eleMobileNumTxt;

	public WebElement getEleMobileNumTxt() {
		return eleMobileNumTxt;
	}

	@FindBy(id = "Create account")
	private WebElement eleCreateAccountTxt;

	public WebElement getEleCreateAccountTxt() {
		return eleCreateAccountTxt;
	}

	@FindBy(id = "Passwd")
	private WebElement eleGooglePwdTxtFld;

	public WebElement getEleGooglePwdTxtFld() {
		return eleGooglePwdTxtFld;
	}

	@FindBy(id = "signIn")
	private WebElement eleGoogleSignInBtn;

	public WebElement getEleGoogleSignInBtn() {
		return eleGoogleSignInBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Enter email / mobile number']")
	private WebElement eleEmailMobPopup;

	public WebElement getEleEmailMobPopup() {
		return eleEmailMobPopup;
	}

	@FindBy(id = "Now, verify your mobile")
	private WebElement eleOtpTxt;

	public WebElement getEleOtpTxt() {
		return eleOtpTxt;
	}

	@FindBy(id = "Enter your name")
	private WebElement eleNamePopup;

	public WebElement getEleNamePopup() {
		return eleNamePopup;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")
	private WebElement eleEmailTxt;

	public WebElement getEleEmailTxt() {
		return eleEmailTxt;
	}

	@FindBy(id = "Enter valid email")
	private WebElement eleEnterValidEmailPopup;

	public WebElement getEleEnterValidEmailPopup() {
		return eleEnterValidEmailPopup;
	}

	@FindBy(id = "Please enter correct OTP")
	private WebElement eleCorrectOtpPopup;

	public WebElement getEleCorrectOtpPopup() {
		return eleCorrectOtpPopup;
	}

	@FindBy(id = "Please enter email")
	private WebElement eleEnterEmailTxtFld1;

	public WebElement getEleEnterEmailTxtFld1() {
		return eleEnterEmailTxtFld1;
	}

	@FindBy(id = "Enter 10-digit mobile number")
	private WebElement ele10DigitNumberPopUp;

	public WebElement getEle10DigitNumberPopUp() {
		return ele10DigitNumberPopUp;
	}

	@FindBy(xpath = "//UIAButton[@name='LOGIN']")
	private WebElement eleLoginLnk;

	public WebElement getEleLoginLnk() {
		return eleLoginLnk;
	}

	@FindBy(xpath = "//span[text()='sulekha")
	private WebElement eleGoogleSulekhaTxt;

	public WebElement getEleGoogleSulekhaTxt() {
		return eleGoogleSulekhaTxt;
	}

	@FindBy(id = "Invalid mobile number, try again")
	private WebElement eleInvalidMobilePopup;

	public WebElement getEleInvalidMobilePopup() {
		return eleInvalidMobilePopup;
	}

	/*
	 * @Description- To navigate to Login page via Join Sulekha button
	 * 
	 * @Author- Yashi Priya
	 */
	public void navigateToLogin(WelcomePO welcomePo) {
		welcomePo.getEleJOINSULEKHABtn().click();
		welcomePo.getEleLoginLnk().click();
		Assert.assertTrue(getEleLoginBtn().isDisplayed(), "Login page is not displayed");
		NXGReports.addStep("Login page is displayed", LogAs.PASSED, null);
	}

	/*
	 * @Description- To navigate to Login page via Join Sulekha button and Login
	 * to Sulekha
	 * 
	 * @Author- Yashi Priya
	 */
	public void login(HomePO homePo, String sData[]) {
		getEleEmailmobTxtFld().sendKeys(sData[1]);
		getElePwddTxtFld().sendKeys(sData[4]);
		try {
			getEleLoginBtn().click();
		} catch (Exception e) {
			homePo.getEleKeyboardReturnBtn().click();
			getEleLoginBtn().click();
			
		}
	}

	/*
	 * @Description- To navigate to Business Profile Page
	 * @Author- RaghuKiran MR
	 */
	public void loginViaMore(String[] sData, HomePO homePo, MorePO morePo, UpdateAccountPO updateAccountPO) {

		homePo.getEleMoreIcn().click();
		updateAccountPO.getEleLoginBtn().click();
		getEleLoginLnk().click();
		getEleEmailmobTxtFld().sendKeys(sData[1]);
		homePo.getEleKeyboardReturnBtn().click();
		getElePwddTxtFld().sendKeys(sData[4]);
		homePo.getEleKeyboardReturnBtn().click();
		getEleLoginBtn().click();
		morePo.getEleHomeIcn().click();
		Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
		NXGReports.addStep("HomePage is displayed", LogAs.PASSED, null);

	}
	
	public void googleLogin(String sData[], WelcomePO welcomePo) throws InterruptedException {
		try {

			Thread.sleep(5000);
			Set<String> contextHandles = driver.getContextHandles();
			for (String contextHandle : contextHandles) {
				if (contextHandle.contains("WEBVIEW")) {
					driver.context(contextHandle);
				}
			}
			getEleGoogleEmailTxtFld().sendKeys(sData[3]);
			getEleGoogleNextBtn().click();
			getEleGooglePwdTxtFld().sendKeys(sData[4]);
			getEleGoogleSignInBtn().click();
			Thread.sleep(10000);
			driver.context("NATIVE_APP");
			Thread.sleep(10000);
			driver.tap(1, 218, 434, 1);
		} catch (Exception e) {

			Thread.sleep(10000);
			driver.context("NATIVE_APP");
			Thread.sleep(10000);
			driver.tap(1, 218, 434, 1);

		}
	}
}
