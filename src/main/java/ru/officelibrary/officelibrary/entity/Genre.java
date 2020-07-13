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
public class Genre implements Serializable {
    @Id
//    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long genreId;

    @Column
    @NotNull
//    @UniqueElements
    @Size(min = 3, max = 40)
    private String genreName;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

//    @Override
//    public String toString() {
//        return "Genre [id=" + genreId + ", genreName=" + genreName + "]";
//    }
}
