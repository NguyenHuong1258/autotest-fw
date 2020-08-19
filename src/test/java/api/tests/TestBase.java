package api.tests;

import api.utils.PropertyReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;


public class TestBase {

    public static PropertyReader prop;


    public static String BASE_URL;
    @BeforeClass
    public static void init(){
        prop = PropertyReader.getInstance();
        RestAssured.baseURI = prop.getBaseUrl();
    }
}
