package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.DevisionDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DevisionBo extends SuperBo {
    public boolean add(DevisionDto dto) throws SQLException;
    public boolean update(DevisionDto dto) throws SQLException;
    public boolean delete(DevisionDto dto) throws SQLException;
    public ArrayList<DevisionDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

