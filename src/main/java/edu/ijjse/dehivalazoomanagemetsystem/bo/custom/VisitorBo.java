package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.VisitorDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VisitorBo extends SuperBo {

    public boolean add(VisitorDto dto) throws SQLException;
    public boolean update(VisitorDto dto) throws SQLException;
    public boolean delete(VisitorDto dto) throws SQLException;
    public ArrayList<VisitorDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}
