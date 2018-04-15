import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class PaymentTest extends BaseRunner {
  @Test
  public void testByXpath() throws InterruptedException {
    driver.get(BASE_URL);
    driver.findElement(By.xpath("//*[@id=\"firstMenu\"]/li[5]/span/a/span")).click();
    driver.findElement(By.xpath("//*[@id=\"xca7ce\"]/div[3]/div/div/div/div[1]/div/div/div/div/div/div[2]/a/span")).click();

    ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 0 + "," + 20 + ");");
    WebElement el = driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/span/span"));
    String result = el.getText();
    result = result.substring(0 , result.length() - 2);
    final int checkResult = Integer.parseInt(result);

    Thread.sleep(1500);
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/div/div[2]/div[2]/div/div[2]/ul/li[1]")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/ul/li[1]")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span/div[2]/div[1]/div/div/div[2]/span/span")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span/div[2]/div[2]/div/div/div[2]/span/span")).click();
    Thread.sleep(3500);

    el = driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/span/span"));
    result = el.getText();
    result = result.substring(0 , result.length() - 2);
    int resultCalc = Integer.parseInt(result);
    if (resultCalc == 0) {
      System.out.println("Calc OK");
    } else {
      throw new NullPointerException("Calculator is wrong");
    }

    if (!driver.findElement(By.xpath("//*[@id=\"form-application\"]//button")).isEnabled()){
      System.out.println("button OK");
    } else {
        throw new NullPointerException("Button is wrong");
    }
    driver.navigate().refresh();

    ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 0 + "," + 20 + ");");
    Thread.sleep(4500);
    el = driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/span/span"));
    result = el.getText();
    result = result.substring(0 , result.length() - 2);
    resultCalc = Integer.parseInt(result);
    if (resultCalc == checkResult) {
      System.out.println("Calk OK");
    } else {
      throw new NullPointerException("Calculator is wrong");
    }
    Thread.sleep(1500);
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/div/div[2]/div[2]/div/div[2]/ul/li[6]")).click();
    Thread.sleep(1500);
    Boolean isPresentOtherService = driver.findElements(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span")).size() > 0;
    if (!isPresentOtherService){
      System.out.println("OtherService OK");
    } else {
      throw new NoSuchElementException("OtherService is wrong");
    }

    el = driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/span/span"));
    result = el.getText();
    result = result.substring(0 , result.length() - 2);
    int unlimit = Integer.parseInt(result);

    System.out.println(unlimit);
  }

  @Test
  public void testPayment() throws InterruptedException {
    driver.get(GOOGLE_URL);
    driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("тинькофф");
    driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//*[text() = 'https://www.tinkoff.ru/']/../../../..//*[@class=\"r\"]//a")).click();
    ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(newTab.get(1));
    driver.findElement(By.xpath("//*[@id=\"x48761\"]/div[3]/div/div/div/div/div/div/div[6]/a")).click();
    driver.findElement(By.xpath("//input[@id='']")).click();
    driver.findElement(By.xpath("//input[@id='']")).clear();
    driver.findElement(By.xpath("//input[@id='']")).sendKeys("Тинькофф Мобайл");
    Thread.sleep(3000);
    driver.findElement(By
        .xpath("//div[@id='search-and-pay-container']/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/div"))
        .click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@id='']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@id='']")).clear();
    driver.findElement(By.xpath("//input[@id='']")).sendKeys("5");
    driver.findElement(By.xpath("//h2")).click();
    driver.findElement(By.xpath("//div[2]/div/div/div/div/form/div/div/div[2]")).click();
    assertEquals(driver.findElement(By.xpath("//div[2]/div/div/div/div/form/div/div/div[2]")).getText(), "Поле обязательное");
    driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div[2]")).click();
    assertEquals(driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div[2]")).getText(), "Минимум — 10 ₽");
  }
}