import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseRunner {
  public static ThreadLocal<WebDriver> tl = new ThreadLocal<>();
  public WebDriver driver;
  public String browserName = System.getProperty("browser");
  public String baseUrl;

  @BeforeClass
  public void setUp(){
    if (tl.get() != null) {
      driver = tl.get();
    } else {
      driver = getDriver();
      tl.set(driver);
    }
    driver.manage().window().maximize();
    baseUrl = "https://www.tinkoff.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      driver.quit();
      driver = null;
    }));
  }


  @AfterClass
  public void tearDown() {
        driver.quit();
  }

  private WebDriver getDriver() {
    try {
      BrowserFactory.valueOf(System.getProperty("browser"));
    } catch (NullPointerException | IllegalArgumentException e) {
      browserName = System.setProperty("browser", browserName);
    }
    return BrowserFactory.valueOf(browserName).create();
  }
}
