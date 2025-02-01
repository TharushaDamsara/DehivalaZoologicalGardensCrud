package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.Visitor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VisitorBo extends SuperBo {

    public boolean add(Visitor dto) throws SQLException;
    public boolean update(Visitor dto) throws SQLException;
    public boolean delete(Visitor dto) throws SQLException;
    public ArrayList<Visitor> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
