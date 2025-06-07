package ru.test.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Param;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;
import ru.test.apiHelper.BooksOperations;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BookResp;
import ru.test.model.enums.Category;

import static io.qameta.allure.model.Parameter.Mode.HIDDEN;

public class GetBooksTest extends BaseTest {

    @Test(testName = "Проверка получения списка книг")
    @Description("Тест-кейс проверяет получение листа книг")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testGetBooks(){
        new BooksOperations()
                .createBook(BookReq.defaultOf(), 201)
                .createBook(BookReq.defaultOf(), 201)
                .createBook(BookReq.defaultOf(), 201)
                .createBook(BookReq.defaultOf(), 201)
                .createBook(BookReq.defaultOf(), 201)
                .getBooks(200, 5);
    }

    @AfterClass
    private void clearBooksList(){
        new BooksOperations()
                .getBooks(200)
                .deleteAllBooks(200)
                .getEmptyListBooks();
    }
}



