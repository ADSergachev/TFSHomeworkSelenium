import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseRunner {

  private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

  WebDriver driver;

  static String BASE_URL = "https://www.tinkoff.ru/";
  static String GOOGLE_URL = "https://www.google.com/";

  @BeforeClass(alwaysRun = true)
  public void setUp() {
    if (webDriverThreadLocal.get() != null) {
      driver = webDriverThreadLocal.get();
    } else {
      driver = getDriver();
      webDriverThreadLocal.set(driver);
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      driver.quit();
      driver = null;
    }));
  }


  @AfterClass(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }

  private WebDriver getDriver() {
    return BrowserFactory.valueOf(System.getProperty("browser")).create();
  }
}
