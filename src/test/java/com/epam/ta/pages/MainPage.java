package com.epam.ta.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://github.com/";

	@FindBy(xpath = "//ul[@id =\"user-links\"]//summary[@class=\"HeaderNavlink\"]")
	private WebElement buttonCreateNew;

	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private WebElement linkNewRepository;
	
	@FindBy(xpath = "//details[@class = \"details-overlay details-reset d-flex pl-2 flex-items-center\"]")
	private WebElement profileInfoButton;
	
	@FindBy(xpath = "//a[@class = \"dropdown-item\"]")
	private WebElement profileButton;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnCreateNewRepositoryButton()
	{
		buttonCreateNew.click();
		linkNewRepository.click();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}
}
