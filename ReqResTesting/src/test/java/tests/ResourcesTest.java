package tests;

import base.TestBase;
import helpers.ApiHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ResourcesTest extends TestBase {

    @Test(priority = 1)
    public void ListResources() {
        Response response = given()
                .when()
                .get("/unknown");

        printPrettyResponse(response);
        assertResponseTime(response);
        response.then()
                .statusCode(200)
                .body("data", notNullValue())
                .body("data.size()", greaterThan(0))
                .body("page", equalTo(1))
                .body("support.text", notNullValue());
    }

    @Test(priority = 2)
    public void ListSingleResources() {
        Response response = given()
                .when()
                .get("/unknown/2");

        printPrettyResponse(response);
        assertResponseTime(response);
        response.then()
                .statusCode(200)
                .body("data", notNullValue())
                .body("data.size()", greaterThan(0))
                .body("support.text", notNullValue());
    }

    @Test(priority = 3)
    public void ListNotFoundResource() {
        Response response = given()
                .when()
                .get("/unknown/23");

        printPrettyResponse(response);
        assertResponseTime(response);
        response.then()
                .statusCode(404);
    }

    @Test(priority =4)
    public void CreateResource() {

        String requestBody = ApiHelper.CreateResourcePayload("Pink", "#FFC0CB");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/unknown");

        printPrettyResponse(response);
        assertResponseTime(response);
        response.then()
                .statusCode(201)
                .body("name", equalTo("Pink"))
                .body("color", equalTo("#FFC0CB"));
    }


    @Test(priority = 5)
    public void UpdateResourceName() {

        String requestBody = ApiHelper.UpdateResourceNamePayload("Green");

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .put("/unknown/2");

        printPrettyResponse(response);
        assertResponseTime(response);
        response.then()
                .statusCode(200)
                .body("name", equalTo("Green"));
    }
    @Test(priority = 6)
    public void UpdateResourceColor() {

        String requestBody = ApiHelper.UpdateResourceColorPayload("#00FF00");

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .put("/unknown/2");

        printPrettyResponse(response);
        assertResponseTime(response);
        response.then()
                .statusCode(200)
                .body("color", equalTo("#00FF00"));
    }

    @Test(priority = 7)
    public void DeleteResource() {
        Response response =
                given()
                        .when()
                        .delete("/unknown/2");

        printPrettyResponse(response);
        assertResponseTime(response);
        response.then()
                .statusCode(204);
    }
}
