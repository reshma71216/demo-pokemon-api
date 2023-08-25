package co.pokeapi.testbase;

import co.pokeapi.utils.TestUtils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase extends TestUtils {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://pokeapi.co/";
        RestAssured.basePath = "/api/v2/";
    }
}
