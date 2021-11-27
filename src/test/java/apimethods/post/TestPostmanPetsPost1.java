package apimethods.post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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

    private String requestBody2 = "{\n" +
            "    \"id\": 777,\n" +
            "    \"category\": {\n" +
            "        \"id\": 217,\n" +
            "        \"name\": \"Category_2\"\n" +
            "    },\n" +
            "    \"name\": \"Tia2\",\n" +
            "    \"photoUrls\": [\n" +
            "        \"http://placeimg.com/640/480648\",\n" +
            "        \"http://placeimg.com/640/480487\",\n" +
            "        \"http://placeimg.com/640/480132\"\n" +
            "    ],\n" +
            "    \"tags\": [\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"name\": \"Ariane1\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "            \"name\": \"Antonietta2\"\n" +
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


    @Test
    public void postRequestParsingResponse() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody2)
                .when()
                .post("/")
                .then()
                .log().all()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("777", response.jsonPath().getString("id"));
        Assertions.assertEquals("Category_2", response.jsonPath().getString("category.name"));


        List<String> userId = Arrays.asList(response.jsonPath().getString("id"));
        assertThat(userId.size(), equalTo(1));

        ResponseBody responseBody = response.getBody();
        PostPetCreation postPetCreations = responseBody.as(PostPetCreation.class);
        System.out.println(postPetCreations);

        String aa = String.valueOf(postPetCreations);
        System.out.println(aa);

        String[] aaa = {aa};
        System.out.println(aaa.length + "!!!!!!!!");

        Assertions.assertEquals(postPetCreations.getName(), "Tia2");
        Assertions.assertEquals(aaa.length, 1);

        logger.info("postRequestParsingResponse() test was passed !!! ");
    }
}

