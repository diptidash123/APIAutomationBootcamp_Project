package apitesting_tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import java.io.File;
import static io.restassured.RestAssured.*;

public class Jsonschemavalidator {

    @Test
    public void jsonschemavalidation_file() {

        // 1. JSON Schema file path
        File schema = new File("src/test/resources/JsonSchemaValidator.json");

        // 2. Base URI
        RestAssured.baseURI = "https://reqres.in";

        // 3. Send GET request and validate JSON schema
        Response response =
                given().header("x-api-key","reqres_fcc9716683f34df488a5273f619e3d01")
                .when()
                    .get("/api/users?page=2")
                .then()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchema(schema))
                    .extract()
                    .response();

        System.out.println(response.asString());
    }
}