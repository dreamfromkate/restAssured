package ru.test.model.classes.request;

import lombok.*;
import lombok.experimental.Accessors;
import ru.test.model.enums.Category;

@Data
@AllArgsConstructor
@Accessors(chain = true)
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

    public static BookReq defaultOf(){
        return new BookReq("The Adventures of Tom Sawyer",
                "Mark Twain",
                "The story about Tom Sawyer.",
                Category.Adventures,
                10,
                250);
    }

    @Override
    public String toString() {
        return "BookReq{" +
                "\n\ttitle = '" + title + '\'' +
                "\n\tauthor = '" + author + '\'' +
                "\n\tdescription = '" + description + '\'' +
                "\n\tcategory = " + category +
                "\n\tcount = " + count +
                "\n\tprice = " + price +
                "\n}";
    }
}
