package com.codeup.adlister.dao;
import com.codeup.adlister.Config;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class LoginCheckDao {
    private Connection connection = null;

    public LoginCheckDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (
                SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    public boolean searchUsernamePassword(String username, String password) {
        String query = "SELECT COUNT(*) > 0 FROM users WHERE username = ? AND password = ? GROUP BY username";


        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            if (rs.getRow() == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {

            throw new RuntimeException(e.getMessage());
        }

    }
}
