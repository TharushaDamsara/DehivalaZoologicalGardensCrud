package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.model.dto.EmpMngDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpMngBo extends SuperBo {
    public boolean add(EmpMngDto dto) throws SQLException;

    public boolean update(EmpMngDto dto) throws SQLException;

    public boolean delete(EmpMngDto dto) throws SQLException;

    public ArrayList<EmpMngDto> getAll() throws SQLException;

    public String getNextId() throws SQLException;
}

