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

public class UpdateTheBookNegTest extends BaseTest {

    @Test(dataProvider = "negative", dataProviderClass = BookData.class,
            description = "Проверка обновления информации книги невалидными данными")

    @Epic("Магазин книг")
    @Feature("Обновление книг")
    @Story("Обновление книги невалидными данными")

    @Description("Тест-кейс производит проверку: " +
            "\n    - обработки ошибки при обновлении книги невалидными данными;" +
            "\n    - минимальных и/или максимальных граничных недопустимых значений параметров:" +
            "\n        -- количество книг;" +
            "\n        -- стоимости книги;" +
            "\n        -- наименования книги;" +
            "\n        -- автора книги;" +
            "\n        -- описания книги;" +
            "\n    - отсутствия обновления книги не валидной информацией.")

    @Owner("Сопова Екатерина Евгеньевна")
    public void testCreateBook(BookReq book, String discr){
        BookResp defaultBook = new BooksOperations().createBook(BookReq.defaultOf());

        new BooksOperations()
                .updateTheBook(book, defaultBook, discr, 400)
                .checkNoUpdate(defaultBook);

    }

    @Test(description = "Проверка получения ошибки 404 при обновлении информации книги")

    @Epic("Магазин книг")
    @Feature("Обновление книг")
    //@Story("Обновление книг валидными данными")

    @Description("Тест-кейс производит проверку получения ошибки 404 при обновлении информации не существующей книги.")

    @Owner("Сопова Екатерина Евгеньевна")
    public void testUpdateTheBookError404(){
        BookResp defaultBook = new BooksOperations().createBook(BookReq.defaultOf());
        new BooksOperations().updateTheBook (BookReq.defaultOf().setCategory(Category.Fiction), defaultBook, 404);
    }

    @Test(description = "Проверка получения ошибки 400 при обновлении информации книги")

    @Epic("Магазин книг")
    @Feature("Обновление книг")
    //@Story("Обновление книг валидными данными")

    @Description("Тест-кейс производит проверку получения ошибки 400 при обновлении информации книги по не валидному ID.")

    @Owner("Сопова Екатерина Евгеньевна")
    public void testUpdateTheBookError400(){
        BookResp defaultBook = new BooksOperations().createBook(BookReq.defaultOf());
        new BooksOperations().updateTheBook (BookReq.defaultOf().setCategory(Category.Fiction), "String", 400);
    }

    @AfterClass
    private void clearBooksList(){
        new BooksOperations()
                .getBooks(BookData.negative().length+2,200)
                .deleteAllBooks(200)
                .getBooks(BookData.negative().length+2,404);
    }

}



