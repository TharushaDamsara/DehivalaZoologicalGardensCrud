package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.VetDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VetBo extends SuperBo {

    public boolean add(VetDto dto) throws SQLException;
    public boolean update(VetDto dto) throws SQLException;
    public boolean delete(VetDto dto) throws SQLException;
    public ArrayList<VetDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
