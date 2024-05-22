package com.testexample.exception;

public class ConflictException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String returnCode;
    private String returnDesc;

    public ConflictException(String returnCode) {
        this.returnDesc = getMessageDesc(returnCode);
        this.returnCode = returnCode;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    private String getMessageDesc(String corpusCode) {
        String desc = "";
        switch (corpusCode) {
            case "A":
                desc = "MESSAGE-A";
                break;
            case "B":
                desc = "MESSAGE-B";
                break;
            default:
                desc = "MESSAGE-D";
        }
        return desc;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public String getReturnCode(String returnCode) {
        return returnCode;
    }
}