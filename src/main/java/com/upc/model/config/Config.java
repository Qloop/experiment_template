package com.upc.model.config;

/**
 * Created by Qloop on 2017/5/20.
 */
public class Config {

    public static int SUCCESS_CODE = 0;
    public static int TIME_OUT_CODE = 1;
    public static int Convert_ERROR_CODE = 2;  //参数转换错误 （比如json -> bean 错误）
    public static int NOT_FIND = 3;
    public static int FILE_SAVE_FAILED = 4;
    public static int FILE_NULL = 5;

    public static final String BASE_URL = "http://118.89.112.50/";
    public static final String UPLOAD_PATH = "/var/www/";
}
