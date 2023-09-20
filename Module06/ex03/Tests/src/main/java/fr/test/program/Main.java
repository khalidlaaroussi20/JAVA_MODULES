package fr.test.program;

import java.sql.*;

import java.util.*;
import javax.sql.DataSource;



import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import fr.test.models.Product;
import fr.test.repositories.ProductsRepository;
import fr.test.repositories.ProductsRepositoryJdbcImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws Exception {

        DataSource dataSource = createDataSource();
        ProductsRepository productsRepositoryImpl = new ProductsRepositoryJdbcImpl(dataSource);
        Product product = new Product(7, "tttt", 1000);
        productsRepositoryImpl.save(product);


    }

    private static DataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/mydb");
        config.setUsername("postgres");
        config.setPassword("ayoub");

        // HikariCP pool settings
        config.setMaximumPoolSize(10); // Maximum number of connections in the pool
        config.setMinimumIdle(5); // Minimum number of idle connections
        config.setConnectionTimeout(30000); // Connection timeout in milliseconds

        // Create and return the HikariDataSource
        return new HikariDataSource(config);
    }
}
