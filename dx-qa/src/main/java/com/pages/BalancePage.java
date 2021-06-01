package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.ConfigReader;

public class BalancePage {
	
	private WebDriver driver;

	private By totalBalance = By.id("txt_ttl_val");
	private By lblValueList = By.xpath("//*[contains(@id,'lbl_val_')]");
	private By txtValueList = By.xpath("//*[contains(@id,'txt_val_')]");

	public BalancePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * method to launch the url
	 */
	public void launchSite() {
		try {
			driver.get(ConfigReader.getURL());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	/**
	 * @return count of lbl_val IDs
	 */
	public int getCountOfLabelValues() {
		return driver.findElements(lblValueList).size();
	}

	/**
	 * @return list of txt_val IDs
	 */
	public List<WebElement> getTextValuesList() {
		return driver.findElements(txtValueList);
	}
	
	/**
	 * @return total balance
	 */
	public String getTotalBalance() {
		return driver.findElement(totalBalance).getText();
	}

}
