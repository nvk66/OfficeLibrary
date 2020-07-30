package ru.officelibrary.officelibrary.exception;

public class SearchException extends Exception{
    private String searchRequest;
    private String errMessage;

    public SearchException(String searchRequest, String errMessage) {
        this.searchRequest = searchRequest;
        this.errMessage = errMessage;
    }

    public SearchException() {
    }

    public String getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(String searchRequest) {
        this.searchRequest = searchRequest;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
