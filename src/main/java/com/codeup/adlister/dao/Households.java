package com.codeup.adlister.dao;

import com.codeup.adlister.models.Household;

import java.sql.SQLException;

public interface Households {
    Household findByUsername(String username);
    Long insert(Household household);

    void update(long id, String password) throws SQLException;
}
