package ru.test.tests;

import io.qameta.allure.*;
import io.qameta.allure.model.Parameter;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.test.apiHelper.BaseTest;

import ru.test.apiHelper.BooksOperations;
import ru.test.model.classes.request.BookReq;
import ru.test.model.classes.response.BookResp;
import ru.test.model.enums.Category;

public class CreateBookPosTest extends BaseTest {

    @Test(testName = "Проверка создания книги с валидными данными",
            dataProvider = "createBooksPositiveData", description = "Проверка создания книги с валидными данными {discr}")
    @Description("Тест-кейс производит проверку: " +
            "\n    - добавления книг с валидными данными;" +
            "\n    - проверку граничных значений параметров:" +
            "\n        --количество книг;" +
            "\n        --стоимости книги;" +
            "\n        --минимальная и максчимальная граница наименования книги;" +
            "\n        --минимальная и максчимальная граница автора книги;" +
            "\n        --минимальная и максчимальная граница описания книги;" +
            "\n    - получение информации конкретной книги по ID")

    @Owner("Сопова Екатерина Евгеньевна")
    public void testCreateBook(BookReq book, String discr){
        BooksOperations bookOper = new BooksOperations();

        BookResp respBook = bookOper.createBook(book, discr, 201);
        bookOper.getTheBook(respBook, 200);

        Allure.description("Проверка создания книги с "+discr);
        Allure.parameter("book", Parameter.Mode.HIDDEN);
    }

    @AfterClass
    private void clearBooksList(){
        new BooksOperations()
                .getBooks(200)
                .deleteAllBooks(200)
                .getEmptyListBooks();
    }

    @DataProvider
    public Object[][] createBooksPositiveData(){
        return new Object[][]{
                {BookReq.defaultOf(), "значениями по умолчанию"},

                {BookReq.defaultOf().setCount(0), "минимальной границей у параметра количество"},
                {BookReq.defaultOf().setPrice(0), "минимальной границей у параметра цена"},

                {BookReq.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3)), "минимальной границей у параметра название"},
                {BookReq.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256)), "максимальной границей у параметра название"},

                {BookReq.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3)), "минимальной границей у параметра автор"},
                {BookReq.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100)), "максимальной границей у параметра автор"},

                {BookReq.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3)), "минимальной границей у параметра описание"},
                {BookReq.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512)), "максимальной границей у параметра описание"},

                {BookReq.defaultOf().setCategory(Category.Detective), "значением категории - Детектив"},
                {BookReq.defaultOf().setCategory(Category.Horror), "значением категории - Ужас"},
                {BookReq.defaultOf().setCategory(Category.Thriller), "значением категории - Триллер"},
                {BookReq.defaultOf().setCategory(Category.Fiction), "значением категории - Научная фантастика"}
        };
    }
}



