package com.arturrdc.issuescoutbackend.project.exception;

public class UnauthorizedProjectEdit extends Exception {
    public UnauthorizedProjectEdit() {
        super();
    }

    public UnauthorizedProjectEdit(String message) {
        super(message);
    }
}
