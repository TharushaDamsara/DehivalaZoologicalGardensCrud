package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.UserDetailsDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.UserDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDetailsDao extends CrudDao<UserDetails> {
    public ArrayList<String> getEmployeeIds() throws SQLException ;
}
