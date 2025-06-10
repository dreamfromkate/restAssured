package ru.test.apiHelper;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BookResp;
import ru.test.model.classes.response.BooksResp;

import static ru.test.apiHelper.BaseTest.*;

public class BooksOperations{

    @Step("Добавление книги {discr}")
    @Attachment(type = "application/json")
    public BookResp createBook (BookReq reqBook, String discr, int expectStatus){
        ValidatableResponse resp = api.post(Endpoints.ADD_BOOK, reqBook).then();

        int actualStatus = resp.extract().statusCode();

        checkStatus(actualStatus, expectStatus);

        if (actualStatus == 400){
            return null;
        }

        BookResp respBook = resp
                .extract()
                .as(BookResp.class);

        checkBodyBook(respBook, reqBook);

        return respBook;
    }

    @Step("Добавление книги")
    public BooksOperations createBook (BookReq reqBook, int expectStatus){
        BookResp respBook = api.post(Endpoints.ADD_BOOK, reqBook)
                                .then()
                                .statusCode(expectStatus)

                                .extract()
                                .as(BookResp.class);

        checkBodyBook(respBook, reqBook);

        return this;
    }

    @Step("Добавление книги")
    public BookResp createBook (BookReq reqBook){
        ValidatableResponse resp = api.post(Endpoints.ADD_BOOK, reqBook)
                                    .then()
                                        .statusCode(201);

        BookResp respBook = resp
                .extract()
                .as(BookResp.class);

        checkBodyBook(respBook, reqBook);

        return respBook;
    }

    @Step("Получение информации о книге по ID")
    public BooksOperations getTheBook(BookResp reqBook, int expectStatus){
        ValidatableResponse resp = api.get(Endpoints.GET_BOOK, reqBook.getId()).then();

        int actualStatus = resp.extract().statusCode();

        checkStatus(actualStatus, expectStatus);

        if (actualStatus == 200){
            BookResp respBook = resp.extract().as(BookResp.class);

            checkBodyBook(respBook, reqBook);

            Assert.assertEquals(respBook.getId(), reqBook.getId());
            Assert.assertEquals(respBook.getLastUpdated(), reqBook.getLastUpdated());
        }

        return this;
    }

    @Step("Получение ошибки при поиске книги по строковому ID")
    public BooksOperations getTheBook(String id, int expectStatus){
        ValidatableResponse resp = api.get(Endpoints.GET_BOOK, id).then();

        int actualStatus = resp.extract().statusCode();

        checkStatus(actualStatus, expectStatus);

        return this;
    }

    @Step("Получение списка книг")
    public BooksOperations getBooks(int size, int expectStatus){
        ValidatableResponse resp = api.get(Endpoints.GET_BOOKS).then();

        int actualStatus = resp.extract().statusCode();

        checkStatus(actualStatus, expectStatus);

        if (actualStatus == 200){
            BooksResp books = resp.extract().as(BooksResp.class);

            Assert.assertEquals(books.getBooks().size(), books.getSize());
            Assert.assertEquals(books.getBooks().size(), size);
            Assert.assertEquals(books.getSize(), size);
        }

        return this;
    }

    @Step("Удалить все книги из списка")
    public BooksOperations deleteAllBooks(int expectStatus){
        api.deleteAllBooks(Endpoints.DELETE_BOOKS)
                .then()
                    .statusCode(expectStatus);

        return this;
    }

    @Step("Удалить книгу по ID")
    public BooksOperations deleteTheBook(BookResp book, int expectStatus){
        api.deleteTheBook(Endpoints.DELETE_BOOK, book.getId())
                .then()
                .statusCode(expectStatus);

        return this;
    }

    @Step("Получиь ошибку при удалении книги по строковому ID")
    public BooksOperations deleteTheBook(String id, int expectStatus){
        api.deleteTheBook(Endpoints.DELETE_BOOK, id)
                .then()
                .statusCode(expectStatus);

        return this;
    }

    @Step("Обновление книги {discr}")
    @Attachment(type = "application/json")
    public BooksOperations updateTheBook (BookReq reqBook, BookResp defaultBook, String discr, int expectStatus){
        ValidatableResponse resp = api.updateTheBook(reqBook, Endpoints.PUT_BOOK, defaultBook.getId()).then();
        int actualStatus = resp.extract().statusCode();

        checkStatus(actualStatus, expectStatus);

        if (actualStatus == 400){
            return this;
        }

        BookResp respBook = resp
                .extract()
                .as(BookResp.class);

        checkBodyBook(respBook, reqBook);

        Assert.assertNotEquals(respBook.getLastUpdated(), defaultBook.getLastUpdated());
        Assert.assertEquals(respBook.getId(), defaultBook.getId());

        return this;
    }

    @Step("Проверка, что информация в книге не обновлилась")
    public BooksOperations checkNoUpdate(BookResp defaultBook){
        ValidatableResponse resp = api.get(Endpoints.GET_BOOK, defaultBook.getId()).then();
        int actualStatus = resp.extract().statusCode();
        checkStatus(actualStatus, 200);

        BookResp respBook = resp
                .extract()
                .as(BookResp.class);

        checkBodyBook(respBook, defaultBook);

        Assert.assertEquals(respBook.getLastUpdated(), defaultBook.getLastUpdated());

        return this;
    }

    @Step("404 ошибка обновления книги")
    @Attachment(type = "application/json")
    public BooksOperations updateTheBook (BookReq reqBook, BookResp defaultBook, int expectStatus){
        ValidatableResponse resp = api.updateTheBook(reqBook, Endpoints.PUT_BOOK, defaultBook.getId()+1).then();
        int actualStatus = resp.extract().statusCode();

        checkStatus(actualStatus, expectStatus);

        return this;
    }

    @Step("400 ошибка обновления книги")
    @Attachment(type = "application/json")
    public BooksOperations updateTheBook (BookReq reqBook, String id, int expectStatus){
        ValidatableResponse resp = api.updateTheBook(reqBook, Endpoints.PUT_BOOK, id).then();
        int actualStatus = resp.extract().statusCode();

        checkStatus(actualStatus, expectStatus);

        return this;
    }



/*    @Step("Получение списка книг")
    public BooksOperations testTest (){


        return this;
    }*/

    private void checkStatus(int actualStatus, int expectStatus) {
        Assert.assertEquals(actualStatus, expectStatus);
    }

    private void checkBodyBook(BookResp respBook, BookReq reqBook) {
        Assert.assertEquals(respBook.getTitle(), reqBook.getTitle());
        Assert.assertEquals(respBook.getAuthor(), reqBook.getAuthor());
        Assert.assertEquals(respBook.getDescription(), reqBook.getDescription());
        Assert.assertEquals(respBook.getCategory(), reqBook.getCategory());

        Assert.assertEquals(respBook.getCount(), reqBook.getCount());
        Assert.assertEquals(respBook.getPrice(), reqBook.getPrice());
    }

    private void checkBodyBook(BookResp respBook, BookResp reqBook) {
        Assert.assertEquals(respBook.getTitle(), reqBook.getTitle());
        Assert.assertEquals(respBook.getAuthor(), reqBook.getAuthor());
        Assert.assertEquals(respBook.getDescription(), reqBook.getDescription());
        Assert.assertEquals(respBook.getCategory(), reqBook.getCategory());

        Assert.assertEquals(respBook.getCount(), reqBook.getCount());
        Assert.assertEquals(respBook.getPrice(), reqBook.getPrice());
    }

}



