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
                {BookReq.defaultOf().setAuthor("Двадцать").setTitle("Один").setCount(-1), "с минимальной недопустимой границей у параметра количество"},
                {BookReq.defaultOf().setAuthor("Двадцатьодин").setTitle("Два").setPrice(-1), "с минимальной недопустимой границей у параметра цена"},

                {BookReq.defaultOf().setAuthor("Двадцатьдва").setTitle(RandomStringUtils.randomAlphabetic(2)), "с минимальной допустимой границей у параметра название"},
                {BookReq.defaultOf().setAuthor("Двадцатьтри").setTitle(RandomStringUtils.randomAlphabetic(257)), "с максимальной допустимой границей у параметра название"},

                {BookReq.defaultOf().setAuthor("Двадцатьчетыре").setTitle("Пять").setAuthor(RandomStringUtils.randomAlphabetic(2)), "с минимальной допустимой границей у параметра автор"},
                {BookReq.defaultOf().setAuthor("Двадцатьпять").setTitle("Шесть").setAuthor(RandomStringUtils.randomAlphabetic(101)), "с максимальной допустимой границей у параметра автор"},

                {BookReq.defaultOf().setAuthor("Двадцатьшесть").setTitle("Семь").setDescription(RandomStringUtils.randomAlphabetic(2)), "с минимальной допустимой границей у параметра описание"},
                {BookReq.defaultOf().setAuthor("Двадцатьсемь").setTitle("Восемь").setDescription(RandomStringUtils.randomAlphabetic(513)), "с максимальной допустимой границей у параметра описание"},

                {BookReq.defaultOf().setAuthor("Двадцатьвосемь").setTitle("Девять").setCategory(Category.Unknown), "со значением категории не по умолчанию"},

                {BookReq.defaultOf().setAuthor("Двадцатьдевять").setTitle("Десять").setAuthor(null), "без параметра автор"},
                {BookReq.defaultOf().setAuthor("Тридцать").setTitle("Одиннадцать").setCategory(null), "без параметра категория"},
                {BookReq.defaultOf().setAuthor("Тридцатьодин").setTitle("Двенадцать").setDescription(null), "без параметра описание"},
                {BookReq.defaultOf().setAuthor("Тридцатьдва").setTitle("Тринадцать").setTitle(null), "без зпараметра наименование"},
        };
    }
}
