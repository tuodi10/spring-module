package com.test.zero.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.reflect.Method;

/**
 *
 */
@Slf4j
public class MultipleDataSourceAspectAdvice
{

    public void invoke(JoinPoint joinPoint)
        throws Throwable
    {
        try
        {
            String method = joinPoint.getSignature().getName();
            Object target = joinPoint.getTarget();
            Class<?>[] classz = target.getClass().getInterfaces();
            Class<?>[] parameterTypes = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameterTypes();
            
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSource.class))
            {
                //当前开启事务，不切换数据源
                if (TransactionSynchronizationManager.isActualTransactionActive()) {
                    //logger.warn(String.format("当前开启事务，不切换数据源，切换数据源为主库; method:%s", method));
                    MultipleDataSource.setDataSourceKey("master");
                    return;
                }

                DataSource data = m.getAnnotation(DataSource.class);
                MultipleDataSource.setDataSourceKey(data.value());
                //logger.warn(String.format("method:%s,DataSource :%s", method, data.value()));
            }
            //logger.info(String.format("after--- DataSourceKey:%s", MultipleDataSource.getDataSourceKey()));
        }
        catch (Exception e)
        {
            MultipleDataSource.setDataSourceKey("master");
            log.error("MultipleDataSourceAspectAdvice is error!", e);
        }
    }
}
