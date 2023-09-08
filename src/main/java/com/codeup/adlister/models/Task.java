package com.codeup.adlister.models;

public class Task {
    private int id;
    private String name;
    private String description;
    private int householdId;

    public Task() {}

    public Task(int id, String name, String description, int householdId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.householdId = householdId;
    }

    public Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }
}
