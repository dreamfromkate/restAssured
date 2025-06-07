package ru.test.model.classes.response;

import lombok.*;
import java.util.List;

@Data
public class BooksResp  {
    private List<BookResp> Books;
    private int size;

}
