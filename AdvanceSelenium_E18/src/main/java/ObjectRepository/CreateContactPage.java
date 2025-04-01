package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateContactPage {

	WebDriver driver;
	
	public CreateContactPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "contactId")
	WebElement contactIdField;
	
	@FindBy(name = "contactName")
	WebElement contactNameField;
	
	@FindBy(name = "organizationName")
	WebElement organizationNameField;
	
	@FindBy(name = "mobile")
	WebElement mobileField;
	
	@FindBy(name = "title")
	WebElement titleField;
	
	@FindBy(name = "email")
	WebElement emailField;
	
	@FindBy(name = "department")
	WebElement departmentField;
	
	@FindBy(xpath = "//button[@type='button' and contains(@style,'white-space')]")
	WebElement selectCampaignIcon;
	
	@FindBy(name = "officePhone")
	WebElement officePhoneField;
	
	@FindBy(xpath = "//button[contains(.,'Create Contact')]")
	WebElement createContactBtn;
	
	@FindBy(id = "search-criteria")
	WebElement searchCampaignDD;
	
	@FindBy(id = "search-input")
	WebElement searchInpField;
	
	@FindBy(xpath = "//button[@class='select-btn']")
	WebElement selectBtn;
	
	public WebElement getContactIdField() {
		return contactIdField;
	}

	public WebElement getContactNameField() {
		return contactNameField;
	}

	public WebElement getOrganizationNameField() {
		return organizationNameField;
	}

	public WebElement getMobileField() {
		return mobileField;
	}

	public WebElement getTitleField() {
		return titleField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getDepartmentField() {
		return departmentField;
	}

	public WebElement getSelectCampaignIcon() {
		return selectCampaignIcon;
	}

	public WebElement getOfficePhoneField() {
		return officePhoneField;
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	
	public WebElement getSearchCampaignDD() {
		return searchCampaignDD;
	}

	public WebElement getSearchInpField() {
		return searchInpField;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}
	
	public void selectCampaign(String campaign)
	{
		searchInpField.sendKeys(campaign);
		selectBtn.click();
	}
	
	public void createContactWithMandatoryFields(String organizationName, String title, String contactName, String mobile, String childUrl, String parentUrl, String campaign)
	{
		organizationNameField.sendKeys(organizationName);
		titleField.sendKeys(title);
		contactNameField.sendKeys(contactName);
		mobileField.sendKeys(mobile);
		selectCampaignIcon.click();
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.switchToWindow(driver, childUrl);
        wUtil.select(searchCampaignDD, "campaignName"); 
        selectCampaign(campaign);
        wUtil.switchToWindow(driver, parentUrl);
        createContactBtn.click();
	}
		
}
