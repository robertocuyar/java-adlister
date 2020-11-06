import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements  Ads {
    private Connection connection = null;
    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );
    }
    @Override
    public List<Ad> all () throws SQLException{
        List<Ad> allList = new ArrayList<>();
        Statement statement = connection.createStatement();
        String selectQuery = "SELECT * FROM ads";
        ResultSet rs = statement.executeQuery(selectQuery);
        while (rs.next()){
            allList.add(new Ad(
                    rs.getLong("id"),
                    rs.getLong("user_id"),
                    rs.getString("title"),
                    rs.getString("description")
            ));
        }
        return allList;
    }
 @Override
    public Long insert (Ad ad) throws SQLException{
        Statement changeStatement = connection.createStatement();
        String insertQuery = String.format("INSERT INTO ads (user_id, title, description) VALUES(%d, %s, %s)", ad.getUserId(), ad.getTitle(), ad.getDescription());
        changeStatement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = changeStatement.getGeneratedKeys();
        if(rs.next()){
            return rs.getLong(1);
        }
        return null;
    }
}
