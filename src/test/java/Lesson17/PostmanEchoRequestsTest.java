package Lesson17;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PostmanEchoRequestsTest {
    // Variables
    private static final String EXPECTED_REQUEST_BODY = "This is expected to be sent back as part of response body.";

    // Tests
    @Test
    public void testGetRequest() {
        Map<String, String> requestHeaders = createRequestHeaders();
        Map<String, String> queryParams = createQueryParams();

        Response response = HttpHelper.sendRequest("GET", "/get", null, null, requestHeaders, queryParams, null);

        assertAll(
                () -> assertResponseStatus(response, 200),
                () -> assertQueryParams(response, "foo1", "bar1"),
                () -> assertQueryParams(response, "foo2", "bar2"),
                () -> assertUrlContains(response, "foo1=bar1&foo2=bar2")
        );
    }

    @Test
    public void testRawTextPostRequest() {
        Response response = HttpHelper.sendRequest("POST", "/post", ContentType.TEXT, EXPECTED_REQUEST_BODY, null, null, null);

        assertAll(
                () -> assertResponseStatus(response, 200),
                () -> assertResponseBody(response, EXPECTED_REQUEST_BODY),
                () -> assertContentType(response, "application/json; charset=utf-8")
        );
    }

    @Test
    public void testFormDataPostRequest() {
        Map<String, String> requestHeaders = createRequestHeadersForFormData();
        Map<String, String> formParams = createFormParams();

        Response response = HttpHelper.sendRequest("POST", "/post", null, null, requestHeaders, null, formParams);

        assertAll(
                () -> assertResponseStatus(response, 200),
                () -> assertFormParams(response, "foo1", "bar1"),
                () -> assertFormParams(response, "foo2", "bar2")
        );
    }

    @Test
    public void testPutRequest() {
        Response response = HttpHelper.sendRequest("PUT", "/put", ContentType.TEXT, EXPECTED_REQUEST_BODY, null, null, null);

        assertAll(
                () -> assertResponseStatus(response, 200),
                () -> assertResponseBody(response, EXPECTED_REQUEST_BODY),
                () -> assertContentType(response, "application/json; charset=utf-8")
        );
    }

    @Test
    public void testPatchRequest() {
        Response response = HttpHelper.sendRequest("PATCH", "/patch", ContentType.TEXT, EXPECTED_REQUEST_BODY, null, null, null);

        assertAll(
                () -> assertResponseStatus(response, 200),
                () -> assertResponseBody(response, EXPECTED_REQUEST_BODY),
                () -> assertContentType(response, "application/json; charset=utf-8")
        );
    }

    @Test
    public void testDeleteRequest() {
        Response response = HttpHelper.sendRequest("DELETE", "/delete", null, null, null, null, null);

        assertResponseStatus(response, 200);
    }

    // Helpers
    private Map<String, String> createRequestHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", "sails.sid=s%3AOp_hQBPnud-lcf5epEMZm2N6c7WUPcyM.AG%2BUP5MTfwWATJVkzXdrsc59OJ5fdgg%2BhprA%2F4F22k0");
        return headers;
    }

    private Map<String, String> createQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("foo1", "bar1");
        queryParams.put("foo2", "bar2");
        return queryParams;
    }

    private Map<String, String> createRequestHeadersForFormData() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        return headers;
    }

    private Map<String, String> createFormParams() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("foo1", "bar1");
        formParams.put("foo2", "bar2");
        return formParams;
    }

    // Assertions
    private void assertResponseStatus(Response response, int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode(), "Invalid status code");
    }

    private void assertQueryParams(Response response, String paramName, String expectedValue) {
        assertEquals(expectedValue, response.jsonPath().getString("args." + paramName), "Invalid value for " + paramName + " parameter");
    }

    private void assertUrlContains(Response response, String expectedUrl) {
        assertTrue(response.jsonPath().getString("url").contains(expectedUrl), "URL does not contain expected parameters");
    }

    private void assertResponseBody(Response response, String expectedResponseBody) {
        assertEquals(expectedResponseBody, response.jsonPath().getString("data"), "Response body does not match expected value");
    }

    private void assertContentType(Response response, String expectedContentType) {
        assertEquals(expectedContentType, response.getHeader("content-type"), "Content-Type does not match expected value");
    }

    private void assertFormParams(Response response, String paramName, String expectedValue) {
        assertEquals(expectedValue, response.jsonPath().getString("form." + paramName), "Invalid value for " + paramName + " parameter");
    }
}