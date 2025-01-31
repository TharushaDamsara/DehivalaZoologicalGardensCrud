package edu.ijjse.dehivalazoomanagemetsystem.model.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AnimalExpencessTM {
private String expenceId;
private String animalId;
private double amount;
private String description;
private String date;
}
