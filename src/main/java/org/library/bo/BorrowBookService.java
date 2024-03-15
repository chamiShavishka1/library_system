package org.library.bo;

import org.library.dto.BookDto;

import java.util.List;

public interface BorrowBookService extends SuperService{

    List<String> getTitles();

    BookDto getData(String title);
    boolean saveTransaction(List<String> data);
}
