package co.pokeapi.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PokeExtraction {
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

    //1. Extract the name of items
    @Test
    public void test001() {
        List<String> listOfName = response.extract().path("results.name");
        System.out.println("Extract all item names are : " + listOfName);
    }

    //2. Extract the url of items
    @Test
    public void test002() {
        List<?> url = response.extract().path("results.url");
        System.out.println("Extract all item url are : " + url);
    }
}
