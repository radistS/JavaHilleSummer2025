package com.sparkjava;

public enum StatusResponse {
    SUCCESS("Success"), ERROR("Error"), DELETED("Deleted");

    final private String status;

    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
