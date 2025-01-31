package edu.ijjse.dehivalazoomanagemetsystem.entity.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TickDetailsDto {
    private String id;
    private String type;
    private int qty;
    private double price;
}
