package edu.ijjse.dehivalazoomanagemetsystem.model.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class VisitorTM {
    private String visitorId;
    private String visitorName;
    private String visitorAddress;
    private String visitDate;
    private String visitorNic;
    private String ticketId;
}
