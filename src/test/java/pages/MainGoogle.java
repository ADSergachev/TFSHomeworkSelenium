package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainGoogle extends Page{
  static String GOOGLE_URL = "https://www.google.ru/";

  By serchField = By.xpath("//*[@id=\"lst-ib\"]");


  public MainGoogle(WebDriver driver){
    super(driver);
  }

  public void open(){
    driver.get(GOOGLE_URL);
  }

  public void setSerchField(String strToFind) {
    driver.findElement(serchField).click();
    driver.findElement(serchField).clear();
    driver.findElement(serchField).sendKeys(strToFind);
    driver.findElement(serchField).sendKeys(Keys.ENTER);
  }

  public void search(String strToFind) {
    this.open();
    this.setSerchField(strToFind);
  }
}
