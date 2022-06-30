package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final int TIME_OUT_IN_SECONDS = 5;
    private static WebDriver driver;
    private static final String PATH_FILE = "src/main/resources/basesetup.json";

    public static void initialized() throws IOException {

        String CHROME_PARAMETER = getParameters().getChromeParameter();
        String NAME_OF_BROWSER = getParameters().getBrowserName();
        if (driver == null) {
            if (getParameters().getBaseBrowserName().equalsIgnoreCase(NAME_OF_BROWSER)) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(CHROME_PARAMETER);
                driver = new ChromeDriver(chromeOptions);
            } else if (getParameters().getBaseBrowserName().equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

    public static void openUrl() throws IOException {
        driver.get(getParameters().getUrl());
    }

    public static WebElement findOfElement(By element) {
        return driver.findElement(element);

    }

    public static List<WebElement> findOfElements(By element) {
        return driver.findElements(element);
    }

    public static WebDriverWait waitOfElement() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, TIME_OUT_IN_SECONDS);
        return wait;
    }

    public static Actions actionOfElement() {
        Actions action = new Actions(BaseTest.driver);
        return action;
    }

    public static JsonParser getParameters() throws IOException {
        JsonParser jsonParser = new JsonParser(PATH_FILE).jsonParser();
        return jsonParser;
    }
}

