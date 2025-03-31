package lesson16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testH2Title() {
        String h2Text = MTSMainPage.getH2Title();
        assertEquals("Онлайн пополнение без комиссии", h2Text);
    }

    @Test
    public void testPartnersLogos() {
        List<String> actualAltTexts = MTSMainPage.getPartnerLogoAltTexts();
        String[] expectedAltTexts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        Assertions.assertArrayEquals(expectedAltTexts, actualAltTexts.toArray(), "Список alt текстов не совпадает с ожидаемым");
    }

    @Test
    public void testLink() {
        String expectedHref = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualHref = MTSMainPage.getMoreInfoLinkHref();
        assert(Objects.requireNonNull(actualHref).contains(expectedHref));

        MTSMainPage.clickMoreInfoLink();

        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        MTSMainPage.waitForUrl(expectedUrl);

        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "URL после перехода не совпадает с ожидаемым");
    }

    @Test
    public void testPaymentFormSubmission() {
        MTSMainPage.startFillingForm("pay-connection")
                .withField("phoneNumber", "297777777")
                .withField("sum", "200")
                .withField("email", "test@example.com")
                .submit("Продолжить");
        Assertions.assertTrue(MTSMainPage.isBepaidIframeDisplayed(), "Форма оплаты не была отправлена успешно");
    }


    @Test
    public void testInternetFormSubmission() {
        MTSMainPage.startFillingForm("pay-internet")
                .withField("phoneNumber", "007777777")
                .withField("sum", "100")
                .withField("email", "test@example.com")
                .submit("Продолжить");
        Assertions.assertTrue(MTSMainPage.isInternetConfirmationDisplayed(), "Форма домашнего интернета не была отправлена успешно");
    }

    @Test
    public void testInstalmentFormSubmission() {
        MTSMainPage.startFillingForm("pay-instalment")
                .withField("scoreInstalment", "444444444444")
                .withField("sum", "500")
                .withField("email", "test@example.com")
                .submit("Продолжить");
        Assertions.assertTrue(MTSMainPage.isInstalmentConfirmationDisplayed(), "Форма рассрочки не была отправлена успешно");
    }

    @Test
    public void testArrearsFormSubmission() {
        MTSMainPage.startFillingForm("pay-arrears")
                .withField("scoreArrears", "207333333333")
                .withField("sum", "50")
                .withField("email", "test@example.com")
                .submit("Продолжить");
        Assertions.assertTrue(MTSMainPage.isArrearsConfirmationDisplayed(), "Форма задолженности не была отправлена успешно");
    }

    @Test
    public void testPaymentOptionsPlaceholders() {
        List<String> placeholders = MTSMainPage.getPaymentOptionsPlaceholders();
        String[] expectedPlaceholders =
                {"Номер телефона", "Сумма", "E-mail для отправки чека",
                 "Номер абонента", "Сумма", "E-mail для отправки чека",
                 "Номер счета на 44", "Сумма", "E-mail для отправки чека",
                 "Номер счета на 2073", "Сумма", "E-mail для отправки чека"};
        Assertions.assertArrayEquals(expectedPlaceholders, placeholders.toArray(), "Список placeholders в вариантах оплаты не совпадает");
    }
}