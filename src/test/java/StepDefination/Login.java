package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver driver;


    @Before
    public void setupTest() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I go to this url {string}")
    public void i_go_to_this_url(String url) {

    driver.get(url);

    }
    @Given("I enter user name and password {string} {string}")
    public void i_enter_user_name_and_password(String userName, String password) {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button/span[contains(text(), 'Login')]")).click();

    }

}
