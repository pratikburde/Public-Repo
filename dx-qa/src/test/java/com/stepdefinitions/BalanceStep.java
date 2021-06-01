package com.stepdefinitions;

import com.factory.DriverFactory;
import com.pages.BalancePage;
import com.utils.CustomAssertion;
import com.utils.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BalanceStep {

	private BalancePage balancePage = new BalancePage(DriverFactory.getDriver());

	@Given("user is on balance page")
	public void user_is_on_balance_page() {
		balancePage.launchSite();
	}

	@Then("count of values should be {int}")
	public void count_of_values_should_be(Integer Expectedcount) {
		try {
			Integer actualCount = balancePage.getCountOfLabelValues(); // 5

			CustomAssertion.assertEquals("Count of values on the screen are 5", Expectedcount, actualCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("values should be greater than {int}")
	public void values_should_be_greater_than(Integer zeroValue) {
		try {
			int txtValCount = balancePage.getTextValuesList().size();

			for (int i = 0; i < txtValCount; i++) {
				String orignalAmount = balancePage.getTextValuesList().get(i).getText();
				String actualAmount = Helper.getNumericValues(orignalAmount);

				CustomAssertion.assertTrue(orignalAmount + " is greater than zero(0)",
						Double.parseDouble(actualAmount) > zeroValue);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("total balance should be {int}")
	public void total_balance_should_be(Integer expTotalbalance) {
		try {
			String actTotalBalance = Helper.getNumericValues(balancePage.getTotalBalance());

			CustomAssertion.assertTrue("Total balance is 1000000",
					expTotalbalance == Integer.parseInt(actTotalBalance));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("values should contain dollar {string} sign")
	public void values_should_contain_dollar_sign(String dollarSign) {
		try {
			int txtValCount = balancePage.getTextValuesList().size();

			for (int i = 0; i < txtValCount; i++) {
				String orignalAmount = balancePage.getTextValuesList().get(i).getText();

				CustomAssertion.assertTrue(orignalAmount + " is in currency format", orignalAmount.contains(dollarSign));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("total balance should match sum of all values")
	public void total_balance_should_match_sum_of_all_values() {
		try {
			String totalBalance = Helper.getNumericValues(balancePage.getTotalBalance());
			Double actTotalBalance = Double.parseDouble(totalBalance);
			Double sumOfAllValues = 0.0;

			int txtValCount = balancePage.getTextValuesList().size();

			for (int i = 0; i < txtValCount; i++) {
				String amount = balancePage.getTextValuesList().get(i).getText();
				String actAmount = Helper.getNumericValues(amount);

				sumOfAllValues = sumOfAllValues + Double.parseDouble(actAmount);
			}

			CustomAssertion.assertTrue("Total balance is matching the sum of al values", actTotalBalance == sumOfAllValues);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
