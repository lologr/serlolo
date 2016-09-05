package gr.lolo.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;

@Configuration
public class DatabaseConfig {

    private final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean
    public DataSource dataSource() throws URISyntaxException {

        String dbUrlParam = "JDBC_DATABASE_URL";
        String dbUserParam = "JDBC_DATABASE_USERNAME";
        String dbPassParam = "JDBC_DATABASE_PASSWORD";

        String dbUrl = System.getProperty(dbUrlParam, System.getenv(dbUrlParam));
        String username = System.getProperty(dbUserParam, System.getenv(dbUserParam));
        String password = System.getProperty(dbPassParam, System.getenv(dbPassParam));

        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(true);
        dataSource.setValidationQuery("SELECT 1");

        migrate(dataSource);

        return dataSource;
    }

    public void migrate(DataSource dataSource) {

        log.info("Migrating db ...");

        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        int migrations = flyway.migrate();

        log.info("Applied " + migrations + " migrations");
    }
}
