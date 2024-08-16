package com.sparta.schedule.Service;

import com.sparta.schedule.DTO.ScheduleDTO;
import com.sparta.schedule.Schedule.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setTask(scheduleDTO.getTask());
        schedule.setAssignee(scheduleDTO.getAssignee());
        schedule.setPassword(scheduleDTO.getPassword());
        schedule.setCreatedDate(LocalDateTime.now());
        schedule.setModifiedDate(LocalDateTime.now());
        scheduleRepository.save(schedule);
        return scheduleDTO;
    }

    public ScheduleDTO getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id);
        return convertToDTO(schedule);
    }

    public List<ScheduleDTO> getSchedules(LocalDateTime modifiedDate, String assignee) {
        List<Schedule> schedules = scheduleRepository.findAll(LocalDate.from(modifiedDate), assignee);
        return schedules.stream().map(this::convertToDTO).toList();
    }

    public ScheduleDTO updateSchedule(Long id, ScheduleDTO scheduleDTO, String password) {
        Schedule existingSchedule = scheduleRepository.findById(id);
        if (existingSchedule == null || !existingSchedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid ID or password");
        }
        existingSchedule.setTask(scheduleDTO.getTask());
        existingSchedule.setAssignee(scheduleDTO.getAssignee());
        existingSchedule.setModifiedDate(LocalDateTime.now());
        scheduleRepository.update(existingSchedule);
        return convertToDTO(existingSchedule);
    }

    public void deleteSchedule(Long id, String password) {
        Schedule existingSchedule = scheduleRepository.findById(id);
        if (existingSchedule == null || !existingSchedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid ID or password");
        }
        scheduleRepository.delete(id);
    }

    private ScheduleDTO convertToDTO(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(schedule.getId());
        dto.setTask(schedule.getTask());
        dto.setAssignee(schedule.getAssignee());
        dto.setCreatedDate(schedule.getCreatedDate());
        dto.setModifiedDate(schedule.getModifiedDate());
        return dto;
    }
}
