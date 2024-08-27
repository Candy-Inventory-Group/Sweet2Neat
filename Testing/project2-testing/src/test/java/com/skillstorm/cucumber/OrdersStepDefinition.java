package com.skillstorm.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.skillstorm.Selenium.OrdersList;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class OrdersStepDefinition {
    private OrdersList ordersList;
    
    @Before("@Orders")
    public void before(){
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        this.ordersList = new OrdersList(driver);
    }

    @Given("I am on the order list page")
    public void iAmOnTheOrderListPage(){
        ordersList.getOrderListPageUrl();
    }

    // @When("I fill in {string}, {string}, {string}, and {string}")
    // public void iFillIn(String customerName, String orderDate, String status, String customerAddress){
    //     ordersList.getCustomerName(customerName);
    //     ordersList.getOrderDate(orderDate);
    //     ordersList.getStatus(status);
    //     ordersList.getCustomerAddress(customerAddress);
    // }

    @And("I click the Add order button")
    public void iClickTheAddOrderButton(){
        ordersList.clickAddOrderBtn();
    }

    @Then("new order information should be in the table")
    public void newOrderInformationShouldBeInTheTable(){
        ordersList.confirmOrderCreation();
    }

    @Given("I am on the base page")
    public void iAmOnTheBasePage(){
        ordersList.getHomeUrl();
    }

    @When("I navigate to the order list page")
    public void iNavigateToTheOrderListPage(){
        ordersList.clickListOfOrdersBtn();
    }

    @Then("I should see the list of orders")
    public void iShouldSeeTheListOfOrders(){
        ordersList.displayOrderListTable();
    }

    @When("I click the delete button")
    public void iClickTheDeleteIcon(){
        ordersList.clickDeleteIcon();
    }

    @Then("The order should not be visible in the order list page")
    public void theOrderShouldNotBeVisibleInTheOrderListPage(){
        ordersList.confirmDeletion();
    }

    
}
