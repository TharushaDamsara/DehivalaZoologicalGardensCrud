package edu.ijjse.dehivalazoomanagemetsystem.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AnimalMngDto {
    private String animalId;
    private String animalName;
    private double animalAge;
    private String animalGender;
    private String catagory;
    private String enclosureId;
    private String divisionId;

}
