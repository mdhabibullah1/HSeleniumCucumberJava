package StepDefination;
import io.cucumber.java.After;
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
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Md Habibullah\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--profile-directory=Profile 2");
        this.world.driver = new ChromeDriver();

    }

    @After
    public void teardown() {
        if (this.world.driver != null) {
            this.world.driver.quit();
        }

    }
}
