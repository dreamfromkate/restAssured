package ru.test.model.classes.response;

import lombok.*;
import ru.test.model.classes.request.BookReq;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BooksResp  {
    private List<BookResp> Books;
    private int size;

}
