package ru.officelibrary.officelibrary.error;

public class OfficeLibraryException {

    private OfficeLibraryErrorCode officeLibraryErrorCode;

    public OfficeLibraryException(OfficeLibraryErrorCode officeLibraryErrorCode) {
        this.officeLibraryErrorCode = officeLibraryErrorCode;
    }

    public OfficeLibraryErrorCode getServerErrorCode() {
        return officeLibraryErrorCode;
    }
}
