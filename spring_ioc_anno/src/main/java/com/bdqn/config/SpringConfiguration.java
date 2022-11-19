package com.bdqn.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.bdqn.config
 * @Author: RainGrd
 * @CreateTime: 2022-05-27  16:27
 * @Description: TODO
 * @Version: 1.0
 */
/*标志该类是Spring的核心配置类*/
@Configuration
@ComponentScan("com.bdqn")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
