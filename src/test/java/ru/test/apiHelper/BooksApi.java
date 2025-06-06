package ru.test.apiHelper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import ru.test.model.classes.request.BookReq;

import static io.restassured.RestAssured.given;

public class BooksApi {

    private final String URI = "http://localhost:8080/";

    public BooksApi(){
        RestAssured.baseURI = URI;
    }

    public Response post (String endpoint, BookReq body){
        return given()
                    .contentType(ContentType.JSON)
                    .body(body)
                .when()
                    .post(endpoint);
    }

    public Response get (String endpoint){
        return given()
                    .contentType(ContentType.JSON)
                .when()
                    .get(endpoint);
    }
}
