package StepDefination;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class World {
    public WebDriver driver;
    public DevTools devTools;


    public World() {
    }

    public WebElement find_WebElement_by_xpath(String xpath){

        WebElement foo =   new WebDriverWait(driver, Duration.ofSeconds(220))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        System.out.println(foo.getText());
        return foo;
    }


}
