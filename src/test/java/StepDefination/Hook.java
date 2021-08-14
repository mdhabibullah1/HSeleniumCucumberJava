package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hook extends World {
    private World world;

    public Hook(World world) {
        this.world = world;
    }

    @Before
    public void setDriver() {
        /**
         * This section download browser driver and store location /User/.cache
         * Also create and manage web driver instance
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setBinary("C:\\Users\\sunny\\chromium-91_Win64\\chrome.exe");
        this.world.driver = new ChromeDriver(options);

        /**
         * This section create chrome devtools session
         */
        devTools = ((ChromeDriver) this.world.driver).getDevTools();
        devTools.createSession();
        this.world.devTools = devTools;
        /**
         * In this app we store all variable in to AllVariables class here we creating an instance of that class
         */
        this.world.allVariables = new AllVariables();

    }

    /**
     * After every cucumber steps we are executing this function
     * Checking and wait if page is not ready or loading state
     */
    @AfterStep
    public void checkPageLoad() {
        this.world.waitForLoad();
    }

    /**
     * After all test done we are closing browser instance
     */
    @After
    public void teardown() {
        if (this.world.driver != null) {
            this.world.driver.quit();
        }

    }
}
