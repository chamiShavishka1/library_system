package org.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.library.dto.BookDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Book")
@NoArgsConstructor
@Data
@ToString
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Book_Id")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "Dis")
    private String dis;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Available")
    private String available;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "book")
    private List<Book_Transaction> details = new ArrayList<>();

    public BookDto toDto() {
        return new BookDto(
                this.id,
                this.title,
                this.autor,
                this.dis,
                this.genre,
                this.available
        );
    }

    public Books(int id, String title, String autor, String dis, String genre, String available, Admin admin) {
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.dis = dis;
        this.genre = genre;
        this.available = available;
        this.admin = admin;
    }
}
