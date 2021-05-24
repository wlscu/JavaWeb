package com.zg.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @author 隔壁老王
 */
public  class QueryRunnerUtil {
    static ComboPooledDataSource ds = new ComboPooledDataSource();
    static QueryRunner qr = new QueryRunner(ds);

    public static QueryRunner getQueryRunner(){
        return qr;
    }
}
