package ru.test.model.classes.request;

import lombok.*;
import ru.test.model.enums.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BookReq {
    private String title;
    private String author;
    private String description;
    private Category category;

    private int count;
    private int price;

    public BookReq(BookReq book) {
        this.title = book.title;
        this.description = book.description;
        this.author = book.author;
        this.price = book.price;
        this.count = book.count;
        this.category = book.category;
    }
}
