package lesson16;

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
    private final WebDriverWait wait;

    // Локаторы
    private final By cookieButtonLocator = By.cssSelector(".btn.btn_black.cookie__ok");
    private final By h2TitleLocator = By.cssSelector(".pay h2");
    private final By partnerLogosLocator = By.cssSelector(".pay__partners ul li img");
    private final By moreInfoLinkLocator = By.linkText("Подробнее о сервисе");
    private final By bepaidIframeLocator = By.cssSelector(".bepaid-iframe");
    private final By inputFieldAlertLocator = By.cssSelector(".pay__forms input.invalid");
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public String getH2Title() {
        return driver.findElement(h2TitleLocator).getText().replaceAll("\n", " ");
    }

    public List<String> getPartnerLogoAltTexts() {
        return driver.findElements(partnerLogosLocator)
                .stream()
                .map(element -> element.getAttribute("alt"))
                .collect(Collectors.toList());
    }

    public void selectPaymentOption(String paymentOption) {
        // Находим элемент <select>
        WebElement selectElement = driver.findElement(By.cssSelector(".select__now"));

        // Кликаем на элемент <select>, чтобы открыть выпадающий список
        selectElement.click();

        // Находим нужный элемент <option> по атрибуту data-open
        WebElement optionElement = driver.findElement(By.xpath("//p[@class='select__option' and text()='" + paymentOption + "']"));

        // Кликаем на найденный элемент <option>
        optionElement.click();
    }

    public String getMoreInfoLinkHref() {
        return driver.findElement(moreInfoLinkLocator).getAttribute("href");
    }

    public void clickMoreInfoLink() {
        driver.findElement(moreInfoLinkLocator).click();
    }

    public boolean isBepaidIframeDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bepaidIframeLocator)).isDisplayed();
    }

    public boolean isInternetConfirmationDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inputFieldAlertLocator)).isDisplayed();
    }
    public boolean isInstalmentConfirmationDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inputFieldAlertLocator)).isDisplayed();
    }
    public boolean isArrearsConfirmationDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inputFieldAlertLocator)).isDisplayed();
    }

    public void waitForUrl(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
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

    public FormBuilder startFillingForm(String formName) {
        // Получаем название опции на основании formName
        String paymentOption = paymentOptionMap.get(formName);
        selectPaymentOption(paymentOption);
        return new FormBuilder(formName);
    }

    public class FormBuilder {
        private final Map<String, String> formData = new HashMap<>();
        private final String formName;

        public FormBuilder(String formName) {
            this.formName = formName;
        }

        public FormBuilder withField(String fieldName, String value) {
            formData.put(fieldName, value);
            return this;
        }

        public void submit(String submitButtonText) {
            fillForm();
            clickSubmitButton(submitButtonText);
        }

        private void fillForm() {
            Map<String, String> fieldIds = formFieldIds.get(formName);
            if (fieldIds == null) {
                throw new IllegalStateException("Unknown form: " + formName);
            }

            for (Map.Entry<String, String> entry : formData.entrySet()) {
                String fieldId = fieldIds.get(entry.getKey());
                WebElement field = wait.until(ExpectedConditions.elementToBeClickable(By.id(fieldId)));
                field.sendKeys(entry.getValue());
            }
        }

        private void clickSubmitButton(String buttonText) {
            WebElement submitButton = driver.findElement(By.xpath("//form[@id='" + formName + "']//button[text()='Продолжить']"));
            submitButton.click();
        }
    }
}