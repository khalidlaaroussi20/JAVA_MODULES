package fr.khalid.chat.repositories;

import fr.khalid.chat.models.Message;

import java.sql.SQLException;
import java.util.Optional;

public interface IMessagesRepository {

    public Optional<Message> findById(Long id) throws SQLException;
}
