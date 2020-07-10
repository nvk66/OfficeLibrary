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
//    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long genreId;

    @Column
    @NotNull
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

    @Override
    public String toString() {
        return "Genre [id=" + genreId + ", genreName=" + genreName + "]";
    }
}
