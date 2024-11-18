package edu.ijjse.dehivalazoomanagemetsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class HelthReportDto {
    private String helthReportId;
    private String animalId;
    private String vetId;
    private String condition;
    private String date;

}
