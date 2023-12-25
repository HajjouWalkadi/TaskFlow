package com.example.taskflow.controller;

import com.example.taskflow.dto.TaskRequestDTO;
import com.example.taskflow.entities.Task;
import com.example.taskflow.handler.response.ResponseMessage;
import com.example.taskflow.mappers.TaskMapper;
import com.example.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity getAllTasks(@PathVariable Long id) {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            return ResponseMessage.notFound("Tasks not found");
        } else {
            return ResponseMessage.ok("Success", tasks);

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getTaskById(@PathVariable Long id) {
        return ResponseMessage.ok("Success", null);
    }

  /* @PostMapping("/save")
    public ResponseEntity addTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO)  {
        Task task1 = taskService.createTask(taskRequestDTO.toTask());
        if (task1 == null) {
            return ResponseMessage.badRequest("Task not created");
        }else {
            return ResponseMessage.created("Success", task1);
        }
    }*/

   @PostMapping("/save")
   public ResponseEntity createTask(@RequestBody @Valid TaskRequestDTO taskRequestDTO) {
       LocalDateTime now = LocalDateTime.now();
       LocalDateTime endDate = taskRequestDTO.getEndDate();

       if (endDate != null && now.until(endDate, ChronoUnit.DAYS) > 3) {
           return ResponseMessage.badRequest("Task deadline cannot be more than 3 days in advance");
       }
       Task task = TaskMapper.mapTaskDtoToTask(taskRequestDTO);
       Task task1 = taskService.createTask(task);
       if (task1 == null) {
           return ResponseMessage.badRequest("Failed To Create Task");
       } else {
           return ResponseMessage.created("Task Created Successfully", task1);
       }
   }

    /*@PutMapping("/{id}")
    public ResponseEntity updateTask(@RequestBody TaskRequestDTO taskRequestDTO, @PathVariable Long id) {
        Task task = taskService.updateTask(taskRequestDTO, id);
        if(task == null) {
            return ResponseMessage.badRequest("Task not updated");
        }else {
            return ResponseMessage.created("Success", task);
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id) {
        return ResponseMessage.ok("Success", null);
    }
}
