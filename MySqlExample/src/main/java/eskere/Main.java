package eskere;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root", ""
        );

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                "SELECT druhy.nazev, zvirata.jmeno, zvirata.id FROM zvirata JOIN druhy ON (zvirata.druh = druhy.id) LIMIT 3"
        );

        while(result.next()) {
            int idecko = result.getInt("id");
            String title = result.getString("jmeno");
            String druhnazev = result.getString("nazev");
            System.out.println(druhnazev + "\t;" + title + "\t;" + idecko);
        }

        connection.close();

    }
}
