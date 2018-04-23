package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TinkoffPayments extends Page {

  public TinkoffPayments(WebDriver driver) {
    super(driver);
  }

  By input = By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div/label/div/input");
  By tinkoffMobile = By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div[1]/div/div/div/div");

  public void setInput(String str){
    driver.findElement(input).click();
    driver.findElement(input).clear();
    driver.findElement(input).sendKeys(str);
  }

  public void findTinkoffMobile(){
    driver.findElement(tinkoffMobile).click();
  }

  public void goToTinkoffMobile(String str){
    this.setInput(str);
    this.findTinkoffMobile();
  }
}

