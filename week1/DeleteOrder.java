package week1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteOrder {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/firstdb";
        String username = "root";
        String password = "hanuma";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter order ID to delete: ");
        int orderId = scanner.nextInt();

        try {
            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create a SQL delete statement
            String sql = "DELETE FROM orders WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the parameter
            preparedStatement.setInt(1, orderId);

            // Execute the delete statement
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("The order was deleted successfully!");
            } else {
                System.out.println("No order found with the given ID.");
            }

            // Close the resources
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
