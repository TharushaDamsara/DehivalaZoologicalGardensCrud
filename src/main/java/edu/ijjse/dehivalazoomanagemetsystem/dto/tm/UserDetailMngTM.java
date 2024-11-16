package edu.ijjse.dehivalazoomanagemetsystem.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class UserDetailMngTM {
    private String id;
    private String empId;
    private String username;
    private String password;
}
