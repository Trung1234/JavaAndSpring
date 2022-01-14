package com.trungnt.excep;

public class ListTooLargeException extends RuntimeException {
    private static final long serialVersionUID = -2931564504098722867L;
    public ListTooLargeException(String message) {
        super(message);
    }
}
