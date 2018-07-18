package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.ta.pages.CreateNewAccountPage;
import com.epam.ta.pages.CreateNewRepositoryPage;
import com.epam.ta.pages.LoginPage;
import com.epam.ta.pages.MainPage;
import com.epam.ta.pages.SettingsPage;

public class Steps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loginGithub(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		logger.info("Actual username: " + actualUsername);
		return actualUsername.equals(username);
	}

	public boolean createNewRepository(String repositoryName, String repositoryDescription) {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
		return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
	}

	public boolean currentRepositoryIsEmpty() {
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}

	public void enterUserInformation() {
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.openPage();
		settingsPage.enterUserInformation();
	}

	public String getSuccessfullMessage() {
		SettingsPage settingsPage = new SettingsPage(driver);
		String successfullMessage = settingsPage.getUpdateMessage();
		return successfullMessage;
	}

	public void createAccount() {
		CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
		createNewAccountPage.openPage();
		createNewAccountPage.createAccount();
	}

	public void deleteAccount(String deletingUserName, String confirmation) {
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.openPage();
		settingsPage.deteleProfile(deletingUserName, confirmation);
	}
	
	public String getSuccessfullDeletingMessage() {
		SettingsPage settingsPage = new SettingsPage(driver);
		String successfullDeletingMessage = settingsPage.getSuccessfulDeletingMessage();
		return successfullDeletingMessage;
	}

}
