package com.springlearning.springmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {
    public static String decodeParam(String param) {
        return URLDecoder.decode(param, StandardCharsets.UTF_8);
    }
}
