package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDto;

import java.sql.SQLException;

public interface UserDao extends CrudDao<UserDto> {
    public boolean getUserCredential(String userName, String pwd) throws SQLException;
}
