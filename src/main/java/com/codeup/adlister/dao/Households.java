package com.codeup.adlister.dao;

public interface Households {
    com.codeup.adlister.models.Households findByUsername(String username);
    Long insert(com.codeup.adlister.models.Households households);
}
