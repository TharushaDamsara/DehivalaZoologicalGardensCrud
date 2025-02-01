package edu.ijjse.dehivalazoomanagemetsystem.entity.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Task {
    private String taskId;
    private String empId;
    private String taskName;
    private String dueDate;
}
