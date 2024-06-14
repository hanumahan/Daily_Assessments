package week1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepvsUnprep {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/firstdb";
    private static final String USER = "root"; 
    private static final String PASSWORD = "hanuma";

    public static void main(String[] args) {
        try {
            
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            
            System.out.println("Using Statement:");
            useStatement(connection);

            
            System.out.println("Using PreparedStatement:");
            usePreparedStatement(connection);

            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void useStatement(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        
        // Insert a new user using Statement
        String insertSql = "INSERT INTO users (name, age) VALUES ('John Doe', 30)";
        statement.executeUpdate(insertSql);
        
        // Query users using Statement
        String querySql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(querySql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }

        statement.close();
    }

    private static void usePreparedStatement(Connection connection) throws SQLException {
        
        String insertSql = "INSERT INTO users (name, age) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, "rohith");
        preparedStatement.setInt(2, 25);
        preparedStatement.executeUpdate();
        
        // Query users using PreparedStatement
        String querySql = "SELECT * FROM users WHERE age > ?";
        preparedStatement = connection.prepareStatement(querySql);
        preparedStatement.setInt(1, 20);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }

        preparedStatement.close();
    }
}
