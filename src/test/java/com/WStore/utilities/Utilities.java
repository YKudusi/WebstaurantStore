package com.WStore.utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utilities extends TestBase {

	/**
	 * @Desc wait for element to be visible
	 * @author Kudusi
	 * @param elmt
	 */
	public void waitUntilVisble(WebElement elmt) {

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(elmt));
	}

	/**
	 * @Desc wait for element to be clickable
	 * @author Kudusi
	 * @param elmt
	 */
	public void waitUntilClickable(WebElement elmt) {

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(elmt));
	}

	/**
	 * 
	 * @author kudusi
	 * @Desc Enter text to input filed
	 * @param String
	 */

	public void enterText(WebElement elmt, String text) {
		waitUntilVisble(elmt);
		elmt.clear();
		elmt.sendKeys(text);
	}

	/**
	 * @author kudusi
	 * @Desc click element
	 * @param Btn
	 */
	public void clickBtn(WebElement elmt) {
		waitUntilClickable(elmt);
		elmt.click();
	}

	/**
	 * 
	 * @author Kudusi
	 * @Desc check the btn is enabled and return boolen value
	 * @param WebElement
	 */
	public boolean checkBtnEnabled(WebElement elmt) {

		return elmt.isDisplayed();
	}

	/**
	 * @author Kudusi
	 * @Desc verify the element is displayed
	 */

	public void verifyVisibilityOfElement(WebElement elmt) {

		waitUntilVisble(elmt);
		Assert.assertTrue(elmt.isDisplayed());
	}

	/**
	 * 
	 * @param dataTable
	 * @param expectedContent
	 * @author Kudusi
	 * @Desc it extract content from table and assert with expected data
	 */
	public void assertContentFromTable(List<WebElement> dataTable, String expectedContent) {

		List<String> containsTable = new ArrayList<String>();
		for (WebElement data : dataTable) {
			String title = data.getText();
			if (title.contains(expectedContent)) {
				System.out.println("The Item Title is :: " + title);
				containsTable.add(title);
			} else {
				System.out.println("The item which is not contains Table is: " + title);
				Assert.assertTrue(false);
			}
		}
	}

	/**
	 * @author kudusi
	 * @Desc Check the page and move to next page.
	 * @param
	 */
	public void moveToNextPage(WebElement elmt) {

		int page = 0;
		while (elmt.getAttribute("aria-disabled").equals("false")) {
			page++;
			System.out.println("currently on Page :: " + page);
			clickBtn(elmt);
			System.out.println("the next page button attribute is disabled :: " + elmt.getAttribute("aria-disabled"));
			if (elmt.getAttribute("aria-disabled").equals("true")) {
				break;
			}
		}
	}

	/**
	 * @author Kudusi
	 * @Desc verify Item Title, go to till last page and add last item to Shopping
	 *       card
	 * 
	 */

	public void verifyItemTileAndAddFinalPageLastItemToshoppingCard(WebElement nextButn, List<WebElement> dataTable,
			String expectedContent, WebElement lastItem) {

		assertContentFromTable(dataTable, expectedContent);

		int page = 1;
		while (nextButn.getAttribute("aria-disabled").equals("false")) {
			page++;
			System.out.println("============== currently on Page " + page + " =============");

			List<String> containsTable = new ArrayList<String>();
			for (WebElement data : dataTable) {
				String title = data.getText();
				if (title.contains(expectedContent)) {
					System.out.println("The Item Title is :: " + title);
					containsTable.add(title);
				} else {
					System.out.println("The item which is not contains Table is: " + title);
					Assert.assertTrue(false);
				}
			}
			clickBtn(nextButn);
			System.out
					.println("the next page button attribute is disabled :: " + nextButn.getAttribute("aria-disabled"));
			if (nextButn.getAttribute("aria-disabled").equals("true")) {
				int lastItemIndex = dataTable.size();
				// add final page last item to shopping card
				clickBtn(lastItem);
				break;
			}
		}

	}
}
