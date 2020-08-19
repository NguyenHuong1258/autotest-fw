package api.tests;

import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITest extends TestBase{

    private  String BASE_PATH = "/posts";

    @Feature("Test Get Method")
    @Test(description = "get info postId = 1")
    public void getContentPostId(){

        RestAssured.basePath = BASE_PATH;
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/1");
                response.prettyPrint();
                response.then().
                        statusCode(200).
                        body("title", equalToIgnoringCase("post 1"));
    }
}
