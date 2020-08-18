package api.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest extends TestBase{

    private static final String BASE_URL = prop.getBaseUrl();

    @Feature("Test Get Method")
    @Test(description = "get info postId = 1")
    public void getContentPosts(){
        RestAssured.baseURI = BASE_URL;
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("typicode/demo/posts/1")
                .then().assertThat().statusCode(200);
    }

}
