package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Encloser;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EncloserBo extends SuperBo {

    public boolean add(Encloser dto) throws SQLException;
    public boolean update(Encloser dto) throws SQLException;
    public boolean delete(Encloser dto) throws SQLException;
    public ArrayList<Encloser> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

