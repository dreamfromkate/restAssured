package ru.test.tests.create;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;
import ru.test.apiHelper.BooksOperations;
import ru.test.apiHelper.dataProvide.BookData;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BookResp;

public class CreateBookNegTest extends BaseTest {

    @Test(dataProvider = "negative", dataProviderClass = BookData.class,
            description = "Проверка создания книги с невалидными данными")

    @Epic("Магазин книг")
    @Feature("Добавление книг")
    @Story("Добавление книг с невалидными данными")

    @Description("Тест-кейс производит проверку: " +
            "\n    - обработки ошибки при добавлении книги с невалидными данными;" +
            "\n    - минимальных и/или максимальных граничных недопустимых значений параметров:" +
            "\n        -- количество книг;" +
            "\n        -- стоимости книги;" +
            "\n        -- наименования книги;" +
            "\n        -- автора книги;" +
            "\n        -- описания книги;" +
            "\n    - получение ошибки при поиске информации не существующей книги")

    @Owner("Сопова Екатерина Евгеньевна")
    public void testCreateBook(BookReq book, String discr){
        BooksOperations bookOper = new BooksOperations();

        BookResp respBook = bookOper.createBook(book, discr, 400);
        bookOper.getBooks( BookData.negative().length,404);

    }

}



