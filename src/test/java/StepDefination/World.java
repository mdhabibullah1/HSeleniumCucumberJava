package StepDefination;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class World {
    public WebDriver driver;

    public World() {
    }

    public WebElement find_WebElement_by_xpath(String xpath){
        WebElement foo =   new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(driver -> driver.findElement(By.name(xpath)));
        System.out.println(foo.getText());
        return foo;
    }

}
