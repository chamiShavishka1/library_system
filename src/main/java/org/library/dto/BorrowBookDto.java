package org.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.library.entity.BorrowBook;
import org.library.entity.Member;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class BorrowBookDto {

        private int id;

        private int qty;

        private Date dueDate;

        private String status;

        private Timestamp addedDate;

        private Member member;


    }
