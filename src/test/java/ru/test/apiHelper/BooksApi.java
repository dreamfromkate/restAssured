package ru.test.apiHelper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.test.model.classes.request.BookReq;

import static io.restassured.RestAssured.given;
import static ru.test.apiHelper.BaseTest.props;

public class BooksApi {
    public BooksApi(){
        RestAssured.baseURI = props.getProperty("uri");
    }

    public Response post (String endpoint, BookReq body){
        return given()
                    .contentType(ContentType.JSON)
                    .body(body)
                .when()
                    .post(endpoint);
    }

    /*public Response get (String endpoint){
        return given()
                    .queryParam("from", "one")
                    .contentType(ContentType.JSON)
                .when()
                    .get(endpoint);
    }*/

    public Response get (String endpoint, int path){
        return given()
                .contentType(ContentType.JSON)

                .when()
                    .get(endpoint, path);
    }

    public Response get (String endpoint, String path){
        return given()
                .contentType(ContentType.JSON)

                .when()
                    .get(endpoint, path);
    }

    public Response get (String endpoint){
        return given()
                .queryParam("perPage", 100)
                .contentType(ContentType.JSON)

                .when()
                .get(endpoint);
    }

    public Response deleteAllBooks(String endpoint){
        return given()
                .contentType(ContentType.JSON)

                .when()
                    .delete(endpoint);
    }

    public Response deleteTheBook (String endpoint, String path){
        return given()
                .contentType(ContentType.JSON)

                .when()
                    .delete(endpoint, path);
    }

    public Response deleteTheBook (String endpoint, int path){
        return given()
                .contentType(ContentType.JSON)

                .when()
                    .delete(endpoint, path);
    }

    public Response updateTheBook (BookReq book, String endpoint, int path){
        return given()
                    .contentType(ContentType.JSON)
                    .body(book)

                .when()
                    .put(endpoint, path);
    }

    public Response updateTheBook (BookReq book, String endpoint, String path){
        return given()
                .contentType(ContentType.JSON)
                .body(book)

                .when()
                .put(endpoint, path);
    }
}
