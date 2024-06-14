package week2.HibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CRUD {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        // Initialize Hibernate SessionFactory
        sessionFactory = new Configuration().configure().buildSessionFactory();

        // Perform CRUD operations
        Long userId = create();
        read(userId);
        update(userId);
        delete(userId);

        // Close the SessionFactory when done
        sessionFactory.close();
    }

    // Create operation: Insert a new User into the database
    public static Long create() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Long userId = null;
        try {
            tx = session.beginTransaction();

            // Create a new User entity
            User newUser = new User();
            newUser.setUsername("john.doe");
            newUser.setPassword("password123");

            // Save the new user entity to the database
            userId = (Long) session.save(newUser);

            // Commit the transaction
            tx.commit();
            System.out.println("User created with ID: " + userId);
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userId;
    }

    // Read operation: Retrieve a User from the database by ID
    public static void read(Long userId) {
        Session session = sessionFactory.openSession();
        try {
            // Retrieve the user entity by its ID
            User user = session.get(User.class, userId);
            if (user != null) {
                System.out.println("Retrieved User: " + user.getUsername());
            } else {
                System.out.println("User not found with ID: " + userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update operation: Update an existing User in the database
    public static void update(Long userId) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Retrieve the user entity to be updated
            User userToUpdate = session.get(User.class, userId);
            if (userToUpdate != null) {
                // Update the user entity
                userToUpdate.setPassword("newPassword123");

                // Perform the update operation
                session.update(userToUpdate);
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User not found with ID: " + userId);
            }

            // Commit the transaction
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete operation: Delete a User from the database
    public static void delete(Long userId) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Retrieve the user entity to be deleted
            User userToDelete = session.get(User.class, userId);
            if (userToDelete != null) {
                // Delete the user entity
                session.delete(userToDelete);
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User not found with ID: " + userId);
            }

            // Commit the transaction
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
