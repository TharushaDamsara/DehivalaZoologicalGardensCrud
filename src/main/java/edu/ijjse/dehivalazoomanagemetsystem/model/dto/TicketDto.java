package edu.ijjse.dehivalazoomanagemetsystem.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TicketDto {
    private String ticketCode;
    private String visitorId;
    private String type;
    private String date;
    private int qty;
    private double amount;
    private String paymentType;
}
