package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBo extends SuperBo {
    public boolean getUserCredential(String userName, String pwd) throws SQLException;

    public boolean add(User dto) throws SQLException;
    public boolean update(User dto) throws SQLException;
    public boolean delete(User dto) throws SQLException;
    public ArrayList<User> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
