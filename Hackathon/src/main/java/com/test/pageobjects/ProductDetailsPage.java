package com.test.pageobjects;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductDetailsPage extends PageObject {
	
	
	private static final String PRODUCT_NAME = "//h1[text()='%s']";

	public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
	
	public WebElementFacade getProductName(String label) {
		WebElementFacade menuLabel = findBy(String.format(PRODUCT_NAME, label));
		return menuLabel;
	}
}