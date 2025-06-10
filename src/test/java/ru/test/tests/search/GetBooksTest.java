package ru.test.tests.search;

import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;
import ru.test.apiHelper.BooksOperations;
import ru.test.model.classes.request.BookReq;

public class GetBooksTest extends BaseTest {
    private int size = 5;

    @Test(description = "Проверка получения списка книг")

    @Epic("Магазин книг")
    @Feature("Получение информации по книгам")
    //@Story("Получение информации по всем книгам")

    @Description("Тест-кейс проверяет получение листа книг")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testGetBooks(){
        new BooksOperations()
                .getBooks(size,200);
    }

    @BeforeClass
    @Description("Добавление книг в список")
    private void addBooks(){
        new BooksOperations()
                .createBook(BookReq.defaultOf(), 201)
                .createBook(BookReq.defaultOf(), 201)
                .createBook(BookReq.defaultOf(), 201)
                .createBook(BookReq.defaultOf(), 201)
                .createBook(BookReq.defaultOf(), 201);
    }

    @AfterClass
    @Description("Очистка списка книг, после выполенния теста")
    private void clearBooksList(){
        new BooksOperations()
                .getBooks(size,200)
                .deleteAllBooks(200)
                .getBooks(size,404);
    }
}



