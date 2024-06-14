package week3.JDBCTemplate;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class ParameterizedQuery {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public User findUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new UserRowMapper());
    }

    public int updateUserPassword(int id, String newPassword) {
        String sql = "UPDATE users SET password = :password WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("password", newPassword)
                .addValue("id", id);
        return namedParameterJdbcTemplate.update(sql, namedParameters);
    }
}

