package ProductTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import ObjectRepository.CreateProductsPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

public class CreateProduct extends BaseClass{
	
	//@Parameters("browser")
	@Test(groups = {"Integration"})
	public void createProductTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		JavaUtility javaUtil = new JavaUtility();
		int randomNum = javaUtil.getRandomNum(1000);
		
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String quantity = exUtil.readingDataFromExcel("Product",1,2) + randomNum;
		String productName = exUtil.readingDataFromExcel("Product",1,3) + randomNum;
		String pricePerUnit = exUtil.readingDataFromExcel("Product",1,4);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Thread.sleep(2000);
		
		//Click on "Products" Link
		DashboardPage dp = new DashboardPage(driver);
		dp.getProductsLink().click();
		
		//Click on "Add Product" button
		ProductPage pp = new ProductPage(driver);
		pp.getAddProductLink().click();
		
		//Fill all mandatory details
		CreateProductsPage cpp = new CreateProductsPage(driver);
		cpp.addProductWithMandatoryFields(driver, quantity, productName, pricePerUnit, "Electronics", "VID_001");
		Thread.sleep(2000);
		
		//Verify the confirmation message
		String confMsg = pp.getAlertPopup().getText();
		boolean status = confMsg.contains(productName);
		Assert.assertEquals(status, true, "Product not added");
		Reporter.log("Product " +productName+ " added successfully", true);
		Thread.sleep(4000);
	}
}
