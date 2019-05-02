package com.hawk.intercepts;


import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * 自定义mybatis插件
 * @author zhangdonghao
 * @date 2019/4/21
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class QueryExecutorFilter implements Interceptor {
    private Boolean printSql;
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("QueryExecutorFilter =======================");
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object paramterObject = args[1];
//        RowBounds rowBounds = (RowBounds) args[2];
//        ResultHandler resultHandler = (ResultHandler) args[3];
//        Executor executor = (Executor) invocation.getTarget();
        BoundSql boundSql = ms.getBoundSql(paramterObject);
//        CacheKey cacheKey = executor.createCacheKey(ms, paramterObject, rowBounds, boundSql);
        if (printSql)System.out.println(boundSql.getSql());
//        return executor.query(ms, paramterObject, rowBounds, resultHandler, cacheKey, boundSql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return target instanceof Executor ? Plugin.wrap(target, this) : target;
    }

    @Override
    public void setProperties(Properties properties) {
        printSql = Boolean.valueOf((String) properties.get("printSql"));
    }
}
