import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


public class CalculatorTest extends BaseRunner{
  @Test
  public void testCalc() throws InterruptedException {
    driver.get(BASE_URL);
    driver.findElement(By.xpath("//*[@id=\"firstMenu\"]/li[5]/span/a")).click();
    driver.findElement(By.xpath("//*[@id=\"xca7ce\"]/div[3]/div/div/div/div[1]/div/div/div/div/div/div[2]/a")).click();
    Thread.sleep(3000);
    ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 0 + "," + 100 + ");");
    String result = driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/span/span")).getText();
    result = result.substring(0 , result.length() - 2);
    final int checkResult = Integer.parseInt(result);
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/ul/li[1]")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/div/div[2]/div[2]/div/div[2]/ul/li[1]")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span/div[2]/div[1]/div/div/div[2]/span")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span/div[2]/div[2]/div/div/div[2]/span/span")).click();
    result = driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/span/span")).getText();
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
    Thread.sleep(3000);
    ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 0 + "," + (-20) + ");");
    ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 0 + "," + 15 + ");");
    result = driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/span/span")).getText();
    result = result.substring(0 , result.length() - 2);
    resultCalc = Integer.parseInt(result);
    if (resultCalc == checkResult) {
      System.out.println("Calk OK");
    } else {
      throw new NullPointerException("Calculator is wrong");
    }
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/div/div[2]/div[2]/div/div[2]/ul/li[6]")).click();
    result = driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/span/span")).getText();
    result = result.substring(0 , result.length() - 2).replaceAll("\\s","");
    int unlimit = Integer.parseInt(result);
    Boolean isPresentOtherService = driver.findElements(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span")).size() > 0;
    if (!isPresentOtherService){
      System.out.println("OtherService OK");
    } else {
      throw new NoSuchElementException("OtherService is wrong");
    }
    driver.navigate().refresh();
    ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 0 + "," + (-20) + ");");
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/div/div[2]/div[2]/div/div[2]/ul/li[5]")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span/div[2]/div[1]/div/div/div[2]/span")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span/div[2]/div[2]/div/div/div[2]/span")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span/div[2]/div[3]/div/div/div[2]/span")).click();
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[1]/div[1]/span/div[2]/div[4]/div/div/div[2]/span")).click();
    ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 0 + "," + (-20) + ");");
    result = driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/span/span")).getText();
    result = result.substring(0 , result.length() - 2).replaceAll("\\s","");;
    resultCalc = Integer.parseInt(result);
    if (unlimit > resultCalc){
      System.out.println("Calc OK");
    }
    else {
      throw new NoSuchElementException("Unlimit is cheaper then 15 Gb");
    }
    driver.findElement(By.xpath("//*[@id=\"x1f5c2\"]/div/div/div/div[2]/button")).click();
  }
}
