package tests;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DelayedResponseTest extends TestBase {

    @Test(priority = 1)
    public void delayTest() {

        Response response = RestAssured
                .given()
                .get("https://reqres.in/api/users?delay=3");
        printPrettyResponse(response);
        assertResponseTime(response);
        response
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(5000L));

    }
}
