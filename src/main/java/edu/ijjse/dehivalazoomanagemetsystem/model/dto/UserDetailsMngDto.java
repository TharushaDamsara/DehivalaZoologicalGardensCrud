package edu.ijjse.dehivalazoomanagemetsystem.model.dto;

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
