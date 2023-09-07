package com.codeup.adlister.dao;

public class DaoFactory {
    private static Tasks adsDao;
    private static Households householdsDao;
    private static Config config = new Config();

    public static Tasks getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLTasksDao(config);
        }
        return adsDao;
    }

    public static Households getUsersDao() {
        if (householdsDao == null) {
            householdsDao = new MySQLHouseholdsDao(config);
        }
        return householdsDao;
    }
}
