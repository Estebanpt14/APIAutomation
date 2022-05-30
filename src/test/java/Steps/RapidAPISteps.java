package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RapidAPISteps {

    private RequestSpecification requestSpecification;
    private Response response;
    private ValidatableResponse json;
    private String accessToken;


    @Given("^I have a valid API key for the (.+) URI$")
    public void APIKey(String URI){
        requestSpecification = given()
                .header("X-RapidAPI-Host","bravenewcoin.p.rapidapi.com")
                .header("X-RapidAPI-Key", "89f67d1c99msh67a6f772cc246a6p107ba0jsn94b856abd0c0")
                .baseUri(URI).contentType(ContentType.JSON)
                .log().all();
    }

    @When("^I send a POST request with a valid body to the endpoint (.+)$")
    public void sendPOSTRequest(String endpoint){
        /*JSONParser jsonParser = new JSONParser();
        Object jsonData = jsonParser.parse(new FileReader("src/test/sources/payLoads/TokenGettableJson.json"));
        JSONObject json = (JSONObject) jsonData;*/

        JSONObject json = new JSONObject();
        json.put("audience", "https://api.bravenewcoin.com");
        json.put("grant_type","client_credentials");
        json.put("client_id", "oCdQoZoI96ERE9HY3sQ7JmbACfBf55RY");

        response = requestSpecification.when().body(json.toString()).post(endpoint).prettyPeek();
    }

    @Then("^I can validate I received a valid token in the response$")
    public void validateValidToken(){
        json = response.then().statusCode(200);
    }
}













