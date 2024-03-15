package org.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.library.entity.Books;
import org.library.entity.BorrowBook;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book_TransactionDto {
    private int id;
    private BorrowBook transaction;
    private Books book;
}
