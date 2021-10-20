package apimethods.delete;


import apimethods.get.TestPostmanEchoGet1;
import apimethods.post.TestPostmanPetsPost1;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityRunner.class)
public class TestPostmanPetsDelete1 {
    private static Logger logger = LogManager.getLogger(TestPostmanEchoGet1.class);

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
    }

    @Before
    public void createPet() {
        TestPostmanPetsPost1 startMethod = new TestPostmanPetsPost1();
        startMethod.postRequest();
    }

    @Test
    public void deleteCurrentPet() {
        given()
                .header("Content-type", "application/json")
                .when()
                .delete("/769")
                .then()
               // .contentType(ContentType.JSON)
                .assertThat()
                .statusCode(200)
                .and()
                .body("message", notNullValue())
                .log().all();

        logger.info("deleteCurrentPet()  test was passed");
    }
}
