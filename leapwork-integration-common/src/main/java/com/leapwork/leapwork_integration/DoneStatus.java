package com.leapwork.leapwork_integration;


public abstract class DoneStatus {
    public final String statusValue;
    public DoneStatus(String status) {
        this.statusValue = status;
    }
}