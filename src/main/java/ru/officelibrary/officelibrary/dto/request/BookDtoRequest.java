package ru.officelibrary.officelibrary.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDtoRequest {
    private String bookName;
    private int publishingYear;
    private String[] genreIds;
    private String[] authorIds;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
}
