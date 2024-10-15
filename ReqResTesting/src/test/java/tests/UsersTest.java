package tests;

import base.TestBase;
import helpers.ApiHelper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsersTest extends TestBase {

    @Test(priority = 1)
    public void CreateUser() {
        String requestBody = ApiHelper.UserPayload("Salwa", "Tester");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/users");

        printPrettyResponse(response);
        assertResponseTime(response);

        response.then()
                .statusCode(201)
                .body("name", equalTo("Salwa"))
                .body("job", equalTo("Tester"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    @Test(priority = 2)
    public void UpdateUser() {
        String requestBody = ApiHelper.UserPayload("Salwa Abdallah", "QA");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/users/2");

        printPrettyResponse(response);
        assertResponseTime(response);

        response.then()
                .statusCode(200)
                .body("name", equalTo("Salwa Abdallah"))
                .body("job", equalTo("QA"))
                .body("updatedAt", notNullValue());
    }

    @Test(priority = 3)
    public void UpdateUserName() {
        String requestBody = ApiHelper.UpdateUserNamePayload("Salwa Abdallah Esmail");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/users/2");

        printPrettyResponse(response);
        assertResponseTime(response);

        response.then()
                .statusCode(200)
                .body("name", equalTo("Salwa Abdallah Esmail"))
                .body("updatedAt", notNullValue());
    }

    @Test(priority = 4)
    public void UpdateUserJob() {
        String requestBody = ApiHelper.UpdateUserJobPayload("Software Test Engineer");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/users/2");

        printPrettyResponse(response);
        assertResponseTime(response);

        response.then()
                .statusCode(200)
                .body("job", equalTo("Software Test Engineer"))
                .body("updatedAt", notNullValue());
    }

    @Test(priority = 5)
    public void DeleteUser() {
        Response response = when()
                .delete("/users/2");

        printPrettyResponse(response);
        assertResponseTime(response);

        response.then()
                .statusCode(204);
    }


    @Test(priority = 6)
    public void GetDeletedUser() {
        Response response = when()
                .get("/users/2");

        printPrettyResponse(response);
        assertResponseTime(response);

        response.then()
                .statusCode(404);
    }


    @Test(priority = 7)
    public void ListPage2Users() {
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users");

        printPrettyResponse(response);
        assertResponseTime(response);

        response.then()
                .statusCode(200)
                .body("data", notNullValue())
                .body("data.size()", greaterThan(0))
                .body("page", equalTo(2))
                .body("support.text", notNullValue());
    }

    @Test(priority = 8)
    public void ListSingleUser() {
        Response response = given()
                .when()
                .get("/users/2");

        printPrettyResponse(response);
        assertResponseTime(response);

        response.then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("support.url", equalTo("https://reqres.in/#support-heading"));
    }

    @Test(priority = 9)
    public void ListSingleUserNotFound() {
        Response response = given()
                .when()
                .get("/users/23");

        printPrettyResponse(response);
        assertResponseTime(response);
        response.then()
                .statusCode(404);
    }
}
