package pages;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch extends Page{
  By tinkoffMainPage = By.xpath("//*[text() = 'https://www.tinkoff.ru/']/../../../..//*[@class=\"r\"]//a");

  public GoogleSearch(WebDriver driver){
    super(driver);
  }

  private void findTinkoff(){
    driver.findElement(tinkoffMainPage).click();
  }

  private void goToLastWindow(){
    ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(newTab.get(newTab.size() - 1));
  }

  public void goToTinkoff(){
    this.findTinkoff();
    this.goToLastWindow();
  }
}
