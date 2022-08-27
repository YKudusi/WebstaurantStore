package com.WStore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WStore.utilities.TestBase;

public class HomePage extends TestBase {

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@value='Search']")
	private WebElement BtnSearch;

	public WebElement getsearchBoxInput() {
		return searchBox;
	}

	public WebElement getSearchBtn() {
		return BtnSearch;
	}

}
