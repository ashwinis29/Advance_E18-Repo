package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {
	
	WebDriver driver;
	
	public CreateCampaignsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignId")
	WebElement campaignIdField;
	
	@FindBy(name = "expectedCloseDate")
	WebElement expectedCloseDate;
	
	@FindBy(name = "campaignName")
	WebElement campaignNameField;
	
	@FindBy(name = "targetAudience")
	WebElement targetAudienceField;
	
	@FindBy(name = "campaignStatus")
	WebElement campaignStatusField;
	
	@FindBy(name = "description")
	WebElement descriptionField;
	
	@FindBy(name = "targetSize")
	WebElement targetSizeField;
	
	@FindBy(xpath = "//button[contains(.,'Create Campaign')]")
	WebElement createCampaignBtn;

	public WebElement getCampaignIdField() {
		return campaignIdField;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getCampaignNameField() {
		return campaignNameField;
	}

	public WebElement getTargetAudienceField() {
		return targetAudienceField;
	}

	public WebElement getCampaignStatusField() {
		return campaignStatusField;
	}

	public WebElement getDescriptionField() {
		return descriptionField;
	}

	public WebElement getTargetSizeField() {
		return targetSizeField;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	public void createCampaignWithMandatoryFields(String campName, String target)
	{
		campaignNameField.sendKeys(campName);
		targetSizeField.clear();
		targetSizeField.sendKeys(target);
		createCampaignBtn.click();
	}
	
	public void createCampaignWithCloseDate(String campName, String target, String closeDate)
	{
		campaignNameField.sendKeys(campName);
		targetSizeField.clear();
		targetSizeField.sendKeys(target);
		expectedCloseDate.sendKeys(closeDate);
		createCampaignBtn.click();
	}
}
