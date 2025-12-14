package apitesting_tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import core.statusCode_validator;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AutomateRequestBody_JSON 

{
  //automate request body using JSON external file for POST/PUT/PATCH methods.
  String BaseURL="https://reqres.in/";
  String Apikey_value="reqres_fcc9716683f34df488a5273f619e3d01";
      @Test
      public void automation_post_requestbodywithJSON() throws IOException {

          // Step 1: Set base URI
          RestAssured.baseURI = BaseURL;

          // Step 2: Read JSON file
          FileInputStream fis = new FileInputStream(
                  new File("src/test/resources/testdata/postrequestbody.json"));

          String requestBody = IOUtils.toString(fis, "UTF-8");

          // Step 3: Send POST request
          Response response =
                  given()
                      .contentType(ContentType.JSON)
                      .header("x-api-key", Apikey_value)
                      .body(requestBody)
                  .when()
                      .post("/api/users")
                  .then()
                      .statusCode(statusCode_validator.created.code)
                      .extract()
                      .response();

          System.out.println(response.asString());
      }
      
      @Test
      public void automation_put_requestbodywithJSON() throws IOException {

          // Step 1: Set base URI
          RestAssured.baseURI = BaseURL;

          // Step 2: Read JSON file
          FileInputStream fis = new FileInputStream(
                  new File("src/test/resources/testdata/putrequestbody.json"));

          String requestBody = IOUtils.toString(fis, "UTF-8");

          // Step 3: Send POST request
          Response response =
                  given()
                      .contentType(ContentType.JSON)
                      .header("x-api-key", Apikey_value)
                      .body(requestBody)
                  .when()
                      .put("/api/users/2")
                  .then()
                      .statusCode(statusCode_validator.success.code)
                      .extract()
                      .response();

          System.out.println(response.asString());
      }
      
      @Test
      public void automation_patch_requestbodywithJSON() throws IOException {

          // Step 1: Set base URI
          RestAssured.baseURI = BaseURL;

          // Step 2: Read JSON file
          FileInputStream fis = new FileInputStream(
                  new File("src/test/resources/testdata/patchrequestbody.json"));

          String requestBody = IOUtils.toString(fis, "UTF-8");

          // Step 3: Send POST request
          Response response =
                  given()
                      .contentType(ContentType.JSON)
                      .header("x-api-key", Apikey_value)
                      .body(requestBody)
                  .when()
                      .patch("/api/users/2")
                  .then()
                      .statusCode(statusCode_validator.success.code)
                      .extract()
                      .response();

          System.out.println(response.asString());
      }
  }