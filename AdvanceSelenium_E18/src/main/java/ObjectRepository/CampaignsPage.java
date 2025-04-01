package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	WebDriver driver;
	
	public CampaignsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'Create Campaign')]")
	WebElement createCampaignLink;
	
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement searchCampaignDropdwn;
	
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchCampaignField;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement alertPopup;
	
	public WebElement getCreateCampaignLink() {
		return createCampaignLink;
	}

	public WebElement getSearchCampaignDropdwn() {
		return searchCampaignDropdwn;
	}

	public WebElement getSearchCampaignField() {
		return searchCampaignField;
	}

	public WebElement getAlertPopup() {
		return alertPopup;
	}
}
