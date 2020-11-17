package com.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MainPage extends PageObject {

	private static final String MAIN_PAGE_MENU = "//a[text()='%s']";
	private static final String MAIN_PAGE_BUTTONS = "//button[text()='%s']";
	private static final String MAIN_PAGE_PRODUCT = "//h3[text()='%s']";

	@FindBy(xpath = "//input[@id='colors__Black']//ancestor::label/span")
	WebElementFacade backColorFilter;

	@FindBy(xpath = "//div[@id='product_grid']")
	WebElement productGrid;

	public WebElement getProductGrid() {
		return productGrid;
	}

	public WebElementFacade getBackColorFilter() {
		return backColorFilter;
	}

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public WebElementFacade getMainPageMenu(String label) {
		WebElementFacade menuLabel = findBy(String.format(MAIN_PAGE_MENU, label));
		return menuLabel;
	}

	public WebElementFacade getMainPageButtons(String label) {
		WebElementFacade menuLabel = findBy(String.format(MAIN_PAGE_BUTTONS, label));
		return menuLabel;
	}

	public WebElementFacade getMainPageProduct(String label) {
		WebElementFacade menuLabel = findBy(String.format(MAIN_PAGE_PRODUCT, label));
		return menuLabel;
	}

	public void waitABit(final long timeInMilliseconds) {
		getClock().pauseFor(timeInMilliseconds);
	}
}
