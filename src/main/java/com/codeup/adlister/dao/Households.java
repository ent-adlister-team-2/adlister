package com.codeup.adlister.dao;

import com.codeup.adlister.models.Household;

public interface Households {
    Household findByUsername(String username);
    Long insert(Household household);
}
