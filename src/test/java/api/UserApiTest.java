package api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import utils.ConfigReader;
public class UserApiTest {


	    String baseUrl =
	            ConfigReader.getProperty("baseUrl");

	    @Test
	    public void getUsers() {

	        given()

	        .when()
	            .get(baseUrl + "/users?page=2")

	        .then()
	            .statusCode(200)
	            .body("page", equalTo(2))
	            .body("data.size()", greaterThan(0));

	    }
	    @Test
	    public void loginWithoutPassword() {

	        String payload =
	            "{ \"email\":\"peter@klaven\" }";

	        given()
	            .contentType("application/json")
	            .body(payload)

	        .when()
	            .post(baseUrl + "/login")

	        .then()
	            .statusCode(400)
	            .body("error",
	                 equalTo("Missing password"));
	    }
	    
	    @Test
	    public void createUser() {

	        String payload =
	            "{ \"name\":\"Saddam\", \"job\":\"QA Engineer\" }";

	        given()
	            .contentType("application/json")
	            .body(payload)

	        .when()
	            .post(baseUrl + "/users")

	        .then()
	            .statusCode(201)
	            .body("name",
	                   equalTo("Saddam"))
	            .body("job",
	                   equalTo("QA Engineer"));
	    }
	
}
