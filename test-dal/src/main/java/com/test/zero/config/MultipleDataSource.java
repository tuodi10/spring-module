package com.test.zero.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    private final static ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    public static String getDataSourceKey() {
        return dataSourceKey.get();
    }

    /**
     * 重置
     */
    public static void reset() {
        dataSourceKey.set(null);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = dataSourceKey.get();
        reset();
        return dataSource;
    }
}
