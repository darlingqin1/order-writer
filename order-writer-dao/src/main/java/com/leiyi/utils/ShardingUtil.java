package com.leiyi.utils;


import org.springframework.stereotype.Component;

@Component
public class ShardingUtil {

    public static final int DATA_BASE_NUM = 8;

    public static final int TABLE_NUM = 8;
    public static long getTableNumber(Long orderId){
        return (orderId % (DATA_BASE_NUM * TABLE_NUM)) / DATA_BASE_NUM;
    }

    public static long getDatabaseNumber(Long orderId){
        return orderId % DATA_BASE_NUM;
    }
}
