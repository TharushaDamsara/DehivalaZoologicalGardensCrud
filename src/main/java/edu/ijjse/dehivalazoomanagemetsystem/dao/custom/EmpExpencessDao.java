package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmployeeExpencesDto;
import edu.ijjse.dehivalazoomanagemetsystem.entity.EmployeeExpences;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpExpencessDao extends CrudDao<EmployeeExpences> {
    public ArrayList<String> getEmployeeIds() throws SQLException;
}
