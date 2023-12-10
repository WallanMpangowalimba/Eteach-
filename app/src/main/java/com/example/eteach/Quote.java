package com.example.eteach;

public class Quote {
    private String key, note, name;

    public Quote(String key, String note, String name) {
        this.key = key;
        this.note = note;
        this.name = name;
    }

    public Quote() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
