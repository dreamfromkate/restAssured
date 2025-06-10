package ru.test.apiHelper.dataProvide;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import ru.test.model.classes.request.BookReq;
import ru.test.model.enums.Category;

public class BookData {

    @DataProvider
    public static Object[][] positive(){
        return new Object[][]{
                {BookReq.defaultOf(), "со значениями по умолчанию"},

                {BookReq.defaultOf().setCount(0), "с минимальной допустимой границей у параметра количество"},
                {BookReq.defaultOf().setPrice(0), "с минимальной допустимой границей у параметра цена"},

                {BookReq.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3)), "с минимальной допустимой границей у параметра название"},
                {BookReq.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256)), "с максимальной допустимой границей у параметра название"},

                {BookReq.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3)), "с минимальной допустимой границей у параметра автор"},
                {BookReq.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100)), "с максимальной допустимой границей у параметра автор"},

                {BookReq.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3)), "с минимальной допустимой границей у параметра описание"},
                {BookReq.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512)), "с максимальной допустимой границей у параметра описание"},

                {BookReq.defaultOf().setCategory(Category.Detective), "со значением категории - Детектив"},
                {BookReq.defaultOf().setCategory(Category.Horror), "со значением категории - Ужас"},
                {BookReq.defaultOf().setCategory(Category.Thriller), "со значением категории - Триллер"},
                {BookReq.defaultOf().setCategory(Category.Fiction), "со значением категории - Научная фантастика"}
        };
    }

    @DataProvider
    public static Object[][] negative(){
        return new Object[][]{
                {BookReq.defaultOf().setCount(-1), "с минимальной недопустимой границей у параметра количество"},
                {BookReq.defaultOf().setPrice(-1), "с минимальной недопустимой границей у параметра цена"},

                {BookReq.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(2)), "с минимальной допустимой границей у параметра название"},
                {BookReq.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(257)), "с максимальной допустимой границей у параметра название"},

                {BookReq.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(2)), "с минимальной допустимой границей у параметра автор"},
                {BookReq.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(101)), "с максимальной допустимой границей у параметра автор"},

                {BookReq.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(2)), "с минимальной допустимой границей у параметра описание"},
                {BookReq.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(513)), "с максимальной допустимой границей у параметра описание"},

                {BookReq.defaultOf().setCategory(Category.Unknown), "со значением категории не по умолчанию"},

                {BookReq.defaultOf().setAuthor(null), "без параметра автор"},
                {BookReq.defaultOf().setCategory(null), "без параметра категория"},
                {BookReq.defaultOf().setDescription(null), "без параметра описание"},
                {BookReq.defaultOf().setTitle(null), "без зпараметра наименование"},
        };
    }
}
