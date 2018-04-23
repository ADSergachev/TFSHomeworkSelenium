package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProviderTinkoffMobile extends Page {

  public ProviderTinkoffMobile(WebDriver driver) {
    super(driver);
  }

  By numberOfTelephone = By.xpath("//*[@type = 'tel' and @name = 'provider-phone']");
  By summ = By.xpath("//*[@class = 'Input__value_2Kx90']");

  public void setNumberOfTelephone(){
    driver.findElement(numberOfTelephone).click();
    driver.findElement(numberOfTelephone).clear();
    driver.findElement(numberOfTelephone).sendKeys("45454454");
  }

  public void setSumm(){
    driver.findElement(summ).click();
    driver.findElement(summ).clear();
    driver.findElement(summ).sendKeys("45");
  }

}
