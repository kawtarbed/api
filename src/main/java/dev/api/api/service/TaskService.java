package dev.api.api.service;

import dev.api.api.Dto.TaskRequestDto;
import dev.api.api.Dto.TaskResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto addTask(TaskRequestDto task);
    TaskResponseDto updateTask(TaskRequestDto task);
    void deleteTask(Long taskId);
    TaskResponseDto getTaskById(Long id);

}
