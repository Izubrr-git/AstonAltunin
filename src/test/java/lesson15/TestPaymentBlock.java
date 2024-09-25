package lesson15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPaymentBlock {
    private WebDriver driver;
    private WebDriverWait wait;

    public void clickCookieButtonIfExists() {
        // Ищем элемент с классом .btn.btn_black.cookie__ok
        List<WebElement> continueButtons = driver.findElements(By.cssSelector(".btn.btn_black.cookie__ok"));

        // Проверяем, существует ли такой элемент
        if (!continueButtons.isEmpty()) {
            // Если элемент существует, нажимаем на кнопку
            WebElement continueButton = continueButtons.get(0);
            continueButton.click();
            System.out.println("Cookie button clicked.");
        } else {
            // Если элемента нет, выводим сообщение
            System.out.println("Cookie button not found. No action taken.");
        }
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.mts.by");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Находим кнопку "Принять куки" и нажимаем на неё
        clickCookieButtonIfExists();
    }

    @Test
    public void testH2Title() {
        // Находим элемент h2 внутри нужного блока
        WebElement h2Element = driver.findElement(By.cssSelector(".pay h2"));

        // Получаем текст заголовка h2
        String h2Text = h2Element.getText().replaceAll("\n"," ");;

        // Проверяем, что текст заголовка совпадает с "Онлайн пополнение без комиссии"
        assertEquals("Онлайн пополнение без комиссии", h2Text);
    }

    @Test
    public void testPartnersLogos() {

        // Находим все изображения внутри блока pay__partners
        List<WebElement> logoElements = driver.findElements(By.cssSelector(".pay__partners ul li img"));

        // Создаем список для хранения alt текстов
        List<String> actualAltTexts = new ArrayList<>();

        // Проходим по каждому найденному элементу и добавляем его alt в список
        for (WebElement logo : logoElements) {
            actualAltTexts.add(logo.getAttribute("alt"));
        }

        // Ожидаемые значения alt атрибутов
        String[] expectedAltTexts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};

        // Проверяем, совпадают ли массивы в том же порядке
        Assertions.assertArrayEquals(expectedAltTexts, actualAltTexts.toArray(), "Список alt текстов не совпадает с ожидаемым");
    }

    @Test
    public void testLink() {
        // Находим элемент ссылки с текстом "Подробнее о сервисе"
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));

        // Проверяем, что href соответствует ожидаемому значению
        String expectedHref = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualHref = link.getAttribute("href");

        // Проверка относительного URL (может содержать домен, поэтому используем contains)
        assert(Objects.requireNonNull(actualHref).contains(expectedHref));

        // Нажимаем на ссылку
        link.click();

        // Ожидаемый полный URL после перехода
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        // Ожидание, пока URL изменится на ожидаемый
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Проверяем, что URL совпадает с ожидаемым
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "URL после перехода не совпадает с ожидаемым");
    }

    @Test
    public void testFormSubmission() {
        // Находим поле для ввода номера телефона и вводим тестовый номер
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        phoneNumberInput.sendKeys("297777777");

        // Находим поле для ввода суммы пополнения и вводим тестовую сумму
        WebElement additionSumInput = driver.findElement(By.id("connection-sum"));
        additionSumInput.sendKeys("200");

        // Находим кнопку "Продолжить" и нажимаем на неё
        WebElement continueButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[text()='Продолжить']"));
        continueButton.click();


        // Ждем, пока появится элемент, подтверждающий успешную отправку формы
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bepaid-iframe")));

        // Проверяем, что сообщение об успешной отправке формы отображается
        Assertions.assertTrue(iframe.isDisplayed(), "Форма не была отправлена успешно");
    }



    @AfterEach
    public void tearDown() {
        // Закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
