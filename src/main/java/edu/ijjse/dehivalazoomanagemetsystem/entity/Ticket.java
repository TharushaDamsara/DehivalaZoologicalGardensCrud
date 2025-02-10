package edu.ijjse.dehivalazoomanagemetsystem.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ticket {
    private String ticketCode;
    private String visitorId;
    private String type;
    private String date;
    private int qty;
    private double amount;
    private String paymentType;
}
