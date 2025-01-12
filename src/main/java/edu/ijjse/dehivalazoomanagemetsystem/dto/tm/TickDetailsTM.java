package edu.ijjse.dehivalazoomanagemetsystem.dto.tm;

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
