package com.example.taskflow.mappers;

import com.example.taskflow.dto.TaskRequestDTO;
import com.example.taskflow.entities.Task;
import com.example.taskflow.entities.User;

public class TaskMapper {
    public static Task mapTaskDtoToTask(TaskRequestDTO taskRequestDTO) {
        return Task.builder()
                .title(taskRequestDTO.getTitle())
                .description(taskRequestDTO.getDescription())
                .startDate(taskRequestDTO.getStartDate())
                .endDate(taskRequestDTO.getEndDate())
                .status(taskRequestDTO.getStatus())
                .tags(taskRequestDTO.getTags())
                //.assignedTo(User.builder().id(taskRequestDTO.getAssignedTo().getId()).build())
                //.createdBy(User.builder().id(taskRequestDTO.getCreatedBy().getId()).build())
                //.assignedTo(taskRequestDTO.getAssignedTo().getId())
                //.createdBy(taskRequestDTO.getCreatedBy().getId())
                .build();
    }
}
