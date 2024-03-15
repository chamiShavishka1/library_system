package org.library.dao;

import org.library.entity.Book_Transaction;

import java.util.List;

public interface BookTransactionRepository extends CrudUtil<Book_Transaction>{
    List<Book_Transaction> bookTransactionData(String id);
}
