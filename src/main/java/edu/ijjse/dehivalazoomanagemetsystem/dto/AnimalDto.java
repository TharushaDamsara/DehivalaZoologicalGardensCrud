package edu.ijjse.dehivalazoomanagemetsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AnimalDto {
    private String animalId;
    private String animalName;
    private double animalAge;
    private String animalGender;
    private String catagory;
    private String enclosureId;
    private String divisionId;

}
