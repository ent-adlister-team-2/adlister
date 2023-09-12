package com.codeup.adlister.dao;

import com.codeup.adlister.models.Household;

import java.sql.SQLException;
import java.util.List;

public interface Households {
    List<Household> all();
    Household findByUsername(String username);
    Household findByEmail(String email);

    Long insert(Household household);

    void updatePassword(long id, String password) throws SQLException;
    void updateUsername(long id, String username) throws SQLException;
    void updateName(long id, String name) throws SQLException;
    void updateEmail(long id, String email) throws SQLException;
    void deleteHousehold(long id) throws SQLException;

}
