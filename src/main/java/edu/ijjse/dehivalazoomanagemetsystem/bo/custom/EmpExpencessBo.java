package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmployeeExpencesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpExpencessBo extends SuperBo {

    public ArrayList<String> getEmployeeIds() throws SQLException;
    public boolean add(EmployeeExpencesDto dto) throws SQLException;
    public boolean update(EmployeeExpencesDto dto) throws SQLException;
    public boolean delete(EmployeeExpencesDto dto) throws SQLException;
    public ArrayList<EmployeeExpencesDto> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

