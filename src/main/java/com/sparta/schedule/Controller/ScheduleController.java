package com.sparta.schedule.Controller;

import com.sparta.schedule.DTO.ScheduleDTO;
import com.sparta.schedule.Service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        // 일정 생성 요청 처리
        return ResponseEntity.ok(scheduleService.createSchedule(scheduleDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> getSchedule(@PathVariable Long id) {
        // 일정 조회 요청 처리
        return ResponseEntity.ok(scheduleService.getSchedule(id));
    }

    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> getSchedules(@RequestParam(required = false) LocalDate modifiedDate,
                                                          @RequestParam(required = false) String assignee) {
        // 일정 목록 조회 요청 처리
        return ResponseEntity.ok(scheduleService.getSchedules(modifiedDate.atStartOfDay(), assignee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable Long id,
                                                      @RequestBody ScheduleDTO scheduleDTO,
                                                      @RequestParam String password) {
        // 일정 수정 요청 처리
        return ResponseEntity.ok(scheduleService.updateSchedule(id, scheduleDTO, password));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id,
                                               @RequestParam String password) {
        // 일정 삭제 요청 처리
        scheduleService.deleteSchedule(id, password);
        return ResponseEntity.noContent().build();
    }
}
