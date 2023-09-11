package fr.khalid.chat;

import java.sql.*;

import java.util.*;
import javax.sql.DataSource;

import fr.khalid.chat.models.User;
import org.postgresql.ds.PGSimpleDataSource;
import org.postgresql.util.PSQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws Exception {

        DataSource dataSource = createDataSource();
        Connection conn = dataSource.getConnection();

        List<User> users = getALlUsers(conn);

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    private  static  List<User> getALlUsers(Connection conn) throws SQLException {
        List<User> users = new ArrayList<>();
        // get a connection from the datasource
        // Create a new statement on the connection
        PreparedStatement stmt = conn.prepareStatement("select * from users");
        // Execute the query, and store the results in the ResultSet instance
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            users.add(new User(
                    rs.getLong("id"),
                    rs.getString("login"),
                    rs.getString("password")));
        }

        return (users);
    }
    private static DataSource createDataSource() {
        final String url =
                "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=ayoub";
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(url);
        return dataSource;
    }
}
