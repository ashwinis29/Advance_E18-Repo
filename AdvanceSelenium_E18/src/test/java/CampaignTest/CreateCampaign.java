package CampaignTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

public class CreateCampaign extends BaseClass{
	
	//@Parameters("browser")
	@Test(groups = {"SmokeTest"}, priority = 1)
	public void createCampaignTest() throws InterruptedException, IOException {
		
		JavaUtility javaUtil = new JavaUtility();
		int randomNum = javaUtil.getRandomNum(2000);
		
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("DDT",1,2) + randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT",1,3);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Thread.sleep(2000);
		DashboardPage dp = new DashboardPage(driver);
		dp.getCampaignsLink().click();
		//Fill mandatory details
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignLink().click();
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithMandatoryFields(Campaign, targetSize);
		Thread.sleep(2000);
		String ConfMsg = cp.getAlertPopup().getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true, "campaign " +Campaign+ " not added");
		Reporter.log("campaign " +Campaign+ " added successfully", true);
		Thread.sleep(5000);
	}
	
	//@Parameters("browser")
	@Test(groups = {"RegressionTest"}, priority = 2, dependsOnMethods = "createCampaignTest")
	public void createCampaignWithDateTest() throws InterruptedException, IOException
	{
		
		JavaUtility javaUtil = new JavaUtility();
		int randomNum = javaUtil.getRandomNum(2000);
		
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("DDT",1,2) + randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT",1,3);
		
		String closeDate = javaUtil.generateReqDate(30);
		
		Thread.sleep(2000);
		DashboardPage dp = new DashboardPage(driver);
		dp.getCampaignsLink().click();
		//Fill mandatory details
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignLink().click();
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithCloseDate(Campaign, targetSize, closeDate);
		Thread.sleep(2000);
		String ConfMsg = cp.getAlertPopup().getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true, "campaign " +Campaign+ " not added");
		Reporter.log("campaign " +Campaign+ " added successfully", true);
		Thread.sleep(5000);
	}

}
