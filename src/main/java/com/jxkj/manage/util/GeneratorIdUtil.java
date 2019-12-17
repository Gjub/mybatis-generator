package com.jxkj.manage.util;

import java.util.Random;

public class GeneratorIdUtil {
    public static Long generatorId(){
        Random r = new Random();
        return (long) r.nextInt(10000);
    }
}
