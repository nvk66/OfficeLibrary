package ru.officelibrary.officelibrary.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "genres")
public class Genre {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long genreID;

    @Column
    @NotNull
    private String genreName;
}
