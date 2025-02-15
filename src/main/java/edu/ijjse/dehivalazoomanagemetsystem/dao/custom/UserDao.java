package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.User;

import java.sql.SQLException;

public interface UserDao extends CrudDao<User> {
    public boolean getUserCredential(String userName, String pwd) throws SQLException;
}
