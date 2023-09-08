package com.codeup.adlister.dao;

import com.codeup.adlister.models.Task;

import java.sql.SQLException;
import java.util.List;

public interface Tasks {
    // get a list of all the ads

    List<Task> all(Long houseId);

    // insert a new ad and return the new ad's id
    Long insert(Task task);

    void viewTask(Task task) throws SQLException;
}
