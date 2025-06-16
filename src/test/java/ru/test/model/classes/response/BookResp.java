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

    @Override
    public String toString() {
        return "BookResp {" +
                "\n\tid = " + id +
                "\n\tlastUpdated = '" + lastUpdated + '\'' +
                "\n\ttitle = '" + title + '\'' +
                "\n\tauthor = '" + author + '\'' +
                "\n\tdescription = '" + description + '\'' +
                "\n\tcategory = " + category +
                "\n\tcount = " + count +
                "\n\tprice = " + price +
                "\n}";
    }

    /*@Override
    public String toStringg(){
        return "BookResp {" +
                "id = " + this.;
    }*/
}
