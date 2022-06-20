
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTestDB {

    static final String DB_URL = "jdbc:mysql://localhost/devprox";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) throws SQLException {

        //createTable();
        saveDataToDB();

    }

    public static void createTable(){

        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE RECORDS " +
                    "(ID VARCHAR(100) not NULL, " +
                    " Name VARCHAR(255), " +
                    " Surname VARCHAR(255), " +
                    " Initials VARCHAR(10), " +
                    " Age VARCHAR(100), " +
                    " DateOfBirth VARCHAR(255), " +
                    " PRIMARY KEY ( ID ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveDataToDB() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        con.setAutoCommit(false);

        String sql = "insert into records (ID, Name, Surname, Initials, Age, DateOfBirth) values(?,?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement (sql) ;

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("output.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                records.add(Arrays.asList(data));

                String ID = data[0];
                String Name = data[1];
                String Surname = data[2];
                String Initials = data[3];
                String Age = data[4];
                String DateOfBirth = data[5];

                statement.setString(1,ID);
                statement.setString(2, Name);
                statement.setString(3, Surname);
                statement.setString(4, Initials);
                statement.setString(5,Age);
                statement.setString(6, DateOfBirth);
                statement.executeUpdate();
            }
            statement.executeUpdate();
            con.commit();
            con.close();
            System.out.println("Date inserted into database");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
