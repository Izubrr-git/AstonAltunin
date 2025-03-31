package lesson18;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MTSMainPage {
    private final WebDriver driver;

    // Локаторы
    private final By cookieButtonLocator = By.cssSelector(".btn.btn_black.cookie__ok");
    private final By paymentFieldsLocator = By.cssSelector("form.pay-form input");

    // Мэппинг идентификаторов полей форм
    private final Map<String, Map<String, String>> formFieldIds = new HashMap<>();
    private static final Map<String, String> paymentOptionMap = new HashMap<>();
    static {
        paymentOptionMap.put("pay-connection", "Услуги связи");
        paymentOptionMap.put("pay-internet", "Домашний интернет");
        paymentOptionMap.put("pay-instalment", "Рассрочка");
        paymentOptionMap.put("pay-arrears", "Задолженность");
    }

    public MTSMainPage(WebDriver driver) {
        this.driver = driver;
        initFormFieldIds();
    }

    public void open() {
        driver.get("https://www.mts.by");
    }

    public void clickCookieButtonIfExists() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator));
            cookieButton.click();
            System.out.println("Cookie button clicked.");
        } catch (TimeoutException e) {
            System.out.println("Cookie button not found or not clickable within the timeout period.");
        }
    }

    public List<String> getPaymentOptionsPlaceholders() {
        List<WebElement> paymentFields = driver.findElements(paymentFieldsLocator);
        return paymentFields.stream()
                .map(element -> element.getAttribute("placeholder"))
                .toList();
    }

    private void initFormFieldIds() {
        // Поля для формы пополнения услуг связи
        Map<String, String> connectionForm = new HashMap<>();
        connectionForm.put("phoneNumber", "connection-phone");
        connectionForm.put("sum", "connection-sum");
        connectionForm.put("email", "connection-email");
        formFieldIds.put("pay-connection", connectionForm);

        // Поля для формы пополнения домашнего интернета
        Map<String, String> internetForm = new HashMap<>();
        internetForm.put("phoneNumber", "internet-phone");
        internetForm.put("sum", "internet-sum");
        internetForm.put("email", "internet-email");
        formFieldIds.put("pay-internet", internetForm);

        // Поля для формы рассрочки
        Map<String, String> instalmentForm = new HashMap<>();
        instalmentForm.put("scoreInstalment", "score-instalment");
        instalmentForm.put("sum", "instalment-sum");
        instalmentForm.put("email", "instalment-email");
        formFieldIds.put("pay-instalment", instalmentForm);

        // Поля для формы задолженности
        Map<String, String> arrearsForm = new HashMap<>();
        arrearsForm.put("scoreArrears", "score-arrears");
        arrearsForm.put("sum", "arrears-sum");
        arrearsForm.put("email", "arrears-email");
        formFieldIds.put("pay-arrears", arrearsForm);
    }
}