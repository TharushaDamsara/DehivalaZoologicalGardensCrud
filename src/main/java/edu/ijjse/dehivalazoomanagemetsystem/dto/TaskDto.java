package edu.ijjse.dehivalazoomanagemetsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class TaskDto {
    private String taskId;
    private String empId;
    private String taskName;
    private String dueDate;
}
