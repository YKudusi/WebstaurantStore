package com.WStore.tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.WStore.pages.HomePage;
import com.WStore.pages.SearchResultPage;
import com.WStore.pages.ShoppingCardPage;
import com.WStore.utilities.TestBase;
import com.WStore.utilities.Utilities;

public class SearchTest extends BaseClass {

	Utilities util = new Utilities();

	@Test
	public void verifySearchResultTest() throws InterruptedException {

		// Step 1 - Searching Item on HomePage
		HomePage homePage = new HomePage(TestBase.driver);
		util.enterText(homePage.getsearchBoxInput(), "stainless work table");
		util.clickBtn(homePage.getSearchBtn());

		// Step 2 - Verifying Item Title, moving to until final page and add last Item
		// to the shopping card
		SearchResultPage srchPage = new SearchResultPage(TestBase.driver);
		List<WebElement> itemList = srchPage.getIitemList();
		util.verifyItemTileAndAddFinalPageLastItemToshoppingCard(srchPage.getnextPage(), itemList, "Table",
				srchPage.getAddLastItem());
		Thread.sleep(2000);
		util.clickBtn(srchPage.getViewCard());

		// Step 3 - Going to Shopping Card and remove the added Item
		ShoppingCardPage shopPage = new ShoppingCardPage(TestBase.driver);
		util.clickBtn(shopPage.getEmptyCardButton());
		Thread.sleep(2000);
		util.clickBtn(shopPage.getEmptyCardConfirmationBtn());
		util.verifyVisibilityOfElement(shopPage.getEmptyCardConfirmationMSG());
		Thread.sleep(2000);

	}

}
