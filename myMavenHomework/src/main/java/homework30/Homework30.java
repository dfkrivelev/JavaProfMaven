package homework30;

/**
 * Java Prof. Homework #30
 *
 * @author Dzmitry Kryvialeu
 * @version 27.02 - 01.03
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Homework30 {

    private static Connection connection;
    private static Statement stnt;

    public static void main(String[] args) {
        connect();
        System.out.println("Connected");
        createTable();
        insert();
        select();
        System.out.println("__________");
        findById(1);
        dropTable();
        disconnect();
    }

    static void createTable() {
        String url = "jdbc:sqlite:D:\\Dima\\sqlite\\connect\\datab\\myDB.db";
        try {
            connection = DriverManager.getConnection(url);
            stnt = connection.createStatement();
            stnt.executeUpdate("CREATE TABLE IF NOT EXISTS  students (\n" +
                    "\tid integer PRiMARY KEY, \n" +
                    "\tname text NOT NULL,\n" +
                    "\tgroup_name \tTEXT NOT NULL\n" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert() {
        try {
            stnt = connection.createStatement();
            stnt.executeUpdate("insert into students (name, group_name) values ('Harry', '39a'), ('Parker', '39a');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void select() {
        try {
            stnt = connection.createStatement();
            ResultSet rec = stnt.executeQuery("select * from students");
            while (rec.next()) {
                System.out.printf("id: %d, name: %s, group: %s\n", rec.getInt(1),
                        rec.getString(2), rec.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void findById(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                System.out.printf("id: %d, name: %s, group: %s\n", res.getInt(1),
                        res.getString(2), res.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void dropTable() {
        try {
            stnt = connection.createStatement();
            stnt.executeUpdate("DROP TABLE IF EXISTS students");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void connect() {
        String url = "jdbc:sqlite:D:\\Dima\\sqlite\\connect\\datab\\myDB.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
            System.out.println("Disconnected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
