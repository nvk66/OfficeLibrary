package ru.officelibrary.officelibrary.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Builder
@Entity
@NoArgsConstructor
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long genreID;

    @Column
    private String genreName;

    public long getGenreID() {
        return genreID;
    }

    public void setGenreID(long genreID) {
        this.genreID = genreID;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
