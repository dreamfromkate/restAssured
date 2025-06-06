package ru.test.model.classes.response;

import lombok.*;
import ru.test.model.classes.request.BookReq;
import ru.test.model.enums.Category;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BookResp /*extends BookReq*/ {
    private int id;
    private String lastUpdated;

    private String title;
    private String author;
    private String description;
    private Category category;

    private int count;
    private int price;
}
