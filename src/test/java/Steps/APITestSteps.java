package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APITestSteps {

    private static RequestSpecification requestSpecification;
    private Response response;
    private ValidatableResponse json;

    @Given("^I send a GET request to the (.+) URI$")
    public void sendGETRequest(String URI){
        requestSpecification = given()
                                .baseUri(URI)
                                .contentType(ContentType.JSON);
    }

    @Then("^I get a (\\d+) status$")
    public void validateListOfUsers(int status){
        response = requestSpecification
                .when()
                .get("/users/TheFreeRangeTester/repos");
        json = response.then().statusCode(status);
    }

    @Then("^I validate they are (\\d+) items on the (.+) endpoint$")
    public void validateSize(int expectedSize, String endPoint){
        response = requestSpecification
                .when()
                .get(endPoint);

        List<String> jsonResponse = response.jsonPath().getList("$");
        Assert.assertEquals(expectedSize, jsonResponse.size());
    }
}
