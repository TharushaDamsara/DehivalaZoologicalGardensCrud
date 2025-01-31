package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.UserDetailsMngDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDetailsBo extends SuperBo {

    public ArrayList<String> getEmployeeIds() throws SQLException ;
    public boolean add(UserDetailsMngDto dto) throws SQLException;
    public boolean update(UserDetailsMngDto dto) throws SQLException;
    public boolean delete(UserDetailsMngDto dto) throws SQLException;
    public ArrayList<UserDetailsMngDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
