package edu.ijjse.dehivalazoomanagemetsystem.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class HelthReport {
    private String helthReportId;
    private String animalId;
    private String vetId;
    private String condition;
    private String date;

}
