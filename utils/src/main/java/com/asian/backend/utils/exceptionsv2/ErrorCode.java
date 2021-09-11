package com.asian.backend.utils.exceptionsv2;

import org.springframework.http.HttpStatus;


/**
 * @Author datdv
 */
public enum ErrorCode {

    SUCCESS(HttpStatus.OK, "Success", "Success"),
    ID_NOT_FOUND(HttpStatus.NOT_FOUND, "LMS-404", "Could not find the Id"),
    API_NOT_FOUND(HttpStatus.NOT_FOUND, "LMS-404", "API Not Found"),
    AUTHORIZATION_FIELD_MISSING(HttpStatus.FORBIDDEN, "LMS-40011", "Please log in"),
    CAN_NOT_DELETE_COURSE(HttpStatus.BAD_REQUEST,"LMS-40018","Student is studying"),
    SIGNATURE_NOT_CORRECT(HttpStatus.FORBIDDEN,"LMS-40001","Signature not correct"),
    EXPIRED(HttpStatus.FORBIDDEN,"LMS-40003","Expired"),
    UNSUPPORT_FILE_EXTENSION(HttpStatus.BAD_REQUEST, "LMS-40020", "Unsupport this file extension");



    private final HttpStatus status;
    private String code;
    private String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public HttpStatus status() {
        return status;
    }

    public String message() {
        return message;
    }
}
