package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends AbstractPage {

	private final String BASE_URL = "https://github.com/settings/profile";
	private final String USER_BIO = "I'm a full of energy university graduate and I'm goint to achieve big goals in IT sphere!";
	private final String USER_BLOG = "www.mysomeitblog.com";
	private final String USER_COMPANY = "EPAM SYSTEMS";
	private final String USER_LOCATION = "Republic of Belarus";

	@FindBy(id = "user_profile_bio")
	private WebElement userBio;

	@FindBy(id = "user_profile_blog")
	private WebElement userBlog;

	@FindBy(id = "user_profile_company")
	private WebElement userCompany;

	@FindBy(id = "user_profile_location")
	private WebElement userLocation;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div[2]/form[1]/div/p[2]/button")
	private WebElement updateChanges;

	@FindBy(xpath = "/html/body")
	private WebElement findMessage;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div[1]/nav[1]/a[2]")
	private WebElement accountSettings;

	@FindBy(xpath = "//summary[@class =\"btn btn-danger\"]")
	private WebElement deleteButton;

	@FindBy(id = "sudo_login")
	private WebElement deletingUserName;

	@FindBy(id = "confirmation_phrase")
	private WebElement confirmation;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div[2]/details[3]/details-dialog/div[3]/form/button")
	private WebElement cancelPlanDeleteButton;

	@FindBy(xpath = "//div[@class = \"container-lg px-2\"]")
	private WebElement deletingMessage;

	public SettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void enterUserInformation() {
		userBio.clear();
		userBio.sendKeys(USER_BIO);
		userBlog.clear();
		userBlog.sendKeys(USER_BLOG);
		userCompany.clear();
		userCompany.sendKeys(USER_COMPANY);
		userLocation.clear();
		userLocation.sendKeys(USER_LOCATION);
		updateChanges.click();
	}

	public String getUpdateMessage() {
		String successMessage = findMessage.getText();
		return successMessage;
	}

	public void deteleProfile(String deletingUserName, String confirmation) {
		accountSettings.click();
		deleteButton.click();
		this.deletingUserName.sendKeys(deletingUserName);
		this.confirmation.sendKeys(confirmation);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cancelPlanDeleteButton.click();
	}

	public String getSuccessfulDeletingMessage() {
		String successDeletingMessage = deletingMessage.getText();
		return successDeletingMessage;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
