package com.test.po;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class WelcomePO {
	IOSDriver driver = null;

	public WelcomePO(IOSDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//UIAButton[@name='JOIN SULEKHA']")
	private WebElement eleJOINSULEKHABtn;

	public WebElement getEleJOINSULEKHABtn() {
		return eleJOINSULEKHABtn;
	}

	@FindBy(xpath = "//*[@name='abc btn radio to on mtrl 000']")
	private WebElement eleFormPopupRadioBtn;

	public WebElement getEleFormPopupRadioBtn() {
		return eleFormPopupRadioBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='11 Businesses matched']")
	private WebElement eleMatchedBusiTxt;

	public WebElement getEleMatchedBusiTxt() {
		return eleMatchedBusiTxt;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Enter 6-digit verification code']")
	private WebElement ele6DigitCodePopup;

	public WebElement getEle6DigitCodePopup() {
		return ele6DigitCodePopup;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Enter a valid verification code']")
	private WebElement eleValidCodePopup;

	public WebElement getEleValidCodePopup() {
		return eleValidCodePopup;
	}

	@FindBy(id = "You'll receive the verification code via SMS")
	private WebElement eleCodeViaSMSTxt;

	public WebElement getEleCodeViaSMSTxt() {
		return eleCodeViaSMSTxt;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Enter your mobile number.']")
	private WebElement eleMobileAlertPopup;

	public WebElement getEleMobileAlertPopup() {
		return eleMobileAlertPopup;
	}

	@FindBy(xpath = "//UIAButton[@name='Done']")
	private WebElement eleDoneBtn;

	public WebElement getEleDoneBtn() {
		return eleDoneBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Invalid mobile number, try again']")
	private WebElement eleInvalidMobileAlertPopup;

	public WebElement getEleInvalidMobileAlertPopup() {
		return eleInvalidMobileAlertPopup;
	}

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")
	private WebElement eleOTPCodeTxtFld;

	public WebElement getEleOTPCodeTxtFld() {
		return eleOTPCodeTxtFld;
	}

	@FindBy(xpath = "//UIAButton[@name='SKIP']")
	private WebElement eleSkipBtn;

	public WebElement getEleSkipBtn() {
		return eleSkipBtn;
	}

	@FindBy(xpath = "//UIAButton[@name='SKIP']")
	private WebElement eleSkiplnk;

	public WebElement getEleSkipLnk() {
		return eleSkiplnk;
	}

	@FindBy(xpath = "//UIAButton[@name='LOGIN']")
	private WebElement eleLoginLnk;

	public WebElement getEleLoginLnk() {
		return eleLoginLnk;
	}

	@FindBy(xpath = "//UIAButton[@name='JOIN NOW']")
	private WebElement eleJOINNOWBtn;

	public WebElement getEleJOINNOWBtn() {
		return eleJOINNOWBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Welcome!']")
	private WebElement eleWelcomeTxt;

	public WebElement getEleWelcomeTxt() {
		return eleWelcomeTxt;
	}

	@FindBy(xpath = "//UIAButton[@name='ic edit grey']")
	private WebElement eleEditIcn;

	public WebElement getEleEditIcn() {
		return eleEditIcn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Allow “Sulekha” to access your location while you use the app?']")
	private WebElement eleAllowSulekhaTxt;

	public WebElement getEleAllowSulekhaTxt() {
		return eleAllowSulekhaTxt;
	}

	@FindBy(xpath = "//UIAStaticText[@name='“Sulekha” Would Like to Send You Notifications']")
	private WebElement eleNotificationAlertTxt;

	public WebElement getEleNotificationAlertTxt() {
		return eleNotificationAlertTxt;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Always']")
	private WebElement eleAlwaysTxt;

	public WebElement getEleAlwaysTxt() {
		return eleAlwaysTxt;
	}

	@FindBy(xpath = "//UIAButton[@name='RESEND CODE']")
	private WebElement eleRESENDCODEBtn;

	public WebElement getEleRESENDCODEBtn() {
		return eleRESENDCODEBtn;
	}

	@FindBy(xpath = "//UIAButton[@name='*T & C apply']")
	private WebElement eleTermsCLnk;

	public WebElement getEleTermsCLnk() {
		return eleTermsCLnk;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Terms & Conditions']")
	private WebElement eleTermsCTxt;

	public WebElement getEleTermsCTxt() {
		return eleTermsCTxt;
	}

	@FindBy(xpath = "//UIAButton[@name='Back']")
	private WebElement eleBackArwIcn;

	public WebElement getEleBackArwIcn() {
		return eleBackArwIcn;
	}
	
	@FindBy(xpath="//UIAButton[@name='Back Ipad']")
	private WebElement eleBackIcn;
	public WebElement getEleBackIcn()
	{
		return eleBackIcn;
	}

	@FindBy(id = "Mobile number")
	private WebElement eleMobileNoTxtFld;

	public WebElement getEleMobileNoTxtFld() {
		return eleMobileNoTxtFld;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Allow Sulekha to access your location even when you are not using the app? Always']")
	private WebElement eleLocationPopup;

	public WebElement getEleLocationPopup() {
		return eleLocationPopup;
	}

	@FindBy(xpath = "//UIAButton[@name='Allow']")
	private WebElement eleAllowBtn;

	public WebElement getEleAllowBtn() {
		return eleAllowBtn;
	}

	@FindBy(xpath = "//UIAButton[@name='Don’t Allow']")
	private WebElement eleDontAllowBtn;

	public WebElement getEleDontAllowBtn() {
		return eleDontAllowBtn;
	}

	@FindBy(xpath = "//UIAButton[@name='OK']")
	private WebElement eleOKBtn;

	public WebElement getEleOKBtn() {
		return eleOKBtn;
	}

	@FindBy(xpath = "//UIAStaticText[@name='Sulekha would like to send you Notifications']")
	private WebElement eleNotificationPopup;

	public WebElement getEleNotificationPopup() {
		return eleNotificationPopup;
	}

	@FindBy(xpath = "(//UIAButton)[3]")
	private WebElement eleOTPTimeLimitTxt;

	public WebElement getEleOTPTimeLimitTxt() {
		return eleOTPTimeLimitTxt;
	}

	@FindBy(id = "Enter your location")
	private WebElement eleDestinationTxtBox;

	public WebElement getEleDestinationTxtBox() {
		return eleDestinationTxtBox;
	}

	/*
	 * @Description- To register into the app
	 * 
	 * @Author- Yashi Priya
	 */
	public void joinNow(String sMobileNo, String sCode) {
		getEleJOINSULEKHABtn().click();
		getEleMobileNoTxtFld().sendKeys(sMobileNo);
		getEleJOINNOWBtn().click();
		getEleOTPCodeTxtFld().sendKeys(sCode);
	}

	/*
	 * @Description- To register into the app
	 * 
	 * @Author- Yashi Priya
	 */
	public void toHandleAlertPopup() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try {
			if (getEleOKBtn().isDisplayed()) {
				NXGReports.addStep("Notification popup is displayed", LogAs.PASSED, null);
				getEleOKBtn().click();
			}

		} catch (Exception e) {
			tohandleLocationPopup();
			if (getEleOKBtn().isDisplayed()) {
				NXGReports.addStep("Notification popup is displayed", LogAs.PASSED, null);
				getEleOKBtn().click();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		NXGReports.addStep("Popups are successfully handled", LogAs.PASSED, null);

	}
	public void tohandleLocationPopup() {
		try {
			if (getEleAllowBtn().isDisplayed()) {
				NXGReports.addStep("Location popup is displayed", LogAs.PASSED, null);
				getEleAllowBtn().click();
			}
		} catch (Exception e) {
			NXGReports.addStep("Location Alert popup is not displayed", LogAs.PASSED, null);
		}
	}

	public void handleForm(MDLDPO mdldpo) throws InterruptedException {
		mdldpo.getEleFormCheckBox().click();
		((IOSElement) driver.findElement(By.id("Provide any other specific details for your need"))).setValue("Good ac service");
		mdldpo.getEleDoneBtn().click();
		((IOSElement) driver.findElement(By.id("Add a locality"))).setValue("jayanagar");
		Thread.sleep(1000);
		mdldpo.getEleLocalitiesList().click();
		mdldpo.getEleNextBtn().click();
	}
	public void handleAcForm(MDLDPO mdldpo,String sData[]) throws InterruptedException{
		mdldpo.getEleFormCheckBox().click();
		mdldpo.getEleNextBtn().click();
		mdldpo.getElelocalityTxtFld().sendKeys(sData[8]);
		mdldpo.getEleReturnBtn().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		mdldpo.getEleNextBtn().click();
	}

}
