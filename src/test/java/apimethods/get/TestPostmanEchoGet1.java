package apimethods.get;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.*;

@RunWith(SerenityRunner.class)
public class TestPostmanEchoGet1 {

    private static Logger logger = LogManager.getLogger(TestPostmanEchoGet1.class);

    @Test
    public void checkGetResponseBody() {
        given()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .contentType(ContentType.JSON)
                .assertThat()
                .statusCode(200)
                .and()
                .contentType("application/json; charset=utf-8")
                .and()
                .body("args", hasEntry("foo2","bar2"))
                .and()
                .body("args.foo1", is("bar1"));
        logger.info("checkGetResponseBody() test was passed");
    }

    @Test
    public void checkGetResponseHeader() {
        Response response = given().get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then().extract().response();
        Headers headers = response.getHeaders();
        String headerName = headers.get("set-cookie").getName();
        String headerValue = headers.getValue("set-cookie");
        assertThat(headerName, equalTo("set-cookie"));
        assertThat(headerValue, notNullValue());

        logger.info("checkGetResponseHeader() test was passed !!! ");
        }
}

