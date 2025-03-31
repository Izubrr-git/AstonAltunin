package Lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import java.util.Map;

public class HttpHelper {

    // Метод для отправки HTTP запросов
    public static Response sendRequest(String method, String endpoint, ContentType contentType, String body, Map<String, String> headers, Map<String, String> queryParams, Map<String, String> formParams) {
        // Устанавливаем базовый URI
        RestAssured.baseURI = "https://postman-echo.com";

        // Создаем запрос
        var request = RestAssured.given();

        // Добавляем заголовки, если они есть
        if (headers != null) {
            headers.forEach(request::header);
        }

        // Добавляем параметры запроса, если они есть
        if (queryParams != null) {
            queryParams.forEach(request::queryParam);
        }

        // Устанавливаем Content-Type, если он задан
        if (contentType != null) {
            request.contentType(contentType);
        }

        // Устанавливаем тело запроса, если оно задано
        if (body != null) {
            request.body(body);
        }

        // Добавляем параметры формы, если они есть
        if (formParams != null) {
            formParams.forEach(request::formParam);
        }

        // Выполняем запрос в зависимости от метода
        Response response = switch (method.toUpperCase()) {
            case "GET" -> request.when().get(endpoint);
            case "POST" -> request.when().post(endpoint);
            case "PUT" -> request.when().put(endpoint);
            case "PATCH" -> request.when().patch(endpoint);
            case "DELETE" -> request.when().delete(endpoint);
            default -> throw new UnsupportedOperationException("Unsupported HTTP method: " + method);
        };

        return response;
    }
}
