import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.junit.BeforeClass

class Base{
    @BeforeClass
    static void setupRestAssured(){
        RestAssured.baseURI = "https://qa-library-dev.herokuapp.com"
        RestAssured.basePath = "/api/"
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                                                            .addHeader("Content-Type", ContentType.JSON.tostring())
                                                            .addHeader("Accept", ContentType.JSON.tostring())
                                                            .build().log().all()
        RestAssured.requestSpecification = requestSpecification
    }
}
