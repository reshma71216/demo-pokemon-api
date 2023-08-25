package co.pokeapi.testsuite;

import co.pokeapi.model.PokePojo;
import co.pokeapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PokeTest extends TestBase {
    //Verify to get all poke items
    @Test
    public void getAllPoke() {
        PokePojo pokePojo = new PokePojo();
        Response response = given()
                .body(pokePojo)
                .when()
                .get("/item");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
