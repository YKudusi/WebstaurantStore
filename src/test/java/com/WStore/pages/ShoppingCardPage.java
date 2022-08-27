package com.WStore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WStore.utilities.TestBase;

public class ShoppingCardPage extends TestBase {

	public ShoppingCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[text()='Empty Cart']")
	private WebElement emptyCard;
	
	@FindBy(xpath = "//button[text()='Empty']")
	private WebElement emptyCardConfirmation;
	
	@FindBy(xpath = "//p[text()='Your cart is empty.']")
	private WebElement emptyCardConfirmationMSG;
	
	
	public WebElement getEmptyCardButton() {

		return emptyCard;
	}

	public WebElement getEmptyCardConfirmationBtn() {

		return emptyCardConfirmation;
	}

	public WebElement getEmptyCardConfirmationMSG() {

		return emptyCardConfirmationMSG;
	}

}
