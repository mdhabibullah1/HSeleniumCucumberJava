package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {
    private World world;

    public Login(World world) {
        this.world = world;
    }

    @Given("I go to this url {string}")
    public void i_go_to_this_url(String url) {
        this.world.driver.get(url);
    }

    @When("I click on Shopping Service")
    public void i_click_on_shopping_service() {
        WebElement element = this.world.find_WebElement_by_xpath(this.world.allVariables.xpathShoppingService);
        this.world.waitForLoad();

        Assert.assertEquals("WHRC | Home", this.world.driver.getTitle());

        Actions actions = new Actions(this.world.driver);
        actions.moveToElement(element).click(element).perform();
    }


    @When("I click on Support Group")
    public void i_click_on_support_group() {
        WebElement element = this.world.find_WebElement_by_xpath(this.world.allVariables.xpathSupportGroup);
        Actions actions = new Actions(this.world.driver);
        this.world.waitForLoad();
        actions.moveToElement(element).click(element).perform();

    }

    @When("I click on Sessions")
    public void i_click_on_sessions() {
        this.world.find_WebElement_by_xpath("//span[contains(text(), 'Sessions')]").click();


    }

    @When("I click on Add New")
    public void i_click_on_add_new() {
        this.world.find_WebElement_by_xpath("//a[@href='/momscradle-admin-webapp/shopping-services/supportgroup/session/new']").click();
    }


    @When("I Enter Time")
    public void i_enter_time() {

        this.world.find_WebElement_by_xpath("//input[@name='start time']").sendKeys("06-00am");
        this.world.find_WebElement_by_xpath("//input[@name='end time']").sendKeys("06-10am");
    }


    @When("I Enter Maximum Size")
    public void i_enter_maximum_size() {
        this.world.find_WebElement_by_xpath("//input[@name='start time']").sendKeys("1");
    }

    @When("I Select Support Group Name")
    public void i_select_support_group_name() {
        Select SupportGroup = new Select(this.world.find_WebElement_by_xpath("//h6[contains(text(), 'Support Group')]//parent::div[@class='form-group']//select"));
        SupportGroup.selectByVisibleText("The Afterglow Edited");

    }

    @When("I Select Location")
    public void i_select_location() {
        Select Location = new Select(this.world.find_WebElement_by_xpath("//select[@name='location']"));
        Location.selectByIndex(6);
    }

    @When("I select Location Details")
    public void i_select_location_details() {
        Select LocationDetails = new Select(this.world.find_WebElement_by_xpath("//select[@name='location details']"));
        LocationDetails.selectByIndex(1);
    }

    @When("I Select Survey")
    public void i_select_survey() {
        Select LocationDetails = new Select(this.world.find_WebElement_by_xpath("//select[@class='form-control mt-2 ']"));
        LocationDetails.selectByIndex(1);
    }

    @When("I click on Save Button")
    public void i_click_on_save_button() {
        world.find_WebElement_by_xpath("//button[contains(text(), 'Save')]").click();
    }


    @Given("I enter user name and password {string} {string}")
    public void i_enter_user_name_and_password(String userName, String password) {
        Assert.assertEquals("WHRC | Login", this.world.driver.getTitle());
        this.world.find_WebElement_by_xpath("//input[@id='email']").sendKeys(userName);
        this.world.find_WebElement_by_xpath("//input[@name='password']").sendKeys(password);
        this.world.find_WebElement_by_xpath("//button/span[contains(text(), 'Login')]").click();
        this.world.waitForLoad();
    }

}
