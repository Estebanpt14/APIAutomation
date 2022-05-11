package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class APITestSteps {

    private static RequestSpecification requestSpecification;
    private Response response;
    private ValidatableResponse json;

    @Given("^I send a GET request to the endpoint$")
    public void sendGETRequest(){
        requestSpecification = given()
                                .baseUri("https://api.github.com/")
                                .contentType(ContentType.JSON);
    }

    @Then("^I get a (\\d+) status")
    public void validateListOfUsers(int status){
        response = requestSpecification
                .when()
                .get("/users/TheFreeRangeTester/repos");
        json = response.then().statusCode(status);
        Assert.assertNull(null);
    }
}
