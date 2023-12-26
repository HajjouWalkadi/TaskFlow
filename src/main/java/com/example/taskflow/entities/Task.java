package com.example.taskflow.entities;

import com.example.taskflow.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name of task cannot be blank")
    @NotNull(message = "Name of task cannot be null")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Start date of task cannot be null")
    @FutureOrPresent(message = "Start date must be in the present or future")
    private LocalDateTime startDate;

    @NotNull(message = "End date of task cannot be null")
    private LocalDateTime endDate;


    @Enumerated(EnumType.STRING)
    private TaskStatus status;


    @ManyToMany
    private List<Tags> tags;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo;
}




