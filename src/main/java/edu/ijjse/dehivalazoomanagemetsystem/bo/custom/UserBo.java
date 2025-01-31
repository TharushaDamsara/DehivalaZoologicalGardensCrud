package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBo extends SuperBo {
    public boolean getUserCredential(String userName, String pwd) throws SQLException;

    public boolean add(UserDto dto) throws SQLException;
    public boolean update(UserDto dto) throws SQLException;
    public boolean delete(UserDto dto) throws SQLException;
    public ArrayList<UserDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
