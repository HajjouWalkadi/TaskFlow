package com.example.taskflow.mappers;

import com.example.taskflow.dto.TaskRequestDTO;
import com.example.taskflow.entities.Task;

public class TaskMapper {
    public static Task mapTaskDtoToTask(TaskRequestDTO taskRequestDTO) {
        return Task.builder()
                .title(taskRequestDTO.getTitle())
                .description(taskRequestDTO.getDescription())
                .completed(taskRequestDTO.getCompleted())
                .startDate(taskRequestDTO.getStartDate())
                .endDate(taskRequestDTO.getEndDate())
                .modificationDate(taskRequestDTO.getModificationDate())
                .status(taskRequestDTO.getStatus())
                .actionType(taskRequestDTO.getActionType())
                .tags(taskRequestDTO.getTags())
                //.assignedTo(taskRequestDTO.getAssignedTo().getId())
                //.createdBy(taskRequestDTO.getCreatedBy().getId())
                .build();
    }
}
