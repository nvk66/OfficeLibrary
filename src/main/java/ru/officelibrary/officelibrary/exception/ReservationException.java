package ru.officelibrary.officelibrary.exception;

public class ReservationException extends Exception {
    private long id;
    private String errMessage;

    public ReservationException(long id, String errMessage) {
        this.id = id;
        this.errMessage = errMessage;
    }

    public ReservationException() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
