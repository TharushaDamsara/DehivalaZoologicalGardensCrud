package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDetailsDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDetailsBo extends SuperBo {

    public ArrayList<String> getEmployeeIds() throws SQLException ;
    public boolean add(UserDetailsDto dto) throws SQLException;
    public boolean update(UserDetailsDto dto) throws SQLException;
    public boolean delete(UserDetailsDto dto) throws SQLException;
    public ArrayList<UserDetailsDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
