package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateNewAccountPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://github.com/join?source=login";

	private final String NEW_NAME = "Epamtestaccount45678";
	private final String NEW_EMAIL = "Lisy14675@dot.com";
	private final String NEW_PASSWORD = "TestAccountPassword6712";

	public CreateNewAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "user_login")
	private WebElement userName;

	@FindBy(id = "user_email")
	private WebElement userEmail;

	@FindBy(id = "user_password")
	private WebElement userPassword;

	@FindBy(id = "signup_button")
	private WebElement submit;

	@FindBy(xpath = "//p[@class = \"lead\"]/strong[1]")
	private WebElement checkCreation;

	public void createAccount() {
		userName.sendKeys(NEW_NAME);
		userEmail.sendKeys(NEW_EMAIL);
		userPassword.sendKeys(NEW_PASSWORD);
		submit.click();
		logger.info("Account was created");
		Assert.assertTrue(checkCreation.getText().contains(NEW_NAME));
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Create new account page opened");
	}
}
