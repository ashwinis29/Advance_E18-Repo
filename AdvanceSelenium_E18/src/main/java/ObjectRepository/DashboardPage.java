package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Campaigns")
	WebElement campaignsLink;
	
	@FindBy(linkText = "Contacts")
	WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	WebElement productsLink;
	
	@FindBy(css = "div[class='user-icon']")
	WebElement profileIcon;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	WebElement logoutBtn;

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void logout()
	{
		profileIcon.click();
		WebDriverUtility Wutil = new WebDriverUtility();
        Wutil.actionMoveToElementAndClick(driver, logoutBtn);
	}
}
