package com.skillstorm.Navigation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NavigationLinks {
    
    private WebDriver driver;
    
    private static final String homeUrl = "http://localhost:5173/";
    private static final String orderUrl = "http://localhost:5173/orders";

    @FindBy(name = "logo")
    private WebElement logo;

    @FindBy(name = "warehouses")
    private WebElement warehousesMenu;

    @FindBy(name = "warehousesRoute")
    private WebElement warehousesListMenu;

    @FindBy(name = "warehouseListTitle")
    private WebElement warehouseListHeader;

    @FindBy(name = "candy")
    private WebElement candyMenu;

    @FindBy(name = "candyRoute")
    private WebElement candyInventoryMenu;

    @FindBy(name = "candy")
    private WebElement candyCategoriesMenu;

    @FindBy(name = "candyInventoryTitle")
    private WebElement candyInventoryHeader;

    // Setup driver
    public NavigationLinks(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void close() {
        this.driver.close();
    }

    //================= NAV TO HOME PAGE ==================//
    public void getOrderPage() {
        this.driver.get(orderUrl);
    }

    public void clickLogo() {
        logo.click();
    }

    public String checkCurrentPage() {
        return this.driver.getCurrentUrl();
    }

    //================= NAV TO WAREHOUSE LIST PAGE ==================//
    public void getHomePage() {
        this.driver.get(homeUrl);
    }

    public void clickWarehouseMenu() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        warehousesMenu.click();        
        warehousesListMenu.click();        
    }

    public String getWarehouseListHeader() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return warehouseListHeader.getText();
    }

    //================= NAV TO WAREHOUSE LIST PAGE ==================//
    public void clickOnCandyInventoryMenu() {
        candyMenu.click();
        candyInventoryMenu.click();        
    }

    public String getCandyInventoryHeader() {
        return candyInventoryHeader.getText();
    }
}
