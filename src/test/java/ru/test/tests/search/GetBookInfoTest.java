package ru.test.tests.search;

import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;
import ru.test.apiHelper.BooksOperations;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BookResp;

public class GetBookInfoTest extends BaseTest {
    private int size = 1;
    private BookResp respBook;

    @Test(description = "Проверка получения инофрмации по книге")

    @Epic("Магазин книг")
    @Feature("Получение информации по книгам")
    //@Story("Получение информации по книге")

    @Description("Тест-кейс проверяет получение информации по книге")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testGetBooks(){
        new BooksOperations().getTheBook(respBook, 200);
    }


    @Test(description = "Проверка получения ошибки при получении информации по не существующей книге")

    @Epic("Магазин книг")
    @Feature("Получение информации по книгам")
    //@Story("Получение информации по книге")

    @Description("Тест-кейс проверяет получение ошибки 404 при получении информации по книге")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testGetError404(){
        int id = respBook.getId() + 1;
        respBook.setId(id);

        new BooksOperations().getTheBook(respBook, 404);
    }

    @Test(description = "Проверка получения ошибки 400 при получении информации по книге")

    @Epic("Магазин книг")
    @Feature("Получение информации по книгам")
    //@Story("Получение информации по книге")

    @Description("Тест-кейс проверяет получение ошибки при отправки невалидного идентификатора книги")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testGetError400(){
        new BooksOperations().getTheBook("String", 400);
    }

    @BeforeClass
    @Description("Добавление книг в список")
    private void addBooks(){
        respBook = new BooksOperations().createBook(BookReq.defaultOf());
    }

    @AfterClass
    @Description("Очистка списка книг, после выполенния теста")
    private void clearBooksList(){
        new BooksOperations()
                .getBooks(size,200)
                .deleteAllBooks(200)
                .getBooks(404);
    }
}



