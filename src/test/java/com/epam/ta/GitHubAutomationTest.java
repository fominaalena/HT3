package com.epam.ta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest {

	private Steps steps;

	private final String USERNAME = "sometestuser5";
	private final String PASSWORD = "sometestuser1";

	private final String DELETING_CONFIRMATION = "delete my account";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Create project", priority = 2)
	public void oneCanCreateProject() {
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
		// Assert.assertTrue(steps.currentRepositoryIsEmpty());
	}

	@Test(description = "Login to Github", priority = 1)
	public void oneCanLoginGithub() {
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}

	@Test(description = "Enter profile information", priority = 3)
	public void enterInformation() {
		steps.loginGithub(USERNAME, PASSWORD);
		steps.enterUserInformation();
		Assert.assertTrue(steps.getSuccessfullMessage().contains("Profile updated successfully"));
	}

	@Test(description = "Create new account", priority = 5)
	public void createNewAccountGithub() {
		steps.createAccount();
	}

	@Test(description = "Deleting account", priority = 4)
	public void deleteAccount() {
		steps.loginGithub(USERNAME, PASSWORD);
		steps.deleteAccount(USERNAME, DELETING_CONFIRMATION);
		Assert.assertTrue(steps.getSuccessfullDeletingMessage().contains("Account successfully deleted"));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
