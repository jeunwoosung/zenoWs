package com.sparta.schedule.repository;

import com.sparta.schedule.Schedule.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Schedule schedule) {
        String sql = "INSERT INTO schedules (task, assignee, password, created_date, modified_date) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, schedule.getTask(), schedule.getAssignee(), schedule.getPassword(),
                schedule.getCreatedDate(), schedule.getModifiedDate());
    }

    public Schedule findById(Long id) {
        String sql = "SELECT * FROM schedules WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ScheduleRowMapper());
    }

    public List<Schedule> findAll(LocalDate modifiedDate, String assignee) {
        String sql = "SELECT * FROM schedules WHERE (modified_date = ? OR ? IS NULL) AND (assignee = ? OR ? IS NULL) ORDER BY modified_date DESC";
        return jdbcTemplate.query(sql, new Object[]{modifiedDate, modifiedDate, assignee, assignee}, new ScheduleRowMapper());
    }

    public int update(Schedule schedule) {
        String sql = "UPDATE schedules SET task = ?, assignee = ?, password = ?, modified_date = ? WHERE id = ?";
        return jdbcTemplate.update(sql, schedule.getTask(), schedule.getAssignee(), schedule.getPassword(),
                schedule.getModifiedDate(), schedule.getId());
    }

    public int delete(Long id) {
        String sql = "DELETE FROM schedules WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class ScheduleRowMapper implements RowMapper<Schedule> {
        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getLong("id"));
            schedule.setTask(rs.getString("task"));
            schedule.setAssignee(rs.getString("assignee"));
            schedule.setPassword(rs.getString("password"));
            schedule.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
            schedule.setModifiedDate(rs.getTimestamp("modified_date").toLocalDateTime());
            return schedule;
        }
    }
}
