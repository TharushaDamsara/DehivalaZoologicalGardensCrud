package edu.ijjse.dehivalazoomanagemetsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDetailsMngDto {
    private String userId;
    private String empId;
    private String userName;
    private String password;
}
