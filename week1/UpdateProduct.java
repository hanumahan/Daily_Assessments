package week1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateProduct {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/firstdb";
        String username = "root";
        String password = "hanuma";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();

        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();

        try {
            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Create a SQL update statement
            String sql = "UPDATE products SET price = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the parameters
            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setInt(2, productId);

            // Execute the update statement
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("The product price was updated successfully!");
            } else {
                System.out.println("No product found with the given ID.");
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
