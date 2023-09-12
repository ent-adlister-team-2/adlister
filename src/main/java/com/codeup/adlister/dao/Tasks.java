package com.codeup.adlister.dao;

import com.codeup.adlister.models.Task;

import java.sql.SQLException;
import java.util.List;

public interface Tasks {
    // get a list of all the ads

    List<Task> all(Long houseId);
    List<Task> sortAllByName(Long houseId);
    Task findById(long taskId) throws SQLException;

    // insert a new ad and return the new ad's id
    Long insert(Task task);
    void deleteTask(long id);


    long updateName(long id, String name);
    long updateDescription(long id, String description);
    long updateStatus(long id, int status);
    long updateRepeatable(long id, Boolean repeatable);

    long updateCategory(long id, String category);

}
