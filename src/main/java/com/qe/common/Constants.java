package com.qe.common;

import io.github.cozyloon.EzConfig;

public class Constants {
    public final static String BASE_URL = EzConfig.getProperty("base.url");
    public final static String FILE_PATH = EzConfig.getProperty("user.dir") + "\\src\\main\\resources\\data\\";
    public final static String TEST_ENV = EzConfig.getProperty("test.env");
    public final static String COMMON_HOST_API = EzConfig.getProperty("commonPath.api.host" + "_" + TEST_ENV);
}
