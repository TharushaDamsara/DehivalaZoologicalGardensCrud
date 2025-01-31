package edu.ijjse.dehivalazoomanagemetsystem.model.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class TaskMngTm {
    private String taskId;
    private String empId;
    private String taskName;
    private String dueDate;
}
