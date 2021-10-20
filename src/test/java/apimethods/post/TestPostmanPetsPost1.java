package apimethods.post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class TestPostmanPetsPost1 {

    private static Logger logger = LogManager.getLogger(TestPostmanPetsPost1.class);

    private String requestBody = "{\n" +
            "    \"id\": 769,\n" +
            "    \"category\": {\n" +
            "        \"id\": 215,\n" +
            "        \"name\": \"Category_1\"\n" +
            "    },\n" +
            "    \"name\": \"Tia\",\n" +
            "    \"photoUrls\": [\n" +
            "        \"http://placeimg.com/640/480648\",\n" +
            "        \"http://placeimg.com/640/480487\",\n" +
            "        \"http://placeimg.com/640/480132\"\n" +
            "    ],\n" +
            "    \"tags\": [\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"name\": \"Ariane\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "            \"name\": \"Antonietta\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"status\": \"available\"\n" +
            "}";

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
    }

    @Test
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/")
                .then()
                .log().all()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("769", response.jsonPath().getString("id"));
        Assertions.assertEquals("Category_1", response.jsonPath().getString("category.name"));

        assertThat(response.header("Access-Control-Allow-Methods"), equalTo("GET, POST, DELETE, PUT"));

        logger.info("postRequest() test was passed !!! ");
    }
}

