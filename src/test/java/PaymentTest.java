import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;
import org.openqa.selenium.*;


public class PaymentTest extends BaseRunner {

  @Test
  public void testPayment(){
    driver.get(BASE_URL);
    driver.findElement(By.xpath("//div[@id='x48761']/div[3]/div/div/div/div/div/div/div/div/div/div[6]/a/span")).click();
    driver.findElement(By.xpath("//input[@id='']")).click();
    driver.findElement(By.xpath("//input[@id='']")).clear();
    driver.findElement(By.xpath("//input[@id='']")).sendKeys("Тинькофф Мобайл");
    driver.findElement(By.xpath("//div[@id='search-and-pay-container']/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div/div/div/div/div/div/div")).click();
    driver.findElement(By.xpath("//input[@id='']")).click();
    driver.findElement(By.xpath("//input[@id='']")).clear();
    driver.findElement(By.xpath("//input[@id='']")).sendKeys("5");
    driver.findElement(By.xpath("//h2")).click();
    driver.findElement(By.xpath("//div[2]/div/div/div/div/form/div/div/div[2]")).click();
    assertEquals(driver.findElement(By.xpath("//div[2]/div/div/div/div/form/div/div/div[2]")).getText(), "Поле обязательное");
    driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div[2]")).click();
    assertEquals(driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div[2]")).getText(), "Минимум — 10 ₽");

  }
}

