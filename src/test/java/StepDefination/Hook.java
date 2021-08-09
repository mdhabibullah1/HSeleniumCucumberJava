package StepDefination;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.network.Network;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.io.File;
import java.util.Optional;

public class Hook extends World {
    private World world;

    public Hook(World world) {
        this.world = world;
    }

    @Before
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setBinary("C:\\Users\\sunny\\chromium-91_Win64\\chrome.exe");
        this.world.driver = new ChromeDriver(options);
        devTools = ((ChromeDriver) this.world.driver).getDevTools();
        devTools.createSession();
        this.world.devTools = devTools;

    }

//    @BeforeStep
//    public void checkPageLoad(){
//        this.devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
////        this.devTools.addListener(Network.requestWillBeSent(),
////                entry -> {
//////                    System.out.println("Request URI : " + entry.getRequest().getUrl());
//////                    System.out.println(entry.getRequestId());
//////                    System.out.println(entry.getRequest().getHeaders());
////                });
//        this.devTools.addListener(Network.responseReceived(),
//                res -> {
//                    System.out.println(res.getResponse().getStatus());
//                }
//        );
//    }

    @After
    public void teardown() {
        if (this.world.driver != null) {
            this.world.driver.quit();
        }

    }
}
