package edu.ijjse.dehivalazoomanagemetsystem.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TickDetails {
    private String id;
    private String type;
    private int qty;
    private double price;
}
