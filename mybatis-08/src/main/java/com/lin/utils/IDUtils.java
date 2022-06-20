package com.lin.utils;

import org.junit.Test;

import java.awt.*;
import java.util.UUID;

public class IDUtils {
    // 生成随机ID
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
