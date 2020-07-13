package ru.officelibrary.officelibrary.entity;

import com.sun.istack.NotNull;
import lombok.*;
import ru.officelibrary.officelibrary.model.Status;

import javax.persistence.*;
import java.sql.Date;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "history")
public class History {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long historyID;

//    @NotNull
//    @Column
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @NotNull
//    @Column
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @NotNull
    @Column
    private Status status;

    @NotNull
    @Column
    private Date startDate;

    @NotNull
    @Column
    private Date dueTo;

    @NotNull
    @Column
    private Date returnDate;


}
