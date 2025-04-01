package ContactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

public class CreateContact extends BaseClass{
	
	//@Parameters("browser")
	@Test(groups = {"RegressionTest"})
	public void createContactWithCampaignTest() throws IOException, InterruptedException {
		
		JavaUtility javaUtil = new JavaUtility();
		int randomNum = javaUtil.getRandomNum(2000);
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("DDT",1,2) + randomNum;
		String targetSize = exUtil.readingDataFromExcel("DDT",1,3);
		String contactName = exUtil.readingDataFromExcel("Contact",1,2) + randomNum;
		String organization = exUtil.readingDataFromExcel("Contact",1,3) + randomNum;
		String mobile = exUtil.readingDataFromExcel("Contact",1,4);
		String title = exUtil.readingDataFromExcel("Contact",1,5);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Thread.sleep(2000);
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		
		//Fill mandatory details
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignLink().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithMandatoryFields(Campaign, targetSize);
		Thread.sleep(3000);
		
		WebDriverUtility Wutil = new WebDriverUtility();
		Wutil.waitForElementToBeClickable(driver, dp.getContactsLink(), 20);
		dp.getContactsLink().click();
		Thread.sleep(3000);
		
		ContactsPage conpg = new ContactsPage(driver); 
		WebElement createContactBtn = conpg.getCreateContactBtn();
		Wutil.waitForElementPresent(driver, createContactBtn, 20);
		createContactBtn.click();
		
		CreateContactPage cconpg = new CreateContactPage(driver);
		cconpg.createContactWithMandatoryFields(organization, title, contactName, mobile, "selectCampaign", "create-contact" ,Campaign);
        Thread.sleep(3000);
        String ConfMsg = conpg.getAlertPopup().getText();
        boolean status = ConfMsg.contains(contactName);
		Assert.assertEquals(status, true, "Contact " +contactName+ " not added");
		Reporter.log("Contact " +contactName+ " added successfully", true);
		Thread.sleep(3000);
	}

}