package com.upc.model.utils;

import com.upc.model.config.Config;

/**
 * Created by Qloop on 2017/5/21.
 */
public class Check {

    public static String checkEmpty(Object object) {
        if (object == null) {
            return Config.Convert_ERROR_CODE + "";
        } else {
            return Config.SUCCESS_CODE + "";
        }
    }
}
