package com.lin.utils;

import org.junit.Test;

import java.awt.*;
import java.util.UUID;

public class IDUtils {
    // çæéæºID
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
