package week3.JDBCTemplate;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HandlingException {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
        } catch (DataAccessException e) {
            // Handle exception System.err.println("Error querying for user by ID: " + e.getMessage());
            return null;
        }
    }

    public int updateUserPassword(int id, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        try {
            return jdbcTemplate.update(sql, new Object[]{newPassword, id});
        } catch (DataAccessException e) {
            
            System.err.println("Error updating user password: " + e.getMessage());
            return 0;
        }
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }
}
