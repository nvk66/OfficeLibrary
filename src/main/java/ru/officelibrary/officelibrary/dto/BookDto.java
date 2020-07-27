package ru.officelibrary.officelibrary.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private long id;
    private String name;
    private int publishingYear;
    private String[] genreIds;
    private String[] authorIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(String[] genreIds) {
        this.genreIds = genreIds;
    }

    public String[] getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(String[] authorIds) {
        this.authorIds = authorIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
