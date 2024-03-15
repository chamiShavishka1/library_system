package org.library.dao;

import org.library.entity.BorrowBook;
import org.library.entity.Member;

public interface BorrowBookRepository extends CrudUtil<BorrowBook>{
    BorrowBook getData(Member Id);

    int BookCount(Member data);
}
