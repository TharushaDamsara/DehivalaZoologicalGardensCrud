package edu.ijjse.dehivalazoomanagemetsystem.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDetails {
    private String userId;
    private String empId;
    private String userName;
    private String password;
}
