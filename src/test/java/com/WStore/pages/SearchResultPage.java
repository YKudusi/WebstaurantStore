package com.WStore.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WStore.utilities.TestBase;

public class SearchResultPage extends TestBase {

	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='product_listing']/div/div[2]/a[2]")
	private List<WebElement> itemtable;

	@FindBy(xpath = "//li[contains(@class,'rc-pagination-next')]")
	private WebElement nextpageBtn;

	@FindBy(xpath = "(//*[@id='ProductBoxContainer']/div[4]/form/div/div/input[2])[last()]")
	private WebElement lastItemAddcard;

	@FindBy(xpath = "//a[text()='View Cart']")
	private WebElement viewCard;

	
	public List<WebElement> getIitemList() {

		return itemtable;
	}

	public WebElement getnextPage() {

		return nextpageBtn;
	}

	public WebElement getAddLastItem() {

		return lastItemAddcard;
	}
	
	public WebElement getViewCard() {

		return viewCard;
	}

}
