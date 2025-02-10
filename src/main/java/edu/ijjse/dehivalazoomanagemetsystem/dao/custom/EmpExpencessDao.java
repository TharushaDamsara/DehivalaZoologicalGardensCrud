package edu.ijjse.dehivalazoomanagemetsystem.dao.custom;

import edu.ijjse.dehivalazoomanagemetsystem.dao.CrudDao;
import edu.ijjse.dehivalazoomanagemetsystem.dto.EmployeeExpencesDto;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmpExpencessDao extends CrudDao<EmployeeExpencesDto> {
    public ArrayList<String> getEmployeeIds() throws SQLException;
}
