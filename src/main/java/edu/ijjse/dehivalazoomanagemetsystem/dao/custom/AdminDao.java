package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Admin;

import java.sql.SQLException;

public interface AdminDao extends CrudDao<Admin> {
    public boolean getAdmin(String userName,String pwd) throws SQLException ;
}
