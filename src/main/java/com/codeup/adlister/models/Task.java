package com.codeup.adlister.models;

public class Task {

    private long id;
    private String name;
    private String description;
    private Boolean repeatable;
    private Boolean status;
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

    public Task(long id, String name, String description, Boolean repeatable, int householdId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.repeatable = repeatable;
        this.householdId = householdId;
    }

    public Task(long id, String name, String description, Boolean repeatable, Boolean status, long householdId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.repeatable = repeatable;
        this.status = status;
        this.householdId = householdId;
    }

    public Task(String name, String description, Boolean repeatable, long householdId) {
        this.name = name;
        this.description = description;
        this.repeatable = repeatable;
        this.householdId = householdId;
    }
    public Task(String name, String description, Boolean repeatable, Boolean status, long householdId) {
        this.name = name;
        this.description = description;
        this.repeatable = repeatable;
        this.status = status;
        this.householdId = householdId;
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

    public Boolean getRepeatable() {
        return repeatable;
    }
    public void setRepeatable(Boolean repeatable) {
        this.repeatable = repeatable;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}
