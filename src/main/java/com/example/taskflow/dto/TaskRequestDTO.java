package com.example.taskflow.dto;

import com.example.taskflow.entities.Tags;
import com.example.taskflow.entities.Task;
import com.example.taskflow.entities.User;
import com.example.taskflow.enums.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskRequestDTO {



    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;


    @NotNull(message = "Start date of task cannot be null")
    @FutureOrPresent(message = "Start date must be in the present or future")
    private LocalDateTime startDate;

    @NotNull(message = "End date of task cannot be null")
    private LocalDateTime endDate;

    @NotNull(message = "At least one status is required")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;


    @NotEmpty(message = "Tag is required")
    @Size(min = 3, message = "At least three tags are required")
    private List<Tags> tags;

    @NotNull(message = "CreatedBy is required")
    private Long createdById;

    @NotNull(message = "AssignedTo is required")
    private Long assignedToId;


}

