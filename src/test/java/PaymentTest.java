import org.testng.annotations.Test;

public class PaymentTest extends BaseRunner {

  @Test
  public void testPaymentXPath() {
    googleMain.search("тинькофф");
    tinkoffSearcher.goToTinkoff();
    tinkoffMainPage.goToPayments();
    tinkoffPayments.goToTinkoffMobile("Тинькофф Мобайл");
    //Проверка ошибок
    providerTinkoffMobile.clickPayButton();
    //Телефон не заполнен
    providerTinkoffMobile.numberValidator("Поле обязательное");

    //Сумма не заполнена
    providerTinkoffMobile.summValidator("Поле обязательное");

    //Номер заполнен неверно
    providerTinkoffMobile.setNumberOfTelephone("000");
    providerTinkoffMobile.clickPayButton();
    providerTinkoffMobile.numberValidator("Поле неправильно заполнено");

    //Сумма меньше 10
    providerTinkoffMobile.setSumm("0");
    providerTinkoffMobile.clickPayButton();
    providerTinkoffMobile.summValidator("Минимум — 10 \u20BD");

    //сумма больше 15000
    providerTinkoffMobile.setSumm("42340");
    providerTinkoffMobile.clickPayButton();
    providerTinkoffMobile.summValidator("Максимум — 15 000 \u20BD");

    //неверное заполнение суммы
    providerTinkoffMobile.setSumm("45aaaa");
    providerTinkoffMobile.clickPayButton();
    providerTinkoffMobile.sumFieldTextValidator("45");

    //максимально допустимое количество символов ввода
    providerTinkoffMobile.setNumberOfTelephone("00000000000000000");
    providerTinkoffMobile.clickPayButton();
    providerTinkoffMobile.numberFieldValidator("+7 (000) 000-00-00");

    //запрет ввода любых символов кроме цифр
    providerTinkoffMobile.setNumberOfTelephone("aaaaaaa");
    providerTinkoffMobile.clickPayButton();
    providerTinkoffMobile.numberFieldValidator("+7 (");

    //максимально допустимое количество символов ввода
    providerTinkoffMobile.maximizeSumm();
    providerTinkoffMobile.clickPayButton();
    providerTinkoffMobile.sumFieldTextValidator("0");
  }

}
