package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TinkoffMainPage extends Page{
  By payment = By.xpath("//*[@id=\"x48761\"]/div[3]/div/div/div/div/div/div/div[6]/a");

  public TinkoffMainPage(WebDriver driver) {
    super(driver);
  }

  public void goToPayments(){
    driver.findElement(payment).click();
  }
}
