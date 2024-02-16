package dev.api.api.service;


import lombok.AllArgsConstructor;
import dev.api.api.Dto.TaskResponseDto;
import dev.api.api.entity.Status;
import dev.api.api.entity.Task;
import dev.api.api.Dto.TaskRequestDto;
import dev.api.api.Utilis.ToDoMapper;
import dev.api.api.repository.TaskRepository;
import dev.api.api.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ImpTaskService implements TaskService{
    private final TaskRepository taskRepository;
    private final UserRepository userResposetory;
    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskRepository
                .findAll()
                .stream()
                .map(ToDoMapper::taskToTaskResponseDto)
                .toList();
    }

    @Override
    public TaskResponseDto addTask(TaskRequestDto taskDto) {
        var user = userResposetory.findById(taskDto.getUserId()).orElseThrow();
        Task task = ToDoMapper.taskRequestDtoToTask(taskDto);
        task.setStatus(Status.NOTDONE);
        task.setUser(user);
        var savedTask = taskRepository.save(task);
        return ToDoMapper.taskToTaskResponseDto(savedTask);
    }

    @Override
    public TaskResponseDto updateTask(TaskRequestDto task) {
        return null;
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return ToDoMapper.taskToTaskResponseDto( taskRepository.getReferenceById(id));
    }
}






