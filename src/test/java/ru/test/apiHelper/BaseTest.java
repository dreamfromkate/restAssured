package ru.test.apiHelper;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.expect;

public class BaseTest {
    public static ResponseSpecification RESP200 = expect().statusCode(200);
    public static ResponseSpecification RESP201 = expect().statusCode(201);
    public static ResponseSpecification RESP400 = expect().statusCode(400);
    public static ResponseSpecification RESP404 = expect().statusCode(404);

    public static Properties props;
    public static BooksApi api;

    static {
        String service = "config";

        InputStream is = ClassLoader.getSystemResourceAsStream(service + ".properties");
        props = new Properties();

        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        api = new BooksApi();
    }

}
