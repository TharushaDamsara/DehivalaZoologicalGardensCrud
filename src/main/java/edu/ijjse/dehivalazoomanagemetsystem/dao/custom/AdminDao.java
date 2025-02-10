package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.AdminDto;

import java.sql.SQLException;

public interface AdminDao extends CrudDao<AdminDto> {
    public boolean getAdmin(String userName,String pwd) throws SQLException ;
}
