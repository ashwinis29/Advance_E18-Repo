package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;
	
	public ProductPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'Add Product')]")
	WebElement addProductLink;
	
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement searchProductDropdwn;
	
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchProductField;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement alertPopup;

	public WebElement getAddProductLink() {
		return addProductLink;
	}

	public WebElement getSearchProductDropdwn() {
		return searchProductDropdwn;
	}

	public WebElement getSearchProductField() {
		return searchProductField;
	}

	public WebElement getAlertPopup() {
		return alertPopup;
	}	
}
