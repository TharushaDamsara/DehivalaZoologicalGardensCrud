package edu.ijjse.dehivalazoomanagemetsystem.entity.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AnimalExpencesDto {
    private String animalExpencesId;
    private String animalId;
    private double amount;
    private String discription;
    private String date;
}
