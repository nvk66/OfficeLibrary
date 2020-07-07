package ru.officelibrary.officelibrary.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "history")
public class History {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long historyID;

    @NotNull
    @Column
//    @OneToOne
//    @JoinColumn(name = "userID")
    private User user;

    @NotNull
    @Column
//    @OneToOne
//    @JoinColumn(name = "bookID")
    private Book book;

    @NotNull
    @Column
    private Status status;
}
