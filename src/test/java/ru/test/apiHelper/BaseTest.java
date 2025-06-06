package ru.test.apiHelper;

import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;

public class BaseTest {

    public static BooksApi api;

    static {
        api = new BooksApi();
    }

}
