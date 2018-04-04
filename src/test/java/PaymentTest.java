import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PaymentTest {
  private WebDriver driver;
  private String baseUrl;

  @BeforeClass(alwaysRun = true)
  public void setUp(){
    System.setProperty("webdriver.gecko.driver", "/Users/sergacevandrey/Desktop/TFSHomeworkSelenium/src/drivers/geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "https://www.tinkoff.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPayment(){
    driver.get(baseUrl);
    driver.findElement(By.xpath("//div[@id='x48761']/div[3]/div/div/div/div/div/div/div/div/div/div[6]/a/span")).click();
    driver.findElement(By.xpath("//input[@id='']")).click();
    driver.findElement(By.xpath("//input[@id='']")).clear();
    driver.findElement(By.xpath("//input[@id='']")).sendKeys("Тинькофф Мобайл");
    driver.findElement(By.xpath("//div[@id='search-and-pay-container']/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/div")).click();
    driver.findElement(By.xpath("//input[@id='']")).click();
    driver.findElement(By.xpath("//input[@id='']")).clear();
    driver.findElement(By.xpath("//input[@id='']")).sendKeys("5");
    driver.findElement(By.xpath("//h2")).click();
    driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div[2]")).click();
    driver.findElement(By.xpath("//div[2]/div/div/div/div/form/div/div/div[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown(){
    driver.quit();
  }
}

