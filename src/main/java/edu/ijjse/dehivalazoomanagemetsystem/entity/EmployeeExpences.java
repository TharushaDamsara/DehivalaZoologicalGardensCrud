package edu.ijjse.dehivalazoomanagemetsystem.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeExpences {
    private String paymentId;
    private String employeeId;
    private String date;
    private double basicSalary;
    private double addonSalary;
    private double cutOffSalary;
    private double totalSalary;


}
