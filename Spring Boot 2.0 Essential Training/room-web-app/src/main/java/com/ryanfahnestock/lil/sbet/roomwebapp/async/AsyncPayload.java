package com.ryanfahnestock.lil.sbet.roomwebapp.async;

public class AsyncPayload {
    private long id;
    public String model;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
