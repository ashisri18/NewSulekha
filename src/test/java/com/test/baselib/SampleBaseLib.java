package com.test.baselib;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.kirwa.nxgreport.NXGReports;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class SampleBaseLib {

	public IOSDriver driver;
	static public String sDirPath=System.getProperty("user.dir");
	static public String sConfigFile=sDirPath+"//Capabilities.Properties";
	static public String sAPPPath = "//Users//automation//Documents//Automation//Apps//Sulekha.ipa";//sDirPath+"/../Apps/Sulekha.app";

	File file = new File(sAPPPath);
	public DesiredCapabilities capabilities=null;
	GenericLib genericLib;
	@BeforeTest
	public void setobjects()
	{		
		genericLib = new GenericLib();

	}
	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,genericLib.getCongigValue(sConfigFile, "AUTOMATIONNAME") );
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.IOS );
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,genericLib.getCongigValue(sConfigFile, "PLATFORMVERSION"));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,genericLib.getCongigValue(sConfigFile, "DEVICENAME") );
		capabilities.setCapability(MobileCapabilityType.UDID, genericLib.getCongigValue(sConfigFile, "UDID") );
		capabilities.setCapability("bundleId", genericLib.getCongigValue(sConfigFile, "BUNDLEID") );
		capabilities.setCapability("unicodekeyboard",true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset",true);
		
		driver=new IOSDriver(new URL(genericLib.getCongigValue(sConfigFile, "URL")), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		NXGReports.setWebDriver(driver);
		
	}
	@BeforeMethod
	public void launchApp()
	{
		
		driver.launchApp();
	}

	@AfterMethod
	public void closeApp()
	{
		driver.closeApp();
	}
	@AfterClass
	public void tearDown() throws MalformedURLException, InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
		Thread.sleep(5000);
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,genericLib.getCongigValue(sConfigFile, "AUTOMATIONNAME") );
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.IOS );
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,genericLib.getCongigValue(sConfigFile, "PLATFORMVERSION"));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,genericLib.getCongigValue(sConfigFile, "DEVICENAME") );
		capabilities.setCapability(MobileCapabilityType.UDID, genericLib.getCongigValue(sConfigFile, "UDID") );
		capabilities.setCapability("bundleId", genericLib.getCongigValue(sConfigFile, "BUNDLEID") );	
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("unicodekeyboard",true);
		capabilities.setCapability("fullReset",true);
	//	driver.launchApp();
		driver=new IOSDriver(new URL(genericLib.getCongigValue(sConfigFile, "URL")), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		if(driver.findElement(By.xpath("//UIAButton[@name='OK']")).isDisplayed())
		{
			driver.findElement(By.xpath("//UIAButton[@name='OK']")).click();
		}
		driver.quit();
		
		//driver.installApp(appPath);
	}
}

