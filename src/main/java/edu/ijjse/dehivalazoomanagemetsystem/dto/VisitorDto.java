package edu.ijjse.dehivalazoomanagemetsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class VisitorDto {
    private String visitorId;
    private String visitorName;
    private String visitorAddress;
    private String visitDate;
    private String visitNic;
}
