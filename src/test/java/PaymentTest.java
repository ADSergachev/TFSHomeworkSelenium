import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class PaymentTest extends BaseRunner {
  @Test
  public void testPaymentXPath() {
    driver.get(GOOGLE_URL);
    driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("тинькофф");
    driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//*[text() = 'https://www.tinkoff.ru/']/../../../..//*[@class=\"r\"]//a")).click();
    ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(newTab.get(newTab.size() - 1));
    driver.findElement(By.xpath("//*[@id=\"x48761\"]/div[3]/div/div/div/div/div/div/div[6]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div/label/div/input")).click();
    driver.findElement(By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div/label/div/input")).clear();
    driver.findElement(By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div/label/div/input")).sendKeys("Тинькофф Мобайл");
    driver.findElement(By.xpath("//*[@id=\"search-and-pay-container\"]/div[2]/div[2]/div/form/div[3]/div/div/div/div[2]/div/div[1]/div/div/div[1]/div")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[1]/form/div[2]/div/div/div/div/div/div/div/div/label/div/input")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[1]/form/div[2]/div/div/div/div/div/div/div/div/label/div/input")).clear();
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[1]/form/div[2]/div/div/div/div/div/div/div/div/label/div/input")).sendKeys("5");
    driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/div/div/div[1]/form/div[4]/div/div[1]/div/div/button")).click();
    assertEquals(driver.findElement(By.xpath("//div[2]/div/div/div/div/form/div/div/div[2]")).getText(), "Поле обязательное");
    assertEquals(driver.findElement(By.xpath("//form/div[2]/div/div/div/div/div/div/div/div[2]")).getText(), "Минимум — 10 ₽");
  }

  @Test
  public void testPaymentCSSSelectors(){
    driver.get(GOOGLE_URL);
    driver.findElement(By.cssSelector("#lst-ib")).click();
    driver.findElement(By.cssSelector("#lst-ib")).sendKeys("тинькофф");
    driver.findElement(By.cssSelector("#lst-ib")).sendKeys(Keys.ENTER);
    List <WebElement> links = driver.findElements(By.cssSelector(".f > cite"));
    List <WebElement> cites = driver.findElements(By.cssSelector(".rc > h3 > a"));
    for (int i = 0; i < links.size(); i++){
      WebElement a = cites.get(i);
      WebElement b = links.get(i);
      if (b.getText().equals("https://www.tinkoff.ru/")){
        a.click();
      }
    }
    ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(newTab.get(newTab.size() - 1));
    driver.findElement(By.cssSelector("#x48761 > div.SecondMenu__root_3k8f6.SecondMenu__root_border_3F0bm.SecondMenu__root_hideOnPhone_3wL3A > div > div > div > div > div > div > div:nth-child(6) > a")).click();
    driver.findElement(By.cssSelector("#search-and-pay-container > div.Banner__root_3tcdX > div.Container__container_1WsuA.Container__container_authorized_false_2dESI.Container__containerNoPhonePadding_q6z3q > div > form > div.ui-form__row.SearchAndPayHeader__form__field_1mwtG.SearchAndPayHeader__form__field_to_3tf_N > div > div > div > div > label > div > input")).click();
    driver.findElement(By.cssSelector("#search-and-pay-container > div.Banner__root_3tcdX > div.Container__container_1WsuA.Container__container_authorized_false_2dESI.Container__containerNoPhonePadding_q6z3q > div > form > div.ui-form__row.SearchAndPayHeader__form__field_1mwtG.SearchAndPayHeader__form__field_to_3tf_N > div > div > div > div > label > div > input")).clear();
    driver.findElement(By.cssSelector("#search-and-pay-container > div.Banner__root_3tcdX > div.Container__container_1WsuA.Container__container_authorized_false_2dESI.Container__containerNoPhonePadding_q6z3q > div > form > div.ui-form__row.SearchAndPayHeader__form__field_1mwtG.SearchAndPayHeader__form__field_to_3tf_N > div > div > div > div > label > div > input")).sendKeys("Тинькофф Мобайл");
    driver.findElement(By.cssSelector("#search-and-pay-container > div.Banner__root_3tcdX > div.Container__container_1WsuA.Container__container_authorized_false_2dESI.Container__containerNoPhonePadding_q6z3q > div > form > div.ui-form__row.SearchAndPayHeader__form__field_1mwtG.SearchAndPayHeader__form__field_to_3tf_N > div > div > div > div.SearchSuggested__suggestContainer_Z6mjO > div > div:nth-child(1) > div > div > div:nth-child(1) > div")).click();
    driver.findElement(By.cssSelector("body > div.application > div > div > div.PlatformLayout__layoutPage_WoIKN > div.PortalContainer__container_lyBzt > div.UILayoutPage__page_19-Kp > div:nth-child(1) > div.PlatformLayout__layoutPageComponent_3W4dc > div > div:nth-child(2) > div > div > div > div.Grid__column_3qcJA.Grid__column_size_8_13Rlm > form > div:nth-child(2) > div > div > div > div > div > div > div > div > label > div > input")).click();
    driver.findElement(By.cssSelector("body > div.application > div > div > div.PlatformLayout__layoutPage_WoIKN > div.PortalContainer__container_lyBzt > div.UILayoutPage__page_19-Kp > div:nth-child(1) > div.PlatformLayout__layoutPageComponent_3W4dc > div > div:nth-child(2) > div > div > div > div.Grid__column_3qcJA.Grid__column_size_8_13Rlm > form > div:nth-child(2) > div > div > div > div > div > div > div > div > label > div > input")).clear();
    driver.findElement(By.cssSelector("body > div.application > div > div > div.PlatformLayout__layoutPage_WoIKN > div.PortalContainer__container_lyBzt > div.UILayoutPage__page_19-Kp > div:nth-child(1) > div.PlatformLayout__layoutPageComponent_3W4dc > div > div:nth-child(2) > div > div > div > div.Grid__column_3qcJA.Grid__column_size_8_13Rlm > form > div:nth-child(2) > div > div > div > div > div > div > div > div > label > div > input")).sendKeys("5");
    driver.findElement(By.cssSelector("body > div.application > div > div > div.PlatformLayout__layoutPage_WoIKN > div.PortalContainer__container_lyBzt > div.UILayoutPage__page_19-Kp > div:nth-child(1) > div.PlatformLayout__layoutPageComponent_3W4dc > div > div:nth-child(2) > div > div > div > div.Grid__column_3qcJA.Grid__column_size_8_13Rlm > form > div:nth-child(4) > div > div.ui-form__row.ui-form__row_component.ui-form__row_button-submit > div > div > button")).click();
    assertEquals(driver.findElement(By.cssSelector("body > div.application > div > div > div.PlatformLayout__layoutPage_WoIKN > div.PortalContainer__container_lyBzt > div.UILayoutPage__page_19-Kp > div:nth-child(1) > div.PlatformLayout__layoutPageComponent_3W4dc > div > div:nth-child(2) > div > div > div > div.Grid__column_3qcJA.Grid__column_size_8_13Rlm > form > div.ui-form__row.ui-form__row_phone.ui-form__row_default-error-view-visible > div > div.ui-form-field-error-message.ui-form-field-error-message_ui-form")).getText(), "Поле обязательное");
    assertEquals(driver.findElement(By.cssSelector("body > div.application > div > div > div.PlatformLayout__layoutPage_WoIKN > div.PortalContainer__container_lyBzt > div.UILayoutPage__page_19-Kp > div:nth-child(1) > div.PlatformLayout__layoutPageComponent_3W4dc > div > div:nth-child(2) > div > div > div > div.Grid__column_3qcJA.Grid__column_size_8_13Rlm > form > div.ui-form__row.ui-form__row_combination > div > div > div > div > div > div > div > div.ui-form-field-error-message.ui-form-field-error-message_ui-form")).getText(), "Минимум — 10 ₽");
  }
}
