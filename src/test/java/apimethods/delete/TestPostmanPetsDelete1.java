package apimethods.delete;


import apimethods.get.TestPostmanEchoGet1;
import apimethods.post.TestPostmanPetsPost1;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityRunner.class)
public class TestPostmanPetsDelete1 {
    private static Logger logger = LogManager.getLogger(TestPostmanEchoGet1.class);
    private TestPostmanPetsPost1 startMethod;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
    }

    @Before
    public void createPet() {
        startMethod = new TestPostmanPetsPost1();
        startMethod.postRequest();
    }

    @Test
    public void deleteCurrentPet() {
      Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/769")
                .then()
                .log().all()
                .extract()
                .response();
             /*   .then()
                // .contentType(ContentType.JSON)
                .assertThat()
                .statusCode(200)
                .and()
                .body("message", notNullValue())*/


        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.statusCode()).isEqualTo(200);
       // assertThat(response.jsonPath().getString("message"), notNullValue());
        softAssertions.assertThat(response.jsonPath().getString("message")).isNotNull();

        logger.info("deleteCurrentPet()  test was passed");
    }
}
