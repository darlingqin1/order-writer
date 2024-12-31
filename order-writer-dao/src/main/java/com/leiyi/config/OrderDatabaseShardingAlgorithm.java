package com.leiyi.config;

import com.leiyi.utils.ShardingUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;

@Component
@Slf4j
public class OrderDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private static final String SHARDING_NAME = "order_id";

    private static final String DATABASE_NAME_PREFIX = "order_";

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        String columnName = preciseShardingValue.getColumnName();
        if (!Objects.equals(columnName, SHARDING_NAME)) {
            log.error("订单库表分片键错误,columnName:{}", columnName);
            throw new RuntimeException("订单库表分片键错误,columnName:" + columnName);
        }
        long databaseNumber = ShardingUtil.getDatabaseNumber(preciseShardingValue.getValue());
        log.info("订单表最终定位到的库：{}", databaseNumber);
        return DATABASE_NAME_PREFIX + databaseNumber;
    }
}
