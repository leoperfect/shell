package com.github.zheyi.shell.utils;

/**
 * @author zheyi
 * @date 2018/10/10
 */
public class StringUtils {

    public static String upperCaseFirstChar(String source) {
        if (source != null && source.length() > 1) {
            return String.valueOf(Character.toUpperCase(source.charAt(0))) + source.substring(1);
        }
        return source;
    }

}
