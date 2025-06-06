package ru.test.tests;

import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;

import ru.test.apiHelper.Endpoints;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BooksResp;
import ru.test.model.enums.Category;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateBookTest extends BaseTest {

    @Test
    public void testCreateBook(){
        BookReq bookReq = new BookReq("The Adventures of Tom Sawyer",
                            "Mark Twain",
                        "The story about Tom Sawyer.",
                                  Category.Adventures,
                            10,
                            250);

        api.post(Endpoints.ADD_BOOK, bookReq);

    }

    @Test
    public void testGetBooks(){
        BooksResp books = api.get(Endpoints.GET_BOOKS).as(BooksResp.class);

        System.out.println(books);
    }
}
