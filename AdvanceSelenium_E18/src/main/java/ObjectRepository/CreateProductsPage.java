package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductsPage {
	
	WebDriver driver;
	
	public CreateProductsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productId")
	WebElement productIdField;
	
	@FindBy(name = "quantity")
	WebElement quantityField;
	
	@FindBy(name = "productName")
	WebElement productNameField;
	
	@FindBy(name = "price")
	WebElement pricePerUnitField;
	
	@FindBy(name = "productCategory")
	WebElement productCategoryDropdown;
	
	@FindBy(name = "vendorId")
	WebElement selectVendorDropdown;
	
	@FindBy(xpath = "//button[text()='Add']")
	WebElement addProductBtn;

	public WebElement getProductIdField() {
		return productIdField;
	}

	public WebElement getQuantityField() {
		return quantityField;
	}

	public WebElement getProductNameField() {
		return productNameField;
	}

	public WebElement getPricePerUnitField() {
		return pricePerUnitField;
	}

	public WebElement getProductCategoryDropdown() {
		return productCategoryDropdown;
	}

	public WebElement getSelectVendorDropdown() {
		return selectVendorDropdown;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}	
	
	public void addProductWithMandatoryFields(WebDriver driver, String quantity, String productName, String pricePerUnit, String productCategory, String vendorID)
	{
		Actions actions = new Actions(driver);
		quantityField.clear();
		quantityField.sendKeys(quantity);
		productNameField.sendKeys(productName);
		pricePerUnitField.clear();
		pricePerUnitField.sendKeys(pricePerUnit);
		actions.scrollByAmount(0, 400).perform();
		WebDriverUtility Wutil = new WebDriverUtility();
		Wutil.select(productCategoryDropdown, productCategory);
		Wutil.select(selectVendorDropdown, vendorID);
		addProductBtn.submit();
	}
}
