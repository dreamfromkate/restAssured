import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import ru.test.model.classes.Book;
import ru.test.model.enums.Category;

import static io.restassured.RestAssured.given;

public class CreateBookTest {

    @Test
    public  void testCreateBook(){
        Book book = new Book("The Adventures of Tom Sawyer", "Mark Twain", "The story about Tom Sawyer.", Category.Adventures, 10, 250);

        given()
                .baseUri("http://localhost:8080/rest-api")
                .basePath("/books")
                .contentType(ContentType.JSON)
                .body(book)
                .log().all()

                .when()
                    .post()

                .then()
                    .assertThat()
                        .statusCode(201)
                        .body("id", Matchers.notNullValue())
                        .body("title", Matchers.equalTo(book.getTitle()))
                        .body("description", Matchers.equalTo(book.getDescription()))
                        .body("author", Matchers.equalTo(book.getAuthor()))
                        .body("price", Matchers.equalTo(book.getPrice()))
                        .body("count", Matchers.equalTo(book.getCount()))
                        .body("category", Matchers.equalTo(book.getCategory().toString()))
                        .log().all();

    }
}
