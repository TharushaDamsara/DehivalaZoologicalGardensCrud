package edu.ijjse.dehivalazoomanagemetsystem.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeExpencessTM {
    private String paymentId;
    private String employeeId;
    private String date;
    private double basic;
    private double addons;
    private double cutOffs;
    private double total;
}
