package co.pokeapi.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class PokeAssertion {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://pokeapi.co/api/v2";
        //RestAssured.basePath = "/api/v2/";
        response = given()
                .when()
                .get("/item")
                .then().statusCode(200);
    }

    //1. Check the single ‘Name’ in the Array list (master-ball)
    @Test
    public void test001() {
        response.body("results.name",hasItem("master-ball"));
    }

    //2. Verify the 3rd record
    @Test
    public void test002(){
        response.body("results[2].name", equalTo("great-ball"));
    }

    //3. Verify the if the total record is 20
    @Test
    public void test003() {
        response = given()
                .when()
                .get("/item?offset=20&limit=20")
                .then().statusCode(200);
        List<?> total = response.extract().path("results.name");
        Assert.assertEquals(total.size(), 20);
    }
}
