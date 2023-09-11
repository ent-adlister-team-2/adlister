package com.codeup.adlister.dao;

import com.codeup.adlister.models.Task;

import java.sql.SQLException;
import java.util.List;

public interface Tasks {
    // get a list of all the ads

    List<Task> all(Long houseId);

    // insert a new ad and return the new ad's id
    Long insert(Task task);
    long deleteTask(long id);
    long updateName(long id, String name);
    long updateDescription(long id, String description);
    long updateStatus(long id, int status);
    long updateRepeatable(long id, int repeatable);
    long updateCategory(long id, String category);

    Task findById(long taskId) throws SQLException;
}
