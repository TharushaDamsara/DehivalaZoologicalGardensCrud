package edu.ijjse.dehivalazoomanagemetsystem.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class HelthReportTM {
    private String helthReportId;
    private String animalId;
    private String vetId;
    private String condition;
    private String date;
}
