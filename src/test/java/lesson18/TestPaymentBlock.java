package lesson18;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;

@Epic("Payment System Tests")
@Feature("Payment Options")
public class TestPaymentBlock extends BaseTest {
    private MTSMainPage MTSMainPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        MTSMainPage = new MTSMainPage(driver);
        MTSMainPage.open();
        MTSMainPage.clickCookieButtonIfExists();
    }

    @Test
    @Story("Verification of Payment Options Placeholders")
    @Description("This test verifies that the placeholders in the payment options form are correct")
    @Severity(SeverityLevel.NORMAL)
    public void testPaymentOptionsPlaceholders() {
        Step("Get placeholders from payment options");
        List<String> placeholders = MTSMainPage.getPaymentOptionsPlaceholders();

        Step("Define expected placeholders");
        String[] expectedPlaceholders =
                {"Номер телефона", "Сумма", "E-mail для отправки чека",
                        "Номер абонента", "Сумма", "E-mail для отправки чека",
                        "Номер счета на 44", "Сумма", "E-mail для отправки чека",
                        "Номер счета на 2073", "Сумма", "E-mail для отправки чека"};

        Step("Compare actual placeholders with expected ones");
        Assertions.assertArrayEquals(expectedPlaceholders, placeholders.toArray(),
                "Список placeholders в вариантах оплаты не совпадает");
    }

    @Attachment(value = "Page {0} screenshot", type = "image/png")
    public byte[] saveScreenshot(String name) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("{0}")
    public void Step(String description) {
        // This method is empty as it's used only for Allure reporting
    }
}