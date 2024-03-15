package org.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.library.entity.Books;
import org.library.entity.BorrowBook;
import org.library.entity.TransactionDetailPK;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book_TransactionDto {
    private TransactionDetailPK id;
    private BorrowBook transaction;
    private Books book;
}
