package com.nequi.franchise.config;


import io.r2dbc.postgresql.PostgresqlConnectionFactoryProvider;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@EnableR2dbcRepositories
public class DatabaseConfig extends AbstractR2dbcConfiguration {

    @Value("${db.host}")
    String host;

    @Value("${db.port}")
    Integer port;

    @Value("${db.user}")
    String user;

    @Value("${db.password}")
    String password;

    @Value("${db.database}")
    String database;

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactoryProvider()
                .create(ConnectionFactoryOptions.builder()
                        .option(DRIVER, "postgresql")
                        .option(HOST, host)
                        .option(PORT, port)
                        .option(USER, user)
                        .option(PASSWORD, password)
                        .option(DATABASE, database)
                        .build()
                );
    }
}
