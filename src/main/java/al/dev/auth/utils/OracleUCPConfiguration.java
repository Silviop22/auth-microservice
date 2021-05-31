package al.dev.auth.utils;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@Profile("oracle-ucp")
public class OracleUCPConfiguration {

    Properties loader;

    {
        try {
            loader = PropertiesLoaderUtils.loadAllProperties("db.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public static DataSource dataSource() throws SQLException {
        PoolDataSource dataSource = PoolDataSourceFactory.getPoolDataSource();
        dataSource.setRoleName("SYSOPER");
        dataSource.setUser("sys as sysdba");
        dataSource.setPassword("tgb#1234");
        dataSource.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
        dataSource.setURL("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain");
        dataSource.setFastConnectionFailoverEnabled(true);
        dataSource.setInitialPoolSize(10);
        dataSource.setMinPoolSize(8);
        dataSource.setMaxPoolSize(16);
        return dataSource;
    }
}
