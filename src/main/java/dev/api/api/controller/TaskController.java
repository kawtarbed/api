package dev.api.api.controller;


import lombok.AllArgsConstructor;
import dev.api.api.Dto.TaskRequestDto;
import dev.api.api.Dto.TaskResponseDto;
import dev.api.api.entity.Task;
import dev.api.api.service.ImpTaskService;
import dev.api.api.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService tasksServices;

    //Get
    @GetMapping(value = "/get/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTaskById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(tasksServices.getTaskById(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //Post
    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody TaskRequestDto task){
        try {
            return ResponseEntity.ok(tasksServices.addTask(task));
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        try {
            tasksServices.deleteTask(id);
            return ResponseEntity.ok().build();
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    //Update
    @PutMapping("/update")
    public ResponseEntity<?> updateTask(@RequestBody TaskRequestDto task){
        try {
            return ResponseEntity.ok(tasksServices.updateTask(task));
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
