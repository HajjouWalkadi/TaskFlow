package com.example.taskflow.entities;

import com.example.taskflow.enums.AssignmentTaskType;
import com.example.taskflow.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

   @NotBlank(message = "Name shouldn't be blank")
    private String name;

    @NotBlank(message = "Full name shouldn't be blank")
    private String lastName;

    @NotBlank(message = "Email Cannot Be blank")
    private String email;

    @NotBlank(message = "Password Cannot Be blank")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "assignedTo")
    private List<Task> tasksAssigned;

    @OneToMany(mappedBy = "createdBy")
    private List<Task> tasksCreated;

    @Enumerated(EnumType.STRING)
    private AssignmentTaskType assignmentType;

}



