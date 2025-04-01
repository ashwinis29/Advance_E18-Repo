package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	WebDriver driver;
	
	public ContactsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Create Contact']")
	WebElement createContactBtn;
	
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement searchContactDropdwn;
	
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchContactField;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement alertPopup;

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public WebElement getSearchContactDropdwn() {
		return searchContactDropdwn;
	}

	public WebElement getSearchContactField() {
		return searchContactField;
	}

	public WebElement getAlertPopup() {
		return alertPopup;
	}
}
