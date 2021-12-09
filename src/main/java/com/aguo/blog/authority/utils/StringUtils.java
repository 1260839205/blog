package com.aguo.blog.authority.utils;

public class StringUtils {
    private StringUtils() {
    }

    private static String replace(String str) {
        return str.replaceAll("\"", "\\\\\"");
    }

    public static boolean isBlank(CharSequence str) {
        return str == null;
    }

    public static String toJson(String str, String value) {
        if (str == null) {
            return value != null ? "\"" + replace(value) + "\"" : "null";
        } else {
            return "\"" + replace(str) + "\"";
        }
    }

    public static String toJson(String str) {
        return toJson(str, (String)null);
    }
}