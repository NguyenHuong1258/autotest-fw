package api.tests;

import api.utils.PropertyReader;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static PropertyReader prop;

    @BeforeAll
    public static void init(){
        prop = PropertyReader.getInstance();
    }
}
