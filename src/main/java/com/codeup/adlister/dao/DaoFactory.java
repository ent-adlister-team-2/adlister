package com.codeup.adlister.dao;

import com.codeup.adlister.util.Config;

public class DaoFactory {
    private static Tasks tasksDao;
    private static Households householdsDao;
    private static Config config = new Config();

    public static Tasks getTasksDao() {
        if (tasksDao == null) {
            tasksDao = new MySQLTasksDao(config);
        }
        return tasksDao;
    }

    public static Households getUsersDao() {
        if (householdsDao == null) {
            householdsDao = new MySQLHouseholdsDao(config);
        }
        return householdsDao;
    }
}
