package Steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class Autentication {
    public static String clientID = "";
    public static String redirectURI = "";
    public static String scope = "";
    public static String username = "";
    public static String password = "";
    public static String grantType = "";
    public static String accessToken = "";

    public static String encode(String url, String url2){
        return new String (Base64.getEncoder().encode((url+":"+url2).getBytes()));
    }

    public static Response getCode(){
        String authorization = encode(username, password);
        return
                given()
                .header("authorization", "Basic"+authorization)
                .contentType(ContentType.URLENC)
                .formParam("response_type", "code")
                .queryParam("client_id", clientID)
                .queryParam("redirect_uri", redirectURI)
                .queryParam("scope", scope)
                .post("/oath-authorization")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static String parseForOauthCode(Response response){
        return response.jsonPath().getString("code");
    }

    public static Response getToken(String oauthCode){
        String authorization = encode(username, password);
        return
                given()
                .header("authorization", "Basic"+authorization)
                .contentType(ContentType.URLENC)
                .formParam("response_type", oauthCode)
                .queryParam("redirect_uri", redirectURI)
                .queryParam("grant_type", grantType)
                .post("/oath-authorization")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static String parseForToken(Response response){
        return response.jsonPath().getString("access_token");
    }

    public static void getFinalService(){
        given().auth()
                .oauth2(accessToken)
                .when()
                .get("/service")
                .then()
                .statusCode(200);
    }
}
