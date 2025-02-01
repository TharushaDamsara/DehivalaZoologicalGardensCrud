package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Devision;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DevisionBo extends SuperBo {
    public boolean add(Devision dto) throws SQLException;
    public boolean update(Devision dto) throws SQLException;
    public boolean delete(Devision dto) throws SQLException;
    public ArrayList<Devision> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

