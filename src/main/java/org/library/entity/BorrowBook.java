package org.library.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "Borrow_Book")
public class BorrowBook{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Borrow_id")
    private int id;

    @Column(name = "book_qty")
    private int qty;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "transaction_status")
    private String status;

    @CreationTimestamp
    @Column(name = "transaction_added")
    private Timestamp addedDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "Payment")
    private double payment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "transaction")
    private List<Book_Transaction> details = new ArrayList<>();

    public BorrowBook(int qty, LocalDate dueDate, String status, Member member,double payment) {
        this.qty = qty;
        this.dueDate = Date.valueOf(dueDate);
        this.status = status;
        this.member = member;
        this.payment=payment;
    }

}