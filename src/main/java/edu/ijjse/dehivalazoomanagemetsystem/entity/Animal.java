package edu.ijjse.dehivalazoomanagemetsystem.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Animal {
    private String animalId;
    private String animalName;
    private double animalAge;
    private String animalGender;
    private String catagory;
    private String enclosureId;
    private String divisionId;

}
