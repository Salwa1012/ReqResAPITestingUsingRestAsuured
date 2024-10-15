package tests;

import base.TestBase;
import helpers.ApiHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(priority = 1)
    public void successfulLogin() {
        String requestPayload = ApiHelper.SuccessfulPayload("eve.holt@reqres.in", "pistol");

        Response response =
                RestAssured.given()
                        .contentType("application/json")
                        .body(requestPayload)
                        .when()
                        .post("/login");

        printPrettyResponse(response);
        assertResponseTime(response);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("token"));

    }
    @Test(priority = 2)
    public void UnsuccessfulLoginMissingEmail() {
        String requestPayload = ApiHelper.UnSuccessfulMissingEmailPayload( "pistol");

        Response response =
                RestAssured.given()
                        .contentType("application/json")
                        .body(requestPayload)
                        .when()
                        .post("/login");

        printPrettyResponse(response);
        assertResponseTime(response);
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(response.jsonPath().getString("error"), "Missing email or username");

    }
    @Test(priority = 3)
    public void UnsuccessfulLoginMissingPassword() {
        String requestPayload = ApiHelper.UnSuccessfulMissingPassPayload("eve.holt@reqres.in");

        Response response =
                RestAssured.given()
                        .contentType("application/json")
                        .body(requestPayload)
                        .when()
                        .post("/login");

        printPrettyResponse(response);
        assertResponseTime(response);
        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(response.jsonPath().getString("error"), "Missing password");

    }
}
