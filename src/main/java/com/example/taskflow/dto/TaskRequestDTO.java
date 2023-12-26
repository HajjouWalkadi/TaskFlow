package com.example.taskflow.dto;

import com.example.taskflow.entities.Task;
import com.example.taskflow.enums.TaskStatus;

public record TaskRequestDTO (
        String title,
        String description,
        String status,
        Long tagId
) {
 public Task toTask() {
     Task.TaskBuilder taskBuilder = new Task().builder()
                .title(title)
                .description(description);
        if(status != null) {
            taskBuilder.status(TaskStatus.valueOf(status));
        }
        return taskBuilder.build();
    }

 }