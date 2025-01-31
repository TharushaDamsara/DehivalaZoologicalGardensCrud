package edu.ijjse.dehivalazoomanagemetsystem.entity.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TicketTm {

    private String ticketCode;
    private String visitorId;
    private String type;
    private String date;
    private int qty;
    private double amount;
    private String paymentType;
}
