package ru.test.apiHelper;

import io.qameta.allure.Attachment;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BookResp;
import ru.test.model.classes.response.BooksResp;
import ru.test.model.enums.Category;

import static io.qameta.allure.model.Parameter.Mode.HIDDEN;
import static ru.test.apiHelper.BaseTest.*;

import java.lang.reflect.Method;

public class BooksOperations{

    @Step("Создание книги с {discr}")
    @Attachment
    public BookResp createBook (BookReq reqBook, String discr, int status){
        BookResp respBook = api.post(Endpoints.ADD_BOOK, reqBook)
                                .then()
                                    .statusCode(status)

                                .extract()
                                    .as(BookResp.class);

        Assert.assertEquals(respBook.getTitle(), reqBook.getTitle());
        Assert.assertEquals(respBook.getAuthor(), reqBook.getAuthor());
        Assert.assertEquals(respBook.getDescription(), reqBook.getDescription());
        Assert.assertEquals(respBook.getCategory(), reqBook.getCategory());

        Assert.assertEquals(respBook.getCount(), reqBook.getCount());
        Assert.assertEquals(respBook.getPrice(), reqBook.getPrice());

        return respBook;
    }

    @Step("Создание книги")
    @Attachment
    public BooksOperations createBook (BookReq reqBook, int status){
        BookResp respBook = api.post(Endpoints.ADD_BOOK, reqBook)
                                .then()
                                .statusCode(status)

                                .extract()
                                .as(BookResp.class);

        Assert.assertEquals(respBook.getTitle(), reqBook.getTitle());
        Assert.assertEquals(respBook.getAuthor(), reqBook.getAuthor());
        Assert.assertEquals(respBook.getDescription(), reqBook.getDescription());
        Assert.assertEquals(respBook.getCategory(), reqBook.getCategory());

        Assert.assertEquals(respBook.getCount(), reqBook.getCount());
        Assert.assertEquals(respBook.getPrice(), reqBook.getPrice());

        return this;
    }

    @Step("Получение книги по ID")
    public BooksOperations getTheBook(BookResp reqBook, int status){
        BookResp respBook = api.get(Endpoints.GET_BOOK, reqBook.getId())
                                .then()
                                    .statusCode(status)

                                .extract()
                                    .as(BookResp.class);

        Assert.assertEquals(respBook.getTitle(), reqBook.getTitle());
        Assert.assertEquals(respBook.getAuthor(), reqBook.getAuthor());
        Assert.assertEquals(respBook.getDescription(), reqBook.getDescription());
        Assert.assertEquals(respBook.getCategory(), reqBook.getCategory());

        Assert.assertEquals(respBook.getCount(), reqBook.getCount());
        Assert.assertEquals(respBook.getPrice(), reqBook.getPrice());

        Assert.assertEquals(respBook.getId(), reqBook.getId());
        Assert.assertEquals(respBook.getLastUpdated(), reqBook.getLastUpdated());

        return this;
    }

    @Step("Получения списка книг")
    public BooksOperations getBooks(int status){
        BooksResp books = api.get(Endpoints.GET_BOOKS)
                            .then()
                                .statusCode(status)

                            .extract()
                                .as(BooksResp.class);


        Assert.assertEquals(books.getBooks().size(), books.getSize());

        return this;
    }

    @Step("Получения списка из {count} книг")
    public BooksOperations getBooks(int status, int count){
        BooksResp books = api.get(Endpoints.GET_BOOKS)
                            .then()
                                .statusCode(status)

                            .extract()
                                .as(BooksResp.class);


        Assert.assertEquals(books.getBooks().size(), books.getSize());
        Assert.assertEquals(books.getBooks().size(), count);
        Assert.assertEquals(books.getSize(), count);

        return this;
    }

    @Step("Получить пустой список книг")
    public BooksOperations getEmptyListBooks(){
        api.get(Endpoints.GET_BOOKS)
                .then()
                    .statusCode(404);

        return this;
    }

    @Step("Удалить все книги из списка")
    public BooksOperations deleteAllBooks(int status){
        api.deleteAllBooks(Endpoints.DELETE_BOOKS)
                .then()
                    .statusCode(status);

        return this;
    }


}



