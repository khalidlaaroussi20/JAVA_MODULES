package fr.khalid.chat;

import java.sql.*;

import java.util.*;
import javax.sql.DataSource;

import fr.khalid.chat.models.Message;
import fr.khalid.chat.models.User;
import fr.khalid.chat.repositories.IMessagesRepository;
import fr.khalid.chat.repositories.implementations.MessagesRepositoryJdbcImpl;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws Exception {

        DataSource dataSource = createDataSource();
        IMessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
        long idMessage = 2;
        Optional<Message> OptionalMessage = messagesRepository.findById(idMessage);
        if (OptionalMessage.isPresent()) {
            Message message = OptionalMessage.get();
            System.out.println("message : {\n" +
                    message +
                    "author = " + message.author +
                    "room = " + message.room +
                    "}\n");
        }
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
