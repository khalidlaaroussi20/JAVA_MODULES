package fr.khalid.chat.repositories.implementations;

import fr.khalid.chat.models.Message;
import fr.khalid.chat.models.Room;
import fr.khalid.chat.models.User;
import fr.khalid.chat.repositories.IMessagesRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements IMessagesRepository {
    private DataSource _dataSource = null;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        _dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Connection conn = this._dataSource.getConnection();
        Message message = null;
        PreparedStatement stmt = conn.prepareStatement("select * from messages " +
                "join users on users.id = messages.author " +
                "join rooms on rooms.id = messages.room  " +
                "where messages.id = ?");
        stmt.setLong(1, id);

        // Execute the query, and store the results in the ResultSet instance
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            User author = new User(rs.getLong("author"), rs.getString("login"), rs.getString("password"));
            Room room = new Room(rs.getLong("room"), rs.getString("name"), null);
            message = new Message(rs.getLong("id") ,rs.getString("text"), author, room);
        }
        return Optional.ofNullable(message);
    }
}
