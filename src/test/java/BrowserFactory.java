import java.io.File;
import java.util.Locale;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public enum BrowserFactory {
  chrome {
    public WebDriver create() {
      setUpDriver(CHROME);
      return new ChromeDriver();
    }
  },
  firefox {
    public WebDriver create() {
      setUpDriver(FIREFOX);
      return new FirefoxDriver();
    }
  };

  public abstract WebDriver create();


  private static final String CHROME = "chrome";
  private static final String FIREFOX = "firefox";

  // Путь к драйверам
  private static final String BASE_PACKAGE = "drivers/";
  public static final String WINDOWS = "windows/";
  public static final String MAC = "mac/";
  private static final String CHROME_DRIVER_NAME = "chromedriver";
  private static final String FIREFOX_DRIVER_NAME = "geckodriver";

  void setUpDriver(final String browserName) {
    System.out.println(String.format("\nStarting %s-browser......", browserName));

    if (browserName.equals(CHROME)) {
      System.setProperty(
          "webdriver.chrome.driver",
          getDriverPath(CHROME_DRIVER_NAME));
    } else {
      System.setProperty(
          "webdriver.gecko.driver",
          getDriverPath(BASE_PACKAGE + FIREFOX_DRIVER_NAME));
    }
  }

  private String getDriverPath(final String driverName) {
    final String osName = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    String driverPath = null;

    if (osName.contains("win")) {
      driverPath = BASE_PACKAGE + WINDOWS + driverName + ".exe";

    }

    if (osName.contains("mac")) {
      driverPath = BASE_PACKAGE + MAC + driverName;
    }

    if (Objects.isNull(driverPath) || driverPath.isEmpty()) {
      throw new IllegalStateException("Отсутствует драйвер для вашей операционной системы");
    }

    final File driver = new File(Objects.requireNonNull(
        ClassLoader
            .getSystemClassLoader()
            .getResource(driverPath)
    ).getFile());

    if (!driver.setExecutable(true)) {
      throw new IllegalStateException("Не удалось запустить драйвер из ресурсов");
    }

    return driver.getAbsolutePath();
  }
}