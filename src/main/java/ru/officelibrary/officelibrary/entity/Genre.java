package ru.officelibrary.officelibrary.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ToString(exclude = "genreId")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "genres")
public class Genre implements Serializable, Comparable<Genre> {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 3, max = 40)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String genreName) {
        this.name = genreName;
    }

    public long getId() {
        return id;
    }

    public void setId(long genreId) {
        this.id = genreId;
    }

    @Override
    public int compareTo(Genre genre) {
        return this.name.toLowerCase().compareTo(genre.getName().toLowerCase());
    }
}
