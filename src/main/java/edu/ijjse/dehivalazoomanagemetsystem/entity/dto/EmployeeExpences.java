package edu.ijjse.dehivalazoomanagemetsystem.entity.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeExpencesDto {
    private String paymentId;
    private String employeeId;
    private String date;
    private double basicSalary;
    private double addonSalary;
    private double cutOffSalary;
    private double totalSalary;


}
