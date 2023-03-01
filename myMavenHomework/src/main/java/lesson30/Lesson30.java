package lesson30;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Lesson30 {

    private static Connection connection;

    public static void main(String[] args) {
        connect("jdbc:postgresql://localhost:5432/telran", "postgres", "Fdtd676");
        System.out.println("Postgresql server connected");

        try {
            Statement stnt = connection.createStatement();
//            dropTable(stnt);
//            createTable(stnt);
//            System.out.println("Table created");
//
//            insertInto(stnt);
//            System.out.println("Update");

            select(stnt);

            findById(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }



        disconnect();
        System.out.println("Postgresql server disconnected");
    }

    public static void findById(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                System.out.printf("id: %d, name: %s, group: %s\n", res.getInt(1),
                        res.getString(2), res.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void select(Statement stnt) {
        try {
          ResultSet rec = stnt.executeQuery("select * from students");
          while(rec.next()){
              System.out.printf("id: %d, name: %s, group: %s\n", rec.getInt(1),
                      rec.getString(2), rec.getString(3));
          }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dropTable(Statement stnt) {
        try {
            stnt.executeUpdate("DROP TABLE IF EXISTS students");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void createTable (Statement stnt) {
        try {
            stnt.executeUpdate("create table students (\n" +
                    "\tid \t\tSERIAL PRiMARY KEY, \n" +
                    "\tname \tTEXT NOT NULL,\n" +
                    "\tgroup_name \tTEXT NOT NULL\n" +
                    ");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertInto(Statement stnt){
        try {
            stnt.executeUpdate("insert into students (name, group_name) values ('Harry', '39a'), ('Parker', '39a');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void connect(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
