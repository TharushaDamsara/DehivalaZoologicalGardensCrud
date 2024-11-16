package edu.ijjse.dehivalazoomanagemetsystem.dto.tm;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AnimalMngTM {
    private String id;
    private String name;
    private double age;
    private String gender;
    private String category;
    private String enclosureId;
    private String divisionId;



}
