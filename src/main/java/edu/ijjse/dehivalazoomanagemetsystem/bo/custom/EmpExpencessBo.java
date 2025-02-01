package edu.ijjse.dehivalazoomanagemetsystem.bo.custom;

import edu.ijjse.dehivalazoomanagemetsystem.bo.SuperBo;
import edu.ijjse.dehivalazoomanagemetsystem.entity.dto.EmployeeExpences;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpExpencessBo extends SuperBo {

    public ArrayList<String> getEmployeeIds() throws SQLException;
    public boolean add(EmployeeExpences dto) throws SQLException;
    public boolean update(EmployeeExpences dto) throws SQLException;
    public boolean delete(EmployeeExpences dto) throws SQLException;
    public ArrayList<EmployeeExpences> getAll() throws SQLException;
    public String getNextId() throws SQLException;
}

