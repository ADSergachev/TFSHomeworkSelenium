import org.testng.annotations.Test;

public class PaymentTest extends BaseRunner {

  @Test
  public void testPaymentXPath() {
    googleMain.search("тинькофф");
    tinkoffSearcher.goToTinkoff();
    tinkoffMainPage.goToPayments();
    tinkoffPayments.goToTinkoffMobile("Тинькофф Мобайл");

  }

}