package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class ProviderTinkoffMobile extends Page {

  public ProviderTinkoffMobile(WebDriver driver) {
    super(driver);
  }

  By numberOfTelephone = By.xpath("//*[@id=\"phone\"]");
  By summ = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[1]/form/div[2]/div/div/div/div/div/div/div/div[1]/label/div/input");
  By button = By.xpath("//*[@class='ui-button ui-button_failure ui-button_mobile-wide ui-button_provider-pay ui-button_size_xxl ui-form__button ui-button_inline']");
  By numberError = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[1]/form/div[1]/div/div[2]");
  By summError = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[1]/form/div[2]/div/div/div/div/div/div/div/div[2]");

  public void setNumberOfTelephone(String str){
    driver.findElement(numberOfTelephone).click();
    driver.findElement(numberOfTelephone).clear();
    driver.findElement(numberOfTelephone).sendKeys(str);
  }

  public void setSumm(String str){
    driver.findElement(summ).click();
    driver.findElement(summ).clear();
    driver.findElement(summ).sendKeys(str);
  }

  public void clickPayButton(){
    driver.findElement(button).click();
  }

  public void numberValidator(String error){
    assertEquals(driver.findElement(numberError).getText(), error);
  }

  public void summValidator(String error){
    assertEquals(driver.findElement(summError).getText(), error);
  }

  public void sumFieldTextValidator(String out){
    assertEquals(driver.findElement(summ).getAttribute("value"), out);
  }

  public void numberFieldValidator(String out){
    assertEquals(driver.findElement(numberOfTelephone).getAttribute("value"), out);
  }

  public void maximizeSumm(){
    driver.findElement(summ).click();
    driver.findElement(summ).clear();
    for (int i = 0; i < 23; i++){
      driver.findElement(summ).sendKeys("0");
    }
  }

  public void checkAuto(){
    driver.findElement(numberOfTelephone).click();
    driver.findElement(numberOfTelephone).clear();
    driver.findElement(numberOfTelephone).sendKeys("123");
    assertEquals(driver.findElement(numberOfTelephone).getAttribute("value"), "+7 (123) ");
    driver.findElement(numberOfTelephone).sendKeys("123");
    assertEquals(driver.findElement(numberOfTelephone).getAttribute("value"), "+7 (123) 123-");
    driver.findElement(numberOfTelephone).sendKeys("12");
    assertEquals(driver.findElement(numberOfTelephone).getAttribute("value"), "+7 (123) 123-12-");
    driver.findElement(numberOfTelephone).sendKeys("12");
    assertEquals(driver.findElement(numberOfTelephone).getAttribute("value"), "+7 (123) 123-12-12");
  }
}
