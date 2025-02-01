package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.EmpMng;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpMngBo extends SuperBo {
    public boolean add(EmpMng dto) throws SQLException;

    public boolean update(EmpMng dto) throws SQLException;

    public boolean delete(EmpMng dto) throws SQLException;

    public ArrayList<EmpMng> getAll() throws SQLException;

    public String getNextId() throws SQLException;
}

