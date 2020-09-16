package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.SearchObject;

import java.util.List;

public class productSearch {
    private WebDriver driver;
    By SearchLocator = By.id("search");

    @Given("the customer is on a product list page")
    public void the_customer_is_on_a_product_list_page() {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Juice\\Desktop\\Automation Tools\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://magento.abox.co.za/index.php/");

       //AssertTrue contains "Home Page"
        String expectedTitle ="Home Page";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        //AssertTrue contains "Mampopo"
//                String expectedTitle ="Mampopo";
//                String actualTitle=driver.getTitle();
//                Assert.assertEquals(actualTitle,expectedTitle);


    }
    @When("customer views the products")
    public void customer_views_the_products() {

        //Search For Product
        SearchObject SearchResults = PageFactory.initElements(driver, SearchObject.class);
        SearchResults.SearchProducts("bag");

    }

    @Then("the system should display the products by the default pagination")
    public void the_system_should_display_the_products_by_the_default_pagination() {


        WebElement body = driver.findElement(By.tagName("body"));
        List<WebElement> pagination = driver.findElements(By.xpath("/html/body/div[1]/main/div[3]/div[1]/div[2]/div[3]/div[2]/ul/li[3]/strong"));
        //check if pagination link exists
             if ((pagination).size() > 1) {
                 System.out.println("pagination exists");
            }
            String bodyText = body.getText();
            Assert.assertTrue("Does not Contain the Text '9'", bodyText.contains("9"));
           // Assert.assertTrue("Does not Contain the Text '15'",bodyText.contains("15"));


            //Close Browser
            //driver.close();




    }
}
