package StepDefination;

import java.time.Duration;

public class AllVariables extends World {

    /**
     * Maximum web driver wait time to do any operation
     */
    public Duration maxWaitTime = Duration.ofSeconds(5 * 60);
    public Duration maxWebDriverPullDuration = Duration.ofMillis(250);

    public String xpathShoppingService = "//span[@class='menu-title' and contains(text(), 'Shopping Service')]";
    public String xpathSupportGroup = "//a[@class='nav-link' and contains(text(), 'Support Group')]";
    public String xpathLoaderCircles = "//body/div[@id='app']/div/div[@class='vld-icon']";

    public AllVariables() {

    }
}
