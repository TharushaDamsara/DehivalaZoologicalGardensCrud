package edu.ijjse.dehivalazoomanagemetsystem.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Visitor {
    private String visitorId;
    private String visitorName;
    private String visitorAddress;
    private String visitDate;
    private String visitNic;
    private String ticketId;
}
