import io.restassured.response.Response
import org.junit.Assert
import org.testng.annotations.Test
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.RestAssured.*

class Books extends Base{

    @Test(groups = "smoke")
    void getBookList(){
        Response response = get("/books")

        List<String> allBooks = response.path("data.title")
        Assert.assertTrue(!allBooks.isEmpty(), "No books returned")
    }

    @Test
    void booksSchemaIsValid(){
        get("/books").then().assertThat().body(matchesJsonSchemaInClasspath("booksSchema.json"))
    }

    @Test
    void createBook(){

    }
}
