package fr.test.repositories;

import  org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class EmbeddedDataSourceTest {

    private  DataSource dataSource = null;
    @BeforeEach
    public void init() {
        dataSource = EmbeddedDataSourceTest.getDataSource();
    }
    public static DataSource getDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL) // Specify the database type
                .addScript("schema.sql") // Optional: Initialize with SQL scripts
                .addScript("data.sql") // Optional: Initialize with SQL scripts
                .build();
    }

    @Test
    public void shouldConnectionBeEstablishedWithHsqldb() throws SQLException {
        //given

        //when
        Connection connection = dataSource.getConnection();
        //except

        assertNotNull(connection);

    }
}
