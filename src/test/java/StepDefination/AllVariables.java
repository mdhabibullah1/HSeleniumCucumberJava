package StepDefination;

import java.time.Duration;

public class AllVariables extends World {

    /**
     * Maximum web driver wait time to do any operation
     */
    public Duration maxWaitTime = Duration.ofSeconds(5 * 60);
    public Duration maxWebDriverPullDuration = Duration.ofMillis(250);

    public String xpathLoaderCircles = "//body/div[@id='app']/div/div[@class='vld-icon']";

    public String xpathShoppingService = "//span[@class='menu-title' and contains(text(), 'Shopping Service')]";
    public String xpathSupportGroup = "//a[@class='nav-link' and contains(text(), 'Support Group')]";
    public String xpathSession = "//span[contains(text(), 'Sessions')]";
    public String xpathAddNew = "//a[@href='/momscradle-admin-webapp/shopping-services/supportgroup/session/new']";
    public String xpathSelectSG = "//label[contains(text(), 'Support Group')]//parent::div//select";
    public String xpathStartTime = "//input[@name='start time']";
    public String xpathEndTime = "//input[@name='end time']";
    public String xpathMaxSize = "//input[@name='start time']";


    public AllVariables() {

    }
}
