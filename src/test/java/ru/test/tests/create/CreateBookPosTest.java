package ru.test.tests.create;

import io.qameta.allure.*;
import org.testng.annotations.*;
import ru.test.apiHelper.BaseTest;

import ru.test.apiHelper.BooksOperations;
import ru.test.apiHelper.dataProvide.BookData;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BookResp;

public class CreateBookPosTest extends BaseTest {

    @Test(dataProvider = "positive", dataProviderClass = BookData.class,
            description = "Проверка создания книги с валидными данными")

    @Epic("Магазин книг")
    @Feature("Добавление книг")
    @Story("Добавление книг с валидными данными")

    @Description("Тест-кейс производит проверку: " +
            "\n    - добавления книг с валидными данными;" +
            "\n    - минимальных и/или максимальных граничных допустимых значений параметров:" +
            "\n        -- количество книг;" +
            "\n        -- стоимости книги;" +
            "\n        -- наименования книги;" +
            "\n        -- автора книги;" +
            "\n        -- описания книги;" +
            "\n    - получение информации конкретной книги по ID")

    @Owner("Сопова Екатерина Евгеньевна")
    public void testCreateBook(BookReq book, String discr){
        BooksOperations bookOper = new BooksOperations();

        BookResp respBook = bookOper.createBook(book, discr, 201);
        bookOper.getTheBook(respBook, 200);
    }

    @AfterClass
    private void clearBooksList(){
        new BooksOperations()
                .getBooks(BookData.positive().length,200)
                .deleteAllBooks(200)
                .getBooks(404);
    }
}



