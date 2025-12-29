package com.projecttracker.model;

public interface Trackable {
    void start();
    void markDone();
    String getStatus();
}
