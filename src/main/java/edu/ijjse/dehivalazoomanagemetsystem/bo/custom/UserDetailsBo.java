package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.UserDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDetailsBo extends SuperBo {

    public ArrayList<String> getEmployeeIds() throws SQLException ;
    public boolean add(UserDetails dto) throws SQLException;
    public boolean update(UserDetails dto) throws SQLException;
    public boolean delete(UserDetails dto) throws SQLException;
    public ArrayList<UserDetails> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
