package base;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class TestBase {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    protected void printPrettyResponse(Response response) {
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Response: ");
        response.prettyPrint();
    }
    private static final long MAX_RESPONSE_TIME_MS = 10000L; // Change to your preferred value

    protected void assertResponseTime(Response response) {
        response.then()
                .time(lessThan(MAX_RESPONSE_TIME_MS));
    }
}
