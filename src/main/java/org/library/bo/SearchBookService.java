package org.library.bo;

import org.library.dto.BookDto;

import java.util.List;

public interface SearchBookService extends SuperService {
    BookDto getData(String title);
    List<String> getTitles();
}
