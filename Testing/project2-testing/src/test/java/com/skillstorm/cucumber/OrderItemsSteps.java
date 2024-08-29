package com.skillstorm.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.Selenium.NavigationLinks;
import com.skillstorm.Selenium.OrderItems;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderItemsSteps {

    private OrderItems orderItems;


    @Before("@OrderItems")
    public void before() {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        this.orderItems = new OrderItems(driver);
    }

    @After("@OrderItems")
    public void after() {
        orderItems.close();
    }

    @Given("I am on the order information page")
    public void onTheOrderInformationPage() {
        this.orderItems.getOrderItemsPage();
    }

    @When("I select {string} and {string}")
    public void selectCustomerNameAndCandyName(String customerName, String candyName) {
        this.orderItems.selectCustomerName(customerName);
        this.orderItems.selectCandy(candyName);
    }

    @And("input {string} and {string} fields")
    public void inputPriceAndQuantityFields(String price, String quantity) {
        this.orderItems.inputPrice(price);
        this.orderItems.inputQuantity(quantity);
    }

    @And("I click the Add Order Item button")
    public void clickTheAddOrderItemButton() {
        this.orderItems.addOrderItemButton();
    }

    @Then("I should see the order item with {string}, {string}, {string}, and {string} in the list")
    public void shouldSeeOrderItemWith(String customerName, String candyName, String price, String quantity) {

    }
}
