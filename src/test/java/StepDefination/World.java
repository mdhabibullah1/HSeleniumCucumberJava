package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class World {
    public WebDriver driver;
    public DevTools devTools;
    public AllVariables allVariables;

    //test comment

    public World() {
    }

    public WebElement find_WebElement_by_xpath(String xpath){
        FluentWait wait = new FluentWait(this.driver);
        wait.withTimeout(this.allVariables.maxWaitTime);
        wait.pollingEvery(this.allVariables.maxWebDriverPullDuration);
        this.waitForLoad();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
        return this.driver.findElement(By.xpath(xpath));
    }

    /**
     * This method is check if page is not ready state
     * This method is check if there is a loader present in page
     */
    public void waitForLoad() {
        FluentWait wait = new FluentWait(this.driver);
        wait.withTimeout(this.allVariables.maxWaitTime);
        wait.pollingEvery(this.allVariables.maxWebDriverPullDuration);
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(this.allVariables.xpathLoaderCircles)));

    }


}
