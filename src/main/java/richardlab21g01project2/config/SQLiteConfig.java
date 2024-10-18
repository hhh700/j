package richardlab21g01project2.config;

import org.springframework.context.annotation.*;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class SQLiteConfig {   
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url("jdbc:sqlite:database.db");
        return dataSourceBuilder.build();   
    }
}
