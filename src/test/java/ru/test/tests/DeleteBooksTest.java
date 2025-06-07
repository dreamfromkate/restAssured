package ru.test.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;
import ru.test.apiHelper.BooksOperations;
import ru.test.model.classes.request.BookReq;

public class DeleteBooksTest extends BaseTest {

    @Test(testName = "Проверка удаления книг из списка")
    @Description("Тест-кейс проверяет удаление всех книг из списка")
    @Owner("Сопова Екатерина Евгеньевна")
    public void testDeleteAllBooks(){
        new BooksOperations()
                .createBook(BookReq.defaultOf(), 201)
                .getBooks(200)
                .deleteAllBooks(200)
                .getEmptyListBooks();
    }
}



