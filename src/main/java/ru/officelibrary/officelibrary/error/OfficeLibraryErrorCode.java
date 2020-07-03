package ru.officelibrary.officelibrary.error;

public enum OfficeLibraryErrorCode {
    ;
    private String message;

    OfficeLibraryErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
