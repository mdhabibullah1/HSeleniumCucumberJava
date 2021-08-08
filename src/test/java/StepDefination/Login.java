package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {
    private  World world;

    public  Login(World world) {
        this.world = world;
    }

//    @Before
//    public void setupTest() {
//        WebDriverManager.chromedriver().setup();
//
//        driver = new ChromeDriver();
//    }

  /*  @After
    public void teardown() throws InterruptedException {


        if (driver != null) {
            driver.quit();
        }
    }*/
// Test comment
    @Given("I go to this url {string}")
    public void i_go_to_this_url(String url) {
        world.driver.get(url);
        world.driver.manage().window().maximize();
    }

    @When("I click on Shopping Service")
    public void i_click_on_shopping_service() {

        world.find_WebElement_by_xpath("//span[contains(text(), 'Shopping Services')]").click();
        //unable to commit and push

    }
    @When("I click on Support Group")
    public void i_click_on_support_group() throws InterruptedException {
        world.find_WebElement_by_xpath("//a[@href='/momscradle-admin-webapp/shopping-services/supportgroup']").click();

        Thread.sleep(5000);
//        JavascriptExecutor js = (JavascriptExecutor) world;
//        js.executeScript("window.scrollBy(0,0)", "");
    }
    @When("I click on Sessions")
    public void i_click_on_sessions() {
      world.find_WebElement_by_xpath("//span[contains(text(), 'Sessions')]").click();


    }

    @When("I click on Add New")
    public void i_click_on_add_new() {
      world.find_WebElement_by_xpath("//a[@href='/momscradle-admin-webapp/shopping-services/supportgroup/session/new']").click();
    }


    @When("I Enter Time")
    public void i_enter_time() {

        world.find_WebElement_by_xpath("//input[@name='start time']").sendKeys("06-00am");
        world.find_WebElement_by_xpath("//input[@name='end time']").sendKeys("06-10am");
    }



    @When("I Enter Maximum Size")
    public void i_enter_maximum_size() {
        world.find_WebElement_by_xpath("//input[@name='start time']").sendKeys("1");
    }

    @When("I Select Support Group Name")
    public void i_select_support_group_name() {
        Select SupportGroup = new Select(world.find_WebElement_by_xpath("//h6[contains(text(), 'Support Group')]//parent::div[@class='form-group']//select"));
        SupportGroup.selectByVisibleText("The Afterglow Edited");

//
//        WebElement SupportGroup = world.find_WebElement_by_xpath("//h6[contains(text(), 'Support Group')]//parent::div[@class='form-group']//select");
//        Select dropdownField = new Select(SupportGroup);
//        dropdownField.selectByVisibleText("The Afterglow Edited");
    }

    @When("I Select Location")
    public void i_select_location() {
        Select Location =new Select(world.find_WebElement_by_xpath("//select[@name='location']"));
        Location.selectByIndex(6);
    }

    @When("I select Location Details")
    public void i_select_location_details() {
        Select LocationDetails =new Select(world.find_WebElement_by_xpath("//select[@name='location details']"));
        LocationDetails.selectByIndex(1);
    }

    @When("I Select Survey")
    public void i_select_survey() {
        Select LocationDetails =new Select(world.find_WebElement_by_xpath("//select[@class='form-control mt-2 ']"));
        LocationDetails.selectByIndex(1);
    }

    @When("I click on Save Button")
    public void i_click_on_save_button() {
        world.find_WebElement_by_xpath("//button[contains(text(), 'Save')]").click();
    }


    @Given("I enter user name and password {string} {string}")
    public void i_enter_user_name_and_password(String userName, String password) {
        world.driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
        world.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        world.driver.findElement(By.xpath("//button/span[contains(text(), 'Login')]")).click();

    }

}
//span[contains(text(), '06:00-06:10')]//parent::td//a[contains(text(), 'Edit')]
//span[contains(text(), '06:00-06:10')]//parent::td//a[contains(text(), 'Remove')]
//button[contains(text(), 'Yes')]