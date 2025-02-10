package edu.ijjse.dehivalazoomanagemetsystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDetailsDto {
    private String userId;
    private String empId;
    private String userName;
    private String password;
}
