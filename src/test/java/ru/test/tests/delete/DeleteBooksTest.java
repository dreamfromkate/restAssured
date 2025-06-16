package ru.test.tests.delete;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;
import ru.test.apiHelper.BooksOperations;
import ru.test.model.classes.request.BookReq;

public class DeleteBooksTest extends BaseTest {

    @Test(testName = "Проверка удаления книг из списка")
    @Epic("Магазин книг")
    @Feature("Очистка спика книг")
    @Story("Удаление всех книг в списке")

    @Description("Тест-кейс проверяет удаление всех книг из списка")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testDeleteAllBooks(){
        new BooksOperations()
                .createBook(BookReq.defaultOf(), 201)
                .getBooks(1,200)
                .deleteAllBooks(200)
                .getBooks(404);
    }
}



