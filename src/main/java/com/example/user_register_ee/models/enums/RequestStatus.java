package com.example.user_register_ee.models.enums;

public enum RequestStatus {

    WAITING, ACCEPTED, CANCELED, COMPLETE;


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
