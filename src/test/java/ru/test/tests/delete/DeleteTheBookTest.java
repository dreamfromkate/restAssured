package ru.test.tests.delete;

import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;
import ru.test.apiHelper.BooksOperations;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BookResp;

public class DeleteTheBookTest extends BaseTest {
    private BookResp respBook;

    @Test(description = "Проверка удаления книги по идентификатору", priority = 1)
    @Epic("Магазин книг")
    @Feature("Очистка спика книг")
    //@Story("Удаление всех книг в списке")

    @Description("Тест-кейс проверяет удаление книги из списка по идентификатору")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testDeleteTheBook(){
        new BooksOperations()
                .getTheBook(respBook,200)
                .deleteTheBook(respBook, 200)
                .getTheBook(respBook,404);
    }

    @Test(description = "Проверка получения ошибки 404 при удалении книги", priority = 2)
    @Epic("Магазин книг")
    @Feature("Очистка спика книг")

    @Description("Тест-кейс проверяет получение ошибки 404 при удалении книги по не существующему идентификатору")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testDeleteError404(){
        new BooksOperations()
                .getTheBook(respBook,404)
                .deleteTheBook(respBook, 404);
    }

    @Test(description = "Проверка получения ошибки 400 при удаления книги по идентификатору", priority = 3)
    @Epic("Магазин книг")
    @Feature("Очистка спика книг")

    @Description("Тест-кейс проверяет получение ошибки 400 при удалении книги из списка по не валидному идентификатору")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testDeleteError400(){
        new BooksOperations().deleteTheBook("String", 400);
    }


    @BeforeClass
    @Description("Добавление книг в список")
    private void addBooks(){
        respBook = new BooksOperations().createBook(BookReq.defaultOf());
    }
}



