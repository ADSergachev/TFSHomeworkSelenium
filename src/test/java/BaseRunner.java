import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.GoogleSearch;
import pages.MainGoogle;
import pages.ProviderTinkoffMobile;
import pages.TinkoffMainPage;
import pages.TinkoffPayments;

public class BaseRunner {

  private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

  WebDriver driver;
  MainGoogle googleMain;
  GoogleSearch tinkoffSearcher;
  TinkoffMainPage tinkoffMainPage;
  TinkoffPayments tinkoffPayments;
  ProviderTinkoffMobile providerTinkoffMobile;

  public void setDrivers(){
    googleMain = new MainGoogle(driver);
    tinkoffSearcher = new GoogleSearch(driver);
    tinkoffMainPage = new TinkoffMainPage(driver);
    tinkoffPayments = new TinkoffPayments(driver);
    providerTinkoffMobile = new ProviderTinkoffMobile(driver);
  }

  @BeforeTest(alwaysRun = true)
  public void setUp() {
    if (webDriverThreadLocal.get() != null) {
      driver = webDriverThreadLocal.get();
    } else {
      driver = getDriver();
      webDriverThreadLocal.set(driver);
    }
    setDrivers();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      driver.quit();
      driver = null;
    }));
  }


  @AfterTest(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }

  private WebDriver getDriver() {
    return BrowserFactory.valueOf(System.getProperty("browser")).create();
  }
}
