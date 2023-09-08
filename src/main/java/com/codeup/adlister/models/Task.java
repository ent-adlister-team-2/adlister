package com.codeup.adlister.models;

public class Task {
    private long id;
    private String name;
    private String description;
    private long householdId;

    public Task() {}

    public Task(long id, String name, String description, long householdId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.householdId = householdId;
    }

    public Task(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }
}
