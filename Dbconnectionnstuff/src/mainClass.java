import java.sql.*;

public class mainClass {
    static final String DB_URL = "jdbc:sqlite:src/mydbtest.db";
    static final String QUERY = "SELECT * from Products";

    public static void main(String[] args) {
        // Open a connection
        // matzul = kk;
        try(Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            int name;
            while (rs.next())
            {
                name = rs.getInt("Price");

                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}