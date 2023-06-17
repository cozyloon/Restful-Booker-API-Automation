package com.qe.common;

import io.github.cozyloon.EzConfig;

public class Constants {
    public final static String BASE_URL = EzConfig.getProperty("base.url");
    public final static String FILE_PATH = EzConfig.getProperty("user.dir") + "\\src\\main\\resources\\data\\";
    public final static String TEST_ENV = EzConfig.getProperty("test.env");
    public final static String COMMON_HOST_API = EzConfig.getProperty("commonPath.api.host" + "_" + TEST_ENV);
    public final static String DB_URL = EzConfig.getProperty("db.url");
    public final static String DB_USERNAME = EzConfig.getProperty("db.username");
    public final static String DB_PASSWORD = EzConfig.getProperty("db.password");
    public final static String AUTH_USERNAME = EzConfig.getProperty("auth.username");
    public final static String AUTH_PASSWORD = EzConfig.getProperty("auth.password");
}
