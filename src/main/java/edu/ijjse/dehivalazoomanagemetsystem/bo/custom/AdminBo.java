package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminBo extends SuperBo {

    public void getAdmin(String userName,String pwd) throws SQLException ;
    public boolean add(Admin dto) throws SQLException;
    public boolean update(Admin dto) throws SQLException;
    public boolean delete(Admin dto) throws SQLException;
    public ArrayList<Admin> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

