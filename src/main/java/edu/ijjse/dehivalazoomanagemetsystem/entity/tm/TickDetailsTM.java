package edu.ijjse.dehivalazoomanagemetsystem.entity.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TickDetailsTM {
    private String id;
    private String type;
    private int qty;
    private double price;
}
