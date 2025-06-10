package ru.test.tests.update;

import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;
import ru.test.apiHelper.BooksOperations;
import ru.test.apiHelper.dataProvide.BookData;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BookResp;
import ru.test.model.enums.Category;

public class UpdateTheBookPosTest extends BaseTest {
    BookResp defaultBook;

    @Test(dataProvider = "positive", dataProviderClass = BookData.class,
            description = "Проверка обновления информации книги валидными данными")

    @Epic("Магазин книг")
    @Feature("Обновление книг")
    @Story("Обновление книг валидными данными")

    @Description("Тест-кейс производит проверку: " +
            "\n    - обновления книги валидными данными;" +
            "\n    - минимальных и/или максимальных граничных допустимых значений параметров:" +
            "\n        -- количество книг;" +
            "\n        -- стоимости книги;" +
            "\n        -- наименования книги;" +
            "\n        -- автора книги;" +
            "\n        -- описания книги;" +
            "\n    - проверка обновления информации книги.")

    @Owner("Сопова Екатерина Евгеньевна")
    public void testUpdateTheBook(BookReq book, String discr){
        defaultBook = new BooksOperations().createBook(BookReq.defaultOf());
        new BooksOperations().updateTheBook(book, defaultBook, discr, 200);
    }

    @AfterClass
    private void clearBooksList(){
        new BooksOperations()
                .getBooks(BookData.positive().length,200)
                .deleteAllBooks(200)
                .getBooks(BookData.positive().length,404);
    }
}



