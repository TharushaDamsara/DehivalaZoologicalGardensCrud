package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.UserDetailsMngDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDetailsDao extends CrudDao<UserDetailsMngDto> {
    public ArrayList<String> getEmployeeIds() throws SQLException ;
}
