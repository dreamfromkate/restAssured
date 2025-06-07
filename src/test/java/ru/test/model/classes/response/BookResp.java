package ru.test.model.classes.response;

import lombok.*;
import lombok.experimental.Accessors;
import ru.test.model.classes.request.BookReq;
import ru.test.model.enums.Category;

import java.time.OffsetDateTime;

@Data
public class BookResp {

    private int id;
    private String lastUpdated;

    private String title;
    private String author;
    private String description;
    private Category category;

    private int count;
    private int price;
}
