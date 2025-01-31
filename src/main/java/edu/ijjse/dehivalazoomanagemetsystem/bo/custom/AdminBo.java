package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.AdminDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminBo extends SuperBo {

    public void getAdmin(String userName,String pwd) throws SQLException ;
    public boolean add(AdminDto dto) throws SQLException;
    public boolean update(AdminDto dto) throws SQLException;
    public boolean delete(AdminDto dto) throws SQLException;
    public ArrayList<AdminDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

