package cn.shangpin.utils;

import java.util.UUID;

/**
 * Created by qujie on 2018/12/4
 * */
public class UUIDUtil {

    public UUIDUtil() {
    }

    public static String getUUID() {
        String uuidStr = UUID.randomUUID().toString();
        uuidStr = uuidStr.replace("-", "");
        return uuidStr;
    }
}
